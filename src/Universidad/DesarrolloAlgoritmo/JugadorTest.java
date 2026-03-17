package Universidad.DesarrolloAlgoritmo;

import java.util.Scanner;

public class JugadorTest {
    public static void main(String[] args) {
        Jugador[] jugadores = new Jugador[10];
        int aux = 0;
        Scanner sc = new Scanner(System.in);
        ingresarJugadores(jugadores, sc);
        mostrarJugadores(jugadores,0);
        aux = buscarPorDni(jugadores,47181430);
        if(aux != -1){
            System.out.println("El jugador con el dni 47181430 es: \n"+jugadores[aux].toString());
        }else{
            System.out.println("No existe el jugador");
        }
        Jugador[] jugadores2 = filtrarXPuntos(jugadores,25);
        System.out.println("Los jugadores con mas de 25 puntos son: ");
        mostrarJugadores(jugadores2,0);
        System.out.println("El mejor jugador según puntaje es: ");
        mejorJugador(jugadores);
        if(eliminarJugador(jugadores,47181430)){
            System.out.println("No se ha encontrado el jugador que desea eliminar del plantel");
        }else{
            System.out.println("El jugador con el dni 47181430, ha sido eliminado del plantel");
        }
        mostrarJugadores(jugadores,0);
        ordenarJugPuntTotal(jugadores);
        mostrarJugadores(jugadores,0);
    }

