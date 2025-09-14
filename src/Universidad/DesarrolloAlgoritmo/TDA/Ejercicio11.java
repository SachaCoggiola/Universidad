package Universidad.DesarrolloAlgoritmo.TDA;
import java.util.Scanner;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el largo del primer arreglo: ");
        int[] array1 = new int[sc.nextInt()];
        System.out.println("Ingrese el largo del segundo arreglo: ");
        int[] array2 = new int[sc.nextInt()];
        cargarArray(array1,sc);
        cargarArray(array2,sc);
        if(compararArray(array1,array2)){
            System.out.println("Los arreglos son iguales");
        }else {
            System.out.println("Los arreglos son diferentes");
        }
    }
}
