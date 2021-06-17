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