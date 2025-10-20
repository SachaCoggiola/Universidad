package Universidad.DesarrolloAlgoritmo.TDA;
import java.util.Scanner;

public class TestIngrediente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ingrediente harina = new Ingrediente("Harina","Gramos");
        System.out.println("Ingrese la cantidad, en gramos, de harina que tenga:");
        harina.setCantidad(sc.nextDouble());
        System.out.println(harina.toString());
    }
}
