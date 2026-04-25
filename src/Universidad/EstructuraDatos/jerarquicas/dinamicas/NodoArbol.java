package Universidad.EstructuraDatos.jerarquicas.dinamicas;

public class NodoArbol {
    private Object elem;
    private NodoArbol hijoIzq;
    private NodoArbol hijoDer;
    public NodoArbol(Object elem) {
        this.elem = elem;
        this.hijoIzq = null;
        this.hijoDer = null;
    }
    public NodoArbol(Object elem, NodoArbol hijoIzq, NodoArbol hijoDer) {
        this.elem = elem;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }
    public Object getElem() {
        return elem;
    }
    public void setElem(Object elem) {
        this.elem = elem;
    }
    public NodoArbol getHijoIzq() {
        return hijoIzq;
    }
    public void setHijoIzq(NodoArbol hijoIzq) {
        this.hijoIzq = hijoIzq;
    }
    public NodoArbol getHijoDer() {
        return hijoDer;
    }
    public void setHijoDer(NodoArbol hijoDer) {
        this.hijoDer = hijoDer;
    }
}
