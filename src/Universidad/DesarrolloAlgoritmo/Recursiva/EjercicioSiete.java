package Universidad.DesarrolloAlgoritmo.Recursiva;

import java.util.Scanner;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;

public class EjercicioSiete {
    public static void main(String[] args) {
        int[][] matriz = new int[4][4];
        Scanner sc = new Scanner(System.in);
        cargarMatriz(matriz,sc);
        mostrarSumFil(matriz,0);
    }
    public static void mostrarSumFil(int[][] matriz,int i){
        if(i<matriz.length){
            System.out.println("La suma de los elementos de la fila N°"+i+" es igual a: "+sumFil(matriz,i,0));
            mostrarSumFil(matriz,i+1);
        }
    }
    public static int sumFil(int[][] matriz,int i,int j){
        int sum=0;
        if(j<matriz[i].length){
            sum = matriz[i][j]+sumFil(matriz,i,j+1);
        }
        return sum;
    }
}
