package Universidad.EstructuraDatos;

public class Node {
    private Object elemento;
    private Node enlace;

    public Node(Object elemento, Node enlace){
        this.elemento = elemento;
        this.enlace = enlace;
    }
    public Object getElemento(){
        return elemento;
    }
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    public Node getEnlace(){
        return enlace;
    }
    public void setEnlace(Node enlace){
        this.enlace = enlace;
    }
}
