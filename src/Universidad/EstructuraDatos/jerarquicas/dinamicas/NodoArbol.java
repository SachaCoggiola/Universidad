package Universidad.EstructuraDatos.jerarquicas.dinamicas;

public class NodoArbol {
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    public NodoArbol(Object elem) {
        this.elem = elem;
        this.izquierdo = null;
        this.derecho = null;
    }
    public NodoArbol(Object elem, NodoArbol hijoIzq, NodoArbol hijoDer) {
        this.elem = elem;
        this.izquierdo = hijoIzq;
        this.derecho = hijoDer;
    }
    public Object getElemento() {
        return elem;
    }
    public void setElemento(Object elem) {
        this.elem = elem;
    }
    public NodoArbol getIzquierdo() {
        return izquierdo;
    }
    public void setIzquierdo(NodoArbol hijoIzq) {
        this.izquierdo = hijoIzq;
    }
    public NodoArbol getDerecho() {
        return derecho;
    }
    public void setDerecho(NodoArbol hijoDer) {
        this.derecho = hijoDer;
    }
}
