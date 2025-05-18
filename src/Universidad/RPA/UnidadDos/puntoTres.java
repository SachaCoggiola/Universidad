package Universidad.RPA.UnidadDos;
import java.util.Scanner;

public class puntoTres {
    public static void main (String[] args) {
        System.out.println("Ingrese la cantidad total de productos en formato numerico decimal: ");
        Scanner sc = new Scanner(System.in);
        int cantidadProductos = sc.nextInt();
        double precioTotal = 0;
        double precioProducto;
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.println("Ingrese el precio del producto numero " + (i + 1) + ": ");
            precioProducto = sc.nextDouble();
            precioTotal = precioTotal + precioProducto;
        }
        System.out.println("El precio del producto total es: " + "$" + precioTotal);
    }
}
