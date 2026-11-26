package Universidad.DesarrolloAlgoritmo;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;

public class insertionSort {
    public static void main(String[] args) {
        String[] arreglo = {  "Enrique", "Daria", "Aroa", "Franco", "Bautista", "Camila" };
        imprimirArray(arreglo);
        System.out.println();
        insercion(arreglo);
        imprimirArray(arreglo);
    }
    public static void sortDecreciente(int[] arr){
        int aux, j, n;
        n = arr.length;

        for(int i = 1; i < n; i++){
            aux = arr[i];
            j = i;
            while(j > 0 && aux > arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = aux;
        }
    }
    public static void sortcreciente(int[] arr){
        int aux, j, n;
        n = arr.length;

        for(int i = 1; i < n; i++){
            aux = arr[i];
            j = i;
            while(j > 0 && aux < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = aux;
        }
    }
    public static void insercion(String[] arr) {
        int j, i, n;
        n = arr.length;
        char aux;
        String palabraaux;
        char inicial;

        for (i = 1; i < n; i++) {
            palabraaux = arr[i];

            aux = obtenerInicial(arr[i]);

            j = i;
            inicial = obtenerInicial(arr[j - 1]);

            while (j > 0 && aux < inicial) {
                inicial = obtenerInicial(arr[j - 1]);
                if(aux < inicial){
                    arr[j] = arr[j - 1];
                    j--;
                }
            }

            arr[j] = palabraaux;
        }

    }

    public static char obtenerInicial(String nombre) {
        char inicial = nombre.charAt(0);
        return inicial;
    }
}
