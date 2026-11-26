package Universidad.ProgramacionConcurrente.runnables;

import Universidad.ProgramacionConcurrente.recursos.GestorPiscina;

public class Persona implements Runnable {
    private String nombre;
    private GestorPiscina gestorPiscina;

    public Persona(String nombre, GestorPiscina gestorPiscina) {
        this.nombre = nombre;
        this.gestorPiscina = gestorPiscina;
    }

    @Override
    public void run() {
        try{
            this.gestorPiscina.entrar(this.nombre);
            Thread.sleep(1000+(int)(Math.random()*1000));
        }catch (Exception e){
            System.out.println("La persona fue interrumpida al entrar");
        }finally {
            try {
                this.gestorPiscina.salir(this.nombre);
            }catch (Exception e){
                System.out.println("La persona fue interrumpida al salir");
            }
        }
    }
}
