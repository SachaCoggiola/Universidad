package Universidad.EstructuraDatos.lineal.dinamico;

public class Nodo {
    private Object elemento;
    private Nodo enlace;

    public Nodo(Object elemento, Nodo enlace){
        this.elemento = elemento;
        this.enlace = enlace;
    }
    public Object getElemento(){
        return elemento;
    }
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    public Nodo getEnlace(){
        return this.enlace;
    }
    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }
}
