package Universidad.ProgramacionConcurrente.runnables;

import Universidad.ProgramacionConcurrente.recursos.Comedor;

public class Animal implements Runnable {
    private String nombre;
    private Comedor comedero;
    private int tipoAnimal;

    public Animal(String nombre, Comedor comedero, String tipoAnimal) {
        this.nombre = nombre;
        this.comedero = comedero;
        if(tipoAnimal.equalsIgnoreCase("perro")){
            this.tipoAnimal = 1;
        }else{
            this.tipoAnimal = 0;
        }
    }

    public void setComedero(Comedor comedero) {
        this.comedero = comedero;
    }

    public void run() {
        try {
            this.comedero.esperar(this.nombre, this.tipoAnimal);
        } catch (InterruptedException e) {
            System.out.println("El animal fue interrumpido al entrar a la lista de espera");
        }
    }
}
