# O que � deploy, para que serve, vantagens e como fazer deploy

#### Ugo Roveda

Planejar uma aplica��o, desenvolv�-la e ver seu c�digo funcionando perfeitamente ap�s o per�odo de testes s�o algumas das etapas que antecedem o temido deploy.

Extremamente necess�rio, pois sem ele nenhum site, software ou aplicativo seria utilizado pelos seus usu�rios finais, este processo gera muitas d�vidas em estudantes de programa��o.

Afinal, como fazer um deploy? Em que exatamente consiste este processo? S� existe uma maneira de colocar uma aplica��o no ar?

No conte�do de hoje, responderei a todas estas d�vidas! Vamos l�?

## O que � Deploy em programa��o?

O verbo **deploy**, em ingl�s, quer dizer **implantar**.

Em programa��o, seu sentido est� intimamente relacionado � sua tradu��o literal: fazer um deploy, em termos pr�ticos, significa colocar no ar alguma aplica��o que teve seu desenvolvimento conclu�do.

Esta tarefa � extremamente comum dentro do escopo de trabalho dos programadores, embora seja muito comumente associada somente aos profissionais de infraestrutura, ou DevOps.

Quando um site � finalizado por um desenvolvedor e, ap�s seus testes, � finalmente hospedado e colocado no ar, ele passa pelo processo de deploy.

De mesmo modo, quando um sistema sofre alguma melhoria ou altera��o em seu c�digo-fonte, implementar essa altera��o ao sistema que est� no ar tamb�m � um tipo de deploy.

## Destinos poss�veis de um deploy

Ao utilizar um aplicativo em seu smartphone, � dif�cil imaginar tudo o que est� por tr�s de seu desenvolvimento, inclusive todas as dificuldades ultrapassadas para que se chegasse ao resultado final.

Tomando um aplicativo como exemplo, explicarei abaixo quais s�o os tr�s principais destinos de um deploy pelo qual uma aplica��o deve passar antes de ser disponibilizada para o usu�rio final.

Vamos l�?

## Desenvolvimento

Este � o ambiente inicial.

Ele n�o �, necessariamente, um deploy, mas �, por exemplo, o primeiro ecossistema de uma aplica��o, que geralmente fica somente na m�quina do programador ou programadora respons�vel por desenvolv�-la.

Aqui, o profissional tem total liberdade para criar e trabalhar dentro do m�todo de tentativa e erro. Dentro do ambiente de desenvolvimento, tanto profissional quanto c�digo t�m a oportunidade de tornarem-se mais maduros para a pr�xima etapa.

## Staging/Teste

No ambiente de testagem, esta aplica��o j� carrega uma responsabilidade um pouco maior.

Para que ela chegue a este ambiente e seja disponibilizada para a equipe que ir� test�-la, ela precisa passar pelo seu primeiro deploy. 

Este ambiente, comumente chamado de ambiente de homologa��o, pode estar dispon�vel, por exemplo, apenas em uma intranet, a depender da empresa. Ele fica em algum lugar entre o acesso �nico de seu programador e o acesso p�blico do usu�rio final.

## Produ��o

Ap�s todas as testagem serem feitas, falhas identificadas, melhorias implementadas, chegou a hora de fazer o deploy desta aplica��o para o seu ambiente de **produ��o**.

Este ambiente nada mais � que um servidor ao qual o usu�rio final pode ter acesso, onde o aplicativo, site, software ou sistema est� definitivamente no ar, pronto para uso.

Este � o �ltimo deploy dentro da estrutura b�sica de desenvolvimento de uma aplica��o, mas vale lembrar que, durante a manuten��o desta aplica��o, ela provavelmente passar� por outros deploys.

## Como fazer deploy em 4 etapas

Para os estudantes de programa��o ou jovens desenvolvedores que ainda est�o tomando alguma familiaridade com o mercado de trabalho, podemos resumir um processo simples de deploy em 4 etapas b�sicas.

Abaixo, explicarei melhor cada um destes conceitos:

### Infraestrutura

