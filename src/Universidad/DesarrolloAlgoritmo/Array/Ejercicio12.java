package Universidad.DesarrolloAlgoritmo.Array;
import java.util.Scanner;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;

public class Ejercicio12 {
    public static void main(String[] args) {
        int posicion;
        char caracter;
        int largo;
        char[] array;
        char[] arrayCopia;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el largo del arreglo: ");
        largo = sc.nextInt();
        array = new char[largo];
        cargarArray(array,sc);
        arrayCopia = copiarArray(array);
        do {
            System.out.println("Ingrese una posicion del arreglo: ");
            posicion = sc.nextInt()-1;
        } while (!validarNumero(posicion, 0, largo));
        System.out.println("Ingrese un caracter: ");
        caracter = sc.next().charAt(0);
        array[posicion] = caracter;
        System.out.println("El arreglo original es: ");
        imprimirArray(arrayCopia);
        System.out.println();
        System.out.println("El arreglo modificado es: ");
        imprimirArray(array);
    }
}
