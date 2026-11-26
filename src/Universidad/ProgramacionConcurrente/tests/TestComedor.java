package Universidad.ProgramacionConcurrente.tests;

import Universidad.ProgramacionConcurrente.recursos.Comedor;
import Universidad.ProgramacionConcurrente.runnables.Animal;

import java.util.Scanner;

public class TestComedor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Animal[] gatos = new Animal[5];
        Animal[] perros = new Animal[5];
        Thread[] hilos = new Thread[10];
        Comedor comedero = new Comedor(2);
        for(int i = 0; i < gatos.length; i++){
            System.out.println("Ingresar nombre del gato N°"+(i+1));
            gatos[i] = new Animal(sc.nextLine(), comedero,"gato");
            hilos[i] = new Thread(gatos[i]);
        }
        for(int i = 0; i < perros.length; i++){
            System.out.println("Ingresar nombre del perro N°:"+(i+1));
            perros[i] = new Animal(sc.nextLine(), comedero,"perro");
            hilos[i+5] = new Thread(perros[i]);
        }
        for (Thread hilo : hilos) {
            hilo.start();
        }
    }
}
