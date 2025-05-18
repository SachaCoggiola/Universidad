package Universidad.RPA.UnidadTres.ejercicioUno;

import java.util.Scanner;

public class puntoE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la velocidad del objeto en kilometros por hora: ");
        int velocidad = sc.nextInt();
        System.out.println("Introduzca el tiempo que estuvo en movimiento el objeto en horas: ");
        double tiempo = sc.nextDouble();
        System.out.println("La distancia recorrida en kilometros es de: " + calcularDistancia(velocidad, tiempo));
    }
    public static double calcularDistancia(int velocidad, double tiempo){
        return velocidad * tiempo;
    }
}
