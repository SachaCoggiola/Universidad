package Universidad.RPA.UnidadDos;

import java.util.Scanner;

public class puntoNueve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cotización de pesos a dolares: ");
        double cotizacion = sc.nextDouble();
        System.out.println("Ingrese la cantidad de pesos a convertir a dolares: ");
        int pesos = sc.nextInt();
        double dolares = pesos/cotizacion;
        System.out.println("La cantidad de pesos ingresada es convertida a dolares es: " + dolares);
    }
}
