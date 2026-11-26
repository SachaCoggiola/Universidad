package Universidad.ProgramacionConcurrente.tests;

import Universidad.ProgramacionConcurrente.recursos.Pizarron;
import Universidad.ProgramacionConcurrente.runnables.UsuarioPizarron;

public class TestPizarron {
    public static void main(String[] args) {
        Pizarron p = new Pizarron();
        UsuarioPizarron usuario1 = new UsuarioPizarron(p);
        UsuarioPizarron usuario2 = new UsuarioPizarron(p);
        UsuarioPizarron usuario3 = new UsuarioPizarron(p);
        Thread t1 = new Thread(usuario1);
        t1.setName("Usuario 1");
        Thread t2 = new Thread(usuario2);
        t2.setName("Usuario 2");
        Thread t3 = new Thread(usuario3);
        t3.setName("Usuario 3");
        t1.start();
        t2.start();
        t3.start();
    }
}
