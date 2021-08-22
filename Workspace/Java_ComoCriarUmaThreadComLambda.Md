# Java

## Como criar uma Thread com Lambda
##### Por Gustavo Furtado de Oliveira Alves

As funções lambda introduzidas na versão 8 do java trouxeram muitos benefícios para a linguagem.

Um exemplo é a criação de Threads que agora ficou bem mais simples com lambda. Veja:

...
new Thread(() -> <seu código aqui>).start();
...

O exemplo acima, cria uma Thread com o seu código e já inicia essa nova thread.

Vamos ver um exemplo prático.

O código abaixo cria uma Thread em que imprime um texto após 3 segundos.

...
public class TesteThreadLambda {
    public static void main(String[] args){
        new Thread(() -> {
            System.out.println("Executando a Thread. Espere 1 segundo.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finalizando a Thread.");
        }).start();
        System.out.println("Finalizou a thread main.");
    }
}
...

Para verificar o funcionamento da Thread, podemos ver que o texto Finalizou a thread main. foi impresso antes da Thread criada iniciar. Veja a execução deste código na imagem abaixo.

[Artigo original](https://dicasdejava.com.br/java-como-criar-uma-thread-com-lambda/)