package Universidad.RPA;

import java.util.Scanner;

public class puntoOcho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la primer calificación del estudiante: ");
        double notaUno = sc.nextFloat();
        System.out.println("Introduzca la segunda calificación del estudiante: ");
        double notaDos = sc.nextFloat();
        System.out.println("Introduzca la tercer calificación del estudiante: ");
        double notaTres = sc.nextFloat();
        double promedio = (notaUno + notaDos + notaTres)/3;
        System.out.println("El promedio es del estudiante es de: " + promedio);
    }
}
