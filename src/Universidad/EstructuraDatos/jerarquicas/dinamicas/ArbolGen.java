package Universidad.EstructuraDatos.jerarquicas.dinamicas;

import Universidad.EstructuraDatos.lineal.dinamico.Lista;
import Universidad.EstructuraDatos.lineal.dinamico.Pila;

public class ArbolGen {
    private NodoGen raiz;
    public ArbolGen() {
        this.raiz = null;
    }
    public boolean insertar(Object hijo, Object padre) {
        NodoGen aux;
        NodoGen nuevo;
        boolean flag = false;
        if(this.raiz == null) {
            this.raiz = new NodoGen(hijo);
            flag = true;
        }else{
            aux = buscarPreorden(padre,this.raiz);
            if(aux != null) {
                nuevo = new NodoGen(hijo,null,aux.getHijoIzquierdo());
                aux.setHijoIzquierdo(nuevo);
                flag = true;
            }
        }
        return flag;
    }
    private NodoGen buscarPreorden(Object padre, NodoGen aux) {
        NodoGen res = null;
        if(aux != null){
            if(padre.equals(aux.getElem())){
                res = aux;
            }else{
                res = buscarPreorden(padre,aux.getHijoIzquierdo());
                if(res == null){
                    res = buscarPreorden(padre,aux.getHermanoDerecho());
                }
            }
        }
        return res;
    }
    public boolean insertarPorPosicion(Object hijo, int padre) {
        NodoGen aux;
        NodoGen nuevo;
        boolean flag = false;
        int[] arr = {padre};
        if(this.raiz == null) {
            this.raiz = new NodoGen(hijo);
            flag = true;
        }else{
            aux = buscarPosicionPreorden(arr,this.raiz);
            if(aux != null) {
                nuevo = new NodoGen(hijo,null,aux.getHijoIzquierdo());
                aux.setHijoIzquierdo(nuevo);
                flag = true;
            }
        }
        return flag;
    }
    private NodoGen buscarPosicionPreorden(int[] padre, NodoGen aux) {
        NodoGen res = null;
        if(aux!=null){
            padre[0]--;
            if(padre[0]==0){
                res=aux;
            }else{
                res=buscarPosicionPreorden(padre,aux.getHijoIzquierdo());
                if(res==null){
                    res=buscarPosicionPreorden(padre,aux.getHermanoDerecho());
                }
            }
        }
        return res;
    }
    public boolean pertenece(Object hijo) {
        return pertenceAux(hijo, this.raiz);
    }
    private boolean pertenceAux(Object hijo, NodoGen aux) {
        boolean flag = false;
        if(aux != null) {
            if(aux.getElem().equals(hijo)) {
                flag = true;
            }else{
                flag = pertenceAux(hijo, aux.getHijoIzquierdo());
                if(!flag){
                    flag = pertenceAux(hijo, aux.getHermanoDerecho());
                }
            }
        }
        return flag;
    }
    public Lista ancestros(Object hijo){
        Lista anc = new Lista();
        ancestrosAux(this.raiz, hijo,anc);
        return anc;
    }
    private boolean ancestrosAux(NodoGen aux, Object hijo, Lista anc) {
        boolean flag = false;
        if(aux != null) {
            if(aux.getElem().equals(hijo)) {
                flag = true;
            }else{
                flag = ancestrosAux(aux.getHijoIzquierdo(),hijo,anc);
                if(!flag){
                    flag = ancestrosAux(aux.getHermanoDerecho(),hijo,anc);
                }else{
                    anc.insertar(aux.getElem(),1);
                }
            }
        }
        return flag;
    }
    public boolean esVacio(){
        return this.raiz == null;
    }
    public int altura(){
        return calcAltura(this.raiz);
    }
    private int calcAltura(NodoGen nodo){
        int altIzquierda = -1,altDerecha = -1,max;
        if(nodo != null){
            altIzquierda = 1 + calcAltura(nodo.getHijoIzquierdo());
            altDerecha = calcAltura(nodo.getHermanoDerecho());
        }
        max = Math.max(altIzquierda,altDerecha);
        return max;
    }
    public int nivel(Object elem){
        return calcNivel(this.raiz, elem);
    }
    private int calcNivel(NodoGen nodo, Object elem){
        int nivel = -1;
        if(nodo!=null){
            if(nodo.getElem().equals(elem)){
                nivel = 0;
            }else{
                nivel = calcNivel(nodo.getHijoIzquierdo(), elem);
                if(nivel==-1){
                    nivel = calcNivel(nodo.getHermanoDerecho(), elem);
                }else{
                    nivel += 1;
                }
            }
        }
        return nivel;
    }
    public Object padre(Object hijo){
        return buscarPadre(hijo, this.raiz).getElem();
    }
    private NodoGen buscarPadre(Object hijo, NodoGen nodo) {
        NodoGen padre = null;
        if(nodo!=null){
            if(nodo.getElem().equals(hijo)){
                padre = nodo;
            }else{
                padre = buscarPadre(hijo, nodo.getHijoIzquierdo());
                if(padre==null){
                    padre = buscarPadre(hijo, nodo.getHermanoDerecho());
                }
                if(padre!=null&&padre.getElem().equals(hijo)){
                    padre = nodo;
                }
            }
        }
        return padre;
    }
    public Lista listarPreorden(){
        Lista lista = new Lista();
        listarEnPreorden(this.raiz,1,lista);
        return lista;
    }
    private void listarEnPreorden(NodoGen nodo,int largo,Lista lista) {
        if(nodo!=null){
            lista.insertar(nodo.getElem(),largo);
            listarEnPreorden(nodo.getHijoIzquierdo(),largo+1,lista);
            listarEnPreorden(nodo.getHermanoDerecho(),largo+1,lista);
        }
    }
    public Lista listarInorden(){
        Lista lista = new Lista();
        Pila pilaRaiz = new Pila();
        listarEnInorden(this.raiz,pilaRaiz,lista,false);
        return lista;
    }
    private void listarEnInorden(NodoGen nodo,Pila pilaRaiz,Lista lista, boolean hijoIzq) {
        if(nodo!=null){
            listarEnInorden(nodo.getHermanoDerecho(),pilaRaiz,lista,false);
            if(hijoIzq){
                lista.insertar(((NodoGen) pilaRaiz.obtenerTope()).getElem(),1);
                pilaRaiz.desapilar();
            }
            pilaRaiz.apilar(nodo);
            listarEnInorden(nodo.getHijoIzquierdo(),pilaRaiz,lista,true);
        }else{
            if(hijoIzq){
                lista.insertar(((NodoGen) pilaRaiz.obtenerTope()).getElem(),1);
                pilaRaiz.desapilar();
            }
        }
    }
    public Lista listarPosorden(){
        Lista lista = new Lista();
        listarEnPosorden(this.raiz,1,lista);
        return lista;
    }
    private void listarEnPosorden(NodoGen nodo,int largo,Lista lista) {
        if(nodo!=null){
            listarEnPosorden(nodo.getHijoIzquierdo(),largo+1,lista);
            lista.insertar(nodo.getElem(),largo);
            listarEnPosorden(nodo.getHermanoDerecho(),largo+1,lista);
        }
    }
    public ArbolGen clone(){
        ArbolGen res = new ArbolGen();
        if(this.raiz!=null){
            res.raiz = new NodoGen(this.raiz.getElem());
            cloneAux(this.raiz,res.raiz);
        }
        return res;
    }
    private void cloneAux(NodoGen nodo, NodoGen copia){
        NodoGen aux;
        if(nodo!=null){
            aux = nodo.getHijoIzquierdo();
            if(aux!=null){
                copia.setHijoIzquierdo(new NodoGen(aux.getElem()));
                cloneAux(aux,copia.getHijoIzquierdo());
            }
            nodo = nodo.getHermanoDerecho();
            while(nodo!=null){
                copia.setHermanoDerecho(new NodoGen(nodo.getElem()));
                copia = copia.getHermanoDerecho();
                cloneAux(nodo,copia);
                nodo = nodo.getHermanoDerecho();
            }
        }
    }
    public void vaciar(){
        this.raiz = null;
    }
    public String toString(){
        return "\n"+string(this.raiz);
    }
    private String string(NodoGen nodo){
        StringBuilder res = new StringBuilder();
        NodoGen aux;
        if(nodo!=null){
            res.append(nodo.getElem()).append(": ");
            aux = nodo.getHijoIzquierdo();
            while(aux!=null){
                res.append(aux.getElem());
                if(aux.getHermanoDerecho()!=null) {
                    res.append(", ");
                }
                aux = aux.getHermanoDerecho();
            }
            res.append("\n");
            res.append(string(nodo.getHijoIzquierdo()));
            res.append(string(nodo.getHermanoDerecho()));
        }
        return res.toString();
    }
}
