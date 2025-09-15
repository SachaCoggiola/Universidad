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
    public static void imprimirArray(int[] array){
        for (int j : array)
            System.out.print(j + " ");
    }
    public static void imprimirArray(char[] array){
        for(char c : array) {
            System.out.print(c + " ");
        }
    }
    public static void imprimirArray(double[] array){
        for (double v : array)
            System.out.print(v + " ");
    }
    public static void imprimirArray(String[] array){
        for(String v : array)
            System.out.print(v + " ");
    }
    public static void imprimirArrayFilasCaracter(char[] array){
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
    public static void cargarArray(int[] array, Scanner sc){
        for(int i=0; i<array.length; i++){
            System.out.println("Ingrese el numero de la posicion "+(i+1));
            array[i] = sc.nextInt();
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
    public static void invertirArray(int[] array){
        int temp;
        for (int i=0; i<array.length/2; i++){
            temp = array[i];
            array[i]=array[array.length-1-i];
            array[array.length-1-i]=temp;
        }
    }
    public static boolean compararArray(int[] array1, int[] array2){
        boolean verificado = true;
        int i = 0;
        if(array1.length!=array2.length){
            verificado = false;
        }
        while(i < array1.length && verificado){
            if(array1[i]!=array2[i]){
                verificado = false;
            }
            i++;
        }
        return verificado;
    }
    public static char[] copiarArray(char[] array1){
        char[] array = new char[array1.length];
        for (int i=0; i<array1.length; i++){
            array[i]=array1[i];
        }
        return array;
    }
    public static boolean validarNumero(int numero,int minimo,int maximo){
        if(minimo>maximo)
            throw new RuntimeException("El maximo debe de ser mayor al minimo.");
        return numero>=minimo && numero<=maximo;
    }
    public static boolean validarMinimo(int numero,int minimo){
        if(numero<minimo)
            throw new RuntimeException("El numero debe ser mayor al minimo.");
        return true;
    }
    public static boolean validarMaximo(int numero,int maximo){
        if(numero>maximo)
            throw new RuntimeException("El numero debe ser menor al maximo.");
        return true;
    }
    public static char[] soloVocalesArray(char[] array){
        char[] arrayVocales;
        int largo = contarVocales(array);
        int j = 0;
        String vocales = "aeiouAEIOU";
        arrayVocales = new char[largo];
        for (char c : array) {
            if (vocales.indexOf(c) != -1) {
                arrayVocales[j] = c;
                j++;
            }
        }
        return arrayVocales;
    }
    public static int contarVocales(char[] array){
        int contador = 0;
        String vocales = "aeiouAEIOU";
        for (char c : array) {
            if (vocales.indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }
    public static void dividirArray(String[] array, String[] arrayPar, String[] arrayImpar){
        int j = 0;
        int k = 0;
        for(int i=0; i<array.length; i++){
            if(i%2==0){
                arrayPar[j]=array[i];
                j++;
            }else {
                arrayImpar[k]=array[i];
                k++;
            }
        }
    }
}
