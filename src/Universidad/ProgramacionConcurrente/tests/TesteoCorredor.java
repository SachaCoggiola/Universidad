package Universidad.ProgramacionConcurrente.tests;

import Universidad.ProgramacionConcurrente.runnables.Corredor;

public class TesteoCorredor {
    public static void main(String[] args) {
        Corredor[] corredores = new Corredor[100];
        Thread[] threads = new Thread[100];
        Corredor ganador;
        int aux;
        for (int i = 0; i < 100; i++) {
            corredores[i] = new Corredor("Corredor #"+(i+1));
            threads[i] = new Thread(corredores[i]);
            threads[i].start();
        }
        for (int i = 0; i < 100; i++) {
            try{
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("El hilo principal fue interrumpido");
            }
        }
        ganador = corredores[0];
        for (int i = 0; i < 100; i++) {
            aux = corredores[i].getDistancia();
            if(ganador.getDistancia() < aux){
                ganador = corredores[i];
            }
        }
        System.out.println("El corredor con mayor distancia recorrida es: "+ganador.getNombre()+", con un total de "+ganador.getDistancia()+" unidades recorridas.");
    }
}
