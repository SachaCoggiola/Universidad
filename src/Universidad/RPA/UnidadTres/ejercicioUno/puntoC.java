package Universidad.RPA.UnidadTres.ejercicioUno;

import java.util.Scanner;

public class puntoC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la primer distancia en cm: ");
        double distancia = sc.nextDouble();
        System.out.print("La primer distancia expresada en metros es: ");
        System.out.println(convertirCmAMtr(distancia));
        System.out.println("Introduzca la segunda distancia en cm: ");
        distancia = sc.nextDouble();
        System.out.print("La segunda distancia expresada en metros es: ");
        System.out.println(convertirCmAMtr(distancia));
        System.out.println("Introduzca la tercer distancia en cm: ");
        distancia = sc.nextDouble();
        System.out.print("La tercer distancia expresada en metros es: ");
        System.out.println(convertirCmAMtr(distancia));
    }
    public static double convertirCmAMtr(double distancia){
        return distancia/100;
    }
}
