package Universidad.RPA.UnidadTres.ejercicioDos;

import java.util.Scanner;
import static Universidad.RPA.UnidadTres.ejercicioUno.modulos.convertirASeg;

public class puntoA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la hora de despegue del vuelo: ");
        int hora = sc.nextInt();
        System.out.println("Ingrese el minuto de despegue del vuelo: ");
        int minuto = sc.nextInt();
        System.out.println("Ingrese el segundo de despegue del vuelo: ");
        int segundo = sc.nextInt();
        int horarioLlegada = convertirASeg(hora,minuto,segundo);
        System.out.println("Ingrese la hora del arribo del vuelo: ");
        hora = sc.nextInt();
        System.out.println("Ingrese el minuto del arribo del vuelo: ");
        minuto = sc.nextInt();
        System.out.println("Ingrese el segundo del arribo del vuelo: ");
        segundo = sc.nextInt();
        int horarioArribo = convertirASeg(hora,minuto,segundo);
        int tiempoVuelo = horarioArribo-horarioLlegada;
        segundo = tiempoVuelo%60;
        tiempoVuelo = tiempoVuelo/60;
        minuto = tiempoVuelo%60;
        hora = tiempoVuelo/60;
        System.out.println("El vuelo tardara: "+hora+"hs "+minuto+"min "+segundo+"seg");

    }
}
