package Universidad.EstructuraDatos;

public class TestPila {
    public static void main(String[] args) {
        Pila primerPila = new Pila();
        System.out.println(primerPila.toString());
        System.out.println();
        String elemento = "Lorem";
        String elemento2 = "ipsum";
        String elemento3 = "ungret";
        String elemento4 = "malik";
        String elemento5 = "epxileq";
        Pila pilaApilar = new Pila();
        if(pilaApilar.apilar(elemento)) {
            System.out.println(pilaApilar.toString());
        }
        System.out.println();
        Pila vaciarPila = new Pila();
        if(vaciarPila.apilar(elemento)&&vaciarPila.apilar(elemento2)&&vaciarPila.apilar(elemento3)&&vaciarPila.apilar(elemento4)&&vaciarPila.apilar(elemento5)){
            System.out.println(vaciarPila.toString());
        }
        vaciarPila.vaciar();
        System.out.println(vaciarPila.toString());
        System.out.println();
        Pila getTopePila = new Pila();
        if(getTopePila.apilar(elemento)&&getTopePila.apilar(elemento2)&&getTopePila.apilar(elemento3)){
            System.out.println(getTopePila.toString());
            System.out.println(getTopePila.getTope());
            getTopePila.desapilar();
            System.out.println(getTopePila.toString());
            System.out.println(getTopePila.getTope());
        }
        System.out.println();
        Pila pilaVacia = new Pila();
        if(pilaVacia.esVacio()){
            System.out.println(pilaVacia.toString());
        }
    }
}
