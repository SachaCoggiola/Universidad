package Universidad.DesarrolloAlgoritmo;
import java.util.Scanner;
public class Modulos {
    public static void caracterArray(char[] array){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<array.length; i++){
            System.out.println("Ingrese el caracter de la posicion "+i);
            array[i] = sc.next().charAt(0);
        }
    }
    public static void imprimirArrayEntero(int[] array){
        for (int j : array)
            System.out.print(j + " ");
    }
    public static void imprimirArrayFilacCaracter(char[] array){
        for (char c : array)
            System.out.print(c);
    }
    public static void imprimirArrayReves(char[] array){
        for(int i=(array.length-1); i>=0; i--)
            System.out.print(array[i]);
    }
    public static void imprimirMatrizZigZag(int[][] matriz){
        int k = 0;
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                if(i%2==0){
                    System.out.print(matriz[i][k]+" ");
                    k++;
                }else {
                    k--;
                    System.out.print(matriz[i][k]+" ");
                }
            }
            System.out.println();
        }
    }
    public static int promedioArray(int[] array){
        int total=0;
        for (int j : array) total += j;
        total/=array.length;
        return total;
    }
    public static boolean verificarLetra(char letra){
        return letra > 64 && letra < 91 || letra > 96 && letra < 123;
    }
    public static char[] cargarArray(char[] array,Scanner sc){
        for(int i=0; i<array.length; i++){
            System.out.println("Ingrese el caracter de la posicion "+(i+1));
            array[i] = sc.next().charAt(0);
        }
        return array;
    }
    public static void cargarArray(String[] array, Scanner sc){
        sc.nextLine();
        for(int i=0; i<array.length; i++){
            System.out.println("Ingrese la palabra de la posicion "+(i+1));
            array[i] = sc.nextLine();
        }
    }
    public static String generarCadena(String[] array){
        StringBuilder cadena = new StringBuilder();
        for (String s : array) {
            cadena.append(s).append(" ");
        }
        return cadena.toString();
    }
    public static int buscarPalabraLarga(String[] array){
        int posicion = 0;//no existe cadena de largo negativo
        int largo = -1;
        for(int i=0; i<array.length; i++){
            if(array[i].length()>largo){
                posicion = i;
                largo = array[i].length();
            }
        }
        return posicion;
    }
    public static boolean buscarCaracter(char[] array,char caracter){
        boolean verificado = false;
        for (char c : array) {
            if (c == caracter)
                verificado = true;
        }
        return verificado;
    }
    public static int cantidadCaracteres(char[] array, char caracter){
        int cantidad = 0;
        for (char c : array) {
            if (c == caracter) {
                cantidad++;
            }
        }
        return cantidad;
    }
}
