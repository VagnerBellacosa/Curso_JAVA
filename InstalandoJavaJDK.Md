# Java

## Instalação do Java JDK

A versão do Java JDK mais recente é a 16, através do site oficial da Oracle é possível ter acesso a documentação, instruções de instalação e, mais importante, download do JDK. Portanto, para instalar e configurar siga estes passos:

- Acesse o site oficial da Oracle clicando aqui;
- Siga até Oracle JDK e clique em Download;
- Procure por Windows x64 Installer e faça o download;
- Inicie a instalação do Java JDK executando o arquivo de instalação;
- Siga instalação e copie o endereço do diretório instalado… (ao final, para mim, o diretório de instalação foi C:\Program Files\Java\jdk-16);
- Abra as configurações do Windows, para isso clique no menu iniciar, procure a engrenagem e clique para abrir as configurações;
- Na barra de pesquisa digite Exibir configurações avançadas do sistema;
- Clique em Variáveis de Ambiente;
- Embaixo, nas Variáveis do sistema, clique em Novo… no campo Nome da variável digite JAVA_HOME (exatamente em maiúsculas) e em Valor da variável digite o endereço do diretório em que o Java JDK foi instalado, no meu caso C:\Program Files\Java\jdk-16;
- Em seguida, selecione a variável do sistema Path, clique em Editar, clique em Novo, digite %JAVA_HOME%\bin. Por fim, clique em Ok e Ok;
- Abra seu prompt de comando para testar se tudo deu certo, digite o comando

>java -version

o resultado esperado é:

>java version "16" 2021-03-16
>Java(TM) SE Runtime Environment (build 16+36-2231)
>Java HotSpot(TM) 64-Bit Server VM (build 16+36-2231, mixed mode, sharing)

Se tudo até agora deu certo, parabéns, você conseguiu instalar e configurar o Java JDK!!

## Instalação do Maven

Agora, vamos instalar e configurar o Maven. A versão mais atual do Maven disponível é a 3.8.1, através do site oficial do Maven é possível ter acesso a sua documentação e informações da comunidade.

- Acesse o site oficial do Maven clicando aqui;
- Siga até Files e faça o download da coluna Link na linha Binary zip archive;
- Será necessário criar um diretório para extrair os arquivos do zip baixado. Como sugestão deixo: vá até o diretório C:\ que pode ser acessada pelo diretório Este computador, Disco Local (C:). Crie uma nova pasta chamada “Maven”, mova o arquivo zip baixado para ela e extraia os arquivos;
- Um diretório com o nome apache-maven-3.8.1 deverá ter aparecido. Abra este diretório e copie o endereço dele. Ex.: C:\Maven\apache-maven-3.8.1;
- Será necessário, assim como na instalação do Java, configurar as variáveis de ambiente. Para isso, abra as configurações do Windows, na barra de pesquisa digite Exibir configurações avançadas do sistema, clique em Variáveis de Ambiente;
- Embaixo, nas Variáveis do sistema, clique em Novo… no campo Nome da variável digite MAVEN_HOME (exatamente em maiúsculas) e em Valor da variável digite o endereço do diretório em que o Maven foi instalado, no meu caso C:\Maven\apache-maven-3.8.1, clique em Ok;
- Selecione a variável do sistema Path, clique em Editar, clique em Novo, digite %MAVEN_HOME%\bin. Por fim, clique em Ok e Ok;
- Abra seu prompt de comando para testar se tudo deu certo, digite o comando

> mvn -version

Se o resultado obtido NÃO foi

> 'mvn' não é reconhecido como um comando interno…

Significa que deu certo.

## Instalação do Gradle

O processo para instalação do Gradle é muito semelhante ao do Maven. A versão mais atual é a 7.0 e toda a documentação está disponível no site oficial.

- Acesse o site oficial do Gradle clicando aqui;
- Siga até Installing manually e faça o download da v7.0;
- Será necessário criar um diretório para extrair os arquivos do zip baixado. Como sugestão deixo: vá até o diretório C:\ que pode ser acessado pelo diretório Este computador, Disco Local (C:). Crie uma nova pasta chamada Gradle, mova o arquivo zip baixado para ela e extraia os arquivos;
- Abra o diretório que apareceu e copie seu endereço, no meu caso C:\Gradle\gradle-7.0;
- Será necessário, assim como na instalação do Java e do Maven, configurar as variáveis de ambiente. Para isso, abra as configurações do Windows, na barra de pesquisa digite Exibir configurações avançadas do sistema, clique em Variáveis de Ambiente;
- Embaixo, nas Variáveis do sistema, clique em Novo… no campo Nome da variável digite GRADLE_HOME (exatamente em maiúsculas) e em Valor da variável digite o endereço do diretório em que o Gradle foi instalado, no meu caso C:\Gradle\gradle-7.0, clique em Ok;
- Selecione a variável do sistema Path, clique em Editar, clique em Novo, digite %GRADLE_HOME%\bin. Por fim, clique em Ok e Ok;
- Abra seu prompt de comando para testar se tudo deu certo, digite o comando

> gradle -version

Se o resultado obtido NÃO foi

'gradle' não é reconhecido como um comando interno…
