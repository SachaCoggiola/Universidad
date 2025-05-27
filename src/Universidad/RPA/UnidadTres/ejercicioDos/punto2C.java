package Universidad.RPA.UnidadTres.ejercicioDos;

import java.util.Scanner;
import static Universidad.RPA.modulos.*;

public class punto2C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la altura, en centimetros, del primer triangulo: ");
        double altura = sc.nextDouble();
        System.out.println("Ingrese la base del triangulo: ");
        double base = sc.nextDouble();
        double hipotenusa = calcularHipotenusa(altura, base);
        System.out.println("Ingrese la altura, en centimetros, del segundo triangulo: ");
        altura = sc.nextDouble();
        System.out.println("Ingrese la base del segundo triangulo: ");
        base = sc.nextDouble();
        hipotenusa = convertirCmAMtr(hipotenusa);
        System.out.println("La hipotenusa del primer triangulo tiene un valor de "+hipotenusa+" metros.");
        hipotenusa = calcularHipotenusa(altura, base);
        hipotenusa = convertirCmAMtr(hipotenusa);
        System.out.println("La hipotenusa del segundo triangulo tiene un valor de "+hipotenusa+" metros." );
    }
}
