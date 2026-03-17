package Universidad.DesarrolloAlgoritmo.Recursiva;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3,6,4,1,7,2,5,9,8};
        quickSort(arr, 0, arr.length-1);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
    public static void quickSort(int[] arr, int ini, int fin) {
        if(ini < fin) {
            int pivote = particion(arr,ini,fin);
            quickSort(arr,ini,pivote-1);
            quickSort(arr,pivote+1,fin);
        }
    }
    public static int particion(int[] arr, int ini, int fin) {
        int posPiv = calcPivote(arr,ini,fin);
        int pivote = arr[posPiv];
        intercambiar(arr,posPiv,fin);
        int i = ini;
        for(int j=ini;j<fin;j++) {
            if(arr[j]<pivote) {
                intercambiar(arr,i,j);
                i++;
            }
        }
        intercambiar(arr,i,fin);
        return i;
    }
    public static int calcPivote(int[] arr, int ini, int fin) {
        int pivote;
        int medio = (fin+ini)/2;
        int auxIni, auxMed, auxFin;
        auxIni = arr[ini];
        auxMed = arr[medio];
        auxFin = arr[fin];
        if((auxIni >= auxMed)!=(auxIni >= auxFin)) {
            pivote = ini;
        } else if ((auxMed>=auxIni)!=(auxMed>=auxFin)) {
            pivote = medio;
        }else{
            pivote = fin;
        }
        return pivote;
    }
    public static void intercambiar(int[] arr, int i, int j) {
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }
}
