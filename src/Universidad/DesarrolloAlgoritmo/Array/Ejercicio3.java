package Universidad.DesarrolloAlgoritmo.Array;
import Universidad.DesarrolloAlgoritmo.Modulos;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        int largo = 1;
        int numero = 0;
        System.out.println("Ingrese el largo del array: ");
        Scanner sc = new Scanner(System.in);
        largo = sc.nextInt();
        if(largo<=0)
            largo=1;
        int[] array = new int[largo];
        for(int i=0; i<largo; i++){
            System.out.println("Ingrese el entero de la posicion "+(i+1));
            array[i] = sc.nextInt();
        }
        System.out.println("Ingrese el numero a reemplazar en el array: ");
        numero = sc.nextInt();
        for(int i=0; i<largo; i++){
            if(i%2==0)
                array[i] = numero;
        }
        Modulos.imprimirArray(array);
    }
}
