package Universidad.ProgramacionConcurrente.tests;

import Universidad.ProgramacionConcurrente.recursos.GestorPiscina;
import Universidad.ProgramacionConcurrente.runnables.Persona;

public class TestPiscina {
    public static void main(String[] args) {
        String[] nombres = {"Aries", "Beckram", "Cerberus", "Drutheim", "Ehm", "Faustus"};
        Persona[] personas = new Persona[nombres.length];
        Thread[] threads = new Thread[nombres.length];
        GestorPiscina gestor = new GestorPiscina(4);

        for (int i = 0; i < nombres.length; i++) {
            personas[i] = new Persona(nombres[i], gestor);
            threads[i] = new Thread(personas[i]);
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < nombres.length; i++) {
            threads[i].start();
        }
    }
}
