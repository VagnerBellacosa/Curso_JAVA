# Java

## Entendendo os comandos Java e Javac

É fato que os desenvolvedores que começam a programar na linguagem Java, muitas vezes não sabem nem que existem formas de compilar, e rodar, a aplicação através de linha de comando. Isto, para quem está começando, acaba se tornando um vício, onde o programador só saberá criar e executar a sua aplicação através de um IDE que faça todo o trabalho “manual”. O resultado disto são desenvolvedores que não sabem lidar com situações onde não existe nenhum IDE disponível, obrigando-o a ter de fazer o download de IDE para que possa iniciar o seu trabalho.

Para a certificação OCJP 6, o candidato precisa conhecer bem alguns desses comandos. Iremos abordar, neste artigo, os comandos javac e java que podem ser executados através de um Terminal (Mac OS), Console (Linux) ou CMD (Windows).

Atenção: Para poder executar estes comandos, é necessário ter o Java instalado no seu sistema operacional.

## Compilando com javac

O javac é utilizado para compilar as classes em Java. Use-o antes de executar uma classe para que seja gerado um arquivo .class da classe em questão.

Existem várias opções que podem ser utilizadas junto com o comando javac, como mostra a Figura 1.

## Lista de opções que complementam o javac

...
C:\Workspace\Curso_JAVA>javac
Usage: javac <options> <source files>
where possible options include:
  @<filename>                  Read options and filenames from file
  -Akey[=value]                Options to pass to annotation processors
  --add-modules <module>(,<module>)*
        Root modules to resolve in addition to the initial modules, or all modules
        on the module path if <module> is ALL-MODULE-PATH.
  --boot-class-path <path>, -bootclasspath <path>
        Override location of bootstrap class files
  --class-path <path>, -classpath <path>, -cp <path>
        Specify where to find user class files and annotation processors
  -d <directory>               Specify where to place generated class files
  -deprecation
        Output source locations where deprecated APIs are used
  --enable-preview
        Enable preview language features. To be used in conjunction with either -source or --release.
  -encoding <encoding>         Specify character encoding used by source files
  -endorseddirs <dirs>         Override location of endorsed standards path
  -extdirs <dirs>              Override location of installed extensions
  -g                           Generate all debugging info
  -g:{lines,vars,source}       Generate only some debugging info
  -g:none                      Generate no debugging info
  -h <directory>
        Specify where to place generated native header files
  --help, -help, -?            Print this help message
  --help-extra, -X             Print help on extra options
  -implicit:{none,class}
        Specify whether or not to generate class files for implicitly referenced files
  -J<flag>                     Pass <flag> directly to the runtime system
  --limit-modules <module>(,<module>)*
        Limit the universe of observable modules
  --module <module>(,<module>)*, -m <module>(,<module>)*
        Compile only the specified module(s), check timestamps
  --module-path <path>, -p <path>
        Specify where to find application modules
  --module-source-path <module-source-path>
        Specify where to find input source files for multiple modules
  --module-version <version>
        Specify version of modules that are being compiled
  -nowarn                      Generate no warnings
  -parameters
        Generate metadata for reflection on method parameters
  -proc:{none,only}
        Control whether annotation processing and/or compilation is done.
  -processor <class1>[,<class2>,<class3>...]
        Names of the annotation processors to run; bypasses default discovery process
  --processor-module-path <path>
        Specify a module path where to find annotation processors
  --processor-path <path>, -processorpath <path>
        Specify where to find annotation processors
  -profile <profile>
        Check that API used is available in the specified profile
  --release <release>
        Compile for the specified Java SE release. Supported releases: 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
  -s <directory>               Specify where to place generated source files
  --source <release>, -source <release>
        Provide source compatibility with the specified Java SE release. Supported releases: 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
  --source-path <path>, -sourcepath <path>
        Specify where to find input source files
  --system <jdk>|none          Override location of system modules
  --target <release>, -target <release>
        Generate class files suitable for the specified Java SE release. Supported releases: 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
  --upgrade-module-path <path>
        Override location of upgradeable modules
  -verbose                     Output messages about what the compiler is doing
  --version, -version          Version information
  -Werror                      Terminate compilation if warnings occur
...

Para entendermos melhor como funcionam esses complementos, primeiro precisamos entender a estrutura deste comando, que é: javac [opções] [arquivos-fontes].

