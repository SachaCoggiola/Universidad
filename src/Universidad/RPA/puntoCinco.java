package Universidad.RPA;

import java.util.Scanner;

public class puntoCinco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la altura del triangulo: ");
        double altura = sc.nextDouble();
        System.out.println("Introduzca la base del triangulo: ");
        double base = sc.nextDouble();
        double area = (altura*base)/2;
        System.out.println("El area del triangulo es: " + area);
    }
}
