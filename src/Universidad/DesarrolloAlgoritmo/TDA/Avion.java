package Universidad.DesarrolloAlgoritmo.TDA;

public class Avion {
    private String idAvion;
    private String modelo;
    private int cantAsiento;
    private int kmRecorrido;
    private double velocidadPromedio;
    public Avion(String idAvion, String modelo, int cantAsiento, int kmRecorrido, double velocidadPromedio){
        this.idAvion = idAvion;
        this.modelo = modelo;
        this.cantAsiento = cantAsiento;
        this.kmRecorrido = kmRecorrido;
        this.velocidadPromedio = velocidadPromedio;
    }
    public String getIdAvion() {
        return idAvion;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getCantAsiento() {
        return cantAsiento;
    }
    public void setCantAsiento(int cantAsiento) {
        this.cantAsiento = cantAsiento;
    }
    public int getKmRecorrido() {
        return kmRecorrido;
    }
    public void setKmRecorrido(int kmRecorrido) {
        this.kmRecorrido = kmRecorrido;
    }
    public double getVelocidadPromedio() {
        return velocidadPromedio;
    }
    public void setVelocidadPromedio(double velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }
    public String toString(){
        return "Identificador: "+idAvion+", Modelo: "+modelo+"Cantidad de Asientos: "+cantAsiento+", Kilometros Recorridos: "+kmRecorrido+", Velocidad Promedio: "+velocidadPromedio;
    }
    public void aumentarKmRecorrido(int km){
        this.kmRecorrido += km;
    }
}
