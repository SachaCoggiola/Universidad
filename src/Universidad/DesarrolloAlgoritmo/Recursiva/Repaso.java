package Universidad.DesarrolloAlgoritmo.Recursiva;

public class Repaso {
    public static void main(String[] args) {
        /*int natural = 5;
        int num = 123457;
        int base = 4;
        int potencia = 2;
        int[] arr = {1,2,3,43,5,6,7,8,10};
        int[][] mat = {{1,0,0},{0,1,0},{0,2,1}};
        System.out.println("Suma de natural : " + sumNaturales(natural) + "\n"
        + "Cantidad de digitos : " + contDigitos(num) + "\n"
        + "Numero invertido : " + invertirNumero(num) + "\n"
        + "Base elevado a potencia : " + potencia(base,potencia) + "\n"
        + "Cantidad de digitos pares : " + contDigitPar(num) + "\n"
        + "El numero mas grande del array es : " + maxNumArr(arr,0) + "\n"
        + "La matriz es simetrica es : " + esMatrixSimetrica(mat,0,1));
        int[] arr = {1,2,3,4,5};
        int num = 6;
        System.out.println(busquedaBinariarecursiva(arr,0,arr.length-1,num));
        System.out.println(busquedaBinaria(arr,num));
         */
        int[] arr = {5,6,1,4,2,3,7,9,8};
        selectionSort(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
    public static int sumNaturales(int n) {
        int aux;
        if(n==1){
            aux = 1;
        }else{
            aux = sumNaturales(n-1)+n;
        }
        return aux;
    }
    public static int contDigitos(int n) {
        int aux;
        if(n/10==0){
            aux = 1;
        }else{
            aux = contDigitos(n/10)+1;
        }
        return aux;
    }
    public static int invertirNumero(int n){
        int aux;
        if(n/10==0){
            aux = n % 10;
        }else{
            aux = invertirNumero(n/10)+(n%10*(int)Math.pow(10,contDigitos(n)-1));
        }
        return aux;
    }
    public static int potencia(int base, int pot){
        int aux;
        if(pot==0){
            aux = 1;
        } else if (pot==1) {
            aux = base;
        }else{
            aux = base * potencia(base, pot-1);
        }
        return aux;
    }
    public static int contDigitPar(int n){
        int aux=0;
        if(n/10==0){
            if(n%2==0){
                aux = 1;
            }
        }else{
            if(n%2==0){
                aux = contDigitPar(n/10)+1;
            }else{
                aux = contDigitPar(n/10);
            }
        }
        return aux;
    }
    public static int maxNumArr(int[] arr, int i){
        int max = arr[arr.length-1];
        if(i==arr.length-2){
            if(arr[i]>max){
                max = arr[i];
            }
        }else{
            max=maxNumArr(arr,i+1);
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static boolean esMatrixSimetrica(int[][] aux, int i, int j){
        boolean sim = true;
        if(i < aux.length && j < aux[i].length){
            if(j == aux[i].length-1){
                if(aux[i][j]==aux[j][i]){
                    i+=1;
                    j=i+1;
                    sim = esMatrixSimetrica(aux,i,j);
                }else{
                    sim = false;
                }
            }else {
                if (aux[i][j] == aux[j][i]) {
                    sim = esMatrixSimetrica(aux, i, j + 1);
                }else{
                    sim = false;
                }
            }
        }
        return sim;
    }
    public static int busquedaBinariarecursiva(int[] arr, int ini, int fin, int num){
        int pos = -1;
        int mid = (ini+fin)/2;
        if(ini<=fin){
            if(arr[mid]==num){
                pos = mid;
            } else if (num>arr[mid]) {
                pos = busquedaBinariarecursiva(arr,mid + 1,fin,num);
            }else {
                pos = busquedaBinariarecursiva(arr,ini,mid - 1,num);
            }
        }
        return pos;
    }
    public static int busquedaBinaria(int[] arr, int num){
        int ini = 0, mid, fin = arr.length-1, pos = -1;
        boolean flag = true;
        while(ini<=fin&&flag){
            mid = (ini+fin)/2;
            if(arr[mid]==num){
                pos = mid;
                flag = false;
            }else if(num>arr[mid]){
                ini = mid + 1;
            }else {
                fin = mid - 1;
            }
        }
        return pos;
    }
    public static void selectionSort(int[] arr){
        int menor;
        int aux;
        for(int i = 0; i < arr.length-1; i++){
            menor = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j]<arr[menor]){
                    menor = j;
                }
            }
            if(menor != i) {
                aux = arr[i];
                arr[i] = arr[menor];
                arr[menor] = aux;
            }
        }
    }
}
