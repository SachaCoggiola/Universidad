package Universidad.RPA.UnidadTres;

import java.util.Scanner;

public class puntoSeis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la base del prisma rectangular: ");
        double base = sc.nextDouble();
        System.out.println("Introduzca la altura del prisma rectangular: ");
        double altura = sc.nextDouble();
        System.out.println("Introduzca la profundidad del prisma rectangular: ");
        double profundidad = sc.nextDouble();
        System.out.println("El volumen del prisma rectangular es de: " + calcularVolumen(base, altura, profundidad));
    }
    public static double calcularVolumen(double base, double altura, double profundidad){
        return base*altura*profundidad;
    }
}
