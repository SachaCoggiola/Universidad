package Universidad.DesarrolloAlgoritmo.TDA;

public class Ingrediente {
    private String nombre;
    private double cantidad;
    private String unidad;
    //Constructores
    public Ingrediente(String nombre, double cantidad, String unidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }
    public Ingrediente(String nombre, String unidad) {
        this.nombre = nombre;
        this.unidad = unidad;
    }
    //Observadores
    public String getNombre() {
        return nombre;
    }
    public double getCantidad() {
        return cantidad;
    }
    public String getUnidad() {
        return unidad;
    }
    public String toString() {
        return nombre + "\t" + cantidad + "\t" + unidad;
    }
    //Modificadores
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
