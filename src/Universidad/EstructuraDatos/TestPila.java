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
            System.out.println("La pila esta vacia");
        }
        System.out.println("Apilo un elemento");
        pilaVacia.apilar(elemento);
        if(pilaVacia.esVacio()){
            System.out.println("La pila esta vacia");
        }else{
            System.out.println("La pila no esta vacia");
        }

        System.out.println();

        Pila errorTope = new Pila();
        if(errorTope.apilar(elemento)&&errorTope.apilar(elemento)&&errorTope.apilar(elemento)&&errorTope.apilar(elemento)&&errorTope.apilar(elemento)){
            if(errorTope.apilar(elemento2)){
                System.out.println("La pila no esta llena "+errorTope.getTope());
            }else{
                System.out.println("La pila esta llena "+errorTope.getTope());
            }
        }

        System.out.println();

        Pila errorDesapilar = new Pila();
        if(errorDesapilar.desapilar()){
            System.out.println("La pila no estaba vacia, y se desapilo el tope");
        }else{
            System.out.println("La pila estaba vacia, y no se pudo desapilar el tope");
        }

        System.out.println();

        Pila pilaOriginal = new Pila();
        Pila pilaClon;
        if(pilaOriginal.apilar(elemento)&&pilaOriginal.apilar(elemento2)&&pilaOriginal.apilar(elemento3)&&pilaOriginal.apilar(elemento4)&&pilaOriginal.apilar(elemento5)){
            System.out.println(pilaOriginal.toString());
            pilaClon = pilaOriginal.clone();
            System.out.println(pilaClon.toString());
        }else{
            System.out.println("No se pudo cargar la pila original");
        }

        System.out.println();

        Pila pilaOrigen = new Pila();
        Pila pilaDest = new Pila();
        Pila esIgual = new Pila();
        if(pilaOrigen.apilar(elemento)&&pilaOrigen.apilar(elemento2)&&pilaOrigen.apilar(elemento3)&&pilaOrigen.apilar(elemento4)&&pilaOrigen.apilar(elemento5)){
            System.out.println(pilaOrigen.toString());
            if(esIgual.equals(pilaDest))
                System.out.println("Las pilas estan vacias, y por lo tanto son iguales");
            esIgual = pilaOrigen.clone();
            System.out.println(esIgual.toString());
            if(esIgual.equals(pilaOrigen))
                System.out.println("Las pilas son clones, y por lo tanto son iguales");
            if(!esIgual.equals(pilaDest))
                System.out.println("La pila esIgual ya no esta vacia, y por lo tanto no es igual");
        }
    }
}
