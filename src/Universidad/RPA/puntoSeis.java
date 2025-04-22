package Universidad.RPA;

import java.util.Scanner;

public class puntoSeis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la cantidad de minutos: ");
        int minutos = sc.nextInt();
        int horas;
        for (horas = 0; minutos >= 60; horas++) {
            minutos = minutos - 60;
        }
        System.out.println("La cantidad de minutos ingresados, escrito en horas y minutos es de: " + horas + " horas y " + minutos + " minutos." );
    }
}
