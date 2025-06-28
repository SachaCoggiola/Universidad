package Universidad.RPA;

import java.util.Scanner;

public class tpFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jugadorUno, jugadorDos;
        double puntajeUno = 0, puntajeDos = 0, maxPuntUno = 0, maxPuntDos = 0;
        int cantRonda = 0, valorCarta, rondaJugUno = 1, rondaJugDos = 1;
        boolean turno = true;
        System.out.println("Ingrese el nombre del jugador N°1:");
        jugadorUno = sc.nextLine();
        System.out.println("Ingrese el nombre del jugador N°2:");
        jugadorDos = sc.nextLine();
        do {
            cantRonda++;
            System.out.println("Ha comenzado la ronda N°"+cantRonda);
            for (int i = 0; i < 2; i++) {//modularizar el turno? no cambia nada solo queda mas lindo
                if(turno){
                    System.out.println("Es turno del jugador "+jugadorUno);
                }else{
                    System.out.println("Es turno del jugador "+jugadorDos);
                }
                double puntaje = 0;
                do {
                    System.out.println("Ingrese el valor de la carta:");
                    valorCarta = sc.nextInt();
                    valorCarta = verificarCarta(valorCarta);
                    puntaje += calcularPuntaje(valorCarta);
                    System.out.println(puntaje);
                } while (valorCarta != 1 && valorCarta != 12);
                if (turno) {
                    puntajeUno += puntaje;
                    turno = false;
                } else {
                    puntajeDos += puntaje;
                    turno = true;
                }
            }
            if (maxPuntUno < puntajeUno) { //modularizar? para que no quede feo
                maxPuntUno = puntajeUno;
                rondaJugUno = cantRonda;
            }
            if (maxPuntDos < puntajeDos) {
                maxPuntDos = puntajeDos;
                rondaJugDos = cantRonda;
            }
        }while(puntajeUno <= 60 && puntajeDos <= 60);
        if(puntajeUno == puntajeDos){
            System.out.println("Los jugadores "+ jugadorUno +" y "+ jugadorDos +" han empatado con un total de "+puntajeUno);
            System.out.println("Han jugado un total de "+cantRonda+" rondas.");
            System.out.println("El jugador "+jugadorUno+" ha logrado "+maxPuntUno+" puntos en la ronda numero "+rondaJugUno);
            System.out.println("El jugador " +jugadorDos+" ha logrado "+maxPuntDos+" puntos en la ronda numero "+rondaJugDos);
        } else if (puntajeUno < puntajeDos) {
            System.out.println("El jugador "+jugadorDos+" ha ganado");
            System.out.println(jugadorDos+" ha hecho "+puntajeDos+" puntos.");
            System.out.println("El jugador " +jugadorDos+" ha logrado "+maxPuntDos+" puntos en la ronda numero "+rondaJugDos);
        }else{
            System.out.println("El jugador "+jugadorUno+" ha ganado");
            System.out.println(jugadorUno+" ha hecho "+puntajeUno+" puntos.");
            System.out.println("El jugador "+jugadorUno+" ha logrado "+maxPuntUno+" puntos en la ronda numero "+rondaJugUno);
        }
    }

    public static int verificarCarta(int valorCarta){
        if(valorCarta < 1||valorCarta > 12) {
            valorCarta = 0;
        }
        return valorCarta;
    }
    public static double calcularPuntaje(int valorCarta){
        if(valorCarta == 1 || valorCarta == 12) {
            return 0;
        }else if(esPar(valorCarta)){
            return (double) valorCarta * 2;
        }else{
            return (double) valorCarta / 2;
        }
    }
    public static boolean esPar(int valorCarta){
        return valorCarta % 2 == 0;
    }
}
