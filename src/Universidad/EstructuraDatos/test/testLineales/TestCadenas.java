package Universidad.EstructuraDatos.test.testLineales;

import Universidad.EstructuraDatos.lineal.dinamico.Cola;

public class TestCadenas {
    public static void main(String[] args) {
        Cola cola = new Cola();
        cola.poner("AB");
        cola.poner("C");
        cola.poner("DEF");
        System.out.println(cola.toString());
        System.out.println(generar(cola).toString());
    }
    public static Cola generar(Cola cola1){
        Cola colaRes = new Cola();
        String cad;
        while(!cola1.esVacia()){
            cad = (String) cola1.obtenerFrente();
            colaRes.poner(cad+invertirCadena(cad)+cad);
            cola1.sacar();
        }
        return colaRes;
    }
    public static String invertirCadena(String cadena){
        StringBuilder res= new StringBuilder();
        for (int i = cadena.length()-1; i >= 0; i--) {
            res.append(cadena.charAt(i));
        }
        return res.toString();
    }
}
