package Universidad.EstructuraDatos.jerarquicas.dinamicas;

import Universidad.EstructuraDatos.lineal.dinamico.Cola;
import Universidad.EstructuraDatos.lineal.dinamico.Lista;

public class ArbolBB {
    private NodoABB raiz;
    public ArbolBB() {
        raiz = null;
    }
    public boolean insertar(Comparable elem){
        boolean res = true;
        if(this.raiz == null){
            this.raiz = new NodoABB(elem);
        }else{
            res = insertarAux(elem, this.raiz);
        }
        return res;
    }
    private boolean insertarAux(Comparable elem, NodoABB nodo){
        boolean res = true;
        NodoABB nodoAux;
        int comparacion = elem.compareTo(nodo.getElem());
        if((comparacion == 0)){
            res = false;
        }else if((comparacion < 0)){
            nodoAux = nodo.getIzquierdo();
            if(nodoAux != null){
                res = insertarAux(elem, nodoAux);
            }else{
                nodo.setIzquierdo(new NodoABB(elem));
            }
        }else{
            nodoAux = nodo.getDerecho();
            if(nodoAux != null){
                res = insertarAux(elem, nodoAux);
            }else{
                nodo.setDerecho(new NodoABB(elem));
            }
        }
        return res;
    }
    public boolean eliminar(Comparable elem){
        boolean res = false;
        NodoABB nodoAux;
        if(this.raiz != null){  //Si el arbol esta vacio devulve false
            if(elem.compareTo(this.raiz.getElem()) == 0){   //Caso especial: eliminar la raiz
                nodoAux = eliminarCaso3(this.raiz);
                nodoAux.setIzquierdo(this.raiz.getIzquierdo());
                nodoAux.setDerecho(this.raiz.getDerecho());
                this.raiz = nodoAux;
            }else {
                nodoAux = buscarPadre(elem, this.raiz); //Busca al elemento, y si lo encuentra devuelve a su padre
                if (nodoAux != null) {
                    eliminarAux(elem, nodoAux);         //Se llama al metodo que se encarga de separar los caso de eliminar
                }
            }
            res = true;
        }
        return res;
    }
    private NodoABB buscarPadre(Comparable elem, NodoABB nodo){
        NodoABB res = null;
        if(nodo != null){
            int comparacion = elem.compareTo(nodo.getElem());
            if((comparacion == 0)){ //Se encontro el elemento buscado
                res = nodo;
            }else if((comparacion < 0)){
                res = buscarPadre(elem, nodo.getIzquierdo());       //El elemento buscado es menor a nodo, llamada recursiva al subarbol izquierdo
                if(res!=null&&elem.compareTo(res.getElem()) == 0){
                    res = nodo;
                }
            }else{
                res = buscarPadre(elem, nodo.getDerecho());         //El elemento buscado es mayor a nodo, llamada recursiva al subarbol derecho
                if(res!=null&&elem.compareTo(res.getElem()) == 0){  //Si se encontro el elemento, al retornar inmediatamente se reemplaza res por el padre del elemento buscado
                    res = nodo;
                }
            }
        }
        return res;
    }
    private void eliminarAux(Comparable elem, NodoABB padre){
        NodoABB hijo;
        if(elem.compareTo(padre.getElem()) < 0){        //Metodo que pregunta si hay que eleminar hijo izquierdo o derecho
            hijo = padre.getIzquierdo();
            eliminarIzquierdo(padre,hijo);
        }else{
            hijo = padre.getDerecho();
            eliminarDerecho(padre,hijo);
        }
    }
    private void eliminarIzquierdo(NodoABB padre, NodoABB hijo){
        NodoABB aux;
        if(hijo.getIzquierdo()==null&&hijo.getDerecho()==null){             //Caso 1: el elemento a eliminar no tiene hijos
            padre.setIzquierdo(null);
        } else if (hijo.getIzquierdo()!=null&&hijo.getDerecho()==null) {    //Caso 2-A: el elemento a eliminar tiene hijo izquierdo
            padre.setIzquierdo(hijo.getIzquierdo());
        } else if (hijo.getIzquierdo()==null&&hijo.getDerecho()!=null) {    //Caso 2-B: el elemento a eliminar tiene hijo derecho
            padre.setIzquierdo(hijo.getDerecho());
        } else {                                                            //Caso 3: el elemento a eliminar tiene dos hijos
            aux = eliminarCaso3(hijo);                                      //Se busca el reemplazo del elemento a eliminar
            aux.setIzquierdo(hijo.getIzquierdo());                          //Se conecta el reemplazo con los hijos del elemento
            aux.setDerecho(hijo.getDerecho());
            padre.setIzquierdo(aux);                                        //Se conecta el padre del elemento con el reemplazo
        }
    }
    private void eliminarDerecho(NodoABB padre, NodoABB hijo){
        NodoABB aux;
        if(hijo.getIzquierdo()==null&&hijo.getDerecho()==null){             //Metodo espejo del metodo eliminarIzquierdo
            padre.setDerecho(null);
        } else if (hijo.getIzquierdo()!=null&&hijo.getDerecho()==null) {    //Realiza la misma operacio, pero en el caso que el elemento a eliminar sea el hijo derecho
            padre.setDerecho(hijo.getIzquierdo());
        } else if (hijo.getIzquierdo()==null&&hijo.getDerecho()!=null) {
            padre.setDerecho(hijo.getDerecho());
        } else {
            aux = eliminarCaso3(hijo);
            aux.setIzquierdo(hijo.getIzquierdo());
            aux.setDerecho(hijo.getDerecho());
            padre.setDerecho(aux);
        }
    }
    private NodoABB eliminarCaso3(NodoABB hijo){
        NodoABB aux = hijo.getIzquierdo();
        if(aux!=null) {
            while (aux.getDerecho() != null) {      //Este metodo busca el elemento anterior o posterior al elemento hijo en el listado de inorden
                aux = aux.getDerecho();
            }
        }else{
            aux = hijo.getDerecho();
            while (aux.getIzquierdo() != null) {
                aux = aux.getIzquierdo();
            }
        }
        return aux;
    }
    public boolean pertenece(Comparable elem){
        boolean res = false;
        NodoABB nodoAux = this.raiz;
        while(nodoAux!=null && !res){
            if(elem.compareTo(nodoAux.getElem()) == 0){
                res = true;
            }else if(elem.compareTo(nodoAux.getElem()) < 0){
                nodoAux = nodoAux.getIzquierdo();
            }else{
                nodoAux = nodoAux.getDerecho();
            }
        }
        return res;
    }
    public boolean esVacio(){
        return this.raiz==null;
    }
    public void vaciar(){
        this.raiz = null;
    }
    public Lista listar(){
        Lista lista = new Lista();
        if(this.raiz!=null){
            listarEnInorden(lista, this.raiz);
        }
        return lista;
    }
    private void listarEnInorden(Lista lista, NodoABB nodoAux){
        if(nodoAux!=null){
            listarEnInorden(lista, nodoAux.getDerecho());
            lista.insertar(nodoAux.getElem(),1);
            listarEnInorden(lista, nodoAux.getIzquierdo());
        }
    }
    public Lista listarRango(Comparable elemMinimo, Comparable elemMaximo){
        Lista lista = new Lista();
        if(this.raiz!=null){
            listarPorRango(elemMinimo,elemMaximo,lista, this.raiz);
        }
        return lista;
    }
    private void listarPorRango(Comparable elemMinimo,Comparable elemMaximo,Lista lista, NodoABB nodo){
        if(nodo!=null){
            if(elemMaximo.compareTo(nodo.getElem())>=0){
                listarPorRango(elemMinimo,elemMaximo,lista, nodo.getDerecho());
                lista.insertar(nodo.getElem(),1);
                if(elemMinimo.compareTo(nodo.getElem())<=0){
                    listarPorRango(elemMinimo,elemMaximo,lista, nodo.getIzquierdo());
                }
            }
        }
    }
    public Lista listarEntreNiveles(int niv1, int niv2){
        Lista lista = new Lista();
        Cola cola = new Cola();
        int longitud = 0;
        int cantNodos;
        int nivActual;
        if(this.raiz!=null){
            nivActual = 0;
            cantNodos = (int) Math.pow(2,nivActual);
            cola.poner(this.raiz);
            while(!cola.esVacia()){
                NodoABB nodo = (NodoABB) cola.obtenerFrente();
                cola.sacar();
                if(nivActual>=niv1&&nivActual<=niv2){
                    longitud++;
                    lista.insertar(nodo.getElem(),longitud);
                }
                cantNodos--;
                if(cantNodos==0){
                    nivActual++;
                    cantNodos = (int) Math.pow(2,nivActual);
                }
                if(nodo.getIzquierdo() != null){
                    cola.poner(nodo.getIzquierdo());
                }
                if(nodo.getDerecho() != null){
                    cola.poner(nodo.getDerecho());
                }
            }
        }
        return lista;
    }
    public Object minimoElem(Comparable elem){
        NodoABB nodoAux = this.raiz;
        Object res = null;
        if(nodoAux!=null) {
            while (nodoAux.getIzquierdo() != null) {
                nodoAux = nodoAux.getIzquierdo();
            }
            res = nodoAux.getElem();
        }
        return res;
    }
    public Object maximoElem(Comparable elem){
        NodoABB nodoAux = this.raiz;
        Object res = null;
        if(nodoAux!=null) {
            while(nodoAux.getDerecho() != null) {
                nodoAux = nodoAux.getDerecho();
            }
            res = nodoAux.getElem();
        }
        return res;
    }
}
