package Universidad.DesarrolloAlgoritmo.Recursiva;

import java.util.Scanner;

public class ModulosRecursivos {
    public static void main(String[] args) {
        piramide(3);
    }
    public static boolean digitosIguales(int numero){
        boolean verificar;
        if(numero/100==0){
            verificar = numero%10==numero/10;
        }else{
            verificar = digitosIguales(numero/10)&&numero%10==((numero/10)%10);
        }
        return verificar;
    }
    public static int contarMultDeTres(){
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        System.out.println("Ingrese un numero");
        int numero = sc.nextInt();
        if(numero%3==0&&numero!=0) {
            contador++;
        }
        if(numero!=0){
            contador+=contarMultDeTres();
        }
        return contador;
    }
    public static int maxNumArray(int[] array, int i){
        int max=array[i+1];
        if(i<array.length-2){
            max=maxNumArray(array,i+1);
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }
    public static void mostrarSumaFila(int[][] array, int i){
        System.out.println(sumaFila(array,i,0)); //Caso Base: Se muestra la suma de la primer fila
        if(i<array.length-1){
            mostrarSumaFila(array,i+1); //Paso Recursivo: Se llama de nuevo el modulo para la siguiente fila (de existir una siguiente fila)
        }
    }
    public static int sumaFila(int[][] array, int i,int j){
        int suma=0; //Caso Base: El array ya se recorrio completo y la suma es igual a cero por ser el neutro de la suma
        if(j<array[0].length){
            suma=array[i][j]+sumaFila(array,i,j+1); //Paso Recursivo: mientras que j sea menor al largo de la fila, se suma el elemento [i][j] y se llama al modulo de nuevo
        }
        return suma;
    }
    public static int sumaCol(int[][] array, int i,int j){
        int suma=0; //Caso Base: El array ya se recorrio completo y la suma es igual a cero por ser el neutro de la suma
        if(i<array.length){
            suma=array[i][j]+sumaCol(array,i+1,j); //Paso Recursivo: mientras quei sea menor al largo de la fila, se suma el elemento [i][j] y se llama al modulo de nuevo
        }
        return suma;
    }
    public static boolean oracionEsCapicua(String oracion){
        boolean esCapicua;
        int aux=oracion.indexOf(" ");
        if(aux==-1){    //Caso Base: no se encuentran mas espacios en la oración
            esCapicua=oracion.equalsIgnoreCase(invertirString(oracion));
        }else { //Paso Recursivo: se separa la primer palabra del resto de la oración y se le quitan los espacios, luego se vuelve a unir con el resto de la oración
            esCapicua = oracionEsCapicua(oracion.substring(0,aux).trim()+oracion.substring(aux+1).trim());  //Cada palabra se separa por un espacio (" ")
        }
        return esCapicua;
    }
    public static String invertirString(String oracion){    //Metodo auxiliar para invertir un string
        char[] array = oracion.toCharArray();
        char aux;
        for(int i=0;i<array.length/2;i++){
            aux = array[i];
            array[i]=array[array.length-i-1];
            array[array.length-i-1]=aux;
        }
        return new String(array);
    }
    public static int[] divisionRecursiva(int numerador, int denominador){
        int resultado;
        int resto=0;
        if(numerador-denominador<0){    //Caso Base: el denominador es mayor al numerador
            resto=numerador;
            resultado = 1;
        }else{  //Paso Recursivo: llama a la funcion restandole al numerador el denominador y suma uno al resultado
            resultado=divisionRecursiva(numerador-denominador,denominador)[0]+1;
        }
        return new int[]{resultado,resto};
    }
    public static String caracteresAFrase(char caracter){
        Scanner sc = new Scanner(System.in);
        String resultado="";
        if(caracter=='.'){
            resultado += caracter;
        }else{
            System.out.println("Ingrese el siguiente caracter");
            resultado += caracter+caracteresAFrase(sc.nextLine().charAt(0));
        }
        return resultado;
    }
    public static int[] sumaParEImp(int[] array, int i){
        int sumaPar=0;
        int sumaImpar=0;
        int[] aux = new int[2];
        if(i==array.length-1){  //Caso Base: se llega al ultimo elemento del array
            if(i%2==0){
                sumaPar=array[i];
            }else{
                sumaImpar=array[i];
            }
        }else{  //Paso Recursivo: se pregunta si es par o impar, y se suma en el acumulador respectivo, llama a la funcion con i+1
            if(i%2==0){
                aux=sumaParEImp(array,i+1);
                sumaPar=array[i]+aux[0];
                sumaImpar=aux[1];
            }else{
                aux=sumaParEImp(array,i+1);
                sumaImpar=array[i]+aux[1];
                sumaPar=aux[0];
            }
        }
        return new int[]{sumaPar,sumaImpar};
    }
    public static boolean estaCaracterArray(char[] array,char carac, int i){
        boolean verif=false;
        if(i==array.length-1){
            if(carac==array[i]){
                verif=true;
            }
        }else{
            if(carac==array[i]){
                verif=true;
            }else{
                verif=estaCaracterArray(array,carac,i+1);
            }
        }
        return verif;
    }
    public static int maxNumMatrix(int[][] matrix,int i){
        int mayor;
        int aux;
        //se compara y guarda el mayor, luego se repite hasta llegar nuevamente a i = 0 o la primer fila
        if(i==matrix[i].length-2){  //Caso Base: se llega al anteultimo elemento del array
            aux=maxNumArray(matrix[i],0); //se utiliza la funcion de maxNumArray para calcular el mayor de cada fila
            mayor=maxNumArray(matrix[matrix.length-1],0);
        }else{
            mayor=maxNumMatrix(matrix,i+1); //la recursiva de maxNumMatrix devuelve el mayor entre la ultima y anteultima fila
            aux=maxNumArray(matrix[i],0);   //se calcula el mayor de la fila i
        }
        if(aux>mayor){  //se comparan los mayores de las filas
            mayor=aux;
        }
        return mayor;
    }
    public static void mostrarSumColMat(int[][] matrix,int col){
        if(col<matrix[0].length){
            System.out.println(sumaCol(matrix,0,col));
            mostrarSumColMat(matrix,col+1);
        }
    }
    public static int contarVocales(String cadena){
        int cantVocales=0;
        String vocales = "aeiouAEIOU";
        boolean contains = vocales.contains(cadena.charAt(cadena.length() - 1) + "");
        if(cadena.length()==1){
            if (contains){
                cantVocales=1;
            }
        }else {
            if (contains) {
                cantVocales = 1 + contarVocales(cadena.substring(0, cadena.length() - 1));
            }else{
                cantVocales = contarVocales(cadena.substring(0, cadena.length() - 1));
            }
        }    
        return cantVocales;
    }
    public static void mediaPiramide(int numero){
        if (numero < 1) {
            throw new IllegalArgumentException("El numero no puede ser menor que 1");
        }
        if(numero==1){
            System.out.println(1);
        }else{
            mediaPiramide(numero-1);
            imprimirNum(numero); //Se puede usar un modulo auxiliar?
            System.out.println();
        }
    }
    public static void imprimirNum (int num){
        if(num>0){
            System.out.print(num);
            imprimirNum(num-1);
        }
    }
    public static void explotar(int num, int bomba){
        if(num<=bomba){
            System.out.print(num+" ");  //Caso Base: el numero es menor o igual a la bomba, se imprimer el numero más un espacio para separar
        }else{                          //Si se usa la coma para separar se imprime en el ultimo numero: 1,2,3, por se decidio utilizar el espacio como separador
            explotar(num/bomba,bomba);  //Se recorre primero la "rama" de la division
            explotar(num-(num/bomba),bomba);    //Y luego se recorre la "rama" de la resta
        }
    }
    public static void piramide(int num){
        if(num>0){
            imprimirEspacio(num);
            piramide(num-1);
            imprimirPiramide(num,1);
            System.out.println();
        }
    }
    public static void piramide2(int num,int aux){
        if(aux<num){
            //piramide2(aux-1);

        }
    }
    public static void imprimirPiramide(int num, int aux){
        if(aux<num){
            System.out.print(aux);
            imprimirPiramide(num,aux+1);
            System.out.print(aux);
        }else{
            System.out.print(num);
        }
    }
    public static void imprimirEspacio(int num){
        if(num>0){
            System.out.print(" ");
            imprimirEspacio(num-1);
        }
    }
}
