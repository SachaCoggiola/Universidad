package Universidad.DesarrolloAlgoritmo.TDA;

public class Mascota {
    private int codigo;
    private String nombre;
    private double peso;
    private int edad;
    //Constructores
    public Mascota(int codigo, String nombre, double peso, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
    }
    public Mascota(int codigo){
        this.codigo = codigo;
    }
    //Observadores
    public int getCodigo() {return codigo;}
    public String getNombre() {return nombre;}
    public double getPeso() {return peso;}
    public int getEdad() {return edad;}
    public String toString(){return "Mascota{"+codigo+","+nombre+","+peso+","+edad+'}';}
    public boolean equals(Mascota mascota){return this.codigo == mascota.codigo;}
    //Modificadores
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setPeso(double peso) {this.peso = peso;}
    public void setEdad(int edad) {this.edad = edad;}
}
