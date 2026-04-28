package Universidad.EstructuraDatos.TDA;

public class Domicilio {
    private String calle;
    private int numero;
    private String ciudad;
    public Domicilio(String calle, int numero, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }
    public String getCalle() {
        return this.calle;
    }
    public int getNumero() {
        return this.numero;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    public String toString(){
        return "Calle: "+this.calle+"  N°: "+this.numero+" Ciudad: "+this.ciudad+".";
    }
    public boolean equals(Domicilio other){
        return this.calle.equals(other.getCalle())&&this.numero==other.getNumero()&&this.ciudad.equals(other.getCiudad());
    }
}
