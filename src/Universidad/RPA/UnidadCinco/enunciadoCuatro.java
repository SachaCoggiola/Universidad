package Universidad.RPA.UnidadCinco;
import java.util.Scanner;

public class enunciadoCuatro {
    public static void main(String[] args) {
        int i = 0;
        int num;
        int max = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Ingrese un numero: ");
            num = sc.nextInt();
            System.out.println("El cuadrado del numero ingresado es: "+num*num);
            if(num > max){
                max = num;
            }
        }while(num != 0);
        System.out.println("El mayor númnero ingresado es: "+max);
    }
}
