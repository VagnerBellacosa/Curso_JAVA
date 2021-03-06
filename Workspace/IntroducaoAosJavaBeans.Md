# Java

## Introdu��o aos JavaBeans

A arquitetura baseada em componentes oferece diversas vantagens ao desenvolvimento. Combinando componentes especializados, � poss�vel montar um sistema complexo com pouca ou nenhuma programa��o. Do ponto de vista arquitetural, componentes s�o como �caixas pretas�, que oferecem funcionalidades espec�ficas e possuem comportamento conhecido, tendo sido testados e usados em outros projetos.

No Java, os componentes s�o especificados atrav�s do padr�o JavaBeans, que define regras de implementa��o e empacotamento. Neste artigo apresentaremos os conceitos fundamentais dos JavaBeans e desenvolveremos um componente visual completo. Al�m disso, veremos como configurar e instalar componentes na paleta de componentes do IDE NetBeans.

### Componentes em Java

Em Java um componente, denominado de JavaBean ou bean, � um objeto que segue a especifica��o JavaBean. Essa especifica��o define uma API e dita regras de configura��o e comunica��o entre componentes e conven��es de programa��o, al�m de mecanismos de descoberta din�mica (que permitem inspecionar as caracter�sticas do componente). As classes e interfaces da API JavaBeans est�o no pacote java.beans, mas diversas outras normalmente s�o utilizadas na cria��o de beans: java.util.EventObject, java.awt.event, java.io.Serializable, java.lang.reflect etc.

De forma resumida, os JavaBeans t�m as seguintes caracter�sticas:

- Possuem um construtor sem argumentos;
- Implementam java.io.Serializable;
- Definem m�todos get/set para acesso �s suas propriedades;
- Definem m�todos add/remove para manipular listeners (detalhados adiante);
- S�o thread-safe.

Os JavaBeans n�o s�o necessariamente visuais; por exemplo, s�o usados na sua forma mais simples no desenvolvimento web e Java EE. Neste artigo, no entanto, nosso enfoque � na cria��o de um JavaBean visual, que faz uso de eventos e v�rios outros recursos sofisticados da API JavaBeans e do Swing/AWT. Nosso JavaBean segue o estilo dos �components� ou �widgets� usados em ambientes de desenvolvimento como Delphi e VB.

Um ponto interessante dos JavaBeans � que eles podem ser manipulados diretamente nos IDEs e, portanto, suas propriedades podem ser alteradas tanto em tempo de projeto quanto de execu��o. Al�m disso, o IDE salva o estado do componente para edi��o posterior, preservando os valores definidos pelo usu�rio (por isso o bean deve ser serializ�vel).

## Propriedades

Os atributos de um bean s�o denominados propriedades. Um bean pode conter propriedades de diversos tipos como por exemplo cor, tamanho, fonte etc. Para permitir a manipula��o dessas propriedades (que definem o estado do bean), devem ser fornecidos m�todos de acesso get/set.

O padr�o JavaBeans prev� quatro tipos de propriedades: simples (valor �nico), indexadas, bound (vinculadas) e constrained (restritas). Propriedades indexadas suportam um conjunto de valores que possuem, al�m dos m�todos de acesso habituais (get/set), m�todos para acesso individual a cada elemento. Propriedades do tipo bound permitem que objetos sejam avisados quando for alterado o valor da propriedade em quest�o. Propriedades constraint permitem que a altera��o seja vetada antes de ocorrer (� poss�vel impedir que a altera��o aconte�a lan�ando-se uma exce��o java.beans.PropertyVetoException).

## Eventos

A intera��o entre JavaBeans � feita atrav�s de um modelo de eventos (event model) conhecido como modelo de delega��o (delegation model). Esse modelo segue o pattern Observer: um objeto (denominado source) � respons�vel por criar o evento e dispar�-lo. Os objetos interessados em receber notifica��es sobre a ocorr�ncia do evento (listeners) se inscrevem e s�o avisados sempre que um evento ocorre, podendo agir sobre ele.

Como veremos adiante, o objeto source (normalmente o bean) define m�todos para registrar listeners utilizando a conven��o add/remove.

## Implementando JavaBeans

Vamos passar � constru��o de um exemplo completo. Desenvolveremos um TreeMap, que � uma representa��o gr�fica �planar� de uma �rvore a partir de um ret�ngulo. O algoritmo que desenha a �rvore (denominado slice and dice) efetua divis�es sucessivas do ret�ngulo, de acordo com o valor atribu�do a cada n� [1]. Os n�s s�o representados por ret�ngulos e cada n�vel da �rvore � desenhado em tonalidade distinta, o que permite enxergar simultaneamente diversos n�veis.

As Figuras de 1 a 5 mostram o funcionamento do TreeMap. Mais detalhes sobre a teoria por tr�s dos TreeMaps podem ser encontrados nas refer�ncias ao final do artigo.

## Estrutura de uma �rvore e sua representa��o atrav�s de um TreeMap

Figura 1. Estrutura de uma �rvore e sua representa��o atrav�s de um TreeMap

Cada n�vel da �rvore � desenhado em uma tonalidade distinta e a visualiza��o dos n�s pode ser alterada atrav�s da tecla SHIFT e cliques nos bot�es do mouse (esquerdo ou direito). Inicialmente os n�s SUDESTE e NORDESTE s�o exibidos (ambos os n�s est�o no n�vel 2 da �rvore).

- Pressionando-se simultaneamente a tecla SHIFT e o bot�o esquerdo do mouse sobre o n� NORDESTE, os filhos desse n� s�o exibidos
- Pressionando-se simultaneamente a tecla SHIFT e o bot�o esquerdo do mouse sobre os n�s SUDESTE, BAHIA e CEAR�, os filhos de cada um dos n�s s�o mostrados

[Artigo original](https://www.devmedia.com.br/introducao-aos-javabeans/8621)