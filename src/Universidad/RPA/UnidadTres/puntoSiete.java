package Universidad.RPA.UnidadTres;

import java.util.Scanner;

public class puntoSiete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese las horas: ");
        int horas = sc.nextInt();
        System.out.println("Ingrese los minutos: ");
        int minutos = sc.nextInt();
        System.out.println("Ingrese los segundos: ");
        int segundos = sc.nextInt();
        System.out.println("La cantidad total de tiempo ingresado expresado en segundos es: "+convertirASeg(horas, minutos, segundos));
    }
    public static int convertirASeg(int horas, int minutos, int segundos){
        return (horas * 3600 + minutos * 60 + segundos);
    }
}