Quando for necessário utilizar mais de uma opção e/ou arquivo-fonte, é necessário que os separem por espaço.

Sabendo disto, estamos prontos para estudar mais detalhadamente as duas opções que serão importantes para os candidatos à OCJP 6: -d e -classpath.

### Compilando com -d

É imprescindível, principalmente para projetos de grande porte, que os arquivos .class fiquem separados dos arquivos .java, por questões de organização, segurança, controle de versões, depuramento e etc. Sendo assim, ao compilarmos uma classe e, consequentemente, gerarmos um .class da classe .java em questão, precisaremos usar a opção -d para informar ao compilador que insira o arquivo .class em um local determinado.

Digamos que estamos compilando uma classe chamada HelloWorld.java, dentro do pacote commandLine, e queremos que a HelloWorld.class fique em no diretório commandLine/bin. A sintaxe ficaria deste jeito:

...
javac -d bin HelloWorld.java
...

A figura abaixo mostra como estavam as pastas commandLine e commandLine/bin antes da execução da linha de comando anterior.
...
C:.
├───bin
    └───commandLine
...

Pasta commandLine antes da execução da linha de comando

...
Execução do comando javac -d bin HelloWorld.java
...


## Pasta commandLine após a execução do comando

Como podemos ver, o compilador gerou o HelloWorld.class na pasta /bin/commandLine/, criando a hierarquia de diretórios automaticamente. Ou seja, no nosso exemplo, a nossa classe java estava inserida na pasta commandLine, o que fez o compilador criar a pasta /bin/commandLine/. Caso a nossa classe estivesse dentro de commandLine/test/, seriam criadas, pelo compilador, as pastas /bin/commandLin/test/.

O comando -d nada mais é do que a indicação do destino de onde o .class será gerado, já que -d significa destiny.

## Iniciando aplicativos em Java

Utiliza-se o comando java para chamar a JVM. Assim como javac, existem diversas opções que podem ser utilizadas junto ao java. Através do comando java -help, teremos a lista de opções mostradas na figura 5.

## Lista de opções do comando java

Figura 5: Lista de opções do comando java

...
C:\Workspace\Curso_JAVA>java
Usage: java [options] <mainclass> [args...]
           (to execute a class)
   or  java [options] -jar <jarfile> [args...]
           (to execute a jar file)
   or  java [options] -m <module>[/<mainclass>] [args...]
       java [options] --module <module>[/<mainclass>] [args...]
           (to execute the main class in a module)
   or  java [options] <sourcefile> [args]
           (to execute a single source-file program)

 Arguments following the main class, source file, -jar <jarfile>,
 -m or --module <module>/<mainclass> are passed as the arguments to
 main class.

 where options include:

    -cp <class search path of directories and zip/jar files>
    -classpath <class search path of directories and zip/jar files>
    --class-path <class search path of directories and zip/jar files>
                  A ; separated list of directories, JAR archives,
                  and ZIP archives to search for class files.
    -p <module path>
    --module-path <module path>...
                  A ; separated list of directories, each directory
                  is a directory of modules.
    --upgrade-module-path <module path>...
                  A ; separated list of directories, each directory
                  is a directory of modules that replace upgradeable
                  modules in the runtime image
    --add-modules <module name>[,<module name>...]
                  root modules to resolve in addition to the initial module.
                  <module name> can also be ALL-DEFAULT, ALL-SYSTEM,
                  ALL-MODULE-PATH.
    --list-modules
                  list observable modules and exit
    -d <module name>
    --describe-module <module name>
                  describe a module and exit
    --dry-run     create VM and load main class but do not execute main method.
                  The --dry-run option may be useful for validating the
                  command-line options such as the module system configuration.
    --validate-modules
                  validate all modules and exit
                  The --validate-modules option may be useful for finding
                  conflicts and other errors with modules on the module path.
    -D<name>=<value>
                  set a system property
    -verbose:[class|module|gc|jni]
                  enable verbose output for the given subsystem
    -version      print product version to the error stream and exit
    --version     print product version to the output stream and exit
    -showversion  print product version to the error stream and continue
    --show-version
                  print product version to the output stream and continue
    --show-module-resolution
                  show module resolution output during startup
    -? -h -help
                  print this help message to the error stream
    --help        print this help message to the output stream
    -X            print help on extra options to the error stream
    --help-extra  print help on extra options to the output stream
    -ea[:<packagename>...|:<classname>]
    -enableassertions[:<packagename>...|:<classname>]
                  enable assertions with specified granularity
    -da[:<packagename>...|:<classname>]
    -disableassertions[:<packagename>...|:<classname>]
                  disable assertions with specified granularity
    -esa | -enablesystemassertions
                  enable system assertions
    -dsa | -disablesystemassertions
                  disable system assertions
    -agentlib:<libname>[=<options>]
                  load native agent library <libname>, e.g. -agentlib:jdwp
                  see also -agentlib:jdwp=help
    -agentpath:<pathname>[=<options>]
                  load native agent library by full pathname
    -javaagent:<jarpath>[=<options>]
                  load Java programming language agent, see java.lang.instrument
    -splash:<imagepath>
                  show splash screen with specified image
                  HiDPI scaled images are automatically supported and used
                  if available. The unscaled image filename, e.g. image.ext,
                  should always be passed as the argument to the -splash option.
                  The most appropriate scaled image provided will be picked up
                  automatically.
                  See the SplashScreen API documentation for more information
    @argument files
                  one or more argument files containing options
    -disable-@files
                  prevent further argument file expansion
    --enable-preview
                  allow classes to depend on preview features of this release
