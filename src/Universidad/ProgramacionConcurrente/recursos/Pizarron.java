package Universidad.ProgramacionConcurrente.recursos;

public class Pizarron {
    private boolean ocupada;
    public Pizarron() {
        ocupada = false;
    }
    public synchronized void tomarControl() throws InterruptedException {
        while(this.ocupada){
            wait();
        }

        this.ocupada = true;

        System.out.println("El usuario: "+Thread.currentThread().getName()+" toma control de la pizarra.");
    }
    public synchronized void liberarControl() throws InterruptedException {
        this.ocupada = false;
        System.out.println("El usuario: "+Thread.currentThread().getName()+" libera la pizarra.");
        notifyAll();
    }
}
