package Universidad.ProgramacionConcurrente.tests;

import Universidad.ProgramacionConcurrente.hilos.ThreadEjemplo;

public class MainThreadEjemplo {
    public static void main(String[] args) {
        new ThreadEjemplo("Maria jose").start();
        new ThreadEjemplo("Jose Maria").start();
        System.out.println("Termina thread main");
    }
}
