package Universidad.EstructuraDatos.lineal.dinamico;

public class Cola {
    private Nodo frente;
    private Nodo fin;
    public Cola() {
        this.frente = null;
        this.fin = null;
    }
    public boolean poner(Object elem){
        boolean bandera = false;
        if(this.frente == null){
            this.frente = new Nodo(elem,null);
            this.fin = this.frente;
            bandera = true;
        }else{
            Nodo aux = new Nodo(elem,null);
            this.fin.setEnlace(aux);
            this.fin = aux;
            bandera = true;
        }
        return bandera;
    }
    public boolean sacar(){
        boolean bandera = false;
        if(this.frente != null){
            this.frente = this.frente.getEnlace();
            bandera = true;
        }
        return bandera;
    }
    public Object obtenerFrente(){
        return this.frente.getElemento();
    }
    public boolean esVacia(){
        return this.frente == null;
    }
    public void vaciar(){
        this.frente = null;
        this.fin = null;
    }
    public Cola clone(){
        Cola colaClon = new Cola();
        if(this.frente != null){
            Nodo aux;
            Nodo copia = new Nodo(this.frente.getElemento(),null);
            colaClon.frente = copia;
            aux = this.frente.getEnlace();
            while(aux.getEnlace() != null){
                copia.setEnlace(new Nodo(aux.getElemento(),null));
                aux = aux.getEnlace();
                copia = copia.getEnlace();
            }
            colaClon.fin = copia;
        }
        return colaClon;
    }
    public String toString(){
        return "["+stringRecursivo(this.frente)+"] Frente: "+this.frente.getElemento()+"; Fin: "+this.fin.getElemento();
    }
    private String stringRecursivo(Nodo aux){
        String res = aux.getElemento().toString();
        if(aux.getEnlace() != null){
            res = stringRecursivo(aux.getEnlace()) + ", " + aux.getElemento().toString();
        }
        return res;
    }
}
