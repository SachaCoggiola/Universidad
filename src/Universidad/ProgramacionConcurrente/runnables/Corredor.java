package Universidad.ProgramacionConcurrente.runnables;

public class Corredor implements Runnable {
    private String nombre;
    private int distancia;
    public Corredor(String nombre){
        this.nombre = nombre;
        this.distancia = 0;
    }
    public int getDistancia(){
        return distancia;
    }
    public String getNombre(){
        return nombre;
    }
    private int avanzar(){
        int avance = (int)(Math.random()*10+1);
        this.distancia += avance;
        return avance;
    }
    public void run(){
        for(int i = 0; i < 100; i++){
            System.out.println("Corredor: " + this.nombre + " distancia avanzada: " + avanzar());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Corredor: " + this.nombre + " interrumpido");
            }
        }
        System.out.println("Corredor: " + this.nombre + " ha finalizado la carrera");
    }
}
