package Universidad.DesarrolloAlgoritmo.Array;
import java.util.Scanner;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;

public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el largo del arreglo: ");
        int largo = sc.nextInt();
        String[] array = new String[largo];
        cargarArray(array,sc);
        array = compactarArray(array);
        imprimirArray(array);
    }
    public static boolean esValida(String s) {
        boolean esValida = s.length() >= 5;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))) {
                esValida = false;
            }
        }
        return esValida;
    }
    public static String[] compactarArray(String[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (esValida(array[i])) {
                array[j] = array[i];
                j++;
            }
        }
        String[] compactado = new String[j];
        for (int k = 0; k < j; k++) {
            compactado[k] = array[k];
        }
        return compactado;
    }
}
