# O que é deploy, para que serve, vantagens e como fazer deploy

#### Ugo Roveda

Planejar uma aplicação, desenvolvê-la e ver seu código funcionando perfeitamente após o período de testes são algumas das etapas que antecedem o temido deploy.

Extremamente necessário, pois sem ele nenhum site, software ou aplicativo seria utilizado pelos seus usuários finais, este processo gera muitas dúvidas em estudantes de programação.

Afinal, como fazer um deploy? Em que exatamente consiste este processo? Só existe uma maneira de colocar uma aplicação no ar?

No conteúdo de hoje, responderei a todas estas dúvidas! Vamos lá?

## O que é Deploy em programação?

O verbo **deploy**, em inglês, quer dizer **implantar**.

Em programação, seu sentido está intimamente relacionado à sua tradução literal: fazer um deploy, em termos práticos, significa colocar no ar alguma aplicação que teve seu desenvolvimento concluído.

Esta tarefa é extremamente comum dentro do escopo de trabalho dos programadores, embora seja muito comumente associada somente aos profissionais de infraestrutura, ou DevOps.

Quando um site é finalizado por um desenvolvedor e, após seus testes, é finalmente hospedado e colocado no ar, ele passa pelo processo de deploy.

De mesmo modo, quando um sistema sofre alguma melhoria ou alteração em seu código-fonte, implementar essa alteração ao sistema que está no ar também é um tipo de deploy.

## Destinos possíveis de um deploy

Ao utilizar um aplicativo em seu smartphone, é difícil imaginar tudo o que está por trás de seu desenvolvimento, inclusive todas as dificuldades ultrapassadas para que se chegasse ao resultado final.

Tomando um aplicativo como exemplo, explicarei abaixo quais são os três principais destinos de um deploy pelo qual uma aplicação deve passar antes de ser disponibilizada para o usuário final.

Vamos lá?

## Desenvolvimento

Este é o ambiente inicial.

Ele não é, necessariamente, um deploy, mas é, por exemplo, o primeiro ecossistema de uma aplicação, que geralmente fica somente na máquina do programador ou programadora responsável por desenvolvê-la.

Aqui, o profissional tem total liberdade para criar e trabalhar dentro do método de tentativa e erro. Dentro do ambiente de desenvolvimento, tanto profissional quanto código têm a oportunidade de tornarem-se mais maduros para a próxima etapa.

## Staging/Teste

No ambiente de testagem, esta aplicação já carrega uma responsabilidade um pouco maior.

Para que ela chegue a este ambiente e seja disponibilizada para a equipe que irá testá-la, ela precisa passar pelo seu primeiro deploy. 

Este ambiente, comumente chamado de ambiente de homologação, pode estar disponível, por exemplo, apenas em uma intranet, a depender da empresa. Ele fica em algum lugar entre o acesso único de seu programador e o acesso público do usuário final.

## Produção

Após todas as testagem serem feitas, falhas identificadas, melhorias implementadas, chegou a hora de fazer o deploy desta aplicação para o seu ambiente de **produção**.

Este ambiente nada mais é que um servidor ao qual o usuário final pode ter acesso, onde o aplicativo, site, software ou sistema está definitivamente no ar, pronto para uso.

Este é o último deploy dentro da estrutura básica de desenvolvimento de uma aplicação, mas vale lembrar que, durante a manutenção desta aplicação, ela provavelmente passará por outros deploys.

## Como fazer deploy em 4 etapas

Para os estudantes de programação ou jovens desenvolvedores que ainda estão tomando alguma familiaridade com o mercado de trabalho, podemos resumir um processo simples de deploy em 4 etapas básicas.

Abaixo, explicarei melhor cada um destes conceitos:

### Infraestrutura

Aqui é preciso definir qual será o primeiro ambiente do seu site ou aplicação.

Pode ser um pequeno servidor, sua máquina, um serviço de hospedagem, uma plataforma voltada exclusivamente a esta função, etc.

O mais importante, porém, é que este ambiente ofereça suporte total a todas as linguagens de programação que serão utilizadas durante este desenvolvimento. 

Isto evita que, durante o andamento do projeto, você seja obrigado a trocar de infraestrutura, atrasando seus processos e passando por mais deploys e mudanças do que o previsto.

### Domínio

Se você está desenvolvendo um site, escolher seu domínio é um passo primordial – até porque será impossível hospedá-lo ou colocá-lo no ar sem um endereço eletrônico.

Após a escolha e a compra do domínio, é preciso fazer suas configurações de DNS (Domain Name System) para conectá-lo à sua hospedagem.

### Ambiente

A terceira etapa deste processo consiste em fazer o deploy do seu código a um ambiente de hospedagem que garantirá sua disponibilização ao usuário final.

Para isso é preciso instalar e configurar servidor, banco de dados e toda a estrutura que será necessária para subir este código para produção, um processo que pode ser um tanto desafiador para os estudantes.

### Otimização

Uma vez que a sua aplicação já está sendo satisfatoriamente utilizada, chegou a hora de otimizar os processos que a envolvem para que ela possa manter-se em bom funcionamento.

## Configuração eficiente de cache, por exemplo, é um destes processos.

E quais as formas de fazer deploy?
Por ser uma prática tão importante dentro do processo de desenvolvimento, não existe apenas uma maneira de realizá-la, mas três.

Nos últimos anos, as tecnologias voltadas à automatização deste processo evoluíram muito, tornando-os muito mais rápidos e eficientes.

