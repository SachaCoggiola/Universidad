package Universidad.ProgramacionConcurrente.recursos;

public class Recurso {
    public Recurso() {}
    public void uso() {
        Thread t = Thread.currentThread();
        System.out.println("En Recurso: Soy " + t.getName());
    }
}
