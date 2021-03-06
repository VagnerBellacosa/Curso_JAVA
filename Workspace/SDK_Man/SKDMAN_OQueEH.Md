# SDKMAN 

## SDKMAN, uma ferramenta CLI para gerenciamento de kits de desenvolvimento de software

##### Damien A. | | Ubuntu

A ferramenta nos fornecer� uma maneira f�cil de instalar, alterar, listar e remover SDK. Com SDKMAN, podemos gerenciar vers�es paralelas de v�rios SDKs facilmente em qualquer sistema operacional semelhante ao Unix. Ele tamb�m permite que os desenvolvedores instalem kits de desenvolvimento de software para JVM, Groovy, Scala, Kotlin e Ceylon. Ant, Gradle, Grails, Maven, SBT, Spark, Spring Boot, Vert.x e muitos outros. SDKMAN � gratuito, leve, c�digo aberto e escrito em bash.

### �ndice

1 Instale SDKMAN
	1.1 Gerenciar v�rios kits de desenvolvimento de software
2. Instale um SDK
	2.1 Instale uma vers�o de um SDK
	2.2 Verifique qual vers�o est� em uso
	2.3 Verifique a vers�o dos pacotes instalados com SDKMAN
	2.4 Candidato de atualiza��o
	2.5 Habilite ou desabilite a fun��o offline
3. Remover um SDK instalado
4. Atualizar SDKMAN
5. Limpar cache
6. Desinstalar SDKMAN
7. ajudar

Instale SDKMAN
A instala��o do SDKMAN � muito simples. Primeiro, teremos que ter certeza instalaram os aplicativos zip, unzip e curl. Eles est�o dispon�veis nos reposit�rios padr�o para a maioria das distribui��es Gnu / Linux. No Ubuntu, s� teremos que digitar no terminal (Ctrl + Alt + T):

...
sudo apt install zip unzip curl
... 

Agora vamos instalar SDKMAN usando o comando:


Instala��o Sdkman

...
curl -s "https://get.sdkman.io" | bash
...

A instala��o � simples assim. Depois de conclu�do, executaremos o seguinte comando:

... 
source "$HOME/.sdkman/bin/sdkman-init.sh"
...
Finalmente, verifique se a instala��o foi bem sucedida usando o comando:

vers�o sdkman

...
sdk version
...

Gerenciar v�rios kits de desenvolvimento de software

Para ver a lista de candidatos dispon�veis (SDK), execute no terminal (Ctrl + Alt + T):

### candidatos sdkman

...
sdk list
...

Como voc� pode ver, SDKMAN lista os candidatos junto com sua descri��o, seu site oficial e o comando de instala��o. Pressione a tecla j para descer na lista e a letra k para subir.

## Instale um SDK

Para instalar um SDK, por exemplo Java JDK, execute:

- sdkman instalar sdk java

...
sdk install java
...

Se voc� tiver v�rios SDKs, ele perguntar� se deseja que a vers�o instalada mais recente seja definida como padr�o. Se voc� responder Si a vers�o que voc� acabou de instalar ser� definida como padr�o.

## Instale uma vers�o de um SDK

P�ra instalar uma vers�o espec�fica de um SDK, faremos algo como o seguinte:

sdkman instalar formiga

...
sdk install ant 1.10.1
...

O comando acima ir� instalar o Apacha Ant vers�o 1.10.1. lista as vers�es dispon�veis de um candidato, formiga neste caso, use o comando:

lista as vers�es candidatas dispon�veis sdkman
---
sdk list ant
---

Como eu disse, se voc� instalou v�rias vers�es, SDKMAN perguntar� se voc� deseja que a vers�o instalada seja definida como padr�o. Voc� pode responder Sim para definir esta vers�o como padr�o. Al�m disso, voc� pode fazer isso mais tarde usando o seguinte comando:

...
sdk default ant 1.10.1
...

O comando acima definir� o Apache Ant vers�o 1.10.1 como o padr�o.

## Verifique qual vers�o est� em uso

P�ra verifique qual vers�o de um SDK est� atualmente em uso, por exemplo Java, vamos executar um comando como:

sdkman java atual

...
sdk current java
...

Verifique a vers�o dos pacotes instalados com SDKMAN

N�s podemos verifique qual vers�o est� atualmente em uso para todos os candidatos que instalamos, vamos executar o comando:

sdkman verifica��o atual de vers�es sdk instaladas

...
sdk current
...

### Candidato de atualiza��o

P�ra atualizar um SDK desatualizado, neste caso scala, fa�a-o com o comando:

---
sdk upgrade scala
---
tamb�m podemos verificar se algum dos SDKs instalados est� desatualizado usando o comando:

----
sdk upgrade
---

## Habilite ou desabilite a fun��o offline

SDKMAN tem um modo offline que permite que SDKMAN funcione ao trabalhar offline. Ele pode ser ativado ou desativado a qualquer momento usando os seguintes comandos:

...
sdk offline enable
...

...
sdk offline disable
...

### Remover um SDK instalado

Para remover um SDK instalado, execute:

...
sdk uninstall ant 1.10.1
...

O comando acima ir� desinstalar o Apache Ant 1.10.1 de nosso sistema.

### Atualizar SDKMAN

Caso haja uma nova vers�o do SDKMAN, o comando a seguir o instalar�, se dispon�vel.

...
sdk selfupdate
...

SDKMAN tamb�m verificar� se h� atualiza��es periodicamente e fornecer� instru��es para a atualiza��o.

#### Limpar cache

sdkman limpar cache

Se recomenda Limpar cache Ele cont�m os arquivos bin�rios do SDK baixados de tempos em tempos. Para fazer isso, basta executar:

...
sdk flush archives
...

Tamb�m � bom limpar pasta tempor�ria para economizar espa�o:

...
sdk flush temp
...

### Desinstalar SDKMAN

Se depois de tentar voc� perceber que n�o precisa do SDKMAN ou n�o gosta muito dele, pode exclu�-lo digitando no terminal:

...
rm -rf ~/.sdkman
...

Finalmente, abra seus arquivos .bashrc, .bash_profile e / ou .profile. Encontre e exclua as seguintes linhas do final do arquivo.

arquivo bashrc desinstala��o sdkman
...
#THIS MUST BE AT THE END OF THE FILE FOR SDKMAN TO WORK!!!
export SDKMAN_DIR="/home/entreunosyceros/.sdkman"
[[ -s "/home/entreunosyceros/.sdkman/bin/sdkman-init.sh" ]] && source "/home/entreunosyceros/.sdkman/bin/sdkman-init.sh"
...

### ajudar

P�ra obtenha mais detalhes, voc� pode consultar a se��o de ajuda digitando:

ajuda sdkman

...
sdk help
...

P�ra obtenha mais informa��es sobre este programa, voc� pode consultar o site do projeto ou sua p�gina GitHub.


[Artigo original](https://ubunlog.com/pt/sdkman-administra-kits-desarrollo/)
[SDK Man no Github](https://github.com/sdkman/sdkman-cli)
[SDKMan Download](https://sdkman.io/)
