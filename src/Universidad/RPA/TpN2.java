package Universidad.RPA;

import java.util.Scanner;

public class TpN2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el precio base del producto seleccionado");
        int precio = sc.nextInt();
        System.out.println("Ingrese el porcentaje de IVA que se le aplica al producto (solo ingrese el valor numerico)");
        int iva = sc.nextInt();
        System.out.println("Ingrese el porcentaje de descuento que se le aplica al producto (solo ingrese el valor numerico)");
        int descuento = sc.nextInt();
        System.out.println("El precio final del producto es de: " + calculoPrecioFinal(precio, iva, descuento));
    }
    public static float calculoPrecioFinal(int precio, int iva, int descuento){
        int subTotal = precio - (descuento * precio/100);
        float total = subTotal -((float)(iva * subTotal) /100);
        return total;
    }
}
