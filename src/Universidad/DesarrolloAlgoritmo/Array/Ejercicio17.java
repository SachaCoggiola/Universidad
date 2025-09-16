package Universidad.DesarrolloAlgoritmo.Array;
import java.util.Scanner;

public class Ejercicio17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int largo;
        double[] array;
        System.out.println("Ingrese la cantidad de notas que posee el alumno: ");
        largo = sc.nextInt();
        array = new double[largo];
        cargarNotas(array,sc);
        if(verificarAprobado(array)){
            System.out.println("El alumno ha aprobado el cuatrimestre.");
        }else {
            System.out.println("El alumno ha desaprobado el cuatrimestre.");
        }
    }
    public static boolean verificarAprobado(double[] array){
        boolean aprobado = true;
        for (double v : array) {
            if (v < 6) {
                aprobado = false;
            }
        }
        return aprobado;
    }
    public static void cargarNotas(double[] notas, Scanner sc){
        double nota;
        for(int i = 0; i < notas.length; i++){
            System.out.println("Ingrese la nota del alumno: ");
            nota = sc.nextDouble();
            if(nota>10||nota<0){
                nota = 0;
                System.out.println("La nota del alumno debe de ser mayor a 0(cero) y menor a 10(diez)");
            }
            notas[i] = nota;
        }
    }
}
