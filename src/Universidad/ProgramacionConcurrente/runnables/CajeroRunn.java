package Universidad.ProgramacionConcurrente.runnables;

import Universidad.ProgramacionConcurrente.recursos.CompraCliente;

public class CajeroRunn implements Runnable {
    private int distancia;
    private CompraCliente compraCliente;
    private long initialTime;
    public CajeroRunn(CompraCliente compraCliente, long initialTime) {
        this.compraCliente = compraCliente;
        this.initialTime = initialTime;
        this.distancia = 0;
    }
    @Override
    public void run() {
        System.out.println("El cajero " +Thread.currentThread().getName()+ " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " +this.compraCliente.getNombre()+ " EN EL TIEMPO: " +(System.currentTimeMillis()-this.initialTime)/1000+ "seg");
        for (int i = 0; i < this.compraCliente.getTamanio(); i++) {
            esperarXsegundos(compraCliente.getProducto(i));
            System.out.println("Procesado el producto " +(i+1)+ " del cliente " +this.compraCliente.getNombre()+ " -> Tiempo: " +(System.currentTimeMillis()-this.initialTime)/1000+ "seg");
        }
        System.out.println("El cajero " +Thread.currentThread().getName()+ " HA TERMINADO DE PROCESAR " +this.compraCliente.getNombre()+ " EN EL TIEMPO: " +(System.currentTimeMillis()-this.initialTime)/1000+ "seg");
    }
    private void esperarXsegundos(int seg){
        try {
            Thread.sleep(seg*1000L);
        } catch (InterruptedException e) {
            System.out.println("Error al esperar el segundos");
        }
    }
}
