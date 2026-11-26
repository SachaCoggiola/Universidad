package Universidad.ProgramacionConcurrente.tests;

import Universidad.ProgramacionConcurrente.hilos.Cliente;
import Universidad.ProgramacionConcurrente.recursos.Recurso;

public class TesteoRecurso {
    public static void main(String[] args) {
        Recurso unRecurso = new Recurso();
        Cliente juan = new Cliente(unRecurso);
        juan.setName("Juan Lopez");
        Cliente ines = new Cliente(unRecurso);
        ines.setName("Ines Garcia");
        ines.start();
        juan.start();
    }
}