O que antes era feito somente de maneira manual, hoje pode ser feito através de ferramentas de fácil manuseio e com o mínimo de risco, auxiliando as aplicações a serem  atualizadas de maneira muito mais segura.

Conheça, abaixo, as três formas possíveis de se fazer um deploy.

## Manual

Esta é a maneira mais trabalhosa de se realizar um deploy, embora ainda seja muito popular.

Um exemplo clássico de deploy manual é o famoso FTP, ou Protocolo de Transferência de Arquivo, um processo que permite que arquivos possam ser transferidos entre dois ou mais computadores através de uma rede de internet, mas precisa de interferência humana para acontecer.

Entre as maiores desvantagens do deploy manual está o tempo e os recursos gastos com uma atividade que poderia ser feita mais rapidamente, otimizando a produtividade da equipe.

Outro problema deste tipo de deploy é o risco de mais de um desenvolvedor ou desenvolvedora subir subir arquivos ao mesmo tempo, causando um conflito na hora de fazer uma melhoria.

Um exemplo ainda mais comum de deploy manual é aquela rápida alteração que programadores(as) costumam fazer em um código para logo subi-la para o ambiente de produção.

## Parcialmente automatizado

Atualizar um repositório GIT, por exemplo, é fazer um deploy parcialmente automatizado.

Ele recebe essa classificação porque, apesar de alguns comandos humanos serem necessitados, o push do branch master que ocorre através de um pequeno hook e atualiza o servidor é totalmente automática.

Outra grande vantagem deste deploy é o controle de versões do GIT.

## Completamente automatizado

O deploy completamente automatizado é um recurso de ponta em termos de tecnologia.

Com ele é possível garantir mais segurança, qualidade e eficiência na hora de fazer atualizações e melhorias em sites, aplicativos ou softwares de grande utilização, como redes sociais e até mesmo serviços Google, por exemplo.

Existem hoje, no mercado, diversas ferramentas voltadas à automatização total do processo de deploy, entre as mais populares estão Jenkins, GitLab, Azure Pipelines e Circle CI.

Esta categoria de deploy, além de transmitir automaticamente as suas atualizações para o servidor, também realiza aquilo que chamamos de integração contínua.

O conceito de CI, ou Continuous Integration, é, em resumo, a prática de unir diversas alterações de código em um repositório central, automaticamente, com o objetivo de fazer testagens e execuções antes do deploy final.

## Integração contínua (CI – Continuous Integration)

Este é um processo bastante importante quando falamos sobre deploys completamente automáticos, uma vez que é graças à integração contínua que erros e bugs são mais facilmente encontrados na hora dos testes automáticos.

A CI é a solução para a problemática de vários desenvolvedores(as) trabalharem ao mesmo tempo em um mesmo projeto e, depois, terem que juntar todas as ramificações de um mesmo código para, então, iniciar os testes.

Todo este procedimento era difícil e trabalhoso, utilizando muito tempo e recursos, o que impedia uma distribuição rápida de softwares e sites, gerando uma bola de neve de entraves na hora de subir aplicações no ar.

Imagine, por exemplo, que um aplicativo como o Uber precise fazer constantes melhorias e correção de bugs em sua estrutura, alterando pequenos detalhes em seus códigos todos os dias.

Como assegurar que estas atualizações não atrapalhem sua utilização, gerando um grande prejuízo financeiro ao negócio?

Graças a integração contínua, isto é possível.

## Qual a melhor estratégia para o deploy?

Assim como existem três maneiras de executar um deploy, também existem três estratégias mais populares para fazer deploys no dia-a-dia.

### Rolling

Esta estratégia consiste em fazer com que duas versões de uma mesma aplicação coexistam enquanto o deploy é executado.

Na prática, este deploy é realizado substituindo totalmente o código fonte de uma aplicação por um novo código, que já contém as alterações a serem implementadas.

Este deploy é feito de modo gradual e a versão antiga só sairá do ar quando a nova estiver totalmente pronta.

### Blue-Green

A Blue-Green é uma estratégia cuja característica principal é que todos os testes de uma aplicação são feitos em um ambiente de produção espelhado, chamado de mirror.

Com esta estratégia, o blue representa o ambiente antigo, enquanto o green representa o ambiente atualizado. 

Para implementar o deploy nestes moldes, a aplicação é espelhada em produção, mas os usuários não têm acesso a ela enquanto ela não estiver totalmente pronta. Quando o deploy é finalizado, um load balancer direciona o tráfego para o novo ambiente, enquanto o antigo é excluído.

### Canary

Na estratégia Canary, os testes da nova versão são feitos na prática pelos seus usuários finais.

Esta é a mais complexa estratégia de deploy porque consiste em liberar a nova versão de um software, site ou aplicativo apenas para uma parte das pessoas que o utilizam para que, em seguida, sejam feitas análises de seus comportamentos para a identificação de erros e falhas.

Com o Canary, a nova versão também coexiste com a antiga, com a diferença de que aqui as duas versões estão em um ambiente de produção acessível aos usuários finais.

## Conclusão

O deploy, ou processo de deployment, é uma prática extremamente necessária para qualquer programador, porque ela representa o final de uma das etapas do desenvolvimento: a de criação e testagem de uma aplicação.

Os deploys que se seguem ao primeiro, mais relacionados à manutenção do projeto, costumam ser, de modo geral, mais simples e enxutos.

[Artigo original](https://kenzie.com.br/blog/o-que-e-deploy/)