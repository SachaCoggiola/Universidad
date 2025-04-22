package cosas;

import java.util.Scanner;

public class calculadoraPrecioJuegos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el precio del juego en USD: ");
        double precio = entrada.nextDouble();
        System.out.println("Ingrese la cotizacion del dolar actual: ");
        double cotizacion = entrada.nextDouble();
        double precioJuego = precio * cotizacion + (precio * cotizacion * 21)/100;
        System.out.println("El precio del juego es: " + precioJuego);
    }
}
