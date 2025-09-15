package Universidad.DesarrolloAlgoritmo.Array;
import java.util.Scanner;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;

public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el N°DNI de 8 cifras: ");
        int numDni = sc.nextInt();
        validarNumero(numDni,1,99999999);
        System.out.println("N°DNI: "+convertirACadena(numDni,conseguirLetra(numDni%23)));
    }
    public static char conseguirLetra(int posicion){
        char[] codigoLetras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        return codigoLetras[posicion];
    }
    public static String convertirACadena(int numero,char letra){
        return String.format("%08d%c", numero, letra);
    }
}
