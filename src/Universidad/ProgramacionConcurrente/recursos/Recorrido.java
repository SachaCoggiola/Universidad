package Universidad.ProgramacionConcurrente.recursos;

public class Recorrido {
    private boolean paradaSalida;
    private boolean paradaLlegada;
    private boolean enMovimiento;
    private int cantR;

    public Recorrido(int cantRecorridos) {
        this.paradaSalida = false;
        this.paradaLlegada = false;
        this.enMovimiento = false;
        this.cantR = cantRecorridos;
    }

    public boolean getParadaSalida() {
        return this.paradaSalida;
    }
    public boolean getParadaLlegada() {
        return this.paradaLlegada;
    }
    public boolean getEnMovimiento() {
        return this.enMovimiento;
    }
    public int getCantR() {
        return this.cantR;
    }

    public void salida(){
        this.paradaSalida = true;
        this.paradaLlegada = false;
        this.enMovimiento = false;
    }
    public void llegada(){
        this.paradaSalida = false;
        this.paradaLlegada = true;
        this.enMovimiento = false;
    }
    public void movimiento(){
        this.paradaSalida = false;
        this.paradaLlegada = false;
        this.enMovimiento = true;
    }
}
