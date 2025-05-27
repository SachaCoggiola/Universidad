package Universidad.RPA.UnidadTres;

import java.util.Scanner;
import static Universidad.RPA.modulos.*;

public class ejercicioTres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la base de la caja: ");
        double base = sc.nextDouble();
        System.out.println("Ingrese la altura de la caja: ");
        double altura = sc.nextDouble();
        System.out.println("Ingrese la profundidad de la caja: ");
        double profundidad = sc.nextDouble();
        System.out.println("Ingrese la cantidad de cajas a fabricar: ");
        int cantidad = sc.nextInt();
        double mtrCuadrados = calcularVolumenCuboide(base, altura, profundidad)*cantidad;
        mtrCuadrados = convertirCmAMtr(mtrCuadrados);
        System.out.println("Ingrese el precio por metro cuadrado de carton:");
        int precioCarton = sc.nextInt();
        System.out.println("La cantidad total de metros cuadrados de carton necesarios para hacer "+cantidad+" cajas, con una base de "+base+", altura de "+altura+" y profundidad de "+profundidad+". Es de "+ mtrCuadrados);
        System.out.println("Además, el monto total por "+mtrCuadrados+" metros cuadrados de carton es de "+calcularMonto(precioCarton,mtrCuadrados));
    }
}
