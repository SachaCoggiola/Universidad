package Universidad.DesarrolloAlgoritmo.Recursiva;

import java.util.Scanner;

// 2.a) Retornar si una matriz nxn dada es de identidad

public class Ejercicio2a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dimension;
        boolean verif;
        System.out.println("Ingrese la dimension de la matriz: ");
        dimension = sc.nextInt();
        int[][] matriz = new int[dimension][dimension];

        matriz = IngresarMatriz(0,0,matriz);

        verif = verificarIdentidad(0,0,matriz,true);
        System.out.println(verif);
    }

    public static boolean verificarIdentidad(int fil, int col, int[][] matriz, boolean verif) {
        int dimension = matriz.length;
        if (fil < dimension&&verif) {
            if (col >= dimension) {
                verif = verificarIdentidad(fil + 1,0,matriz,verif);
            }else{
                if (fil==col&&matriz[fil][col]!=1) {
                    verif = false;
                } else if (fil!=col&&matriz[fil][col] != 0) {
                    verif = false;
                }
                verif = verificarIdentidad(fil,col + 1,matriz,verif);
            }
        }
        return verif;
    }

    public static int[][] IngresarMatriz(int fil, int col, int[][] matriz) {
        Scanner sc = new Scanner(System.in);
        if (fil < matriz.length) {
            if (col >= matriz[fil].length) {
                IngresarMatriz(fil + 1, 0, matriz);
            } else {
                System.out.println("Ingrese el elemento " + fil + " " + col);
                matriz[fil][col] = sc.nextInt();
                matriz = IngresarMatriz(fil, col + 1, matriz);
            }
        }
        return matriz;
    }
}
