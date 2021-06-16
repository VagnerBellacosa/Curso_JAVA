# SDKMAN 

## SDKMAN, uma ferramenta CLI para gerenciamento de kits de desenvolvimento de software

##### Damien A. | | Ubuntu

A ferramenta nos fornecerá uma maneira fácil de instalar, alterar, listar e remover SDK. Com SDKMAN, podemos gerenciar versões paralelas de vários SDKs facilmente em qualquer sistema operacional semelhante ao Unix. Ele também permite que os desenvolvedores instalem kits de desenvolvimento de software para JVM, Groovy, Scala, Kotlin e Ceylon. Ant, Gradle, Grails, Maven, SBT, Spark, Spring Boot, Vert.x e muitos outros. SDKMAN é gratuito, leve, código aberto e escrito em bash.

### Índice

1 Instale SDKMAN
	1.1 Gerenciar vários kits de desenvolvimento de software
2. Instale um SDK
	2.1 Instale uma versão de um SDK
	2.2 Verifique qual versão está em uso
	2.3 Verifique a versão dos pacotes instalados com SDKMAN
	2.4 Candidato de atualização
	2.5 Habilite ou desabilite a função offline
3. Remover um SDK instalado
4. Atualizar SDKMAN
5. Limpar cache
6. Desinstalar SDKMAN
7. ajudar

Instale SDKMAN
A instalação do SDKMAN é muito simples. Primeiro, teremos que ter certeza instalaram os aplicativos zip, unzip e curl. Eles estão disponíveis nos repositórios padrão para a maioria das distribuições Gnu / Linux. No Ubuntu, só teremos que digitar no terminal (Ctrl + Alt + T):

...
sudo apt install zip unzip curl
... 

Agora vamos instalar SDKMAN usando o comando:


Instalação Sdkman

...
curl -s "https://get.sdkman.io" | bash
...

A instalação é simples assim. Depois de concluído, executaremos o seguinte comando:

... 
source "$HOME/.sdkman/bin/sdkman-init.sh"
...
Finalmente, verifique se a instalação foi bem sucedida usando o comando:

versão sdkman

...
sdk version
...

Gerenciar vários kits de desenvolvimento de software

Para ver a lista de candidatos disponíveis (SDK), execute no terminal (Ctrl + Alt + T):

### candidatos sdkman

...
sdk list
...

Como você pode ver, SDKMAN lista os candidatos junto com sua descrição, seu site oficial e o comando de instalação. Pressione a tecla j para descer na lista e a letra k para subir.

## Instale um SDK

Para instalar um SDK, por exemplo Java JDK, execute:

- sdkman instalar sdk java

...
sdk install java
...

Se você tiver vários SDKs, ele perguntará se deseja que a versão instalada mais recente seja definida como padrão. Se você responder Si a versão que você acabou de instalar será definida como padrão.

## Instale uma versão de um SDK

Pára instalar uma versão específica de um SDK, faremos algo como o seguinte:

sdkman instalar formiga

...
sdk install ant 1.10.1
...

O comando acima irá instalar o Apacha Ant versão 1.10.1. lista as versões disponíveis de um candidato, formiga neste caso, use o comando:

lista as versões candidatas disponíveis sdkman
---
sdk list ant
---

Como eu disse, se você instalou várias versões, SDKMAN perguntará se você deseja que a versão instalada seja definida como padrão. Você pode responder Sim para definir esta versão como padrão. Além disso, você pode fazer isso mais tarde usando o seguinte comando:

...
sdk default ant 1.10.1
...

O comando acima definirá o Apache Ant versão 1.10.1 como o padrão.

## Verifique qual versão está em uso

Pára verifique qual versão de um SDK está atualmente em uso, por exemplo Java, vamos executar um comando como:

sdkman java atual

...
sdk current java
...

Verifique a versão dos pacotes instalados com SDKMAN

Nós podemos verifique qual versão está atualmente em uso para todos os candidatos que instalamos, vamos executar o comando:

sdkman verificação atual de versões sdk instaladas

...
sdk current
...

### Candidato de atualização

Pára atualizar um SDK desatualizado, neste caso scala, faça-o com o comando:

---
sdk upgrade scala
---
também podemos verificar se algum dos SDKs instalados está desatualizado usando o comando:

----
sdk upgrade
---

## Habilite ou desabilite a função offline

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

O comando acima irá desinstalar o Apache Ant 1.10.1 de nosso sistema.

### Atualizar SDKMAN

Caso haja uma nova versão do SDKMAN, o comando a seguir o instalará, se disponível.

...
sdk selfupdate
...

SDKMAN também verificará se há atualizações periodicamente e fornecerá instruções para a atualização.

#### Limpar cache

sdkman limpar cache

Se recomenda Limpar cache Ele contém os arquivos binários do SDK baixados de tempos em tempos. Para fazer isso, basta executar:

...
sdk flush archives
...

Também é bom limpar pasta temporária para economizar espaço:

...
sdk flush temp
...

### Desinstalar SDKMAN

Se depois de tentar você perceber que não precisa do SDKMAN ou não gosta muito dele, pode excluí-lo digitando no terminal:

...
rm -rf ~/.sdkman
...

Finalmente, abra seus arquivos .bashrc, .bash_profile e / ou .profile. Encontre e exclua as seguintes linhas do final do arquivo.

arquivo bashrc desinstalação sdkman
...
#THIS MUST BE AT THE END OF THE FILE FOR SDKMAN TO WORK!!!
export SDKMAN_DIR="/home/entreunosyceros/.sdkman"
[[ -s "/home/entreunosyceros/.sdkman/bin/sdkman-init.sh" ]] && source "/home/entreunosyceros/.sdkman/bin/sdkman-init.sh"
...

### ajudar

Pára obtenha mais detalhes, você pode consultar a seção de ajuda digitando:

ajuda sdkman

...
sdk help
...

Pára obtenha mais informações sobre este programa, você pode consultar o site do projeto ou sua página GitHub.


[Artigo original](https://ubunlog.com/pt/sdkman-administra-kits-desarrollo/)
[SDK Man no Github](https://github.com/sdkman/sdkman-cli)
[SDKMan Download](https://sdkman.io/)
