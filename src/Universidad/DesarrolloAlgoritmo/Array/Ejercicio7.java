package Universidad.DesarrolloAlgoritmo.Array;
import java.util.Scanner;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el largo del arreglo: ");
        int largo = sc.nextInt();
        if (largo < 1)
            throw new IllegalArgumentException("El arreglo no puede tener largo menor a uno(1)");
        String[] array = new String[largo];
        cargarArray(array,sc);
        System.out.println(generarCadena(array));
        System.out.println(generarCadenaReves(array));
    }
    public static String generarCadenaReves(String[] array){
        StringBuilder cadena = new StringBuilder();
        for (int i = array.length-1; i > 0; i--) {
            cadena.append(array[i]).append("_");
        }
        cadena.append(array[0]);
        return cadena.toString();
    }
}
