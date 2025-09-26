package Universidad.DesarrolloAlgoritmo.TDA;

import java.util.Scanner;

public class SimulacroParcial12025 {
    public static void main(String[] args) {
        Turno[][] turnos = new Turno[16][5];
    }
    public static void cargarTurno(Turno[][] turnos){
        Scanner sc = new Scanner(System.in);
        String dia, nombre, apellido, obraSocial, diagnostico,hora;
        double montoCoseg;
        boolean asistio, finalizo;
        int dni, diasTratamiento, fila, columna;
        do {
            System.out.println("Ingrese el dia del turno: ");
            dia = sc.nextLine();
            columna = obtenerDiaSemana(dia);
            if(columna == -1)
                System.out.println("El dia ingresado es invalido. Por favor intente de nuevo.");
        }while(columna == -1);
        do {
            System.out.println("Ingrese la hora del turno: "); //Usar LocalTime.of(int hora, int min) y cambiar modulo "obtenerHora"
            hora = sc.nextLine();
            fila=obtenerHora(hora);
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
    public static int obtenerHora(String hora){ //Cambiar parametros, obtenerHora(int hora, int min)
        int fila=-1;
        switch (hora.toLowerCase()) {  //Cambiar condicion del switch por hora
            case "09:00" -> fila = 0;  //Hacer un if al final por si los minutos son 30
            case "09:30" -> fila = 1;  //Ej: hora = 10 y min = 30
            case "10:00" -> fila = 2;  //case 10 -> fila=2;
            case "10:30" -> fila = 3;  //if(min==30){fila++;} solo aumenta en uno si los minutos son 30 que implica otro turno y por ende otra fila.
            case "11:00" -> fila = 4;  //return fila;
            case "11:30" -> fila = 5;
            case "12:00" -> fila = 6;
            case "12:30" -> fila = 7;
            case "13:00" -> fila = 8;
            case "13:30" -> fila = 9;
            case "14:00" -> fila = 10;
            case "14:30" -> fila = 11;
            case "15:00" -> fila = 12;
            case "15:30" -> fila = 13;
            case "16:00" -> fila = 14;
            case "16:30" -> fila = 15;
            case "17:00" -> fila = 16;
        }
        return fila;
    }
    public static boolean dniValido(int dni){
        return dni>0 && dni<100000000;
    }
}

