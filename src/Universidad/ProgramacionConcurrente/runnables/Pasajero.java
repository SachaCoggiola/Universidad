package Universidad.ProgramacionConcurrente.runnables;

import Universidad.ProgramacionConcurrente.recursos.Colectivo;

import java.util.concurrent.Semaphore;

public class Pasajero implements Runnable {
    private Colectivo colectivo;
    Semaphore habilitarSubida;
    Semaphore habilitarBajada;
    Semaphore pasajeroSubio;
    Semaphore pasajeroBajo;
    Semaphore esperandoSubir;
    Semaphore esperandoBajar;


    public Pasajero(Colectivo colectivo, Semaphore habSubida, Semaphore habBajada, Semaphore pasajeroSubio, Semaphore pasajeroBajo, Semaphore espSubir, Semaphore espBajar) {
        this.colectivo = colectivo;
        this.habilitarSubida = habSubida;
        this.habilitarBajada = habBajada;
        this.pasajeroSubio = pasajeroSubio;
        this.pasajeroBajo = pasajeroBajo;
        this.esperandoSubir = espSubir;
        this.esperandoBajar = espBajar;
    }

    public void run() {
        this.esperandoSubir.release();
        subir();
        this.esperandoBajar.release();
        bajar();
    }
    public void subir(){
        try {
            this.habilitarSubida.acquire();
            this.colectivo.subirPasajero();
            this.pasajeroSubio.release();
            System.out.println(Thread.currentThread().getName()+" subio");
        } catch (InterruptedException e) {
            System.out.println("No hay lugar para el pasajero: "+Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
    public void bajar(){
        try {
            this.habilitarBajada.acquire();
            this.colectivo.bajarPasajero();
            this.pasajeroBajo.release();
            System.out.println(Thread.currentThread().getName()+" bajo");
        } catch (InterruptedException e) {
            System.out.println("No hay lugar para el pasajero: "+Thread.currentThread().getName());
        }
    }

}
