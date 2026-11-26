package Universidad.ProgramacionConcurrente.recursos;

import java.util.concurrent.Semaphore;

public class Venta {
    private Semaphore pedirTicket;
    private Semaphore ticketListo;
    private Semaphore mutexPasajeros;
    //Naira te quierooooooo, naoo yo te quiero massssssssssssssssssssssssssssssssssssssssssssssssss
    //sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
    //sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
    //sacha te quieroooooo, yo te quiero

    public Venta() {
        this.pedirTicket = new Semaphore(0, true);
        this.ticketListo = new Semaphore(0, true);
        this.mutexPasajeros = new Semaphore(1,true);
    }

    public void comprarBoleto(String nombre) throws InterruptedException {
        this.mutexPasajeros.acquire();  //Asegura que solo un pasajero pueda comprar el ticket a la vez
        this.pedirTicket.release();
        System.out.println(nombre+ " pide un ticket");
        this.ticketListo.acquire();
        this.mutexPasajeros.release();
    }

    public void generarBoleto() throws InterruptedException {
        this.pedirTicket.acquire();
        System.out.println("Generando ticket");
        this.ticketListo.release();
    }
}
