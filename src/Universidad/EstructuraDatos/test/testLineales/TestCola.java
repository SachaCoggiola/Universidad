package Universidad.EstructuraDatos.test.testLineales;

import Universidad.EstructuraDatos.lineal.dinamico.Cola;

import java.util.Scanner;

public class TestCola {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Scanner sc = new Scanner(System.in);
        cola.poner(40);
        cola.poner(30);
        cola.poner(20);
        cola.poner(10);
        System.out.println(cola.toString());
    }
    public static void llenarCola(Cola unaCola, Scanner sc){
        int num;
        boolean bandera = true;
        while(bandera){
            System.out.println("Ingrese el valor a poner en la cola: ");
            num = sc.nextInt();
            sc.nextLine();
            bandera = unaCola.poner(num);
            if(bandera){
                System.out.println("Desea agregar otro valor?. Ingrese si o no.");
            }else{
                System.out.println("No se ha podido cargar el valor a la cola.");
            }
            bandera = sc.nextLine().equalsIgnoreCase("si");
        }
    }
}
