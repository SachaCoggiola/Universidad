package Universidad.ProgramacionConcurrente.tests;

import Universidad.ProgramacionConcurrente.runnables.CajeroRunn;
import Universidad.ProgramacionConcurrente.recursos.CompraCliente;

public class TesteoCajero {
    public static void main(String[] args) {
        CompraCliente cliente1 = new CompraCliente("CompraCliente1", 6);
        cliente1.setProductos(new int[] {2,2,1,5,2,3});
        CompraCliente cliente2 = new CompraCliente("CompraCliente2", 5);
        cliente2.setProductos(new int[] {1,3,5,1,1});

        long initialTime = System.currentTimeMillis();

        /*Cajero cajero1 = new Cajero("Cajero1");
        cajero1.procesarCompra(cliente1, initialTime);
        cajero1.procesarCompra(cliente2, initialTime);
         */
        /*CajeroThread cajero1 = new CajeroThread("Cajero1",cliente1,initialTime);
        CajeroThread cajero2 = new CajeroThread("Cajero2",cliente2,initialTime);
        cajero1.start();
        cajero2.start();
         */
        CajeroRunn cajero1 = new CajeroRunn(cliente1, initialTime);
        CajeroRunn cajero2 = new CajeroRunn(cliente2, initialTime);
        Thread thread1 = new Thread(cajero1);
        Thread thread2 = new Thread(cajero2);
        thread1.start();
        thread2.start();
    }
}
