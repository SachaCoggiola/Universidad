package Universidad.ProgramacionConcurrente.hilos;

public class Hilo extends Thread {
    public void run(){
        ir();
    }
    public void ir(){
        hacerMas();
    }
    public void hacerMas(){
        System.out.println("En la pila");
    }
}
