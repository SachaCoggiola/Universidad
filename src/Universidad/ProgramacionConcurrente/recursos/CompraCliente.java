package Universidad.ProgramacionConcurrente.recursos;

public class CompraCliente {
    private String nombre;
    private int[] productos;
    private int tamanio;
    public CompraCliente(String nombre, int tamanio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.productos = new int[tamanio];
    }

    public String getNombre() {
        return nombre;
    }
    public int getTamanio(){
        return tamanio;
    }
    public int getProducto(int i) {
        return this.productos[i];
    }
    public void setProducto(int i, int producto) {
        this.productos[i] = producto;
    }
    public void setProductos(int[] productos) {
        for (int i = 0; i < productos.length; i++) {
            this.productos[i] = productos[i];
        }
    }
}
