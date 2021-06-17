import java.util.Scanner;
public class InputTest
{
 public static void main(String[] args)
 {
 Scanner entrada = new Scanner(System.in);
 System.out.print("Qual é seu nome? ");
 String nome = entrada.nextLine();
 System.out.print("Quantos anos você tem? ");
 int idade = entrada.nextInt();
 System.out.println("Olá, " + nome + ". Sua idade é: " + idade);
 }
} 