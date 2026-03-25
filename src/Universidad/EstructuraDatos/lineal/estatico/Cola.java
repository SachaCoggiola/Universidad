package Universidad.EstructuraDatos.lineal.estatico;

public class Cola {
    private int fin;
    private int frente;
    private Object[] arr;
    private static final int tamanio = 5;
    public Cola() {
        this.arr = new Object[tamanio];
        this.fin = 0;
        this.frente = 0;
    }
    public boolean poner(Object elem) {
        boolean res = false;
        if (this.fin + 1 != tamanio) {
            this.arr[this.fin] = elem;
            this.fin = (this.fin + 1) % tamanio;
            res = true;
        }
        return res;
    }
    public boolean sacar(){
        boolean res = false;
        if(this.frente != tamanio){
            this.arr[this.frente] = null;
            this.frente = (this.frente + 1) % tamanio;
            res = true;
        }
        return res;
    }
    public Object obtenerFrente(){
        return this.arr[this.frente];
    }
    public boolean esVacia(){
        return this.fin == tamanio;
    }
    public void vaciar(){
        for(int i = 0; i < this.frente; i++){
            this.arr[i] = null;
        }
        this.frente = 0;
        this.fin = 0;
    }
    public Cola clonar(){
        Cola clon = new Cola();
        clon.fin = this.fin;
        clon.frente = this.frente;
        for(int i = 0; i < tamanio; i++){
            clon.arr[i] = this.arr[i];
        }
        return clon;
    }
    public String toString(){
        return "["+stringRecursivo(this.arr,this.fin,this.frente)+"] Frente: "+this.arr[this.frente]+"; Fin: "+this.arr[this.fin];
    }
    private String stringRecursivo(Object[] arr, int fin, int fr){
        String res = arr[fin].toString();
        if(fin - 1 != fr){
            res = arr[fin].toString() + ", " + stringRecursivo(arr,(fin-1+tamanio)%tamanio,fr);
        }
        return res;
    }
}
