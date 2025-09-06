package Universidad.DesarrolloAlgoritmo.TDA;
import java.util.Scanner;

public class testTerreno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Terreno miTerrenito = new Terreno(1,25,10,1);
        double largoCerco = miTerrenito.perimetro()*3;
        double costoLimpieza = 0;
        double precioMtr2 = 0;
        System.out.println("El perimetro de mi terrenito es: "+miTerrenito.perimetro());
        System.out.println("Se necesitan un total de "+largoCerco+"m para rodear 3 veces el terreno.");
        System.out.println("El terrenito tiene una superficie de: "+miTerrenito.superficie());
        costoLimpieza = miTerrenito.valorM2(150);
        System.out.println("Limpiar el terrenito tiene un costo de: "+costoLimpieza);
        System.out.println("Ingrese el precio del metro cuadrado del terrenito: ");
        precioMtr2 = sc.nextDouble();
        System.out.println("El valor del terrino es de: $"+miTerrenito.valorM2(precioMtr2));
    }
}
