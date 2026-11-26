package Universidad.ProgramacionConcurrente.hilos;

import Universidad.ProgramacionConcurrente.recursos.Venta;

import java.util.concurrent.Semaphore;

public class Pasajero extends Thread{
    private String nombre;
    private Venta compraTicket;

    //Subida al tren
    private Semaphore puertaSubida;
    private Semaphore trenLleno;

    //Recorrido y bajada
    private Semaphore finRecorrido;
    private Semaphore trenVacio;


    public Pasajero(String nombre, Venta compraTicket, Semaphore puertaSubida, Semaphore trenLleno, Semaphore finRecorrido, Semaphore trenVacio) {
        this.nombre = nombre;
        this.compraTicket = compraTicket;
        this.puertaSubida = puertaSubida;
        this.trenLleno = trenLleno;
        this.finRecorrido = finRecorrido;
        this.trenVacio = trenVacio;
    }

    public void run() {
        try {
            this.compraTicket.comprarBoleto(this.nombre);
        } catch (InterruptedException e) {
            System.out.println(this.nombre+" fue interrumpido al comprar un ticket");
        }
        try {
            this.puertaSubida.acquire();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
