package Universidad.ProgramacionConcurrente.tests;

import Universidad.ProgramacionConcurrente.hilos.ControlTren;
import Universidad.ProgramacionConcurrente.hilos.Pasajero;
import Universidad.ProgramacionConcurrente.hilos.VendedorTickets;
import Universidad.ProgramacionConcurrente.recursos.Venta;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class TestTren {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacidadTren = 5, pasajerosSubidos = 0, pasajerosBajados = 0;
        Semaphore mutex = new Semaphore(1, true);

        //Venta de tickets
        Venta venta = new Venta();

        //Subida al tren
        Semaphore puertaSubida = new Semaphore(0, true);
        Semaphore trenLleno = new Semaphore(0, true);

        //Recorrido y bajada
        Semaphore finRecorrido = new Semaphore(0, true);
        Semaphore trenVacio = new Semaphore(0, true);

        VendedorTickets vendedor = new VendedorTickets(venta);
        ControlTren control = new ControlTren();
        Pasajero[] pasajeros = new Pasajero[10];
        for (int i = 0; i < 10; i++) {
            pasajeros[i] = new Pasajero(sc.nextLine(), venta, puertaSubida, trenLleno, finRecorrido, trenVacio);
        }

    }
}
