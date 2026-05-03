package Universidad.EstructuraDatos.test.testLineales;

import Universidad.EstructuraDatos.lineal.dinamico.Lista;

import java.util.Scanner;
public class TestLista {
    public static void main(String[] args) {
        Lista lista = new Lista();
        cargarVarios(lista);
        System.out.println(lista.toString());
        System.out.println(lista.obtenerMutiplo(3).toString());
        lista.eliminarApariciones('A');
        System.out.println(lista.toString());
    }
    public static void cargarVarios(Lista lista){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos que desea cargar: ");
        int cantidad = sc.nextInt();
        for(int i = 0; i < cantidad; i++){
            cargarLista(lista);
        }
    }
    public static boolean cargarLista(Lista lista){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el elemento a cargar: ");
        char elem = sc.next().charAt(0);
        System.out.println("Ingrese la posicion donde quiere cargar el elemento: ");
        int posicion = sc.nextInt();
        return lista.insertar(elem, posicion);
    }
}
