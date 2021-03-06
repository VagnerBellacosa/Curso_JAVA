# Heroku 

## Fazendo deploy de uma API para o Heroku

Quer aprender a fazer **deploy** ? 

#### O que voc� vai encontrar nesse tutorial

- Como criar uma aplica��o Flask nos moldes do Heroku
- Como fazer deploy
- Um pouquinho de Git
- Um pouquinho de consumo de API

## Heroku quem?

Se voc� chegou at� aqui, � prov�vel que voc� j� saiba o que o Heroku �, mas pra quem ainda n�o sabe, Heroku � uma plataforma na nuvem que permite que pessoas �transformem suas ideias o mais r�pido poss�vel em uma URL� e sem ter dores de cabe�a com a parte de infraestrutura.

Essa plataforma prov� um servi�o que, a partir de uma estrutura pr�-definida de uma aplica��o, consegue empacotar essa aplica��o e colocar ela pra rodar num servidor em um dos data centers deles. O Heroku aceita aplica��es escritas em v�rias linguagens, mas hoje vamos usar Python

" Resumo:

tudo computador essa porra "

## Partiu c�digo!

Pra esse tutorial eu fiz uma API em um microframework Python chamado Flask. N�o irei explicar em detalhes como o Flask funciona.

## Nossa API

Ela ter� apenas um endpoint definido pelo /. Esse endpoint poder� dar duas respostas dependendo da requisi��o que voc� fa�a. S�o eles:

 | Requisi��o	 | Resultado | 
 | GET sem cabe�alhos   (headers) extras	 |  N�o entre em p�nico! | 
 | GET com Authorization 42	 | a resposta para a vida, o universo e tudo mais | 

O c�digo pra fazer isso fica pequeninho, d� uma olhada:

...
import os
from flask import Flask, jsonify, request


app = Flask(__name__)

@app.route('/')
def nao_entre_em_panico():
    if request.headers.get('Authorization') == '42':
        return jsonify({"42": "a resposta para a vida, o universo e tudo mais"})
    return jsonify({"message": "N�o entre em p�nico!"})

if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5000))
    app.run(host='0.0.0.0', port=port)
... 

Esse c�digo fica dentro de um arquivo chamado aqui de nao_entre_em_panico.py mas voc� pode nomear da forma que voc� achar melhor. Al�m disso, esse c�digo tem uma peculiaride: as tr�s linhas finais, elas servem para configurar o servidor Flask quando ele estiver rodando no Heroku.

#### Pipfile

Lembra que eu falei l� no come�o que os posts base eram antigos? Pois bem, hoje o Heroku exige um Pipfile para preparar o ambiente em que a nossa aplica��o vai rodar. O Pipfile vai servir para instalar as bibliotecas Python necess�rias para rodar a nossa aplica��o. Se voc�, assim como eu, n�o gosta de usar o Pipenv - desculpa C�ssio - d� pra criar o arquivo na m�o, como criei o meu abaixo:

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

No nosso computador, para rodar (colocar de p�) a nossa API o comando � o seguinte:

...
FLASK_APP=nao_entre_em_panico.py flask run
... 

Como n�o ser� voc� quem ir� executar um comando pra colocar a API de p�, voc� vai precisar de um arquivo que vai dizer �Coloca a API de p� a� para o Heroku, esse arquivo � o Procfile.

Uma aten��ozinha especial para um detalhe: esse arquivo n�o possui extens�o, dependendo do seu sistema operacional e seu editor de texto, na hora de salvaer esse arquivo pode aparecer uma extens�o .txt nesse arquivo e isso vai causar uma falha no nosso deploy ent�o, lembre-se de remover a extens�o do arquivo caso ela apare�a ;)

Para esta aplica��o, o Procfile vai ter uma linha s� que � a seguinte:

...
web: python nao_entre_em_panico.py
...

T� beleza, e o que mais?

## Versionamento

Como o Heroku funciona com o sistema de versionamento Git, independentemente de voc� hospedar ou n�o o c�digo no GitHub, n�s precisamos criar nosso hist�rico de vers�o para a aplica��o.

Ent�o, depois de criar todos esses arquivos aqui de cima, voc� precisa adicionar tudo isso na sua �rvore Git. Se voc� n�o � l� muito f� de Git pode fazer o seguinte:

...
$ git init
$ git add .
$ git commit -m "criando a aplica��o"
... 

Essa sequ�ncia de comandos acima vai colocar todos os arquivos num mesmo commit, isso n�o � uma boa pr�tica e caso esteja interessada(o) em boas pr�ticas l� no fim do desse tutorial vai ter links sobre isso.

3, 2, 1� Deploy \o/

Agora voc� tem uma escolha: existem algumas formas de enviar o seu c�digo para o Heroku. Voc� pode connectar com o GitHub ou com Dropbox ou ainda usar o Heroku CLI. Nesse post n�s vamos fazer da �ltima forma.

Ent�o, pra come�ar voc� precisa instalar o Heroku CLI.

Fazendo login
Come�ando pelo login:

...
$ heroku login
...

Esse comando vai te pedir para digitar e-mail e senha de acesso da sua conta no Heroku:

...
login heroku
...


- Tela de login da CLI do Heroku
- Criando uma aplica��o
- Usando a interface

� poss�vel criar uma aplica��o pela interface do site, onde voc� vai ver a seguinte tela:

tela de cria��o de app no site da heroku

