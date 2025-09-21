package Universidad.DesarrolloAlgoritmo.TDA;
import java.time.LocalDate;

public class Mascota {
    private String tipo;
    private String nombre; //final?
    private double peso;
    private Fecha fechaNacimiento;
    //Constructores
    public Mascota(String nombre, String tipo, double peso, int day, int month, int year) {
        this.nombre = nombre;
        if(!"PERRO, GATO, TORTUGA, CONEJO".contains(tipo.toUpperCase())){
            throw new IllegalArgumentException("Especie de mascota invalida");
        }
        this.tipo = tipo.toUpperCase();
        if(peso<0){
            throw new IllegalArgumentException("Peso invalido");
        }
        this.peso = peso;
        LocalDate actual = LocalDate.now();
        if(year> actual.getYear()){
            throw new IllegalArgumentException("El año de nacimiento no puede ser mayor al año de la fecha actual");
        }
        if(month > actual.getMonthValue()&&year==actual.getYear()){
            throw new RuntimeException("El mes de nacimiento no puede ser mayor al mes de la fecha actual");
        }
        if(day > actual.getDayOfMonth()&&year==actual.getYear()&&month==actual.getMonthValue()){
            throw new RuntimeException("El día de nacimiento no puede ser mayor al día de la fecha actual");
        }
        this.fechaNacimiento = new Fecha(day, month, year);
    }
    public Mascota(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
    }
    //Observadores
    public String getNombre() {
        return nombre;}
    public String getTipo() {
        return tipo;}
    public double getPeso() {
        return peso;}
    public Fecha getFechaNacimiento() {
        return fechaNacimiento;}
    public String toString(){return "Mascota: "+nombre+", "+tipo+", tiene un peso en Kilogramos de "+peso+", y una fecha de nacimiento "+fechaNacimiento.getDay()+
            "/"+fechaNacimiento.getMonth()+"/"+fechaNacimiento.getYear();}
    public boolean equals(Mascota mascota){
        return this.nombre.equals(mascota.getNombre());
    }
    //Modificadores
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setFechaNacimiento(int day, int month, int year) {
        this.fechaNacimiento = new Fecha(day, month, year);
    }
    public int calcularEdad(){
        return this.fechaNacimiento.calcularEdad();
    }
    public int calcularDosaje(){
        int dosis=0;
        int edad = calcularEdad(); // Se utiliza la edad como condición para los calculos de la dosis de remedios
        switch(this.tipo){
            case "PERRO":
                if(this.peso<5){ // Si el perro pesa menos de 5kg la dosis es de 100mg
                    dosis=100;
                } else if (this.peso>=5&&this.peso<=15) { // Si pesa entre 5kg y 15kg la dosis es de 150mg
                    dosis=150;
                }else{          // Si pesa mas de 15kg la dosis es de 300mg
                    dosis=300;
                    if((edad-6)>0){ // Por cada año a partir de los 6 años de edad, se suman 10mg a los 300mg de base
                        dosis+=10*(edad-6);
                    }
                }
                break;
            case "GATO":
                if(this.peso<1){ // Si el gato pesa menos de 1kg la dosis es de 80mg
                    dosis=80;
                } else if(this.peso>=1 && this.peso<=3){ // Si pesa entre 1kg y 3kg la dosis es de 120mg
                    dosis=120;
                }else{
                    dosis=200; // Si pesa más de 3kg la dosis es de 200mg
                }
                break;
            case "TORTUGA":
                if (edad<5){ // Si la tortuga tiene menos de 5 años de edad, la dosis es de 50mg
                    dosis=50;
                } else if (edad>=5 && edad<=20) { // Si la tortuga tiene entre 5 y 20 años de edad, la dosis es de 70mg
                    dosis=70;
                }else{ // Si la tortuga es mayor a 20 años, la dosis es de 150mg
                    dosis=150;
                }
                break;
            case "CONEJO":
                if(edad<1){ // Si el conejo tiene menos de un año de edad, la dosis es de 20mg
                    dosis=20;
                }else { // Si el conejo tiene un año, o más, de edad la dosis es de 25mg
                    dosis=25;
                    if(this.peso-0.5>0){ // Por cada 100gr de peso arriba de los 500gr, se suma 1mg a la dosis base de 25mg
                        dosis+= (int) (10*(this.peso-0.5));
                    }
                }
                break;
        }
        return dosis;
    }
}
