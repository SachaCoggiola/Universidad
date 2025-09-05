package Universidad.DesarrolloAlgoritmo;
import java.util.Scanner;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número el cual desea saber su tabla de multiplicación: ");
        int entero = sc.nextInt();
        System.out.println("Ingrese la cantidad de multiplos que desea conocer: ");
        int largo = sc.nextInt();
        int[] array = new int[largo];
        for (int i = 0; i < largo; i++)
            array[i] = entero * (i+1);
        imprimirArrayEntero(array);
    }
}
