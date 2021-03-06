# Java

## Qual a diferen�a entre JDK, JRE e JVM

##### Gustavo Furtado de Oliveira Alves

### Indice

[Fluxo do Java](### O fluxo � basicamente o seguinte:)
[JVM - M�quina Virtual do Java](## JVM - M�quina Virtual do Java)
[JRE - Ambiente de Execu��o Java](## JRE - Ambiente de Execu��o Java)
[JDK - Kit de Desenvolvimento Java](## JDK - Kit de Desenvolvimento Java)
[Uma vis�o geral](## Uma vis�o geral)

Uma grande confus�o que paira sobre quem est� come�ando a aprender sobre o mundo Java � a diferen�a entre JDK, JRE e JVM. Neste post voc� vai entender, de uma vez por todas, a diferen�a entre essas tr�s siglas e porque � importante saber para que serve cada um.

A primeira coisa que voc� precisa saber � que o Java � muito conhecido por trazer o conceito de multi-plataforma. Na verdade esse � o motivo do grande sucesso do Java � mais de vinte anos! O famoso WORA (Write once, run anywhere.), ou em bom portugu�s: "Escreva uma vez, execute em qualquer lugar".

Na pr�tica, s� de entender esse conceito e como o Java faz para tornar poss�vel escrever um �nico c�digo e execut�-lo em qualquer sistema operacional, voc� j� vai perceber, por alto, a diferen�a entre JDK, JRE e JVM e onde cada um se encaixa.

### O fluxo � basicamente o seguinte:

- Voc� escreve o seu c�digo-fonte (arquivo com a extens�o .java).
- Voc� utiliza o JDK para compilar o seu c�digo-fonte e gerar o arquivo bytecode (arquivo com a extens�o .class).
- Para executar o seu programa, a JVM l� o seu arquivo compilado (.class) e as bibliotecas padr�es do Java que est�o no JRE.
- Pronto, seu programa est� rodando e todo mundo est� feliz! :)

Ent�o, a grosso modo, j� deu pra perceber pra qu� serve cada um:

- **JDK (Java Development Kit)** � o Kit de Desenvolvimento Java respons�vel por compilar c�digo-fonte (*.java*) em bytecode (*.class*)
- **JVM (Java Virtual Machine)** � a M�quina Virtual do Java repons�vel por executar o bytecode (*.class*)
- **JRE (Java Runtime Environment)** Ambiente de Execu��o do Java que fornece as bibliotecas padr�es do Java para o JDK compilar o seu c�digo e para a JVM executar o seu programa.

Este � o b�sico que voc� precisa saber sobre essas tr�s siglas e como o Java funciona.

Mas estes 3 componentes t�m um certo relacionamento entre eles. Vamos nos aprofundar um pouco mais o entendimento de cada um e como eles se relacionam entre s� para possibilitar a "m�gica" do mundo Java.

## JVM - M�quina Virtual do Java

J� vimos que a JVM � a responsavel por executar os programas no formato bytecode, certo? Mas a JVM n�o � s� isso, ela � na verdade o cora��o do Java, repons�vel por fornecer a tal capacidade de multi-plataforma.

Isso porque depois que voc� instala a JVM no sistema operacional (Windows, Linux, Mac, etc.), Ela � capaz de interpretar e executar o programa compilado em formato bytecode em qualquer um desses SOs.

Um coisa legal de perceber aqui � que a JVM executa um programa bytecode, mesmo que este programa bytecode n�o tenha sido escrito em Java necessariamente.

Isso mesmo! Voc� n�o precisa programar na linguagem java, para executar um programa na JVM. Voc� pode criar seus programas em outras linguagens que tamb�m geram arquivos bytecode. Existem v�rias delas, alguns exemplos s�o: Scala, JRuby, Jython, Clojure, Groovy, etc..

Outro ponto importante � que a JVM �, na verdade, uma especifica��o. Isso significa que uma JVM pode ser desenvolvida por qualquer organiza��o, desde que sigam as especifica��es para a Java Virtual Machine.

## JRE - Ambiente de Execu��o Java

O JRE prov� os requisitos m�nimos para executar um programa java. Ele cont�m uma JVM, os pacotes b�sicos do Java (API core), por exemplo o pacote lang que tem a classe String.

Por fim o JRE tamb�m prov� ferramentas para executar os programas java. Uma delas � o execut�vel java.exe, que � utilizado para executar uma classe java que cont�m um m�todo main(String args[]).

Agora voc� j� sabe que quando voc� executa o comando java SuaClasse, � o JRE que prov� esse programa java.exe que voc� est� usando.

## JDK - Kit de Desenvolvimento Java

O JDK � Kit que prov� ferramentas para o desenvolvimento de programas Java. Ou seja, ele cont�m um compilador, um depurador e o pr�prio JRE para voc� executar os seus programas.

� o JDK que nos prov� o programa javac.exe, que compila c�digos .java em bytecodes.class.

Agora voc� j� sabe q eu quando voc� executa o comando javac SuaClasse.java, � o JDK que prov� esse programa javac.exe que voc� est� usando.

## Uma vis�o geral

Agora que voc� j� sabe um pouco mais sobre JDK, JRE e JVM, voc� j� deve ter percebido que a JDK traz tamb�m um JRE, e o JRE, por sua vez, traz tamb�m uma implementa��o da JVM.

A imagem abaixo ilustra a rela��o entre esses componentes.

### JDK, JRE e JVM

Espero que este post tenha sido esclarecedor para voc� e que tenha contribu�do um pouco com o seu aprendizado.

Se tiver alguma d�vida, fique � vontade para postar a� nos coment�rios!

**Refer�ncias:**

[Java.com: TechInfo](https://www.java.com/pt_BR/download/faq/techinfo.xml)
[Artigo original](https://dicasdejava.com.br/qual-a-diferenca-entre-jdk-jre-e-jvm/)