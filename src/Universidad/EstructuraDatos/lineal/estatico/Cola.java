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
        if(this.frente != this.fin){
            this.arr[this.frente] = null;
            this.frente = (this.frente + 1) % tamanio;
            res = true;
        }
        return res;
    }
    public Object obtenerFrente(){
        Object res = null;
        if(this.frente != this.fin){
            res = this.arr[this.frente];
        }
        return res;
    }
    public boolean esVacia(){
        return this.fin == this.frente;
    }
    public void vaciar(){
        for(int i = 0; i < this.frente; i++){
            this.arr[i] = null;
        }
        this.frente = 0;
        this.fin = 0;
    }
    public Cola clone(){
        Cola clon = new Cola();
        clon.fin = this.fin;
        clon.frente = this.frente;
        for(int i = 0; i < tamanio; i++){
            clon.arr[i] = this.arr[i];
        }
        return clon;
    }
    public String toString(){
        StringBuilder res = new StringBuilder("[");
        int i = this.frente;
        if(this.frente != this.fin){
            while(i!=this.fin){
                res.append(this.arr[i].toString());
                i = (i+1) % tamanio;
                if(i != this.fin){
                    res.append(",");
                }
            }
        }
        res.append("]");
        return res.toString();
    }
}
