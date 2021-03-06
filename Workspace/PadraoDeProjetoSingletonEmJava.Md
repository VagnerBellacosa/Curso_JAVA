# Java

## Padr�o de Projeto Singleton em Java

### Introdu��o

Os Design Patterns (Padr�es de Projetos) s�o arquiteturas testadas para construir softwares orientados a objetos flex�veis e sustent�veis. Os padr�es ajudam a reduzir substancialmente a complexidade do processo de design.

Padr�es de Projetos tem sua origem no trabalho de um arquiteto chamado Christopher Alexander que escreveu dois livros de bastante sucesso onde ele exemplificava o uso e descrevia seu racioc�nio para documentar os padr�es para a arquitetura. Por�m em 1995 um grupo de quatro profissionais basearam-se em Christopher Alexander e escreveram o livro "Design Patterns: Elements of Reusable Object-Oriented Software" [Gamma95] que continha um cat�logo com 23 padr�es de projetos (Design Patterns) orientados a software. A id�ia dos autores do livro era documentar problemas recorrentes que acontecia nos softwares.

Os Design Patterns s�o uma cole��o de padr�es de projeto de software que cont�m solu��es para problemas conhecidos e recorrentes no desenvolvimento de software descrevendo uma solu��o comprovada para um problema de projeto recorrente. A Documenta��o desses padr�es permite o reuso e o compartilhamento dessas informa��es sobre a melhor maneira de se resolver um problema de projeto de software.

Neste artigo ser� descrito um importante Padr�o de Projeto muito utilizado pelos desenvolvedores de software que � o Singleton na qual ser� mais detalhado nas se��es subseq�entes do artigo.

## Funcionamento

O padr�o Singleton permite criar objetos �nicos para os quais h� apenas uma inst�ncia. Este padr�o oferece um ponto de acesso global, assim como uma vari�vel global, por�m sem as desvantagens das vari�veis globais. Para entendermos e usarmos bem o padr�o de Projeto Singleton � necess�rio apenas dominar bem as vari�veis e m�todos de classe est�ticos al�m dos modificadores de acesso.

O Padr�o Singleton tem como defini��o garantir que uma classe tenha apenas uma inst�ncia de si mesma e que forne�a um ponto global de acesso a ela. Ou seja, uma classe gerencia a pr�pria inst�ncia dela al�m de evitar que qualquer outra classe crie uma inst�ncia dela. Para criar a instancia tem-se que passar pela classe obrigatoriamente, nenhuma outra classe pode instanciar ela. O Padr�o Singleton tamb�m oferece um ponto global de acesso a sua inst�ncia. A pr�pria classe sempre vai oferecer a pr�pria inst�ncia dela e caso n�o tenha ainda uma inst�ncia, ent�o ela mesma cria e retorna essa nova inst�ncia criada.

O Diagrama de classe abaixo mostra mais detalhes sobre o funcionamento do padr�o Singleton.

Padr�o Singleton
	 Diagrama de classe do Padr�o Singleton.

No diagrama de classe acima tem-se o atributo singleton que � do tipo da sua pr�pria classe e � est�tico, nessa vari�vel tem-se a �nica inst�ncia da classe. Nos m�todos pode-se observar a presen�a do construtor da classe Singleton() que � PRIVADO. Ou seja, um construtor privado n�o permite que a classe seja instanciada a n�o ser que seja feito por ela mesmo na qual ser� instanciada pelo m�todo getInstance() que � est�tico e assim pode ser acessado de qualquer outra classe sem precisar instanciar Singleton. No exemplo veremos mais uma peculiaridade do m�todo getInstance().

#### Exemplo de Implementa��o

Segue abaixo um exemplo de implementa��o em Java utilizando o Padr�o Singleton.

Listagem 1: Exemplo de implementa��o do Padr�o Singleton.

...
public class Singleton {

	private static Singleton uniqueInstance;

	private Singleton() {
	}

	public static synchronized Singleton getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Singleton();

		return uniqueInstance;
	}
}
...

Acima temos a implementa��o do padr�o Singleton. Nesse exemplo nota-se a presen�a do synchronized, isso se deve pois se tir�ssemos o synchronized e tent�ssemos criar duas inst�ncias da classe num determinado momento verificar�amos que isso � poss�vel. Utilizando synchronized tem-se a certeza que o m�todo nunca ser� acessado por duas threads ao mesmo tempo.

O construtor � privado evitando que essa classe seja instanciada fora dela. Assim, para podermos instanciar ou acessar uma inst�ncia da classe criou-se um atributo p�blico e est�tico (da classe) que retorna atrav�s de um m�todo est�tico uma �nica inst�ncia dessa classe. Como getInstance() � est�tico ele pode ser chamado de outra classe sem precisar instanciar a classe Singleton. Caso a classe j� tenha sido instanciada o atributo n�o ser� nulo, assim retorna-se a �nica inst�ncia j� criada.

Tamb�m existem outras abordagens para a cria��o da inst�ncia da classe Singleton. Por exemplo, se uma determinada classe Singleton sempre � criada e usada, pode-se usar o c�digo abaixo:

Listagem 2: Exemplo de implementa��o do Padr�o Singleton instanciando direto.

...
public class Singleton {

	private static Singleton uniqueInstance = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return uniqueInstance;
	}
}
...

Prefira a abordagem da implementa��o acima caso o m�todo getInstance() tamb�m seja muito acessado, pois usar synchronized pode diminuir a performance da aplica��o. Note que a inst�ncia da classe ser� SEMPRE criada mesmo antes de chamar getInstance().

### Vantagens do Padr�o Singleton

O Padr�o Singleton pode ser instanciada e usada apenas quando necess�rio, diferentemente se cri�ssemos uma vari�vel global em que o objeto � sempre criado quando o aplicativo � inicializado e poder� estar usando recursos que n�o s�o necess�rios neste momento. O padr�o Singleton define um ponto �nico de acesso global sendo inclusive muito mais de gerenciar a cria��o e utiliza��o da inst�ncia.

## Conclus�o

O Padr�o Singleton � utilizado quando necessita-se de um ponto �nico para cria��o de uma inst�ncia de classe e quando precisamos de apenas uma inst�ncia de uma classe. O Padr�o Singleton � utilizado em diversos aplicativos e projetos de software como em Drivers que precisam de um ponto de acesso �nico e global para gerenciar diversos recursos. Tem-se diversas formas de implementar o padr�o Singleton e deve-se optar pela implementa��o que melhor atende aos requisitos da aplica��o.

### Bibliografia

Eric Freeman, Elisabeth Robson, Bert Bates, Kathy Sierra. Head First Design Patterns. O'Reilly Media, 2004.
Gamma, E., Helm, R., Johnson, R., Vlissides, J. Design Patterns: Elements of Reusable Object-Oriented Software. Addison Wesley, 2010.

[Artigo original](https://www.devmedia.com.br/padrao-de-projeto-singleton-em-java/26392)