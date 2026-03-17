package Universidad.EstructuraDatos;

public class Stack {
    private Node top;
    public Stack() {
        top = null;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public boolean push(Object element) {
        this.top = new Node(element, this.top);
        return true;
    }
    public boolean pop(){
        boolean itPull = false;
        if(this.top != null){
            this.top = top.getEnlace(); //Es necesario igualar el nodo que se desapila a null?
            itPull = true;
        }
        return itPull;
    }
    public Object getTop() {
        return this.top;
    }
    public boolean isEmptyStack(){
        return top == null;
    }
    /*public Node peek(){
        Node aux = null;
        if(this.top != null){
            aux = this.top.getEnlace();
        }
        return aux;    //muestra cual seria el siguiente nodo
    }*/
    public void emptyStack(){
        this.top = null;
    }
    public Stack clone(){
        Stack newStack = new Stack(); //supermetodo?
        newStack.top = this.top;
        return newStack;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        Node aux;
        if(this.top == null){
            str = new StringBuilder("La pila esta vacía.");
        }else{
            aux = this.top;
            while(aux != null){
                str.append(aux.getElemento().toString()).append("\n");
                aux = aux.getEnlace();
            }
        }
        return str.toString();
    }
}
