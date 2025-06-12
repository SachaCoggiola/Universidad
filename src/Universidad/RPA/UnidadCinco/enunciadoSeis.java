package Universidad.RPA.UnidadCinco;
import java.util.Scanner;
public class enunciadoSeis{
    public static void main(String[] args) {
        int cantVocales = 0;
        int cantPalabras = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una oración: ");
        String oracion = sc.nextLine();
        for(int i = 0; i<oracion.length(); i++){
            if(oracion.charAt(i)=='a'||oracion.charAt(i)=='e'||oracion.charAt(i)=='i'||oracion.charAt(i)=='o'||oracion.charAt(i)=='u'||oracion.charAt(i)=='A'||oracion.charAt(i)=='E'||oracion.charAt(i)=='I'||oracion.charAt(i)=='O'||oracion.charAt(i)=='U'){
                cantVocales++;
            }
            if(oracion.charAt(i)==' '){
                cantPalabras++;
            }
        }
        if(cantVocales==0){
            cantPalabras = 0;
        }
        System.out.println("La oracion ingresada tiene un cantidad de "+cantVocales+" vocales, y "+cantPalabras+" palabras.");
    }
}
