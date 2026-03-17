package Universidad.DesarrolloAlgoritmo;

public class Jugador {
    private int dni;
    private String nickname;
    private int edad;
    private int puntosPartidaUno;
    private int puntosPartidaDos;
    private String clasificacion;

    public Jugador(int dni){
        this.dni = dni;
        this.nickname = "";
        this.edad = 0;
        this.puntosPartidaUno = 0;
        this.puntosPartidaDos = 0;
        this.clasificacion = "";
    }
    public Jugador(int dni, String nickname, int edad, int puntosPartidaUno, int puntosPartidaDos){
        this.dni = dni;
        this.nickname = nickname;
        this.edad = edad;
        this.puntosPartidaUno = puntosPartidaUno;
        this.puntosPartidaDos = puntosPartidaDos;
        this.clasificacion = defClasificacion();
    }

    public int getDni() {
        return dni;
    }
    public String getNickname() {
        return nickname;
    }
    public int getEdad() {
        return edad;
    }
    public int getPuntosPartidaUno() {
        return puntosPartidaUno;
    }
    public int getPuntosPartidaDos() {
        return puntosPartidaDos;
    }
    public int getPuntajeTotal(){return this.puntosPartidaUno+this.puntosPartidaDos;}
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setPuntosPartidaUno(int puntosPartidaUno) {
        this.puntosPartidaUno = puntosPartidaUno;
    }
    public void setPuntosPartidaDos(int puntosPartidaDos) {
        this.puntosPartidaDos = puntosPartidaDos;
    }

    public String toString(){
        return "DNI: " + this.dni+"\nNickname: " + this.nickname + "\nEdad: " + this.edad + "\nCantidad de puntos partida 1: "
                + this.puntosPartidaUno + "\nCantidad de puntos partida 2: " + this.puntosPartidaDos;
    }
    public boolean equals(Jugador obj){
        return this.dni == obj.getDni();
    }
    public int compareTo(Jugador obj){
        return this.nickname.compareTo(obj.getNickname());
    }

    public String defClasificacion(){
        String clasificacion = "";
        if(this.edad<19){
            clasificacion = "Junior";
        }else if(this.edad<31){
            clasificacion = "Senior";
        }else{
            clasificacion = "Master";
        }
        return clasificacion;
    }
}
