package Universidad.EstructuraDatos.TDA;

import Universidad.EstructuraDatos.lineal.dinamico.Cola;
import Universidad.EstructuraDatos.lineal.dinamico.Pila;

public class Matematica {
    public boolean verificarBalanceo(Cola cola){
        Cola colaAux = cola.clone();
        Pila balance = new Pila();
        char caracter;
        boolean flag = true;
        while(!colaAux.esVacia()&&flag){
            caracter = (char)colaAux.obtenerFrente();
            switch (caracter){
                case ('{'),('['),('('):
                    balance.apilar(caracter);
                    break;
                case ('}'):
                    if(balance.esVacia()||(char)balance.obtenerTope()=='{'){
                        balance.desapilar();
                    }else{
                        flag = false;
                    }
                    break;
                case (']'):
                    if(balance.esVacia()||(char)balance.obtenerTope()=='['){
                        balance.desapilar();
                    }else{
                        flag = false;
                    }
                    break;
                case (')'):
                    if(balance.esVacia()||(char)balance.obtenerTope()=='('){
                        balance.desapilar();
                    }else{
                        flag = false;
                    }
                    break;
                default:
                    break;
            }
            colaAux.sacar();
        }
        return balance.esVacia();
    }
}
