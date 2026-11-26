package Universidad.ProgramacionConcurrente.runnables;

import Universidad.ProgramacionConcurrente.recursos.CompraCliente;

public class Cajero {
    private String nombre;

    public Cajero(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void procesarCompra(CompraCliente compra, long timeStamp){
        System.out.println("El cajero "+this.nombre+ "Comienza a procesar la compra del cliente " +compra.getNombre()+ " en el tiempo: " +(System.currentTimeMillis()-timeStamp)/1000+ " seg");
        for(int i = 0; i < compra.getTamanio(); i++){
            esperarXsegundos(compra.getProducto(i));
            System.out.println("Procesando el producto " +(i+1)+ " -> tiempo: " +(System.currentTimeMillis()-timeStamp)/1000+ " seg");
        }
        System.out.println("El cajero "+this.nombre+ "ha terminado de procesar " +compra.getNombre()+ " en el tiempo: " +(System.currentTimeMillis()-timeStamp)/1000+ " seg");
    }

    private void esperarXsegundos(int seg){
        try {
            Thread.sleep(seg*1000L);
        } catch (InterruptedException e) {
            System.out.println("Error al esperar el segundos");
        }
    }
}