Aqui � preciso definir qual ser� o primeiro ambiente do seu site ou aplica��o.

Pode ser um pequeno servidor, sua m�quina, um servi�o de hospedagem, uma plataforma voltada exclusivamente a esta fun��o, etc.

O mais importante, por�m, � que este ambiente ofere�a suporte total a todas as linguagens de programa��o que ser�o utilizadas durante este desenvolvimento. 

Isto evita que, durante o andamento do projeto, voc� seja obrigado a trocar de infraestrutura, atrasando seus processos e passando por mais deploys e mudan�as do que o previsto.

### Dom�nio

Se voc� est� desenvolvendo um site, escolher seu dom�nio � um passo primordial � at� porque ser� imposs�vel hosped�-lo ou coloc�-lo no ar sem um endere�o eletr�nico.

Ap�s a escolha e a compra do dom�nio, � preciso fazer suas configura��es de DNS (Domain Name System) para conect�-lo � sua hospedagem.

### Ambiente

A terceira etapa deste processo consiste em fazer o deploy do seu c�digo a um ambiente de hospedagem que garantir� sua disponibiliza��o ao usu�rio final.

Para isso � preciso instalar e configurar servidor, banco de dados e toda a estrutura que ser� necess�ria para subir este c�digo para produ��o, um processo que pode ser um tanto desafiador para os estudantes.

### Otimiza��o

Uma vez que a sua aplica��o j� est� sendo satisfatoriamente utilizada, chegou a hora de otimizar os processos que a envolvem para que ela possa manter-se em bom funcionamento.

## Configura��o eficiente de cache, por exemplo, � um destes processos.

E quais as formas de fazer deploy?
Por ser uma pr�tica t�o importante dentro do processo de desenvolvimento, n�o existe apenas uma maneira de realiz�-la, mas tr�s.

Nos �ltimos anos, as tecnologias voltadas � automatiza��o deste processo evolu�ram muito, tornando-os muito mais r�pidos e eficientes.

O que antes era feito somente de maneira manual, hoje pode ser feito atrav�s de ferramentas de f�cil manuseio e com o m�nimo de risco, auxiliando as aplica��es a serem  atualizadas de maneira muito mais segura.

Conhe�a, abaixo, as tr�s formas poss�veis de se fazer um deploy.

## Manual

Esta � a maneira mais trabalhosa de se realizar um deploy, embora ainda seja muito popular.

Um exemplo cl�ssico de deploy manual � o famoso FTP, ou Protocolo de Transfer�ncia de Arquivo, um processo que permite que arquivos possam ser transferidos entre dois ou mais computadores atrav�s de uma rede de internet, mas precisa de interfer�ncia humana para acontecer.

Entre as maiores desvantagens do deploy manual est� o tempo e os recursos gastos com uma atividade que poderia ser feita mais rapidamente, otimizando a produtividade da equipe.

Outro problema deste tipo de deploy � o risco de mais de um desenvolvedor ou desenvolvedora subir subir arquivos ao mesmo tempo, causando um conflito na hora de fazer uma melhoria.

Um exemplo ainda mais comum de deploy manual � aquela r�pida altera��o que programadores(as) costumam fazer em um c�digo para logo subi-la para o ambiente de produ��o.

## Parcialmente automatizado

Atualizar um reposit�rio GIT, por exemplo, � fazer um deploy parcialmente automatizado.

Ele recebe essa classifica��o porque, apesar de alguns comandos humanos serem necessitados, o push do branch master que ocorre atrav�s de um pequeno hook e atualiza o servidor � totalmente autom�tica.

Outra grande vantagem deste deploy � o controle de vers�es do GIT.

## Completamente automatizado

O deploy completamente automatizado � um recurso de ponta em termos de tecnologia.

Com ele � poss�vel garantir mais seguran�a, qualidade e efici�ncia na hora de fazer atualiza��es e melhorias em sites, aplicativos ou softwares de grande utiliza��o, como redes sociais e at� mesmo servi�os Google, por exemplo.

