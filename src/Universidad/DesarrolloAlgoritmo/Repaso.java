package Universidad.DesarrolloAlgoritmo;

public class Repaso {
    public static void main(String[] args) {
        String[] arr = {"batata","caramelo",null,"avion",null,"dado","dedo","azucar"};
        String[] arrComp = compactarArr(arr);
        quickSort(arrComp, 0, arrComp.length-1);
        for(String i : arrComp){
            System.out.print(i+" ");
        }
    }
    public static void quickSort(String[] arr, int ini, int fin){
        if(ini < fin){
            int piv = particion(arr,ini,fin);
            quickSort(arr,ini,piv-1);
            quickSort(arr,piv+1,fin);
        }
    }
    public static int particion(String[] arr, int ini, int fin){
        int j = ini;
        int piv = pivote(arr,ini,fin);
        intercambiar(arr,piv,fin);
        for(int i=ini;i<fin;i++){
            if(arr[i].compareTo(arr[fin])<=0){
                intercambiar(arr,j,i);
                j++;
            }
        }
        intercambiar(arr,j,fin);
        return j;
    }
    public static int pivote(String[] arr, int ini, int fin){
        int mid = (fin+ini)/2;
        int piv;
        if((arr[mid].compareTo(arr[ini])>=0)!=(arr[mid].compareTo(arr[fin])>=0)){
            piv = mid;
        }else if((arr[ini].compareTo(arr[mid])>=0)!=(arr[ini].compareTo(arr[fin])>=0)){
            piv = ini;
        }else{
            piv = fin;
        }
        return piv;
    }
    public static void intercambiar(String[] arr, int i, int j){
        String aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }
    public static String[] compactarArr(String[] arr){
        int largo=0;
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]!=null){
                largo++;
            }
        }
        String[] arrComp = new String[largo];
        for(int i = 0; i < arr.length; i++){
            if(arr[i]!=null){
                arrComp[j] = arr[i];
                j++;
            }
        }
        return arrComp;
    }
}
