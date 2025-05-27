package Universidad.RPA.UnidadTres.ejercicioDos;

import java.util.Scanner;
import static Universidad.RPA.modulos.*;

public class punto2B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la base de la caja en centimetros: ");
        double base = sc.nextDouble();
        System.out.println("Ingrese la altura de la caja: ");
        double altura = sc.nextDouble();
        System.out.println("Ingrese la profundidad de la caja: ");
        double profundidad = sc.nextDouble();
        base = convertirCmAMtr(base);
        altura = convertirCmAMtr(altura);
        profundidad = convertirCmAMtr(profundidad);
        System.out.println("El volumen de la caja es de "+calcularVolumenCuboide(base, altura, profundidad)+" metros cubicos");
    }
}
