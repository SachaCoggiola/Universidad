package Universidad.DesarrolloAlgoritmo.Recursiva;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {6,3,7,1,5,8,2,9,4};
        int [] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void mergeSort(int[] arr, int[] aux, int ini, int fin) {
        int mid = (ini + fin) / 2;
        if(ini < fin) {
            mergeSort(arr, aux, ini, mid);
            mergeSort(arr, aux, mid + 1, fin);
            merge(arr, aux, ini, mid, fin);
        }
    }
    public static void merge(int[] arr, int[] aux, int ini, int mid,int fin) {
        for(int i=ini;i<=fin;i++) {
            aux[i] = arr[i];
        }
        int i = ini;
        int j = mid+1;
        int k = ini;
        while(i<=mid && j<=fin) {
            if(aux[i] <= aux[j]) {
                arr[k] = aux[i];
                i++;
            }else{
                arr[k] = aux[j];
                j++;
            }
            k++;
        }
        while(i<=mid) {
            arr[k] = aux[i];
            k++;
            i++;
        }
    }
}
