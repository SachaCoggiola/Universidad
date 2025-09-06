package Universidad.DesarrolloAlgoritmo.TDA;

public class Terreno {
    //Atributos
    private int codigo;
    private double base;
    private double altura;
    private int manzana;
    //Constructores
    public Terreno(int unCodigo){
        this.codigo = unCodigo;
        this.base = 0;
        this.altura = 0;
        this.manzana = 0;
    }
    public Terreno(int unCodigo, double base, double altura, int manzana){
        this.codigo = unCodigo;
        this.base = base;
        this.altura = altura;
        this.manzana = manzana;
    }
    //Observadores
    public int getCodigo() {
        return codigo;
    }
    public double getBase() {
        return base;
    }
    public double getAltura() {
        return altura;
    }
    public int getManzana() {
        return manzana;
    }
    public String toString(){
        return "Terreno{" +
                "codigo=" + codigo +
                ", base=" + base +
                ", altura=" + altura +
                ", manzana=" + manzana +
                '}';
    }
    public boolean equals(Terreno unTerreno){
        return this.codigo == unTerreno.codigo;
    }
    //Modificadores
    public void setBase(double base){
        this.base = base;
    }
    public void setAltura(double altura){
        this.altura = altura;
    }
    public void setManzana(int manzana){
        this.manzana = manzana;
    }
    //Propias del Tipo
    public double perimetro(){
        return 2*(base+altura);
    }
    public double superficie(){
        return base*altura;
    }
    public double valorM2(double precio){
        return superficie()*precio;
    }
}
