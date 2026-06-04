package Universidad.EstructuraDatos.jerarquicas.dinamicas;

public class NodoABB {
    private Comparable elem;
    private NodoABB izquierdo;
    private NodoABB derecho;
    public NodoABB(Comparable elem, NodoABB izq, NodoABB der) {
        this.elem = elem;
        this.izquierdo = izq;
        this.derecho = der;
    }
    public NodoABB(Comparable elem){
        this.elem = elem;
        this.izquierdo = null;
        this.derecho = null;
    }
    public Object getElem() {
        return elem;
    }
    public void setElem(Comparable elem) {
        this.elem = elem;
    }
    public NodoABB getIzquierdo() {
        return izquierdo;
    }
    public void setIzquierdo(NodoABB izq) {
        this.izquierdo = izq;
    }
    public NodoABB getDerecho() {
        return derecho;
    }
    public void setDerecho(NodoABB derecho) {
        this.derecho = derecho;
    }
}
