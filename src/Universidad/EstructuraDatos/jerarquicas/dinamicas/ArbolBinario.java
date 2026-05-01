package Universidad.EstructuraDatos.jerarquicas.dinamicas;

import Universidad.EstructuraDatos.lineal.dinamico.Cola;
import Universidad.EstructuraDatos.lineal.dinamico.Lista;

public class ArbolBinario {
    private NodoArbol raiz;
    public ArbolBinario() {
        this.raiz = null;
    }
    public boolean insertar(Object nuevo, Object padre, char pos){
        NodoArbol aux;
        boolean respuesta = true;
        if(this.raiz == null){
            this.raiz = new NodoArbol(nuevo);
        }else{
            aux = obtenerNodo(this.raiz,padre);
            if(aux != null){
                if(pos == 'I' && aux.getIzquierdo()==null){
                    aux.setIzquierdo(new NodoArbol(nuevo));
                }else if(pos == 'D' && aux.getDerecho()==null){
                    aux.setDerecho(new NodoArbol(nuevo));
                }else{
                    respuesta = false;
                }
            }else{
                respuesta = false;
            }
        }
        return respuesta;
    }
    public boolean insertarPorPosicion(Object nuevo, int posPadre, char posHijo){
        int[] pos = {0};
        NodoArbol aux = nodoPorPosicion(this.raiz, posPadre, pos);
        boolean respuesta = true;
        if(aux != null){
            if(posHijo == 'I' && aux.getIzquierdo()==null){
                aux.setIzquierdo(new NodoArbol(nuevo));
            }else if(posHijo == 'D' && aux.getDerecho()==null){
                aux.setDerecho(new NodoArbol(nuevo));
            }else{
                respuesta = false;
            }
        }else{
            respuesta = false;
        }
        return respuesta;
    }
    private NodoArbol nodoPorPosicion(NodoArbol nodo, int posPadre, int[] pos){
        NodoArbol aux = null;
        if(nodo != null) {
            pos[0]++;
            if (posPadre == pos[0]) {
                aux = nodo;
            } else {
                aux = nodoPorPosicion(nodo.getIzquierdo(), posPadre, pos);
                if(aux == null){
                    aux = nodoPorPosicion(nodo.getDerecho(), posPadre, pos);
                }
            }
        }
        return aux;
    }
    public boolean esVacio(){
        return this.raiz == null;
    }
    public int altura(){
        return calcAltura(this.raiz);
    }
    private int calcAltura(NodoArbol nodo){
        int largo = -1;
        int largoIzq, largoDer;
        if(nodo != null){
            largoIzq = calcAltura(nodo.getIzquierdo())+1;
            largoDer = calcAltura(nodo.getDerecho())+1;
            largo=max(largoIzq,largoDer);
        }
        return largo;
    }
    private int max(int a, int b){
        return Math.max(a, b);
    }
    public int nivel(Object elem){
        return calcNivel(this.raiz, elem);
    }
    private int calcNivel(NodoArbol nodo, Object elem){
        int largo = -1;
        if(nodo != null){
            if(nodo.getElemento().equals(elem)){
                largo++;
            }else{
                largo = calcNivel(nodo.getIzquierdo(), elem);
                if(largo == -1){
                    largo = calcNivel(nodo.getDerecho(), elem);
                }
                if(largo != -1){
                    largo++;
                }
            }
        }
        return largo;
    }
    public Object padre(Object elem){
        Object aux = null;
        NodoArbol padre = buscarPadre(this.raiz, elem);
        if(padre != null){
            aux = padre.getElemento();
        }
        return aux;
    }
    private NodoArbol buscarPadre(NodoArbol nodo, Object elemHijo){
        NodoArbol padre = null;
        if(nodo != null){
            if(nodo.getElemento().equals(elemHijo)){
                padre = nodo;
            }else{
                padre = buscarPadre(nodo.getIzquierdo(), elemHijo);
                if(padre == null){
                    padre = buscarPadre(nodo.getDerecho(), elemHijo);
                }
                if(padre.getElemento() == elemHijo){
                    padre = nodo;
                }
            }
        }
        return padre;
    }
    public Lista listarPreorden(){
        Lista lista = new Lista();
        listaEnPreorden(lista, this.raiz);
        return lista;
    }
    private void listaEnPreorden(Lista lista, NodoArbol nodo){
        if(nodo != null){
            lista.insertar(nodo.getElemento(), lista.longitud());
            listaEnPreorden(lista, nodo.getIzquierdo());
            listaEnPreorden(lista, nodo.getDerecho());
        }
    }
    public Lista listarInorden(){
        Lista lista = new Lista();
        listaEnInorden(lista, this.raiz);
        return lista;
    }
    private void listaEnInorden(Lista lista, NodoArbol nodo){
        if(nodo != null){
            listaEnInorden(lista, nodo.getIzquierdo());
            lista.insertar(nodo.getElemento(),lista.longitud()+1);
            listaEnInorden(lista, nodo.getDerecho());
        }
    }
    public Lista listarPosorden(){
        Lista lista = new Lista();
        listaEnPosorden(lista,this.raiz);
        return lista;
    }
    private void listaEnPosorden(Lista lista, NodoArbol nodo){
        if(nodo != null){
            listaEnPosorden(lista, nodo.getIzquierdo());
            listaEnPosorden(lista, nodo.getDerecho());
            lista.insertar(nodo.getElemento(),lista.longitud()+1);
        }
    }
    public Lista listarNiveles(){
        Lista lista = new Lista();
        Cola cola = new Cola();
        if(this.raiz != null){
            cola.poner(this.raiz);
            while(!cola.esVacia()){
                NodoArbol nodo = (NodoArbol) cola.obtenerFrente();
                cola.sacar();
                lista.insertar(nodo.getElemento(), lista.longitud()+1);
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
    public ArbolBinario clone(){
        ArbolBinario copia = new ArbolBinario();
        copia.raiz = copiarArbol(this.raiz);
        return copia;
    }
    private NodoArbol copiarArbol(NodoArbol nodo){
        NodoArbol copia = null;
        if(nodo != null){
            copia = new NodoArbol(nodo.getElemento());
            copia.setIzquierdo(copiarArbol(nodo.getIzquierdo()));
            copia.setDerecho(copiarArbol(nodo.getDerecho()));
        }
        return copia;
    }
    public void vaciar(){
        this.raiz = null;
    }
    private NodoArbol obtenerNodo(NodoArbol nodo, Object elemBuscado){
        NodoArbol res = null;
        if(nodo != null){
            if(nodo.getElemento().equals(elemBuscado)){
                res = nodo;
            }else{
                res = obtenerNodo(nodo.getIzquierdo(), elemBuscado);
                if(res == null){
                    res = obtenerNodo(nodo.getDerecho(), elemBuscado);
                }
            }
        }
        return res;
    }
    public Lista frontera(){
        Lista lista = new Lista();
        listarFrontera(lista,this.raiz);
        return lista;
    }
    private void listarFrontera(Lista lista, NodoArbol nodo){
        if(nodo != null){
            if(nodo.getIzquierdo() == null && nodo.getDerecho() == null){
                lista.insertar(nodo.getElemento(), lista.longitud()+1);
            }else {
                listarFrontera(lista, nodo.getIzquierdo());
                listarFrontera(lista, nodo.getDerecho());
            }
        }
    }
    public Lista obtenerAncestros(Object elem){
        Lista lista = new Lista();
        boolean[] flag = {false};
        ancestros(lista, elem, this.raiz, flag);
        return lista;
    }
    private void ancestros(Lista lista, Object buscado, NodoArbol nodo, boolean[] flag){
        if(nodo != null){
            if(nodo.getElemento().equals(buscado)){
                flag[0] = true;
            }else {
                ancestros(lista, buscado, nodo.getIzquierdo(), flag);
                if(!flag[0]){
                    ancestros(lista, buscado, nodo.getDerecho(), flag);
                }
                if(flag[0]){
                    lista.insertar(nodo.getElemento(), lista.longitud()+1);
                }
            }
        }
    }
    public Lista obtenerDescendientes(Object elem){
        Lista lista = new Lista();
        descendientes(lista, obtenerNodo(this.raiz,elem));
        lista.eliminar(1);
        return lista;
    }
    private void descendientes(Lista lista, NodoArbol nodo){
        if(nodo != null){
            lista.insertar(nodo.getElemento(), lista.longitud()+1);
            descendientes(lista, nodo.getIzquierdo());
            descendientes(lista, nodo.getDerecho());
        }
    }
}
