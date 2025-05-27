package Universidad.RPA.UnidadTres.ejercicioUno;

import java.util.Scanner;
import static java.lang.Math.*;
public class puntoD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la base del triangulo: ");
        double base = sc.nextDouble();
        System.out.println("Ingrese la altura del triangulo: ");
        double altura = sc.nextDouble();
        System.out.println("La hipotenusa del triangulo ingresado es: "+calcularHipotenusa(base, altura));
    }
    public static double calcularHipotenusa(double base, double altura) {
        return sqrt(base*base+altura*altura);
    }
}
