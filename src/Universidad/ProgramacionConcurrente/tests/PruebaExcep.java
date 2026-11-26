package Universidad.ProgramacionConcurrente.tests;

import java.util.Scanner;

public class PruebaExcep {
    public static void menorDeEdad(int edad){
        if(edad<18){
            throw new RuntimeException("La persona ingresada es menor de edad");
        }
    }
    public static void ruleta(int numero){
        int random = (int) (Math.random()*100)+1;
        if(numero != random){
            throw new RuntimeException("No ha salido el numero ingresado en la ruleta");
        }
    }
    public static void mostrarCol(){
        Scanner sc = new Scanner(System.in);
        int[] col = new int[5];
        for(int i=0; i<5; i++){
            System.out.println("Ingrese el numero de la posicion: "+(i+1));
            col[i] = sc.nextInt();
        }
        for(int i=0; i<7; i++){
            System.out.println(col[i]);
        }
    }
    public static void main(String[] args) {
    }
}
