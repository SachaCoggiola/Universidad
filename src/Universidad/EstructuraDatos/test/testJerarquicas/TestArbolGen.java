package Universidad.EstructuraDatos.test.testJerarquicas;

import Universidad.EstructuraDatos.jerarquicas.dinamicas.ArbolGen;

import java.util.Scanner;

public class TestArbolGen {
    public static void main(String[] args) {
        ArbolGen arbol = new ArbolGen();
        cargarArbol(arbol);
        System.out.println(arbol.toString());
        System.out.println(arbol.listarEntreNiveles(1,1).toString());
    }
    public static void cargarArbol(ArbolGen arbol) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int hijo;
        int padre;
        while (flag) {
            System.out.println("Ingrese el elemento a cargar:");
            hijo = sc.nextInt();
            System.out.println("Ingrese el elemento padre:");
            padre = sc.nextInt();
            arbol.insertar(hijo, padre);
            sc.nextLine();
            System.out.println("Desea seguir insertando elementos?. Responda y o n");
            flag = sc.nextLine().equals("y");
            System.out.println("hola");
        }
    }

}
