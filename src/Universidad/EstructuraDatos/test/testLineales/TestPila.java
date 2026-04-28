package Universidad.EstructuraDatos.test.testLineales;

import Universidad.EstructuraDatos.lineal.dinamico.Pila;

public class TestPila {
    public static String[] elemento = {"Lorem","ipsum","ungret","malik","epxileq"};
    public static void main(String[] args) {
    /*
        crearPila();
        System.out.println();
        apilarPila();
        System.out.println();
        vaciarPila();
        System.out.println();
        obtenerTopePila();
        System.out.println();
        verificarEsVacia();
        System.out.println();
        errorTope();
        System.out.println();
        errorDesapilar();
        System.out.println();
        compararPilaConClon();
        System.out.println();
     */
        Pila pilaCapicua = new Pila();
        pilaCapicua.apilar("n");
        pilaCapicua.apilar("e");
        pilaCapicua.apilar("u");
        pilaCapicua.apilar("q");
        pilaCapicua.apilar("u");
        pilaCapicua.apilar("e");
        pilaCapicua.apilar("n");
        if(esCapicua(pilaCapicua)){
            System.out.println("La pila es capicua");
        }else {
            System.out.println("La pila no es capicua");
        }
    }
    public static boolean esCapicua(Pila pila){
        StringBuilder cadena = new StringBuilder();
        Pila pilaCopia = pila.clone();
        while(!pilaCopia.esVacia()){
                cadena.append(pilaCopia.obtenerTope());
                pilaCopia.desapilar();
        }
        return esCapicua(cadena.toString());
    }
    public static boolean esCapicua(String cadena){
        boolean flag = true;
        int j = cadena.length()-1;
        int i = 0;
        while(i < j && flag){
            if(cadena.charAt(i) != cadena.charAt(j)){
                flag = false;
            }else{
                i++;
                j--;
            }
        }
        return flag;
    }
    public static void crearPila(){
        Pila primerPila = new Pila();
        System.out.println(primerPila.toString());
    }
    public static void apilarPila(){
        Pila pilaApilar = new Pila();
        if(apilar(elemento,pilaApilar,1)) {
            System.out.println(pilaApilar.toString());
        }
    }
    public static void vaciarPila(){
        Pila vaciarPila = new Pila();
        if(apilar(elemento,vaciarPila,5)){
            System.out.println(vaciarPila.toString());
        }
        vaciarPila.vaciar();
        System.out.println(vaciarPila.toString());
    }
    public static void obtenerTopePila(){
        Pila getTopePila = new Pila();
        if(apilar(elemento,getTopePila,4)){
            System.out.println(getTopePila.toString());
            System.out.println(getTopePila.obtenerTope());
            getTopePila.desapilar();
            System.out.println(getTopePila.toString());
            System.out.println(getTopePila.obtenerTope());
        }
    }
    public static void verificarEsVacia(){
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
    }
    public static void errorTope(){
        Pila errorTope = new Pila();
        if(apilarElem(elemento[0],errorTope,5)){
            if(errorTope.apilar(elemento[1])){
                System.out.println("La pila no esta llena "+errorTope.obtenerTope());
            }else{
                System.out.println("La pila esta llena "+errorTope.obtenerTope());
            }
        }
    }
    public static void errorDesapilar(){
        Pila errorDesapilar = new Pila();
        if(errorDesapilar.desapilar()){
            System.out.println("La pila no estaba vacia, y se desapilo el tope");
        }else{
            System.out.println("La pila estaba vacia, y no se pudo desapilar el tope");
        }
    }
    public static void compararPilaConClon(){
        Pila pilaOriginal = new Pila();
        Pila pilaClon;
        if(apilar(elemento,pilaOriginal,5)){
            System.out.println(pilaOriginal.toString());
            pilaClon = pilaOriginal.clone();
            System.out.println(pilaClon.toString());
        }else{
            System.out.println("No se pudo cargar la pila original");
        }
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
