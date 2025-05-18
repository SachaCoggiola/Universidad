package Universidad.RPA.UnidadDos;

import java.util.Scanner;

public class puntoSiete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el sueldo base del empleado: ");
        double sueldoBase = sc.nextDouble();
        System.out.println("Introduzca la bonificación del empleado: ");
        double bonificacion = sc.nextDouble();
        System.out.println("Introduzca los descuentos del empleado: ");
        double descuento = sc.nextDouble();
        double sueldoNeto = sueldoBase + bonificacion - descuento;
        System.out.println("El sueldo neto es: " + sueldoNeto);
    }
}
