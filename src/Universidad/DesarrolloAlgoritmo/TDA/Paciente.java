package Universidad.DesarrolloAlgoritmo.TDA;

public class Paciente {
    private int dni;
    private String nombre;
    private String apellido;
    private String obraSocial;
    public Paciente(int dni, String nombre, String apellido, String obraSocial) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.obraSocial = obraSocial;
    }
    public Paciente(int dni){
        this.dni = dni;
    }
    public int getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getObraSocial() {
        return obraSocial;
    }
    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }
    public boolean equals(Paciente paciente){
        return this.dni == paciente.getDni();
    }

}
