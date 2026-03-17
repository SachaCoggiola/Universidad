package Universidad.EstructuraDatos;

public class Pila {
    private int tope;
    private Object[] arr;
    private static final int tamanio = 5;

    public Pila(){
        this.tope = -1;
        this.arr = new Object[tamanio];
    }
    public boolean apilar(Object elem){
        boolean seCargo = false;
        if(this.tope + 1 < tamanio){
            this.tope++;
            this.arr[this.tope] = elem;
            seCargo = true;
        }
        return seCargo;
    }
    public boolean desapilar(){
        boolean seDescargo = false;
        if(this.tope > -1){
            this.arr[this.tope] = null;
            this.tope--;
            seDescargo = true;
        }
        return seDescargo;
    }
    public Object getTope(){
        Object elem = new Object();
        if(this.tope != -1){
            elem = this.arr[this.tope];
        }
        return elem;
    }
    public boolean esVacio(){
        return this.tope == -1;
    }
    public void vaciar(){
        for(int i = 0; i <= this.tope; i++){
            this.arr[i] = null;
        }
        this.tope = -1;
    }
    public Pila clone(){
        Pila nuevaPila = new Pila();
        nuevaPila.tope = this.tope;
        //System.arraycopy(this.arr, 0, nuevaPila.arr, 0, tamanio);
        for(int i = 0; i < tamanio; i++){
            nuevaPila.arr[i] = this.arr[i];
        }
        return nuevaPila;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i = 0; i <= this.tope; i++){
            str.append(this.arr[i].toString());
            if(i < this.tope){
                str.append(", ");
            }
        }
        str.append("] tope: ").append(this.tope);
        return str.toString();
    }
}
