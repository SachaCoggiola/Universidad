package Universidad.EstructuraDatos.lineal.dinamico;

public class Lista {
    private Nodo cabecera;
    private int longitud;

    public Lista(){
        this.cabecera = null;
        this.longitud = 0;
    }
    public boolean insertar(Object elem, int pos){
        Nodo aux;
        Nodo nuevo;
        int i = 1;
        boolean bandera = false;
        if(1 <= pos && pos <= this.longitud+1){
            if(pos == 1){
                nuevo = new Nodo(elem,this.cabecera);
                this.cabecera = nuevo;
            }else{
                aux = this.cabecera;
                while(i < pos - 1){
                    aux = aux.getEnlace();
                    i++;
                }
                nuevo = new Nodo(elem,aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            bandera = true;
            this.longitud++;
        }
        return bandera;
    }
    public boolean eliminar(int pos){
        boolean bandera = false;
        Nodo aux;
        int i = 1;
        if(1 <= pos && pos <= this.longitud+1){
            if(pos == 1){
                this.cabecera = this.cabecera.getEnlace();
            }else{
                aux = this.cabecera;
                while(i <= pos - 1){
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            bandera = true;
        }
        return bandera;
    }
    public Object recuperar(int pos){
        Object ret = null;
        Nodo aux;
        int i = 1;
        if(1 <= pos && pos <= this.longitud+1){
            if(pos == 1){
                ret = this.cabecera.getElemento();
            }else{
                aux = this.cabecera;
                while(i <= pos){
                    aux = aux.getEnlace();
                    i++;
                }
                ret = aux.getElemento();
            }
        }
        return ret;
    }
    public int localizar(Object elem){
        int pos = -1;
        Nodo aux = this.cabecera;
        if(aux!=null){
            pos = 1;
            while(aux != null){
                if(!(aux.getElemento().equals(elem))){
                    pos++;
                    aux = aux.getEnlace();
                }
            }
        }
        return pos;
    }
    public void vaciar(){
        this.cabecera = null;
        this.longitud = -1;
    }
    public boolean esVacio(){
        return this.cabecera == null && this.longitud == -1;
    }
    public Lista clone(){
        Lista clone = new Lista();
        clone.longitud = this.longitud;
        Nodo aux = this.cabecera;
        Nodo copia = new Nodo(aux.getElemento(),null);
        clone.cabecera = copia;
        aux = aux.getEnlace();
        while(aux != null){
            copia.setEnlace(new Nodo(aux.getElemento(),null));
            copia = copia.getEnlace();
            aux = aux.getEnlace();
        }
        return clone;
    }
    public int longitud(){
        return this.longitud;
    }
    public String toString(){
        StringBuilder ret = new StringBuilder("[");
        Nodo aux = this.cabecera;
        if(aux != null){
            while(aux != null){
                ret.append(aux.getElemento());
                if(aux.getEnlace() != null){
                    ret.append(", ");
                }
                aux = aux.getEnlace();
            }
        }
        ret.append("]");
        return ret.toString();
    }
}
