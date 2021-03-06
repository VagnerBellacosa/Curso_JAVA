# Maven 

## Como instalar o MAVEN no Windows
##### Gustavo Furtado de Oliveira Alves

### Indice
[Pr�-requisito (JDK 1.7)](### Primeiro passo - Pr�-requisito (JDK 1.7))
[Download do maven](### Segundo passo - Download do maven)
[Descompacta��o](### Terceiro passo - Descompacta��o)
[Configurando as vari�veis de ambiente](### Quarto passo - Configurando as vari�veis de ambiente)
[Testando a instala��o do maven](### Testando a instala��o do maven)

O maven � um dos principais gerenciadores de depend�ncias conhecidos para Java. Mas este nome pode assustar um pouco os iniciantes no desenvolvimento Java e a primeira d�vida que surge para come�ar a us�-lo � como eu instalo o maven.

Como n�o tem um "instalador" normal pra voc� executar e ir clicando em "Pr�ximo", a instala��o do maven pode gerar um pouco de confus�o, mas � bem simples.

### Primeiro passo - Pr�-requisito (JDK 1.7)

O principal requisito para instalar e usar o maven na sua m�quina � ter previamente instalado o JDK (Java Development Kit) 1.7 ou superior.

Tamb�m � necess�rio configurar a vari�vel de ambiente JAVA_HOME no seu computador. Mas isso eu vou mostrar como fazer ao longo do post.

Por agora tenha certeza que voc� tenha instalado o JDK 1.7 ou superior.

### Segundo passo - Download do maven

O pr�ximo passo � baixar o maven compactado em sua vers�o mais atual. Voc� precisa baixar o arquivo com os bin�rios do maven, n�o � necess�rio baixar o arquivos-fonte. Ou seja, voc� vai baixar o arquivo que termina com -bin e n�o o arquivo que termina com -src.

Para baixar o maven, basta clicar aqui e fazer o download.

Voc� pode escolher qualquer formato de compacta��o para download, mas eu sugiro o arquivo -bin.zip, por ser o formato de compacta��o mais comum.

Veja um exemplo da p�gina de [download do maven](https://maven.apache.org/download.cgi).

P�gina de download do maven

### Terceiro passo - Descompacta��o

Ap�s fazer o download do arquivo compactado, voc� deve descompact�-lo em uma pasta de sua prefer�ncia.

Mas � importante voc� saber que esta pasta ser� a pasta onde o maven estar� "instalado".

Eu vou descompactar o maven em C:\maven. Ao final da descompacta��o a pasta do maven estar� assim:

Pasta do maven localmente

Pode ser que quando voc� descompactou o arquivo zip a pasta C:\maven tenha ficado s� com uma pasta com os arquivo do maven dentro, algo como C:\maven\apache-maven-3.5.4.

N�o tem problema, basta se lembrar disso quando for configurar a vari�vel de ambiente. Ou voc� pode mover os arquivos de dentro desta pasta e subir um n�vel, colocando-os em C:\maven. Voc� escolhe ...

### Quarto passo - Configurando as vari�veis de ambiente

Agora vem a parte que faz o maven funcionar :)

Para fazer o maven funcionar voc� s� precisa adicionar a pasta bin do maven na vari�vel de ambiente PATH.

Se voc� nunca configurou uma vari�vel de ambiente no Windows basta seguir esses passos.

1. Clique com o bot�o direito do mouse no �cone do seu computador e clique em Propriedades.
	menu: propriedades do computador

2. Clique em Configura��es avan�adas do sistema.
	Configura��es avan�adas do sistema

3. Clique no bot�o Vari�veis de ambiente dentro da aba Avan�ado.
	Configura��es avan�adas do sistema

4. Selecione a vari�vel de ambiente PATH na lista e clique em Editar.
	Editar vari�vel de ambiente PATH

5. Clique no bot�o Novo e adicione o caminho da pasta bin do maven: C:\maven\bin.
	Adicionando a pasta bin do maven na vari�vel de ambiente PATH

6. Verifique se existe a vari�vel de ambiente JAVA_HOME.
	Lembra que falei da vari�vel de ambiente JAVA_HOME? Precisamos saber se ela j� existe no seu sistema ou se precisamos criar.

Entre as vari�veis de ambiente do seu sistema, verifique se j� existe uma vari�vel de ambiente chamada JAVA_HOME que contenha o caminho para o JDK instalado no seu computador.

Se n�o existir, voc� precisa criar essa nova vari�vel de ambiente, clicando em Novo... e informando o nome JAVA_HOME e o valor com o caminho para a pasta onde o seu JDK est� instalado. Por exemplo:

- Exemplo de configura��o do JAVA_HOME

### Testando a instala��o do maven

Para testar se a configura��o do maven funcionou, abra o prompt de comando do seu computador e digite mvn.

A sa�da deve ser algo assim:

Resultado do comando mvn

...
Microsoft Windows [vers�o 10.0.19042.985]
(c) Microsoft Corporation. Todos os direitos reservados.

C:\Users\Compaq>mvn
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.760 s
[INFO] Finished at: 2021-06-16T17:02:20-03:00
[INFO] ------------------------------------------------------------------------
[ERROR] No goals have been specified for this build. You must specify a valid lifecycle phase or a goal in the format <plugin-prefix>:<goal> or <plugin-group-id>:<plugin-artifact-id>[:<plugin-version>]:<goal>. Available lifecycle phases are: validate, initialize, generate-sources, process-sources, generate-resources, process-resources, compile, process-classes, generate-test-sources, process-test-sources, generate-test-resources, process-test-resources, test-compile, process-test-classes, test, prepare-package, package, pre-integration-test, integration-test, post-integration-test, verify, install, deploy, pre-clean, clean, post-clean, pre-site, site, post-site, site-deploy. -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/NoGoalSpecifiedException

C:\Users\Compaq>
...

Se o resultado do seu comando foi como a imagem abaixo, significa que voc� n�o configurou a vari�vel de ambiente PATH com o caminho v�lido para a pasta bin do maven.

...
C:\Users\Compaq>mvn
mvn comando n�o encontrado
...

Neste caso, volte para o in�cio deste Quarto passo - Configurando as vari�veis de ambiente e certifique-se que o caminho da pasta bin do maven esteja na vari�vel de ambiente PATH. Ap�s essa corre��o, feche e abra novamente o prompt de comando.

Referencias
[Maven: Home](https://maven.apache.org/)
[Maven: Instala��o](https://maven.apache.org/install.html)
[Maven: Download](https://maven.apache.org/download.cgi)

[Artigo original](https://dicasdejava.com.br/como-instalar-o-maven-no-windows/)