To specify an argument for a long option, you can use --<name>=<value> or
--<name> <value>.
...

A sintaxe é muito similar da do javac: java [opções] classe [argumentos].

Quando for necessário adicionar múltiplas opções e/ou argumentos, separá-los com espaço. Quanto a classe, o comando java assume que você está se referindo a um .class. Sendo assim, não é necessário digitar .class após o nome do arquivo.

### Declarando e usando Classpaths

Classpaths são variáveis de localização de um diretório que podem conter as classes que serão necessárias para a execução do sistema. Em sua declaração, eles são separados por delimitadores.

Quando estamos utilizado um SO baseado no Unix, as barras normais são utilizadas pra construir a localização de diretórios. Porém, quando estamos no Windows, a barra invertida que é usada. No exame para a OCJP 6, serão utilizados exemplos com barras normais.

A sintaxe do comando -classpath, ou -cp, é a seguinte:

Listagem 2: Sintaxe do comando classpah

...
-classpath /src/teste/dir1:/src/teste
...

No exemplo anterior, será feita uma busca nos diretórios /src/teste/dir1 e /src/teste para procurar as classes necessárias para a execução do comando.

Observação: Quando se especifica um subdiretório, não são inclusos na busca os diretórios acima dele! Ou seja, no exemplo anterior, o diretório teste não será utilizado na busca.

Algo que frequentemente ocorre quando os desenvolvedores compilam e rodam a aplicação pela linha de comando, é se deparar com um erro de Classe não encontrada. Isto geralmente é resolvido quando adicionamos o diretório atual na busca. Desta forma, o javac ou java irá procurar em todas os subdiretórios da pasta atual. Para fazer isto, é necessário adicionar o ponto “.” em um dos diretórios definidos após o comando -cp. Exemplo: -classpath /src/teste/dir1:.

Digamos que o programador esteja dentro do pacote src. Neste caso, todos os subdiretórios de src serão inclusos na busca. Então, ../teste/, e seus subdiretórios, serão inclusos na busca. Além disto, é importante saber que a busca é feita da esquerda para a direita. Sendo assim, caso existam classes com nomes duplicados, a primeira a ser encontrada no diretório da esquerda, será utilizada. Então, preste atenção na hora de definir a ordem de procura!

A figura 6 mostrará a utilização de javac e java com o comando -cp para compilar e executar o HelloWorld.java.

## Utilizando o comando -cp junto com javac e java para executar HelloWorld.java

Listagem 3: Código da classe HelloWorld.java

...
package commandLine;

public class HelloWorld{

        public static void main(String[] args)
        {
                System.out.println("Hello,World!");
        }
}
...

## Conclusão

Neste artigo foram abordados alguns pontos importantes relacionados a javac, java e classpath.

Espero ter ajudado na compreensão do assunto e ter motivado os programadores Java em dar uma maior importância aos comandos que foram apresentados.

[Artigo original](https://www.devmedia.com.br/entendendo-os-comandos-java-e-javac/26394)