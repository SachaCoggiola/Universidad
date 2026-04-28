package Universidad.EstructuraDatos.TDA;

public class Alumno {
    private String legajo;
    private String nombre;
    private String apellido;
    private String tipoDNI;
    private int DNi;
    private Domicilio direccion;
    private int telefono;
    private String usuario;
    private String password;
    public Alumno(String legajo) {
        this.legajo = legajo;
    }
    public Alumno(String legajo, String nombre, String apellido, String tipoDNI, int DNi, String calle, int numCalle, String ciudad, int telefono, String usuario, String password) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDNI = tipoDNI;
        this.DNi = DNi;
        this.direccion = new Domicilio(calle, numCalle, ciudad);
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
    }
    public String getLegajo() {
        return this.legajo;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    public String getTipoDNI() {
        return this.tipoDNI;
    }
    public int getDNi() {
        return this.DNi;
    }
    public Domicilio getDireccion() {
        return this.direccion;
    }
    public int getTelefono() {
        return this.telefono;
    }
    public String getUsuario() {
        return this.usuario;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setDireccion(String calle, int numCalle, String ciudad) {
        this.direccion = new Domicilio(calle, numCalle, ciudad);
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public void cambiarUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void cambiarPassword(String password) {
        this.password = password;
    }
    public boolean equals(Alumno alumno){
        return this.legajo.equals(alumno.getLegajo());
    }
    public String toString(){
        return "Alumno: "+this.nombre+this.apellido+" DNI: "+this.tipoDNI+this.DNi+" Legajo: "+this.legajo;
    }
}
