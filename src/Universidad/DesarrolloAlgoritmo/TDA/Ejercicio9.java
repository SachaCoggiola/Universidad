package Universidad.DesarrolloAlgoritmo.TDA;
import java.util.Scanner;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el largo del arreglo: ");
        int largo = sc.nextInt();
        char[] array = new char[largo];
        caracterArray(array);
        System.out.println("Ingrese el caracter que desea verificar si se encuentra en el arreglo: ");
        char caracter = sc.next().charAt(0);
        if(buscarCaracter(array,caracter)){
            System.out.println("El caracter se encuentra en el arreglo.");
        }
        System.out.println("El caracter se repite unas "+cantidadCaracteres(array,caracter)+" cantidad de veces.");
    }
}
