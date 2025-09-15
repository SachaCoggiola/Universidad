package Universidad.DesarrolloAlgoritmo.Array;
import java.util.Scanner;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;

public class Ejercicio17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int largo;
        double[] array;
        System.out.println("Ingrese la cantidad de notas que posee el alumno: ");
        largo = sc.nextInt();
        array = new double[largo];
    }
    public static boolean verificarAprobado(double nota){
        return nota >= 6;
    }
    public static void cargarNotas(double[] notas, Scanner sc){
        double nota;
        for(int i = 0; i < notas.length; i++){
            System.out.println("Ingrese la nota del alumno: ");
            nota = sc.nextDouble();
            if(nota>10){
                nota = 10;
                System.out.println("La nota del alumno no debe ser mayor que 10");
            }
            notas[i] = nota;
        }
    }
}
