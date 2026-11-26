package Universidad.ProgramacionConcurrente.tests;

import Universidad.ProgramacionConcurrente.runnables.Colectivero;
import Universidad.ProgramacionConcurrente.recursos.Colectivo;
import Universidad.ProgramacionConcurrente.runnables.Pasajero;
import Universidad.ProgramacionConcurrente.recursos.Recorrido;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class TestColectivo {
    public static void main(String[] args) {
        Colectivo cole;
        Recorrido recorrido;
        int aux;
        Pasajero[] pasajeros = new Pasajero[5];
        Thread[] threads = new Thread[5];
        Semaphore habilitarSubida = new Semaphore(0);
        Semaphore habilitarBajada = new Semaphore(0);
        Semaphore pasajeroSubio = new Semaphore(0);
        Semaphore pasajeroBajo = new Semaphore(0);
        Semaphore esperandoSubir = new Semaphore(0);
        Semaphore esperandoBajar = new Semaphore(0);

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de recorridos que realizara el colectivero");
        aux = sc.nextInt();
        recorrido = new Recorrido(aux);

        System.out.println("Ingrese la cantidad de asientos que tiene el colectivo: ");
        aux = sc.nextInt();
        cole = new Colectivo(aux);

        Colectivero chofer = new Colectivero(recorrido, cole, habilitarSubida, habilitarBajada, pasajeroSubio, pasajeroBajo, esperandoSubir, esperandoBajar);
        Thread threadChofer = new Thread(chofer);

        for (int i = 0; i < pasajeros.length; i++) {
            pasajeros[i] = new Pasajero(cole, habilitarSubida, habilitarBajada, pasajeroSubio, pasajeroBajo, esperandoSubir, esperandoBajar);
            threads[i] = new Thread(pasajeros[i]);
            threads[i].setName("Pasajero " + i);
            threads[i].start();
        }
        threadChofer.start();
        try {
            threadChofer.join();
        } catch (InterruptedException e) {
            System.out.println("Error en el main");
        }
        for(int i = 0; i < pasajeros.length; i++) {
            threads[i].interrupt();
        }
    }
}
