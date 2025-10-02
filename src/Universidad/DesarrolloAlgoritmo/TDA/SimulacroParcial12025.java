package Universidad.DesarrolloAlgoritmo.TDA;

import java.util.Scanner;

public class SimulacroParcial12025 {
    public static void main(String[] args) {
        Turno[][] turnos = new Turno[16][5];
    }
    public static void cargarTurno(Turno[][] turnos){
        Scanner sc = new Scanner(System.in);
        String dia, nombre, apellido, obraSocial, diagnostico;
        double montoCoseg;
        boolean asistio, finalizo;
        int dni, diasTratamiento, fila, columna, hora, min;
        do {
            System.out.println("Ingrese el dia del turno: ");
            dia = sc.nextLine();
            columna = obtenerDiaSemana(dia);
            if(columna == -1)
                System.out.println("El dia ingresado es invalido. Por favor intente de nuevo.");
        }while(columna == -1);
        do {
            System.out.println("Ingrese la hora del turno: "); //Usar LocalTime.of(int hora, int min) y cambiar modulo "obtenerHora"
            hora = sc.nextInt();
            System.out.println("Ingrese el minuto del turno: ");
            min = sc.nextInt();
            sc.nextLine();
            fila=obtenerHora(hora,min);
            if(fila == -1)
                System.out.println("La hora ingresada es invalida. Por favor intente de nuevo.");
        }while(fila==-1);
        do {
            System.out.println("Ingrese el dni del paciente del turno: ");
            dni = sc.nextInt();
            if(dniValido(dni))
                System.out.println("El DNI ingresado es invalido. Por favor intente de nuevo.");
        }while(dniValido(dni));
        sc.nextLine();
        System.out.println("Ingrese el nombre del paciente");
        nombre = sc.nextLine();
        System.out.println("Ingrese el apellido del paciente: ");
        apellido = sc.nextLine();
        System.out.println("Ingrese la obra social del paciente: ");
        obraSocial = sc.nextLine();
        turnos[fila][columna]= new Turno(dia,hora,dni,nombre,apellido,obraSocial);
    }
    public static int obtenerDiaSemana(String dia){
        int dias=-1;
        switch (dia.toLowerCase()) {
            case "lunes" -> dias = 0;
            case "martes" -> dias = 1;
            case "miercoles" -> dias = 2;
            case "jueves" -> dias = 3;
            case "viernes" -> dias = 4;
        }
        return dias;
    }
    public static int obtenerHora(int hora, int min){
        int fila=-1;
        switch (hora) {
            case 9 -> fila = 0;
            case 10 -> fila = 2;
            case 11 -> fila = 4;
            case 12 -> fila = 6;
            case 13 -> fila = 8;
            case 14 -> fila = 10;
            case 15 -> fila = 12;
            case 16 -> fila = 14;
            case 17 -> fila = 16;
        }
        if(min==30&&hora!=17){
            fila++;
        }
        return fila;
    }
    public static boolean dniValido(int dni){
        return dni>0 && dni<100000000;
    }
}

