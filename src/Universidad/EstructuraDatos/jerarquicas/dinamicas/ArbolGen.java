package Universidad.EstructuraDatos.jerarquicas.dinamicas;

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
    public boolean pertenece(Object hijo) {
        return pertenceAux(hijo, this.raiz);
    }
    public boolean esVacio(){
        return this.raiz == null;
    }
    public Object padre(Object hijo){
        return buscarPadre(hijo, this.raiz).getElem();
    }
    public int altura(){
        return calAltura(this.raiz);
    }
    private int calAltura(NodoGen nodo){
        int altIzquierda = 0;
        int altDerecha = 0;
        int max;
        if(nodo != null){

        }
    }
    public void vaciar(){
        this.raiz = null;
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
}
