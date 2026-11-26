package Universidad.ProgramacionConcurrente.runnables;

import Universidad.ProgramacionConcurrente.recursos.Colectivo;
import Universidad.ProgramacionConcurrente.recursos.Recorrido;

import java.util.concurrent.Semaphore;

public class Colectivero implements Runnable {
    private Recorrido recorrido;
    private Colectivo colectivo;
    Semaphore permisoSubir;
    Semaphore permisoBajar;
    Semaphore pasajeroSubio;
    Semaphore pasajeroBajo;
    Semaphore esperandoSubir;
    Semaphore esperandoBajar;


    public Colectivero(Recorrido recorrido, Colectivo cole, Semaphore habSubida, Semaphore habBajada, Semaphore pasajeroSubio, Semaphore pasajeroBajo, Semaphore espSubir, Semaphore espBajar) {
        this.recorrido = recorrido;
        this.colectivo = cole;
        this.permisoSubir = habSubida;
        this.permisoBajar = habBajada;
        this.pasajeroSubio = pasajeroSubio;
        this.pasajeroBajo = pasajeroBajo;
        this.esperandoSubir = espSubir;
        this.esperandoBajar = espBajar;
    }

    public void run() {
        for(int i = 0; i < this.recorrido.getCantR(); i++) {
            this.recorrido.salida();
            System.out.println("!!COMENZO EL RECORRIDO!!");
            this.colectivo.habilitarPuertaDelantera();
            habilitarSubida();
            this.colectivo.deshabilitarPuertaDelantera();
            this.recorrido.movimiento();
            System.out.println("Cantidad de pasajeros: " + this.colectivo.getCantPasajeros());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Chofer interrumpido");
            }
            this.recorrido.llegada();
            System.out.println("!!TERMINADO EL RECORRIDO!!");
            this.colectivo.habilitarPuertaTrasera();
            habilitarBajada();
            this.colectivo.deshabilitarPuertaTrasera();
            System.out.println("Cantidad de pasajeros: " + this.colectivo.getCantPasajeros());
            System.out.println("|VOLVIENDO A LA PARADA INICIAL|");
            this.recorrido.movimiento();
            System.out.println("|LLEGADO A LA PARADA INICIAL|");
        }
    }

    public void habilitarSubida() {
        while(this.colectivo.hayLugar()&&this.esperandoSubir.tryAcquire()) {
            this.permisoSubir.release();
            try {
                this.pasajeroSubio.acquire();
            } catch (InterruptedException e) {
                System.out.println("Chofer interrumpido en subida");
            }
        }
    }
    public void habilitarBajada() {
        while(this.esperandoBajar.tryAcquire()) {
            this.permisoBajar.release();
            try {
                this.pasajeroBajo.acquire();
            } catch (InterruptedException e) {
                System.out.println("Chofer interrumpido en bajada");
            }
        }
    }
}
