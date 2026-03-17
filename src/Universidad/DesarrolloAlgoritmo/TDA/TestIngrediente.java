package Universidad.DesarrolloAlgoritmo.TDA;
import java.util.Scanner;

public class TestIngrediente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ingrediente[] ingredientes = new Ingrediente[3];
        int gr;
        for(int i=0;i<3;i++){
            System.out.println("ingrese los gr");
            gr=sc.nextInt();
            ingredientes[i] = new Ingrediente("Harina", gr ,"Gramos");
        }
        System.out.println(ingredientes[0].toString());
        System.out.println(ingredientes[1].toString());
        System.out.println(ingredientes[2].toString());
    }
}