Depois disso voc� ainda precisa adicionar o remote do Heroku no nosso reposit�rio:

...
heroku git:remote -a guiaapi
...

E olha como � a resposta desse comando:

adicionando o remote do Heroku

### Usando o terminal

Mas tamb�m podemos criar a aplica��o usando a CLI do Heroku. O lado bom de usar a CLI � que ao criar a aplica��o o remote � criado automaticamente:

...
heroku apps:create guiaapi
...

O que deve mostrar algo assim �:

cria��o de um app nomeado usando a heroku cli

Pausa para mais um momento de aten��o: desse jeito que eu mostrei a� em cima, a gente consegue nomear nossa aplica��o dentro do Heroku, a� que entra uma �pegadinha�, o nome da minha aplica��o tem que ser �nica dentro do Heroku, pois � o nome da aplica��o que � usado para criar a URL dela, se voc� por acaso tentar criar uma aplica��o com um nome j� utilizado, a resposta para o comando acima vai ser esta:

falha na cria��o de app usando a heroku cli

Se o nome da sua aplica��o n�o for algo importante, voc� pode executar o seguinte comando no lugar do comando anterior:

...
heroku create
...

Esse comando vai criar uma aplica��o com um nome randomizado, por exemplo:

cria��o de um app usando a heroku cli

Depois de criada a aplica��o, voc� pode dar uma espiada l� na dashboard do Heroku na �rea de aplica��es para ver a lista das suas aplica��es:

lista de apps na dashboard da heroku

### Finalmente fazendo o bendito deploy

Depois de commitar tudo, fazer login e criar a sua aplica��o no Heroku chegou a hora do deploy.

A a��o de fazer o deploy, aqui nesse contexto, significa enviar o c�digo da aplica��o para o servidor e rodar o processo para colocar nossa API de p� no servidor.

Outros contextos podem trazer varia��es e passos intermedi�rios desse que estou apresentando, mas aqui como nossa aplica��o � simples e o Heroku � feito para nos ajudar a colocar aplica��es de p�, o maior trabalho se torna a cria��o dos arquivos de configura��o (que j� criamos) ;)

Ent�o, o comando que vai executar o envio do c�digo para o servidor �:

...
git push heroku master
...

Em caso de sucesso voc� deve ver algo parecido com isso:

#### Terminal mostrando o deploy

Uma �ltima configura��o que pode ser necess�ria fazer � garantir que a nossa aplica��o tem pelo menos um dyno rodando com o seguinte comando:

...
heroku ps:scale web=1
...

## Dynos

E o que � um dyno? Em resumo um dyno � um Linux Container, o Heroku utiliza um modelo de container que isola a sua aplica��o e possibilita a f�cil escalabilidade do sistema. Em outras palavras menos t�cnicas: Pega todos os arquivos de c�digo e configura��o que escrevemos at� agora e enfia num caixa e bota pra rodar, isso � um dyno.

Agora pra ver o resultado da sua API podemos (nesse caso) abrir um navegador e acessar https://guiaapi.herokuapp.com/ ou usar a linha de comando pra abrir a URL direto:

...
heroku open
...

Se deu tudo certo (e voc� usar o Firefox como navegador) voc� ver� algo assim:

## Get sem cabe�alho de autoriza��o no navegador

O que aconteceu foi o seguinte: ao acessar a URL da nossa aplica��o no Heroku n�s fizemos uma requisi��o GET pra API com o cabe�alho (header) padr�o, ou seja, sem o campo Authorization. Que seria a mesma coisa que rodar no terminal, isso aqui em baixo:

...
curl -X GET -k -i 'https://guiaapi.herokuapp.com/'
...

#### Que me d� este resultado:

Get sem cabe�alho de autoriza��o no terminal com cURL

Como sabemos, essa nossa API vai ter uma resposta diferente se voc� passar o cabe�alho Authorization com o valor de 42, veja:

...
curl -X GET -k -H 'Authorization: 42' \
    -i 'https://guiaapi.herokuapp.com/'

...

### Temos o seguinte resultado:

Get com cabe�alho de autoriza��o no terminal com cURL

D� pra passar o cabe�alho de autoriza��o no navegador? D�! mas vou deixar isso pra outro post/tutorial que eu prometo que linko aqui quando escrever.

Overview de um app

## Pro tip: Arquivos de log

Pode ser que voc� tenha cometido alguma falha no processo de configura��o da sua aplica��o e, na hora do deploy, o Heroku avise que ele foi mal-sucedido. Nesse caso o primeiro lugar para procurar informa��es do que deu errado s�o os logs.

Um bom sistema faz logs de todas as a��es executadas. Nesse nosso caso, o Heroku se encarrega de logar todos os detalhes pra gente, ent�o basta pedir esse log usando a CLI. Aqui eu ainda escrevo os logs num arquivo para facilitar a inspe��o, veja:

...
heroku logs > out.log
...

Exemplos de linhas que voc� ir� encontrar num desses logs:  

---
...
2018-04-15T02:24:39.000000+00:00 app[api]: Build succeeded
2018-04-15T02:25:11.165813+00:00 heroku[web.1]: Starting process with command `python nao_entre_em_panico.py`
...
2018-04-15T02:52:20.075995+00:00 app[web.1]: 10.5.207.142 - - [15/Apr/2018 02:52:20] "GET / HTTP/1.1" 200 -
---

[Artigo original](https://jtemporal.com/deploy-flask-heroku/)

