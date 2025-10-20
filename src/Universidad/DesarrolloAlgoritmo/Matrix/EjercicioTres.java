package Universidad.DesarrolloAlgoritmo.Matrix;

import java.util.Scanner;

public class EjercicioTres {
    public static void main(String[] args) {
        int fil, col;
        String respuesta;
        String[][] matrix;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de filas de la matriz:");
        fil = sc.nextInt();
        System.out.println("Ingrese la cantidad de columnas de la matriz:");
        col = sc.nextInt();
        sc.nextLine();
        matrix = new String[fil][col];
        cargarMatrizStr(matrix,sc);
        do {
            do{
                System.out.println("Ingrese la fila donde se encuentra la palabra que desea ver:");
                fil = sc.nextInt();
                System.out.println("Ingrese la columna donde se encuentra la palabra que desea ver:");
                col = sc.nextInt();
                sc.nextLine();
                if(fil<0||fil>=matrix.length||col<0||col>=matrix[0].length){
                    System.out.println("Ingrese un numero entre el 0 y el "+(matrix.length-1)+" para la fila, y un numero entre 0 y "+(matrix[0].length-1)+" para las columnas");
                }
            }while(fil<0||fil>=matrix.length||col<0||col>=matrix[0].length);
            System.out.println(matrix[fil][col]);
            System.out.println("¿Desea ver otra palabra?. Ingrese Si o No.");
            respuesta = sc.next();
        }while(respuesta.equalsIgnoreCase("Si"));
    }
    public static void cargarMatrizStr(String[][] mat, Scanner sc){
        llenarStrMatrix(mat);
        String oracion;
        for(int i=0;i<mat[0].length;i++){
            System.out.println("Ingrese la oracion numero "+(i+1));
            oracion = sc.nextLine();
            cargaOracion(mat,oracion,i);
        }
    }
    public static void llenarStrMatrix(String[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                mat[i][j] = " ";
            }
        }
    }
    public static void cargaOracion(String[][] mat, String oracion,int i){
        String esp = " ";
        int pos;
        int j = 0;
        while(j<mat[0].length){
            pos = oracion.indexOf(esp);
            if(pos==-1){
                pos=oracion.length();
                mat[i][j] = oracion.substring(0,pos);
                j=mat[i].length;
            }else{
                mat[i][j] = oracion.substring(0,pos);
                oracion = oracion.substring(pos+1);
                oracion = oracion.trim();
                j++;
            }
        }
    }
}
