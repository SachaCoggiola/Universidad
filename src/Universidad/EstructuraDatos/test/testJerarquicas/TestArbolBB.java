package Universidad.EstructuraDatos.test.testJerarquicas;

import Universidad.EstructuraDatos.jerarquicas.dinamicas.ArbolBB;

import java.util.Scanner;

public class TestArbolBB {
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB();
        cargarArbol(arbol);
        System.out.println(arbol.listar().toString());
        arbol.eliminarMinimo();
        System.out.println(arbol.listar().toString());

    }
    public static void cargarArbol(ArbolBB arbol) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese el elemento a insertar: ");
            int elemento = sc.nextInt();
            sc.nextLine();
            arbol.insertar(elemento);
            System.out.println("Desea insertar más elementos. Ingrese y o n.");
        }while(sc.nextLine().equals("y"));
    }
}
