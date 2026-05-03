package Universidad.EstructuraDatos.test.testJerarquicas;

import Universidad.EstructuraDatos.jerarquicas.dinamicas.ArbolBinario;
import Universidad.EstructuraDatos.lineal.dinamico.Lista;

import java.util.Scanner;

public class TestArbol {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Lista lista = new Lista();
        cargarLista(lista);
        cargarVarios(arbol);
        System.out.println(lista.toString());
        System.out.println(arbol.listarPreorden().toString());
        /*System.out.println(arbol.frontera().toString());
        System.out.println(arbol.obtenerAncestros('E').toString());
        System.out.println(arbol.obtenerDescendientes('B').toString());
        */
        if(arbol.verificarPatron(lista)){
            System.out.println("Patron encontrado");
        }else {
            System.out.println("Patron no encontrado");
        }
    }
    public static void cargarLista(Lista lista) {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        do {
            System.out.println("Ingrese el elemento N°" + i);
            lista.insertar(sc.nextLine().charAt(0), i);
            i++;
            System.out.println("Desea ingresar otro elemento?. Ingrese si o no");
        }while(sc.nextLine().equals("si"));
    }
    public static void cargarVarios(ArbolBinario arbol) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese cuantos elementos desea cargar: ");
        int i = sc.nextInt();
        while (i > 0) {
            cargarArbol(arbol);
            i--;
        }
    }
    public static boolean cargarArbol(ArbolBinario arbol) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el elemento a cargar: ");
        char elem = sc.nextLine().charAt(0);
        System.out.println("Ingrese el elemento del padre del elemento a cargar: ");
        char padre = sc.nextLine().charAt(0);
        System.out.println("Ingrese la posicion donde quiera cargar el elemento: ");
        char pos = sc.nextLine().charAt(0);
        return arbol.insertar(elem,padre,pos);
    }
}
