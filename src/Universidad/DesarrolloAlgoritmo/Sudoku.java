package Universidad.DesarrolloAlgoritmo;

import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        int[][] sudoku = new int[9][9];
        cargarMatrix(sudoku);
        imprimirMatrix(sudoku);
        if(verificarSudoku(sudoku)) {
            System.out.println("El sudoku es correcto");
        }else{
            System.out.println("El sudoku no es correcto");
        }
    }
    public static void imprimirMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void cargarMatrix(int[][] sudoku) {
        Scanner entrada = new Scanner(System.in);
        int num;
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                do{
                    System.out.println("Ingrese el numero " + (i+1) + "x" + (j+1) + ": ");
                    num = entrada.nextInt();
                    if (num < 1 || num > 9) {
                        System.out.println("El numero debe de ser un numero entre 1 y 9: ");
                    }
                }while(num < 1 || num > 9);
                sudoku[i][j] = num;
            }
        }
    }

    public static boolean verificarFil(int[][] matrix,int fil){
        boolean verificado = true;
        int i=0;
        int aux,j;
        do{
            j=i+1;
            aux=matrix[fil][i];
            while(j<matrix.length&&verificado){
                if(aux==matrix[fil][j]){
                    verificado=false;
                }
                j++;
            }
            i++;
        }while(verificado&&i<matrix.length);
        return verificado;
    }
    public static boolean verificarCol(int[][] matrix,int col){
        boolean verificado = true;
        int i=0;
        int aux,j;
        do{
            j=i+1;
            aux=matrix[i][col];
            while(j<matrix.length&&verificado){
                if(aux==matrix[j][col]){
                    verificado=false;
                }
                j++;
            }
            i++;
        }while(verificado&&i<matrix.length);
        return verificado;
    }
    public static boolean verificarSudoku(int[][] sudoku){
        boolean verificado;
        int i=0;
        do{
            verificado=verificarFil(sudoku,i)&&verificarCol(sudoku,i);
            i++;
        }while(verificado&&i<sudoku.length);
        return verificado;
    }
}
