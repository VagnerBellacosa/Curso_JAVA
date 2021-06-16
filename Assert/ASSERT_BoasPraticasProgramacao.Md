# Assert

A partir da vesão 1.4, o recurso de assertivas (assert) permitirão que você teste suposições durante o desenvolvimento sem o desgaste de escrever manipuladores para exceções que se supõe nunca ocorrerão, uma vez que o programa tiver saído da fase de desenvolvimento e for totalmente distribuído.

Se você não quer perder tempo ou trazer impacto ao desempenho do programa escrevendo um código de manipulação de exceções ou não deseja teste IF/else já que se chegar a condição else, significa que a lógica anterior falhou então  as assertivas permite que você teste suas suposições durante a fase de desenvolvimento.
 
Assertivas funcionam de maneira bem simples sempre que você quer ter certeza que o valor testado jamais pode vai ser falso caso contrario m erro  AssertionError (que não é possível manipular) é lançado.

assert (boolean) : string;

Entre (  ) sempre terá que ser um valor booleano e true, caso contrario uma exceção é lançada (AssertionError).

Por padrão assert vem desabilitado para desfrutar do recurso é necessário ativá-lo.

1.Compilando

...
javac  -source 1.5 classe.java
...

2.Habilita

...
java –ea classe
...

ou

...
java –enableAssertion minhaclss
...

3.Desabilita

...
java –de classe
...

ou

...
java –disableAssertion classe
...

### Regras de uso Assert:

- Assertion não pode ser usado no lugar do IF
- Assertion não pode testar métodos públicos ou argumento digitado pelo usuário
- Não pode apresentar efeitos colaterais* no programa. Ou seja, o seu programa deve rodar tanto com ele habilitado ou não.

Usar assertivas capazes de causar efeitos colaterais pode levar a alguns dos bugs mais enlouquecedores e difíceis de encontrar (Kathy Sierra, 2006)

Não é objetivo de assertivas substituir o uso IF/ELSE, tratamentos de exceções. O uso de assertivas é no ambiente de desenvolvimento (debug) e não distribuição.

Na prática:

...
class Asert{

      private static void setD(int z){

            boolean b=true;

            assert(z>0):” alguém alterou o valor da linha 3 “;

            assert(b=false);

            System.out.println(z);

      }

      public static void main(String args[]){

            setD(1);

      }}
...

...
class Assert{

      //usando assertivas    

      public static void main(String args[]){       

            int taxajuros=4;

            assert(taxajuros==2):“algum programador mudou o valor da int taxajuros na linha 6”;

            System.out.println(true);

      }}
...

Agora basta compilar com assert, e ativar em tempo de execução! E verificar a essência desse recurso.

[Artigo original](https://blog.camilolopes.com.br/boas-praticas-de-programacao-assert/)