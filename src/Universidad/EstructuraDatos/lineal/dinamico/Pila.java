package Universidad.EstructuraDatos.lineal.dinamico;

public class Pila {
    private Nodo top;
    public Pila() {
        top = null;
    }
    public boolean esVacia() {
        return top == null;
    }
    public boolean apilar(Object element) {
        this.top = new Nodo(element, this.top);
        return true;
    }
    public boolean desapilar(){
        boolean itPull = false;
        if(this.top != null){
            this.top = top.getEnlace();
            itPull = true;
        }
        return itPull;
    }
    public Object obtenerTope() {
        return this.top.getElemento();
    }
    public void vaciar(){
        this.top = null;
    }
    public Pila clone(){
        Pila clon = new Pila();
        if(this.top != null) {
            Nodo aux = this.top;
            Nodo auxCopia = new Nodo(aux.getElemento(), null);
            clon.top = auxCopia;
            aux = aux.getEnlace();
            while (aux != null) {
                auxCopia.setEnlace(new Nodo(aux.getElemento(), null));
                auxCopia = auxCopia.getEnlace();
                aux = aux.getEnlace();
            }
        }
        return clon;
    }
    public Pila cloneRecursivo(){
        Pila newStack = new Pila();
        newStack.top = cloneRecur(this.top);
        return newStack;
    }
    private Nodo cloneRecur(Nodo nodo){
        Nodo aux = null;
        if(nodo != null){
            aux = new Nodo(nodo.getElemento(),cloneRecur(nodo.getEnlace()));
        }
        return aux;
    }
    public String toString(){
        String cad = "[]";
        if(this.top != null){
            cad = toStringRecursivo(this.top)+"]";
        }
        return cad;
    }
    private String toStringRecursivo(Nodo nodo){
        String aux = "[";
        if(nodo.getEnlace() != null){
            aux = toStringRecursivo(nodo.getEnlace()) + ", " + nodo.getElemento().toString();
        }else{
            aux += nodo.getElemento().toString();
        }
        return aux;
    }
}
