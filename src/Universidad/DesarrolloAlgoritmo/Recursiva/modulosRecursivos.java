package Universidad.DesarrolloAlgoritmo.Recursiva;

import java.util.Scanner;

public class modulosRecursivos {
    public static void main(String[] args) {
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
    public static int maxNumArray(int[] array, int i,int max){
        if(i<array.length){ //Caso Base: En este caso el caso base es el elemento max que se ingresa como parametro en el main con el valor de [i]
            if(array[i]>max){   //Si el numero en la posicion [i] es mayor que el valor de max del momento, se cambia max por el numero de [i]
                max=array[i];
            }
            max=maxNumArray(array,i+1,max); //Paso Recursivo se llama de nuevo el modulo cambiando por la siguiente posicion
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
}
