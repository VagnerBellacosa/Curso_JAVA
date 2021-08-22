# Heroku 

## Fazendo deploy de uma API para o Heroku

Quer aprender a fazer **deploy** ? 

#### O que você vai encontrar nesse tutorial

- Como criar uma aplicação Flask nos moldes do Heroku
- Como fazer deploy
- Um pouquinho de Git
- Um pouquinho de consumo de API

## Heroku quem?

Se você chegou até aqui, é provável que você já saiba o que o Heroku é, mas pra quem ainda não sabe, Heroku é uma plataforma na nuvem que permite que pessoas “transformem suas ideias o mais rápido possível em uma URL” e sem ter dores de cabeça com a parte de infraestrutura.

Essa plataforma provê um serviço que, a partir de uma estrutura pré-definida de uma aplicação, consegue empacotar essa aplicação e colocar ela pra rodar num servidor em um dos data centers deles. O Heroku aceita aplicações escritas em várias linguagens, mas hoje vamos usar Python

" Resumo:

tudo computador essa porra "

## Partiu código!

Pra esse tutorial eu fiz uma API em um microframework Python chamado Flask. Não irei explicar em detalhes como o Flask funciona.

## Nossa API

Ela terá apenas um endpoint definido pelo /. Esse endpoint poderá dar duas respostas dependendo da requisição que você faça. São eles:

 | Requisição	 | Resultado | 
 | GET sem cabeçalhos   (headers) extras	 |  Não entre em pânico! | 
 | GET com Authorization 42	 | a resposta para a vida, o universo e tudo mais | 

O código pra fazer isso fica pequeninho, dá uma olhada:

...
import os
from flask import Flask, jsonify, request


app = Flask(__name__)

@app.route('/')
def nao_entre_em_panico():
    if request.headers.get('Authorization') == '42':
        return jsonify({"42": "a resposta para a vida, o universo e tudo mais"})
    return jsonify({"message": "Não entre em pânico!"})

if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5000))
    app.run(host='0.0.0.0', port=port)
... 

Esse código fica dentro de um arquivo chamado aqui de nao_entre_em_panico.py mas você pode nomear da forma que você achar melhor. Além disso, esse código tem uma peculiaride: as três linhas finais, elas servem para configurar o servidor Flask quando ele estiver rodando no Heroku.

#### Pipfile

Lembra que eu falei lá no começo que os posts base eram antigos? Pois bem, hoje o Heroku exige um Pipfile para preparar o ambiente em que a nossa aplicação vai rodar. O Pipfile vai servir para instalar as bibliotecas Python necessárias para rodar a nossa aplicação. Se você, assim como eu, não gosta de usar o Pipenv - desculpa Cássio - dá pra criar o arquivo na mão, como criei o meu abaixo:

...
[[source]]

url = "https://pypi.python.org/simple"
verify_ssl = true


[packages]

Flask = "*"

[requires]

python_version = "3.6"
...

Para desenvolver (preparar o ambiente local) eu gosto do bom e velho requirements.txt que fica assim:

...
click==6.7
Flask==0.12.2
itsdangerous==0.24
Jinja2==2.10
MarkupSafe==1.0
Werkzeug==0.14.1
Procfile
...

No nosso computador, para rodar (colocar de pé) a nossa API o comando é o seguinte:

...
FLASK_APP=nao_entre_em_panico.py flask run
... 

Como não será você quem irá executar um comando pra colocar a API de pé, você vai precisar de um arquivo que vai dizer “Coloca a API de pé aí” para o Heroku, esse arquivo é o Procfile.

Uma atençãozinha especial para um detalhe: esse arquivo não possui extensão, dependendo do seu sistema operacional e seu editor de texto, na hora de salvaer esse arquivo pode aparecer uma extensão .txt nesse arquivo e isso vai causar uma falha no nosso deploy então, lembre-se de remover a extensão do arquivo caso ela apareça ;)

Para esta aplicação, o Procfile vai ter uma linha só que é a seguinte:

...
web: python nao_entre_em_panico.py
...

Tá beleza, e o que mais?

## Versionamento

Como o Heroku funciona com o sistema de versionamento Git, independentemente de você hospedar ou não o código no GitHub, nós precisamos criar nosso histórico de versão para a aplicação.

Então, depois de criar todos esses arquivos aqui de cima, você precisa adicionar tudo isso na sua árvore Git. Se você não é lá muito fã de Git pode fazer o seguinte:

...
$ git init
$ git add .
$ git commit -m "criando a aplicação"
... 

Essa sequência de comandos acima vai colocar todos os arquivos num mesmo commit, isso não é uma boa prática e caso esteja interessada(o) em boas práticas lá no fim do desse tutorial vai ter links sobre isso.

3, 2, 1… Deploy \o/

Agora você tem uma escolha: existem algumas formas de enviar o seu código para o Heroku. Você pode connectar com o GitHub ou com Dropbox ou ainda usar o Heroku CLI. Nesse post nós vamos fazer da última forma.

Então, pra começar você precisa instalar o Heroku CLI.

Fazendo login
Começando pelo login:

...
$ heroku login
...

Esse comando vai te pedir para digitar e-mail e senha de acesso da sua conta no Heroku:

...
login heroku
...


- Tela de login da CLI do Heroku
- Criando uma aplicação
- Usando a interface

