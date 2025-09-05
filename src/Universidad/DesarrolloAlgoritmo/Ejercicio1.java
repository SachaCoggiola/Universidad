package Universidad.DesarrolloAlgoritmo;
import java.util.Scanner;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el largo del arreglo: ");
        int largo = sc.nextInt();
        char[] array = new char[largo];
       caracterArray(array);
        System.out.println("Si desea ver el array escrito al reves ingrese: R");
        sc.nextLine();
        if(sc.nextLine().equals("R")){
            imprimirArrayReves(array);
        }else
            imprimirArrayFilacCaracter(array);
    }
}
