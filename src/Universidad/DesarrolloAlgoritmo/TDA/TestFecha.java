package Universidad.DesarrolloAlgoritmo.TDA;
import java.util.Scanner;

public class TestFecha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day,month,year;
        System.out.println("Ingrese un dia en formato numerico: ");
        day = sc.nextInt();
        System.out.println("Ingrese un mes en formato numerico: ");
        month = sc.nextInt();
        System.out.println("Ingrese un año: ");
        year = sc.nextInt();
        Fecha miFecha = new Fecha(day,month,year);
        System.out.println(miFecha.toString());
        System.out.println("Transcurrieron unos "+miFecha.diasTranscurridos()+" días del año "+miFecha.getYear());
        System.out.println("Ingrese un dia en formato numerico: ");
        day = sc.nextInt();
        System.out.println("Ingrese un mes en formato numerico: ");
        month = sc.nextInt();
        System.out.println("Ingrese un año: ");
        year = sc.nextInt();
        Fecha segundaFecha = new Fecha(day,month,year);
        if(miFecha.esFechaAnterior(segundaFecha)){
            System.out.println("La fecha "+miFecha.toString()+" es anterior a la fecha: "+segundaFecha.toString());
        }
        System.out.println("Ingrese una cantidad de dias que quiera ir al futuro");
        miFecha.calcularFecha(sc.nextInt());
        System.out.println(miFecha.toString());
    }
}
