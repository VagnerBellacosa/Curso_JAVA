# Assert

A partir da ves�o 1.4, o recurso de assertivas (assert) permitir�o que voc� teste suposi��es durante o desenvolvimento sem o desgaste de escrever manipuladores para exce��es que se sup�e nunca ocorrer�o, uma vez que o programa tiver sa�do da fase de desenvolvimento e for totalmente distribu�do.

Se voc� n�o quer perder tempo ou trazer impacto ao desempenho do programa escrevendo um c�digo de manipula��o de exce��es ou n�o deseja teste IF/else j� que se chegar a condi��o else, significa que a l�gica anterior falhou ent�o  as assertivas permite que voc� teste suas suposi��es durante a fase de desenvolvimento.

Assertivas funcionam de maneira bem simples sempre que voc� quer ter certeza que o valor testado jamais pode vai ser falso caso contrario m erro  AssertionError (que n�o � poss�vel manipular) � lan�ado.

assert (boolean) : string;

Entre (  ) sempre ter� que ser um valor booleano e true, caso contrario uma exce��o � lan�ada (AssertionError).

Por padr�o assert vem desabilitado para desfrutar do recurso � necess�rio ativ�-lo.

1.Compilando





```

javac  -source 1.5 classe.java 
```


2.Habilita

```
java �ea classe
```

ou

```
java �enableAssertion minhaclss
```

3.Desabilita

```
java �de classe
```

ou

```
java �disableAssertion classe
```

### Regras de uso Assert:

- Assertion n�o pode ser usado no lugar do IF
- Assertion n�o pode testar m�todos p�blicos ou argumento digitado pelo usu�rio
- N�o pode apresentar efeitos colaterais* no programa. Ou seja, o seu programa deve rodar tanto com ele habilitado ou n�o.

Usar assertivas capazes de causar efeitos colaterais pode levar a alguns dos bugs mais enlouquecedores e dif�ceis de encontrar (Kathy Sierra, 2006)

N�o � objetivo de assertivas substituir o uso IF/ELSE, tratamentos de exce��es. O uso de assertivas � no ambiente de desenvolvimento (debug) e n�o distribui��o.

Na pr�tica:

```
class Asert{

      private static void setD(int z){
    
            boolean b=true;
    
            assert(z>0):� algu�m alterou o valor da linha 3 �;
    
            assert(b=false);
    
            System.out.println(z);
    
      }
    
      public static void main(String args[]){
    
            setD(1);
    
      }}
```

```
class Assert{

      //usando assertivas    
    
      public static void main(String args[]){       
    
            int taxajuros=4;
    
            assert(taxajuros==2):�algum programador mudou o valor da int taxajuros na linha 6�;
    
            System.out.println(true);
    
      }}
```

Agora basta compilar com assert, e ativar em tempo de execu��o! E verificar a ess�ncia desse recurso.

[Artigo original](https://blog.camilolopes.com.br/boas-praticas-de-programacao-assert/)