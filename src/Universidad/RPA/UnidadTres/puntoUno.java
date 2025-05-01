package Universidad.RPA.UnidadTres;

import java.util.Scanner;

public class puntoUno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el precio del primer producto");
        int precio = sc.nextInt();
        System.out.println("Ingrese el descuento del primer producto");
        int descuento = sc.nextInt();
        int precioUno = calcularPrecioFinal(precio, descuento);
        System.out.println("Ingrese el precio del tercer producto");
        precio = sc.nextInt();
        System.out.println("Ingrese el descuento del segundo producto");
        descuento = sc.nextInt();
        int precioDos = calcularPrecioFinal(precio, descuento);
        System.out.println("Ingrese el precio del primer producto");
        precio = sc.nextInt();
        System.out.println("Ingrese el descuento del primer producto");
        descuento = sc.nextInt();
        int precioTres = calcularPrecioFinal(precio, descuento);
        System.out.println("El precio final de los productos ingresados es: $" + calcularTotal(precioUno, precioDos, precioTres));
    }
    public static int calcularPrecioFinal(int precio, int descuento){
        return precio-(descuento*precio)/100;
    }
    public static int calcularTotal(int precioUno, int precioDos, int precioTres){
        return precioUno+precioDos+precioTres;
    }
}
