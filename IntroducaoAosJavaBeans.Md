# Java

## Introdução aos JavaBeans

A arquitetura baseada em componentes oferece diversas vantagens ao desenvolvimento. Combinando componentes especializados, é possível montar um sistema complexo com pouca ou nenhuma programação. Do ponto de vista arquitetural, componentes são como “caixas pretas”, que oferecem funcionalidades específicas e possuem comportamento conhecido, tendo sido testados e usados em outros projetos.

No Java, os componentes são especificados através do padrão JavaBeans, que define regras de implementação e empacotamento. Neste artigo apresentaremos os conceitos fundamentais dos JavaBeans e desenvolveremos um componente visual completo. Além disso, veremos como configurar e instalar componentes na paleta de componentes do IDE NetBeans.

### Componentes em Java

Em Java um componente, denominado de JavaBean ou bean, é um objeto que segue a especificação JavaBean. Essa especificação define uma API e dita regras de configuração e comunicação entre componentes e convenções de programação, além de mecanismos de descoberta dinâmica (que permitem inspecionar as características do componente). As classes e interfaces da API JavaBeans estão no pacote java.beans, mas diversas outras normalmente são utilizadas na criação de beans: java.util.EventObject, java.awt.event, java.io.Serializable, java.lang.reflect etc.

De forma resumida, os JavaBeans têm as seguintes características:

- Possuem um construtor sem argumentos;
- Implementam java.io.Serializable;
- Definem métodos get/set para acesso às suas propriedades;
- Definem métodos add/remove para manipular listeners (detalhados adiante);
- São thread-safe.

Os JavaBeans não são necessariamente visuais; por exemplo, são usados na sua forma mais simples no desenvolvimento web e Java EE. Neste artigo, no entanto, nosso enfoque é na criação de um JavaBean visual, que faz uso de eventos e vários outros recursos sofisticados da API JavaBeans e do Swing/AWT. Nosso JavaBean segue o estilo dos “components” ou “widgets” usados em ambientes de desenvolvimento como Delphi e VB.

Um ponto interessante dos JavaBeans é que eles podem ser manipulados diretamente nos IDEs e, portanto, suas propriedades podem ser alteradas tanto em tempo de projeto quanto de execução. Além disso, o IDE salva o estado do componente para edição posterior, preservando os valores definidos pelo usuário (por isso o bean deve ser serializável).

## Propriedades

Os atributos de um bean são denominados propriedades. Um bean pode conter propriedades de diversos tipos como por exemplo cor, tamanho, fonte etc. Para permitir a manipulação dessas propriedades (que definem o estado do bean), devem ser fornecidos métodos de acesso get/set.

O padrão JavaBeans prevê quatro tipos de propriedades: simples (valor único), indexadas, bound (vinculadas) e constrained (restritas). Propriedades indexadas suportam um conjunto de valores que possuem, além dos métodos de acesso habituais (get/set), métodos para acesso individual a cada elemento. Propriedades do tipo bound permitem que objetos sejam avisados quando for alterado o valor da propriedade em questão. Propriedades constraint permitem que a alteração seja vetada antes de ocorrer (é possível impedir que a alteração aconteça lançando-se uma exceção java.beans.PropertyVetoException).

## Eventos

A interação entre JavaBeans é feita através de um modelo de eventos (event model) conhecido como modelo de delegação (delegation model). Esse modelo segue o pattern Observer: um objeto (denominado source) é responsável por criar o evento e dispará-lo. Os objetos interessados em receber notificações sobre a ocorrência do evento (listeners) se inscrevem e são avisados sempre que um evento ocorre, podendo agir sobre ele.

Como veremos adiante, o objeto source (normalmente o bean) define métodos para registrar listeners utilizando a convenção add/remove.

## Implementando JavaBeans

Vamos passar à construção de um exemplo completo. Desenvolveremos um TreeMap, que é uma representação gráfica “planar” de uma árvore a partir de um retângulo. O algoritmo que desenha a árvore (denominado slice and dice) efetua divisões sucessivas do retângulo, de acordo com o valor atribuído a cada nó [1]. Os nós são representados por retângulos e cada nível da árvore é desenhado em tonalidade distinta, o que permite enxergar simultaneamente diversos níveis.

As Figuras de 1 a 5 mostram o funcionamento do TreeMap. Mais detalhes sobre a teoria por trás dos TreeMaps podem ser encontrados nas referências ao final do artigo.

## Estrutura de uma árvore e sua representação através de um TreeMap

Figura 1. Estrutura de uma árvore e sua representação através de um TreeMap

Cada nível da árvore é desenhado em uma tonalidade distinta e a visualização dos nós pode ser alterada através da tecla SHIFT e cliques nos botões do mouse (esquerdo ou direito). Inicialmente os nós SUDESTE e NORDESTE são exibidos (ambos os nós estão no nível 2 da árvore).

- Pressionando-se simultaneamente a tecla SHIFT e o botão esquerdo do mouse sobre o nó NORDESTE, os filhos desse nó são exibidos
- Pressionando-se simultaneamente a tecla SHIFT e o botão esquerdo do mouse sobre os nós SUDESTE, BAHIA e CEARÁ, os filhos de cada um dos nós são mostrados

[Artigo original](https://www.devmedia.com.br/introducao-aos-javabeans/8621)