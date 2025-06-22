package Universidad.RPA.UnidadCinco;

import java.util.Scanner;

public class simulacroTres {
    public static void main(String[] args) {
        double precioXKilo, cantKilo, precioFinal, totalKilo = 0, montoFinal = 0, maxKilo = 0;
        String respuesta;
        char formaPago;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a la verduleria \"Rodolfo\"");
        System.out.println("¡¡¡Promoción!!!: si lleva 3 o más kilos de cualquier producto, o paga en efectivo se le aplica un 10% de descuento a su compra");
        do {
            System.out.println("Ingrese el precio por kilo del producto a comprar: ");
            precioXKilo = sc.nextDouble();
            System.out.println("Ingrese la cantidad de kilos del producto a comprar: ");
            cantKilo = sc.nextDouble();
            System.out.println("Ingrese la forma de pago, ingrese \"e\" si desea pagar en efectivo, u \"o\" para otro metodo de pago");
            sc.nextLine();
            formaPago = sc.nextLine().charAt(0);
            precioFinal = calcularprecio(precioXKilo, cantKilo, formaPago);
            totalKilo += cantKilo;
            montoFinal += precioFinal;
            if(maxKilo < cantKilo){
                maxKilo = cantKilo;
            }
            System.out.println("El precio del producto a comprar es: " + precioFinal);
            System.out.println("¿Desea seguir comprando?");
            System.out.println("Ingrese \"si\" o \"no\"");
            respuesta = sc.nextLine();
        }while(respuesta.equals("si"));
        System.out.println("El monto final de su compra es de: $"+montoFinal);
        System.out.println("La cantidad total de kilos de la compra es de: "+totalKilo);
        System.out.println("La mayor cantidad de kilos de la compra es de: "+maxKilo);
    }
    public static double calcularprecio(double precioXKilo, double cantKilo, char formaPago){
        double precio = precioXKilo*cantKilo;
        if(formaPago == 'e'){
            precio *=0.8;
        }
        return precio;
    }
}
