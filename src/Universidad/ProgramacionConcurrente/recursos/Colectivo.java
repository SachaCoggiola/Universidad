package Universidad.ProgramacionConcurrente.recursos;

public class Colectivo {
    private final int cantAsientos;
    private int cantPasajeros;
    private boolean puertaDelantera;
    private boolean puertaTrasera;

    public Colectivo(int cantAsientos) {
        this.cantAsientos = cantAsientos;
        this.cantPasajeros = 0;
        this.puertaDelantera = false;
        this.puertaTrasera = false;
    }

    public int getCantAsientos() {
        return cantAsientos;
    }
    public int getCantPasajeros() {
        return cantPasajeros;
    }
    public boolean getPuertaDelantera() {
        return puertaDelantera;
    }
    public boolean getPuertaTrasera() {
        return puertaTrasera;
    }

    public boolean hayLugar(){
        return this.cantPasajeros < this.cantAsientos;
    }
    public boolean estaLLeno(){
        return this.cantPasajeros == this.cantAsientos;
    }

    public void habilitarPuertaDelantera(){
        this.puertaDelantera = true;
    }
    public void habilitarPuertaTrasera(){
        this.puertaTrasera = true;
    }

    public void deshabilitarPuertaDelantera(){
        this.puertaDelantera = false;
    }
    public void deshabilitarPuertaTrasera(){
        this.puertaTrasera = false;
    }

    public boolean subirPasajero(){
        boolean exito = false;
        if(this.puertaDelantera){
            if(this.cantPasajeros < this.cantAsientos){
                this.cantPasajeros++;
                exito = true;
            }
        }
        return exito;
    }
    public boolean bajarPasajero(){
        boolean exito = false;
        if(this.puertaTrasera){
            if(this.cantPasajeros > 0){
                this.cantPasajeros--;
                exito = true;
            }
        }
        return exito;
    }
}
