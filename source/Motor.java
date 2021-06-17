public class Motor
{
 //Atributos
 private int marcha = 0;
 private int rotação = 0;
 //Construtores
 public Motor(int marcha) { this.marcha = marcha; }
 public Motor() { }
 //Métodos
 public void sobeMarcha() { marcha++; }
 public void desceMarcha() { marcha--; }
 public int getMarcha() { return marcha; }
 
 //Outros métodos...
}