É possível criar uma aplicação pela interface do site, onde você vai ver a seguinte tela:

tela de criação de app no site da heroku

Depois disso você ainda precisa adicionar o remote do Heroku no nosso repositório:

...
heroku git:remote -a guiaapi
...

E olha como é a resposta desse comando:

adicionando o remote do Heroku

### Usando o terminal

Mas também podemos criar a aplicação usando a CLI do Heroku. O lado bom de usar a CLI é que ao criar a aplicação o remote é criado automaticamente:

...
heroku apps:create guiaapi
...

O que deve mostrar algo assim ó:

criação de um app nomeado usando a heroku cli

Pausa para mais um momento de atenção: desse jeito que eu mostrei aí em cima, a gente consegue nomear nossa aplicação dentro do Heroku, aí que entra uma “pegadinha”, o nome da minha aplicação tem que ser única dentro do Heroku, pois é o nome da aplicação que é usado para criar a URL dela, se você por acaso tentar criar uma aplicação com um nome já utilizado, a resposta para o comando acima vai ser esta:

falha na criação de app usando a heroku cli

Se o nome da sua aplicação não for algo importante, você pode executar o seguinte comando no lugar do comando anterior:

...
heroku create
...

Esse comando vai criar uma aplicação com um nome randomizado, por exemplo:

criação de um app usando a heroku cli

Depois de criada a aplicação, você pode dar uma espiada lá na dashboard do Heroku na área de aplicações para ver a lista das suas aplicações:

lista de apps na dashboard da heroku

### Finalmente fazendo o bendito deploy

Depois de commitar tudo, fazer login e criar a sua aplicação no Heroku chegou a hora do deploy.

A ação de fazer o deploy, aqui nesse contexto, significa enviar o código da aplicação para o servidor e rodar o processo para colocar nossa API de pé no servidor.

Outros contextos podem trazer variações e passos intermediários desse que estou apresentando, mas aqui como nossa aplicação é simples e o Heroku é feito para nos ajudar a colocar aplicações de pé, o maior trabalho se torna a criação dos arquivos de configuração (que já criamos) ;)

Então, o comando que vai executar o envio do código para o servidor é:

...
git push heroku master
...

Em caso de sucesso você deve ver algo parecido com isso:

#### Terminal mostrando o deploy

Uma última configuração que pode ser necessária fazer é garantir que a nossa aplicação tem pelo menos um dyno rodando com o seguinte comando:

...
heroku ps:scale web=1
...

## Dynos

E o que é um dyno? Em resumo um dyno é um Linux Container, o Heroku utiliza um modelo de container que isola a sua aplicação e possibilita a fácil escalabilidade do sistema. Em outras palavras menos técnicas: Pega todos os arquivos de código e configuração que escrevemos até agora e enfia num caixa e bota pra rodar, isso é um dyno.

Agora pra ver o resultado da sua API podemos (nesse caso) abrir um navegador e acessar https://guiaapi.herokuapp.com/ ou usar a linha de comando pra abrir a URL direto:

...
heroku open
...

Se deu tudo certo (e você usar o Firefox como navegador) você verá algo assim:

## Get sem cabeçalho de autorização no navegador

O que aconteceu foi o seguinte: ao acessar a URL da nossa aplicação no Heroku nós fizemos uma requisição GET pra API com o cabeçalho (header) padrão, ou seja, sem o campo Authorization. Que seria a mesma coisa que rodar no terminal, isso aqui em baixo:

...
curl -X GET -k -i 'https://guiaapi.herokuapp.com/'
...

#### Que me dá este resultado:

Get sem cabeçalho de autorização no terminal com cURL

Como sabemos, essa nossa API vai ter uma resposta diferente se você passar o cabeçalho Authorization com o valor de 42, veja:

...
curl -X GET -k -H 'Authorization: 42' \
    -i 'https://guiaapi.herokuapp.com/'

...

### Temos o seguinte resultado:

Get com cabeçalho de autorização no terminal com cURL

Dá pra passar o cabeçalho de autorização no navegador? Dá! mas vou deixar isso pra outro post/tutorial que eu prometo que linko aqui quando escrever.

Overview de um app

## Pro tip: Arquivos de log

Pode ser que você tenha cometido alguma falha no processo de configuração da sua aplicação e, na hora do deploy, o Heroku avise que ele foi mal-sucedido. Nesse caso o primeiro lugar para procurar informações do que deu errado são os logs.

Um bom sistema faz logs de todas as ações executadas. Nesse nosso caso, o Heroku se encarrega de logar todos os detalhes pra gente, então basta pedir esse log usando a CLI. Aqui eu ainda escrevo os logs num arquivo para facilitar a inspeção, veja:

...
heroku logs > out.log
...

Exemplos de linhas que você irá encontrar num desses logs:  

---
...
2018-04-15T02:24:39.000000+00:00 app[api]: Build succeeded
2018-04-15T02:25:11.165813+00:00 heroku[web.1]: Starting process with command `python nao_entre_em_panico.py`
...
2018-04-15T02:52:20.075995+00:00 app[web.1]: 10.5.207.142 - - [15/Apr/2018 02:52:20] "GET / HTTP/1.1" 200 -
---

[Artigo original](https://jtemporal.com/deploy-flask-heroku/)

