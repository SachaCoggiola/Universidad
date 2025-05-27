package Universidad.RPA.UnidadTres.ejercicioDos;

import java.util.Scanner;
import static Universidad.RPA.modulos.*;

public class punto2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el precio del primer producto");
        int precioUno = sc.nextInt();
        System.out.println("Ingrese la cantidad del primer producto que desee comprar");
        precioUno = precioUno * sc.nextInt();
        System.out.println("Introduzca el precio del segundo producto");
        int precioDos = sc.nextInt();
        System.out.println("Ingrese la cantidad del segundo producto que desee comprar");
        precioDos = precioDos * sc.nextInt();
        System.out.println("El monto final de la compra es de: "+calcularTotal(0,calcularPrecioFinal(precioUno,25),calcularPrecioFinal(precioDos,25)));
    }
}
