package Universidad.DesarrolloAlgoritmo.Recursiva;

import java.util.Scanner;

public class Ejercicio5a {
    public static void main(String[] args) {
        int largo,prom;
        int[] array;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el largo del array: ");
        largo = sc.nextInt();
        array = new int[largo];
        cargarArray(array,sc,0);
        prom = sumaArray(array,0)/array.length;
        System.out.println("El promedio del arreglo es: "+prom);
        System.out.println("La cantidad de elementos del array mayores al promedio del mismo son: "+mayorPromArray(array,prom,0));
    }
    public static int mayorPromArray(int[] array,int prom, int i) {
        int result = 0;
        if(i<array.length){
            if(array[i]>prom){
                result += 1+mayorPromArray(array,prom,i+1);
            }else{
                result += mayorPromArray(array,prom,i+1);
            }
        }
        return result;
    }
    public static int sumaArray(int[] array, int i){
        int total = 0;
        if(i<array.length){
            total += sumaArray(array,i+1)+array[i];
        }
        return total;
    }
    public static void cargarArray(int[] array, Scanner sc, int i){
        if(i<array.length){
            System.out.println("Ingrese el numero de la posicion "+(i+1));
            array[i] = sc.nextInt();
            cargarArray(array,sc,i+1);
        }
    }
}
