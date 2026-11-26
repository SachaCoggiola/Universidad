package Universidad.ProgramacionConcurrente.runnables;

import Universidad.ProgramacionConcurrente.recursos.Pizarron;

import static java.lang.Thread.sleep;

public class UsuarioPizarron implements Runnable {
    private Pizarron pizarron;
    boolean tengoControl;

    public UsuarioPizarron(Pizarron pizarron) {
        this.pizarron = pizarron;
        tengoControl = false;
    }

    @Override
    public void run() {
        try {
            this.pizarron.tomarControl();
            this.tengoControl = true;
            trabajarEnPizarron();
        } catch (InterruptedException e) {
            System.out.println("Pizarron interrumpido al tomar el control");
        } finally {
            if(this.tengoControl){
                try {
                    this.pizarron.liberarControl();
                } catch (InterruptedException e) {
                    System.out.println("Pizarron interrumpido al liberar el control");
                }
                this.tengoControl = false;
            }
        }
    }
    private void trabajarEnPizarron(){
        System.out.println("El usuario: "+Thread.currentThread().getName()+" esta trabajando en el pizarron.");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Usuario interrumpido trabajando en el pizarron.");
        }
        System.out.println("El usuario: "+Thread.currentThread().getName()+" ha terminado de trabajar en el pizarron.");
    }
}
