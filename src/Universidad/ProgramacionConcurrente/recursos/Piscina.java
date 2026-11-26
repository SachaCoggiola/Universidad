package Universidad.ProgramacionConcurrente.recursos;

public class Piscina {
    private int tamanio;

    public Piscina(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getTamanio() {
        return tamanio;
    }
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void anunciarEntrada(String nombre){
        System.out.println("La persona " + nombre + " entro a la piscina.");
    }

    public void anunciarSalida(String nombre){
        System.out.println("La persona " + nombre + " salio de la piscina.");
    }
}
