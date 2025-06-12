package Universidad.RPA.UnidadCinco;
import java.util.Scanner;
import static Universidad.RPA.modulos.*;
public class enunciadoUno {
    public static void main(String[] args) {
        int num;
        int total = 0;
        int i=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        do {
            i++;
            num = sc.nextInt();
            total += num;
        }while(num>0);
        double promedio = (double)total/i;
        System.out.println("La suma de los numeros ingresados es: "+total+", y el promedio es de: "+promedio);
    }
}
