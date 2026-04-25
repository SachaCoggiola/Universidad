package Universidad.EstructuraDatos.jerarquicas.dinamicas;

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
                if(pos == 'I' && aux.getHijoIzq()==null){
                    aux.setHijoIzq(new NodoArbol(nuevo));
                }else if(pos == 'D' && aux.getHijoDer()==null){
                    aux.setHijoDer(new NodoArbol(nuevo));
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
            if(posHijo == 'I' && aux.getHijoIzq()==null){
                aux.setHijoIzq(new NodoArbol(nuevo));
            }else if(posHijo == 'D' && aux.getHijoDer()==null){
                aux.setHijoDer(new NodoArbol(nuevo));
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
                aux = nodoPorPosicion(nodo.getHijoIzq(), posPadre, pos);
                if(aux == null){
                    aux = nodoPorPosicion(nodo.getHijoDer(), posPadre, pos);
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
            largoIzq = calcAltura(nodo.getHijoIzq())+1;
            largoDer = calcAltura(nodo.getHijoDer())+1;
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
            if(nodo.getElem().equals(elem)){
                largo++;
            }else{
                largo = calcNivel(nodo.getHijoIzq(), elem);
                if(largo == -1){
                    largo = calcNivel(nodo.getHijoDer(), elem);
                }
                if(largo != -1){
                    largo++;
                }
            }
        }
        return largo;
    }
    public Object padre(Object elem){
        return buscPadre(this.raiz, elem);
    }
    private Object buscPadre(NodoArbol nodo, Object elem){
        Object res = null;
        if(nodo != null){
            if(nodo.getElem().equals(elem)){
                res = nodo.getElem();
            }else{
                res = buscPadre(nodo.getHijoIzq(), elem);
                if(res == null){
                    buscPadre(nodo.getHijoDer(), elem);
                }
                if(res == elem){
                    res = nodo.getElem();
                }
            }
        }
        return res;
    }
    public Lista listarPreorden(){
        Lista lista = new Lista();
        listaEnPreorden(lista, this.raiz, 1);
        return lista;
    }
    private int listaEnPreorden(Lista lista, NodoArbol nodo, int pos){
        if(nodo != null){
            lista.insertar(nodo.getElem(), pos);
            pos = listaEnPreorden(lista, nodo.getHijoIzq(), pos+1);
            pos = listaEnPreorden(lista, nodo.getHijoDer(), pos+1);
        }
        return pos;
    }
    public Lista listarInorden(){
        Lista lista = new Lista();
        listaEnInorden(lista, this.raiz, 0);
        return lista;
    }
    private void listaEnInorden(Lista lista, NodoArbol nodo, int pos){
        if(nodo != null){
            listaEnInorden(lista, nodo.getHijoIzq(), pos);
            listaEnInorden(lista, nodo.getHijoDer(), pos);
            lista.insertar(nodo.getElem(),pos);
        }
    }
    private NodoArbol obtenerNodo(NodoArbol nodo, Object elemBuscado){
        NodoArbol res = null;
        if(nodo != null){
            if(nodo.getElem().equals(elemBuscado)){
                res = nodo;
            }else{
                res = obtenerNodo(nodo.getHijoIzq(), elemBuscado);
                if(res == null){
                    res = obtenerNodo(nodo.getHijoDer(), elemBuscado);
                }
            }
        }
        return res;
    }
}
