package Universidad.RPA.UnidadCuatro;

import java.util.Scanner;

public class ejercicios {
    public static String alertaMetereologica(int temp1, int temp2, int temp3){
        if(temp1>40 || temp2>40 || temp3>40){
            return "#634";
        }else {
            return "#353";
        }
    }

    public static boolean impar(int numero){
        return numero%2==1;
    }
    public static boolean esVocal(char letra){
        return switch (letra) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }
    public static boolean esCandidato(int tp, int mascotas, int clases){
        if(mascotas<0||clases<0){
            throw new RuntimeException("Mascotas o clases no validas");
        }
        return tp == 5 && mascotas <= 2 && clases <= 2;
    }
    public static boolean promocion(int nota1, int nota2, int notaRecu){
        return (nota1 + nota2) / 2 > 80 || notaRecu > 90;
    }
    public static int numeroDeLaSuerte(int dia, int mes, int ano){
        int temp = 0;
        int numeroSuerte = dia+mes+ano;
        numeroSuerte = numeroSuerte%1000;
        numeroSuerte = numeroSuerte%100;
        if(numeroSuerte<20){
            return numeroSuerte;
        }else{
            temp = numeroSuerte/10;
            numeroSuerte = numeroSuerte%10;
            temp += numeroSuerte;
            return temp;
        }
    }
    public static void becaComedor(double promedio, int edad, int distancia){
        if(promedio>7&&edad<25||distancia>30){
            System.out.println("El alumno puede acceder a la beca.");
        }else {
            System.out.println("El alumno no puede acceder a la beca.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero entero: ");
        int numero = sc.nextInt();
        if(impar(numero)){
            System.out.println("El numero es impar.");
        }else {
            System.out.println("El numero no es impar.");
        }
        System.out.println("Ingrese la cantidad de TP's realizados:");
        int tp = sc.nextInt();
        System.out.println("Ingrese la cantidad de mascotas que posee:");
        int mascotas = sc.nextInt();
        System.out.println("Ingrese la cantidad de clases practicas que ha faltado:");
        int clases = sc.nextInt();
        System.out.println("Ingrese el nombre y apellido del alumno:");
        String alumno = sc.next();
        System.out.println("Ingrese la nota del primer parcial:");
        int nota1 = sc.nextInt();
        System.out.println("Ingrese la nota del segundo parcial:");
        int nota2 = sc.nextInt();
        System.out.println("Ingrese la nota del recuperatorio integral(si no lo ha rendido ingrese 0):");
        int notaRecu = sc.nextInt();
        if(promocion(nota1,nota2,notaRecu)){
            System.out.println("El alumno "+alumno+" ha promocionado.");
        }else {
            System.out.println("El alumno "+alumno+" no ha promocionado.");
        }
    }
}
