package Universidad.DesarrolloAlgoritmo;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] array = new char[100];
        int i = 0;
        char letra;
        System.out.println("Cargue el array con letras. Ingrese el caracter $ si desea finalizar la carga de datos.");
        do {
            System.out.println("Ingrese la letra de la posicion N°"+(i+1)+": ");
            letra = sc.next().charAt(0);
            if(verificarLetra(letra)||letra=='$'){
                array[i] = letra;
                i++;
            }else {
                System.out.println("El caracter ingresado no es una letra, intente nuevamente.");
            }
        }while (i < array.length&&letra!='$');
        i--;
        array[i]=' ';
        System.out.println("La cantidad de letras guardadas en el array es de: "+i);

    }
}
