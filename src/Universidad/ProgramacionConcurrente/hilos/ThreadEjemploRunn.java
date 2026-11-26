package Universidad.ProgramacionConcurrente.hilos;
public class ThreadEjemploRunn implements Runnable {
    private String nombre;
    public ThreadEjemploRunn(String str) {
        this.nombre = str;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(i+" "+nombre);
        }
        System.out.println("Termina thread "+nombre);
    }
}
