package Universidad.DesarrolloAlgoritmo.TDA;

public class Turno {
    private final String dia;
    private final int hora;
    private final Paciente paciente;
    private String diagnostico;
    private boolean asistio;
    private boolean finalizo;
    private int diasTratamiento;
    private double montoCoseg;
    public Turno(String dia, int hora, int dni, String nombre, String apellido, String obraSocial) {
        this.dia = dia;
        this.hora = hora;
        this.paciente = new Paciente(dni, nombre, apellido, obraSocial);
    }

    public Turno(String dia, int hora, int dni, String nombre, String apellido, String obraSocial, String diagnostico, boolean asistio, boolean finalizo, int diasTratamiento, double montoCoseg){
        this.dia = dia;
        this.hora = hora;
        this.paciente = new Paciente(dni, nombre, apellido, obraSocial);
        this.diagnostico = diagnostico;
        this.asistio = asistio;
        this.finalizo = finalizo;
        this.diasTratamiento = diasTratamiento;
        this.montoCoseg = montoCoseg;
    }
    public String getDia() {
        return dia;
    }
    public int getHora() {
        return hora;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public boolean getAsistio() {
        return asistio;
    }
    public boolean getFinalizo() {
        return finalizo;
    }
    public int getDiasTratamiento() {
        return diasTratamiento;
    }
    public double getMontoCoseg() {
        return montoCoseg;
    }
    public String toString() {
        return "El turno del paciente "+this.paciente.getNombre()+" "+this.paciente.getApellido()+" es el dia "+this.dia+" y a la hora "+this.hora+", tiene un diagnostico de "+this.diagnostico+
                ".\nTiene obra social: "+this.paciente.getObraSocial()+" y un monto de coseguro de : $"+this.montoCoseg+".";
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public void setAsistio(boolean asistio) {
        this.asistio = asistio;
    }
    public void setFinalizo(boolean finalizo) {
        this.finalizo = finalizo;
    }
    public void setDiasTratamiento(int diasTratamiento) {
        this.diasTratamiento = diasTratamiento;
    }
    public void setMontoCoseg(double montoCoseg) {
        this.montoCoseg = montoCoseg;
    }
    public boolean equals(Turno turno) {
        return this.dia.equals(turno.getDia())&&this.hora==(turno.getHora());
    }
    public boolean equalsPaciente(Turno turno) {
        return this.paciente.equals(turno.getPaciente());
    }
    public boolean equals(String diagnostico) {
        return this.diagnostico.equals(diagnostico);
    }
}
