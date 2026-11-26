package Universidad.ProgramacionConcurrente.recursos;

import java.util.concurrent.Semaphore;

public class GestorPiscina {
    private Piscina piscina;
    private Semaphore capacidad;

    public GestorPiscina(int capacidad) {
        this.piscina = new Piscina(capacidad);
        this.capacidad = new Semaphore(capacidad, true);
    }

    public void entrar(String nombre) throws InterruptedException {
        this.capacidad.acquire();
        this.piscina.anunciarEntrada(nombre);
    }

    public void salir(String nombre) throws InterruptedException {
        this.capacidad.release();
        this.piscina.anunciarSalida(nombre);
    }
}
