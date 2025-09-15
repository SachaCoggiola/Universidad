package Universidad.DesarrolloAlgoritmo.Array;
import java.util.Scanner;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el largo del arreglo: ");
        int largoArray = sc.nextInt();
        int largoArrayPar;
        int largoArrayImp = largoArray/2;
        String[] array = new String[largoArray];
        cargarArray(array,sc);
        if(largoArray%2==0){
            largoArrayPar = largoArray/2;
        }else {
            largoArrayPar = largoArray/2+1;
        }
        String[] arrayPar = new String[largoArrayPar];
        String[] arrayImp = new String[largoArrayImp];
        dividirArray(array,arrayPar,arrayImp);
        System.out.println("El arreglo par es: ");
        imprimirArray(arrayPar);
        System.out.println();
        System.out.println("El arreglo impar es: ");
        imprimirArray(arrayImp);
    }
}
