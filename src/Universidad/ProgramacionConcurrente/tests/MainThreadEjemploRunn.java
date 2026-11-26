package Universidad.ProgramacionConcurrente.tests;

import Universidad.ProgramacionConcurrente.hilos.ThreadEjemploRunn;

public class MainThreadEjemploRunn {
    public static void main(String[] args) {
        ThreadEjemploRunn mariaJose = new ThreadEjemploRunn("Maria Jose");
        ThreadEjemploRunn joseMaria = new ThreadEjemploRunn("Jose Maria");
        Thread mariaJ = new Thread(mariaJose);
        Thread joseM = new Thread(joseMaria);
        mariaJ.start();
        joseM.start();
        System.out.println("Termina thread main");
    }
}
