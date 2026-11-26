package Universidad.ProgramacionConcurrente.hilos;

import Universidad.ProgramacionConcurrente.recursos.CompraCliente;

public class CajeroThread extends Thread {
    private String nombre;
    private CompraCliente compraCliente;
    private long initialTime;

    public CajeroThread(String nombre, CompraCliente compraCliente, long initialTime) {
        this.nombre = nombre;
        this.compraCliente = compraCliente;
        this.initialTime = initialTime;
    }
    public void run() {
        System.out.println("El cajero " +this.nombre+ " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " +this.compraCliente.getNombre()+ " EN EL TIEMPO: " +(System.currentTimeMillis()-this.initialTime)/1000+ "seg");
        for (int i = 0; i < this.compraCliente.getTamanio(); i++) {
            esperarXsegundos(compraCliente.getProducto(i));
            System.out.println("Procesado el producto " +(i+1)+ " del cliente " +this.compraCliente.getNombre()+ " -> Tiempo: " +(System.currentTimeMillis()-this.initialTime)/1000+ "seg");
        }
        System.out.println("El cajero " +this.nombre+ " HA TERMINADO DE PROCESAR " +this.compraCliente.getNombre()+ " EN EL TIEMPO: " +(System.currentTimeMillis()-this.initialTime)/1000+ "seg");
    }
    private void esperarXsegundos(int seg){
        try {
            Thread.sleep(seg*1000L);
        } catch (InterruptedException e) {
            System.out.println("Error al esperar el segundos");
        }
    }
}
