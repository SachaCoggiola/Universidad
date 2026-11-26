package Universidad.ProgramacionConcurrente.hilos;

import Universidad.ProgramacionConcurrente.recursos.Venta;

import java.util.concurrent.Semaphore;

public class VendedorTickets extends Thread {
    private Venta ventaTickets;

    public VendedorTickets(Venta ventaTickets) {
        this.ventaTickets = ventaTickets;
    }

    public void run(){
        while(true){
            try {
                this.ventaTickets.generarBoleto();
            } catch (InterruptedException e) {
                System.out.println("El vendedor fue interrumpido al generar el ticket");
            }
        }
    }
}
