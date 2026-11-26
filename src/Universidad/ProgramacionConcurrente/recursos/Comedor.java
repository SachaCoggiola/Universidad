package Universidad.ProgramacionConcurrente.recursos;

import java.util.concurrent.Semaphore;

public class Comedor {
    private int cantidadMaxima;
    private int especieActual; //perro = 1 : gato = 0
    private Semaphore mutex;
    private Semaphore comederos;
    private Semaphore[] listaEspera;
    private int comiendo;
    private int seguidos;
    private int[] esperando;

    public Comedor(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
        this.especieActual = -1;
        this.mutex = new Semaphore(1, true);
        this.comederos = new Semaphore(cantidadMaxima,true);
        this.listaEspera = new Semaphore[2];
        this.listaEspera[0] = new Semaphore(0,true);
        this.listaEspera[1] = new Semaphore(0,true);
        this.comiendo = 0;
        this.seguidos = 0;
        this.esperando = new int[]{0, 0};
    }

    public void esperar(String nombre, int especieAnimal) throws InterruptedException {
        this.mutex.acquire();
        if (this.especieActual == especieAnimal || this.especieActual == -1) {
            if (this.comiendo < this.cantidadMaxima) {
                try {
                    empezarComer(nombre, especieAnimal);
                } catch (Exception e) {
                    System.out.println("El animal: "+ nombre +" fue interrumpido al empezar a comer");
                }
            }else{
                this.esperando[especieAnimal]++;
                this.mutex.release();
                this.listaEspera[especieAnimal].acquire();
                empezarComer(nombre, especieAnimal);
            }
        } else {
            this.esperando[especieAnimal]++;
            this.mutex.release();
            this.listaEspera[especieAnimal].acquire();
            empezarComer(nombre, especieAnimal);
        }
    }

    public void empezarComer(String nombre, int especiaAnimal) throws InterruptedException {
        this.comederos.acquire();
        this.mutex.acquire();
        this.especieActual = especiaAnimal;
        this.comiendo++;
        this.seguidos++;
        this.esperando[especiaAnimal]--;
        this.mutex.release();
        System.out.println("El animal: " + nombre + " empezo a comer");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("El animal: "+nombre +" fue interrumpido al comer");
        }finally {
            try {
                terminarDeComer(nombre, especiaAnimal);
            }catch (Exception e){
                System.out.println("El animal: "+nombre +" fue interrumpido al terminar de comer");
            }
        }
    }

    public void terminarDeComer(String nombre, int especieAnimal) throws InterruptedException {
        this.comederos.release();
        System.out.println("El animal: " + nombre + " termino de comer");
        this.mutex.acquire();
        this.comiendo--;
        if(this.seguidos < this.cantidadMaxima && this.esperando[especieAnimal] > 0) {
            this.listaEspera[especieAnimal].release();
        }else if(this.comiendo == 0){
            this.seguidos = 0;
            this.especieActual = -1;
            if(this.esperando[1 - especieAnimal] > 0) {
                this.listaEspera[1 - especieAnimal].release();
            }
        }
        this.mutex.release();
    }
}