Existem hoje, no mercado, diversas ferramentas voltadas � automatiza��o total do processo de deploy, entre as mais populares est�o Jenkins, GitLab, Azure Pipelines e Circle CI.

Esta categoria de deploy, al�m de transmitir automaticamente as suas atualiza��es para o servidor, tamb�m realiza aquilo que chamamos de integra��o cont�nua.

O conceito de CI, ou Continuous Integration, �, em resumo, a pr�tica de unir diversas altera��es de c�digo em um reposit�rio central, automaticamente, com o objetivo de fazer testagens e execu��es antes do deploy final.

## Integra��o cont�nua (CI � Continuous Integration)

Este � um processo bastante importante quando falamos sobre deploys completamente autom�ticos, uma vez que � gra�as � integra��o cont�nua que erros e bugs s�o mais facilmente encontrados na hora dos testes autom�ticos.

A CI � a solu��o para a problem�tica de v�rios desenvolvedores(as) trabalharem ao mesmo tempo em um mesmo projeto e, depois, terem que juntar todas as ramifica��es de um mesmo c�digo para, ent�o, iniciar os testes.

Todo este procedimento era dif�cil e trabalhoso, utilizando muito tempo e recursos, o que impedia uma distribui��o r�pida de softwares e sites, gerando uma bola de neve de entraves na hora de subir aplica��es no ar.

Imagine, por exemplo, que um aplicativo como o Uber precise fazer constantes melhorias e corre��o de bugs em sua estrutura, alterando pequenos detalhes em seus c�digos todos os dias.

Como assegurar que estas atualiza��es n�o atrapalhem sua utiliza��o, gerando um grande preju�zo financeiro ao neg�cio?

Gra�as a integra��o cont�nua, isto � poss�vel.

## Qual a melhor estrat�gia para o deploy?

Assim como existem tr�s maneiras de executar um deploy, tamb�m existem tr�s estrat�gias mais populares para fazer deploys no dia-a-dia.

### Rolling

Esta estrat�gia consiste em fazer com que duas vers�es de uma mesma aplica��o coexistam enquanto o deploy � executado.

Na pr�tica, este deploy � realizado substituindo totalmente o c�digo fonte de uma aplica��o por um novo c�digo, que j� cont�m as altera��es a serem implementadas.

Este deploy � feito de modo gradual e a vers�o antiga s� sair� do ar quando a nova estiver totalmente pronta.

### Blue-Green

A Blue-Green � uma estrat�gia cuja caracter�stica principal � que todos os testes de uma aplica��o s�o feitos em um ambiente de produ��o espelhado, chamado de mirror.

Com esta estrat�gia, o blue representa o ambiente antigo, enquanto o green representa o ambiente atualizado. 

Para implementar o deploy nestes moldes, a aplica��o � espelhada em produ��o, mas os usu�rios n�o t�m acesso a ela enquanto ela n�o estiver totalmente pronta. Quando o deploy � finalizado, um load balancer direciona o tr�fego para o novo ambiente, enquanto o antigo � exclu�do.

### Canary

Na estrat�gia Canary, os testes da nova vers�o s�o feitos na pr�tica pelos seus usu�rios finais.

Esta � a mais complexa estrat�gia de deploy porque consiste em liberar a nova vers�o de um software, site ou aplicativo apenas para uma parte das pessoas que o utilizam para que, em seguida, sejam feitas an�lises de seus comportamentos para a identifica��o de erros e falhas.

Com o Canary, a nova vers�o tamb�m coexiste com a antiga, com a diferen�a de que aqui as duas vers�es est�o em um ambiente de produ��o acess�vel aos usu�rios finais.

## Conclus�o

O deploy, ou processo de deployment, � uma pr�tica extremamente necess�ria para qualquer programador, porque ela representa o final de uma das etapas do desenvolvimento: a de cria��o e testagem de uma aplica��o.

Os deploys que se seguem ao primeiro, mais relacionados � manuten��o do projeto, costumam ser, de modo geral, mais simples e enxutos.

[Artigo original](https://kenzie.com.br/blog/o-que-e-deploy/)