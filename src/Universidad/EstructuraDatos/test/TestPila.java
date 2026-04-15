package Universidad.EstructuraDatos.test;

import Universidad.EstructuraDatos.lineal.dinamico.Pila;

public class TestPila {
    public static void main(String[] args) {
        Pila primerPila = new Pila();
        System.out.println(primerPila.toString());

        System.out.println();

        String[] elemento = {"Lorem","ipsum","ungret","malik","epxileq"};

        Pila pilaApilar = new Pila();
        if(apilar(elemento,pilaApilar,1)) {
            System.out.println(pilaApilar.toString());
        }

        System.out.println();

        Pila vaciarPila = new Pila();
        if(apilar(elemento,vaciarPila,5)){
            System.out.println(vaciarPila.toString());
        }
        vaciarPila.vaciar();
        System.out.println(vaciarPila.toString());

        System.out.println();

        Pila getTopePila = new Pila();
        if(apilar(elemento,getTopePila,4)){
            System.out.println(getTopePila.toString());
            System.out.println(getTopePila.obtenerTope());
            getTopePila.desapilar();
            System.out.println(getTopePila.toString());
            System.out.println(getTopePila.obtenerTope());
        }

        System.out.println();

        Pila pilaVacia = new Pila();
        if(pilaVacia.esVacia()){
            System.out.println("La pila esta vacia");
        }
        System.out.println("Apilo un elemento");
        pilaVacia.apilar(elemento);
        if(pilaVacia.esVacia()){
            System.out.println("La pila esta vacia");
        }else{
            System.out.println("La pila no esta vacia");
        }

        System.out.println();

        Pila errorTope = new Pila();
        if(apilarElem(elemento[0],errorTope,5)){
            if(errorTope.apilar(elemento[1])){
                System.out.println("La pila no esta llena "+errorTope.obtenerTope());
            }else{
                System.out.println("La pila esta llena "+errorTope.obtenerTope());
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
        if(apilar(elemento,pilaOriginal,5)){
            System.out.println(pilaOriginal.toString());
            pilaClon = pilaOriginal.clone();
            System.out.println(pilaClon.toString());
        }else{
            System.out.println("No se pudo cargar la pila original");
        }

        System.out.println();
    }
    public static boolean apilar(String[] elemento, Pila pila, int cant){
        int i = 0;
        boolean apilado = true;
        while(i < cant && apilado){
            apilado = pila.apilar(elemento[i]);
            i++;
        }
        return apilado;
    }
    public static boolean apilarElem(String elemento, Pila pila, int cant){
        int i = 0;
        boolean apilado = true;
        while(i < cant && apilado){
            apilado = pila.apilar(elemento);
            i++;
        }
        return apilado;
    }
}