    public static void mostrarJugadores(Jugador[] jugadores, int i) {
        if(i<jugadores.length) {
            if(jugadores[i] != null) {
                System.out.println(jugadores[i].toString());
            }
            mostrarJugadores(jugadores, i+1);
        }
    }
    public static void ingresarJugadores(Jugador[] jugadores, Scanner sc) {
        String resp;
        int pos;
        do {
            pos = espacioLibre(jugadores);
            if (pos == -1) {
                System.out.println("El plantel de jugadores esta completo, no es posible ingresar otro jugador sin eliminar alguno previamente.");
            } else {
                if (cargarJugador(jugadores, sc, pos)) {
                    System.out.println("El jugador ha sido ingresado correctamente.");
                } else {
                    System.out.println("El jugador que desea cargar ya se encuentra cargado en el plantel.");
                }
            }
            System.out.println("¿Desea ingresar otro jugador?. Responda \"Si\" de asi serlo: ");
            resp = sc.nextLine();
        }while(resp.equalsIgnoreCase("Si"));
    }
    public static boolean cargarJugador(Jugador[] jugadores, Scanner sc, int i) {
        int dni;
        boolean flag;
        do {
            System.out.println("Ingrese el DNI del jugador: ");
            dni = sc.nextInt();
            flag = verificarDni(dni);
            if(!flag){
                System.out.println("El dni ingresado no es valido, desea intentar nuevamente. Responda con \"Si\" de asi serlo: ");
            }
        }while(sc.nextLine().equalsIgnoreCase("Si"));
        if(verificarJugador(jugadores, dni)){
            cargarDatosJugador(jugadores, sc, dni, i);
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }
    public static boolean verificarDni(int dni) {
        return dni >= 0 && dni <= 99999999;
    }
    public static void cargarDatosJugador(Jugador[] jugadores, Scanner sc, int dni, int i) {
        System.out.println("Ingrese el nickname del jugador: ");
        String nickname = sc.nextLine();
        System.out.println("Ingrese la edad del jugador: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese la cantidad de puntos que obtuvo el jugador en la primer partida: ");
        int puntosPartidoUno = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese la cantidad de puntos que obtuvo el jugador en la segundo partida: ");
        int puntosPartidoDos = sc.nextInt();
        sc.nextLine();
        jugadores[i] = new Jugador(dni, nickname, edad, puntosPartidoUno, puntosPartidoDos);
    }
    public static int espacioLibre(Jugador[] jugadores) {
        int pos = -1;
        int i = 0;
        boolean flag = true;
        while(i<jugadores.length&&flag) {
            if(jugadores[i] == null) {
                pos = i;
                flag = false;
            }
            i++;
        }
        return pos;
    }
    public static boolean verificarJugador(Jugador[] jugadores, int dni) {
        boolean flag = true;
        int i = 0;
        while(i<jugadores.length&&flag) {
            if(jugadores[i] != null) {
                if(jugadores[i].getDni() == dni) {
                    flag = false;
                }
            }
            i++;
        }
        return flag;
    }
    public static int buscarPorDni(Jugador[] jugadores, int dni) {
        int pos = -1;
        int i = 0;
        boolean flag = true;
        while(i<jugadores.length&&flag) {
            if(jugadores[i] != null) {
                if(jugadores[i].getDni() == dni) {
                    flag = false;
                    pos = i;
                }
            }
            i++;
        }
        return pos;
    }
    public static void mejorJugador(Jugador[] jugadores) {
        int maxPuntosUno = -1;
        int maxPuntosDos = -1;
        int pos = -1;
        for(int i = 0; i < jugadores.length; i++) {
            if(jugadores[i]!=null){
                if(jugadores[i].getPuntosPartidaUno()>maxPuntosUno){
                    pos = i;
                    maxPuntosUno = jugadores[i].getPuntosPartidaUno();
                    maxPuntosDos = jugadores[i].getPuntosPartidaDos();
                } else if (jugadores[i].getPuntosPartidaUno() == maxPuntosUno && jugadores[i].getPuntosPartidaDos() > maxPuntosDos) {
                    pos = i;
                    maxPuntosUno = jugadores[i].getPuntosPartidaUno();
                    maxPuntosDos = jugadores[i].getPuntosPartidaDos();
                }
            }
        }
        if(pos==-1){
            System.out.println("No existe ningun jugador cargado en el plantel.");
        }else {
            System.out.println("El jugador con mayor puntaje es: " + jugadores[pos].toString());
        }
    }
    public static void ordenarJugPuntTotal(Jugador[] jugadores) {
        quickSort(jugadores, 0, jugadores.length-1);
    }
    public static void intercambiar(Jugador[] jugadores, int i, int j) {
        Jugador jug = jugadores[i];
        jugadores[i] = jugadores[j];
        jugadores[j] = jug;
    }
    public static Jugador[] filtrarXPuntos(Jugador[] jugadores, int puntaje) {
        Jugador[] jugXPuntos = new Jugador[jugadores.length];
        int j = 0;
        for (Jugador jug : jugadores) {
            if (jug != null) {
                if (jug.getPuntosPartidaUno() > puntaje) {
                    jugXPuntos[j] = jug;
                    j++;
                }
            }
        }
        return jugXPuntos;
    }
    public static void quickSort(Jugador[] arr, int ini, int fin) {
        if (ini < fin) {
            int pivote = particion(arr, ini, fin);
            quickSort(arr, ini, pivote - 1);
            quickSort(arr, pivote + 1, fin);
        }
    }
    public static int particion(Jugador[] arr, int ini, int fin) {
        int posPiv = calcPivote(arr, ini, fin);
        Jugador pivote = arr[posPiv];
        intercambiar(arr, posPiv, fin);

        int i = ini;

        for (int j = ini; j < fin; j++) {
            if (arr[j] != null && pivote != null && arr[j].getPuntajeTotal() > pivote.getPuntajeTotal()) {
                intercambiar(arr, i, j);
                i++;
            }
        }

        intercambiar(arr, i, fin);
        return i;
    }
    public static int calcPivote(Jugador[] arr, int ini, int fin) {
        int pos=0;
        boolean flag = true;
        while(flag){
            if(arr[pos]!=null){
                flag = false;
            }else{
                pos++;
            }
        }
        return pos;
    }
    public static boolean eliminarJugador(Jugador[] arr, int dni){
        boolean flag = true;
        int i = 0;
        while(i<arr.length && flag) {
            if(arr[i]!=null){
                if(arr[i].getDni() == dni){
                    flag = false;
                    arr[i] = null;
                }
            }
            i++;
        }
        return flag;
    }
}
