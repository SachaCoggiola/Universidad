package Universidad.DesarrolloAlgoritmo.TDA;

import java.util.Scanner;

public class EjercicioMascota {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mascota[] mascotas = new Mascota[2]; // Arreglo con las diez mascotas
        char respuesta;
        String resp;
        String nombre;
        cargarMascotas(mascotas,sc);
        do {
            System.out.println("Ingrese \"D\" si deasea ver la dosis de una mascota, o \"B\" si desea buscar y mostrar, o modificar, los datos de una mascota");
            resp = sc.nextLine();
            if(resp.equalsIgnoreCase("B")){
                System.out.println("Ingrese el nombre de la mascota");
                nombre = sc.nextLine();
                System.out.println(mascotas[buscarmascota(mascotas, nombre)].toString()); // Busca la posicion de la mascota con el nombre ingresado y muestra los datos
                System.out.println("Ingrese \"S\" si desea sobreescribir los datos de la mascota llamada: "+nombre+".");
                if(sc.nextLine().equalsIgnoreCase("S")){
                    sobreescribirMascota(mascotas,nombre,sc);
                }
            } else if (resp.equalsIgnoreCase("D")) {
                System.out.println("Ingrese el nombre de la mascota");
                nombre = sc.nextLine();
                System.out.println("La dosis de analgésicos de la mascota llamada "+nombre+" es de "+dosisMascota(mascotas,nombre)+"miligramos.");
            }
            System.out.println("Ingrese \"N\" si no desea realizar otra operación.");
            respuesta = sc.nextLine().charAt(0);
        }while(!(respuesta=='n'||respuesta=='N'));
    }
    // Modulo para la carga inicial del arreglo de mascotas
    public static void cargarMascotas(Mascota[] mascotas,Scanner sc) {
        int year,month,day;
        for (int i = 0; i < mascotas.length; i++) {
            cargarDatos(mascotas, sc, i);
        }
    }
    // Modulo para buscar por nombre, una mascota dentro del arreglo de mascotas
    public static int buscarmascota(Mascota[] mascotas,String nombre) {
        int posicion = -1;
        for (int i = 0; i < mascotas.length; i++) {
            if(mascotas[i].getNombre().equals(nombre)) {
                posicion = i;
            }
        }
        return posicion;
    }
    // Modulo para cargar datos de una mascota en una posicion indicada del arreglo de mascotas
    public static void cargarDatos(Mascota[] mascotas,Scanner sc,int posicion) {
        String nombre, tipo;
        double peso;
        int day,month,year;
        boolean verificar;
        do{
            System.out.println("Ingrese el nombre de la mascota numero: " + (posicion + 1));
            nombre = sc.nextLine();
            verificar = verificarNombre(nombre,mascotas,posicion);
            if(verificar){
                System.out.println("El nombre ingresado de la mascota ya esta cargado. Utilice un nombre distinto.");
            }
        }while(verificar);
        System.out.println("Ingrese la especie de la mascota numero: "+(posicion+1));
        tipo = sc.nextLine();
        System.out.println("Ingrese el peso de la mascota numero: "+(posicion+1));
        peso = sc.nextDouble();
        System.out.println("Ingrese el año de nacimiento de la mascota numero: "+(posicion+1));
        year = sc.nextInt();
        System.out.println("Ingrese el mes de nacimiento de la mascota numero: "+(posicion+1));
        month = sc.nextInt();
        System.out.println("Ingrese el día de nacimiento de la mascota numero: "+(posicion+1));
        day = sc.nextInt();
        mascotas[posicion] = new Mascota(nombre, tipo, peso, day, month, year);
        sc.nextLine();
    }
    // Modulo para reemplazar los datos de una mascota por otra
    public static void sobreescribirMascota(Mascota[] mascotas,String nombre,Scanner sc) {
        int posicion = buscarmascota(mascotas,nombre);
        cargarDatos(mascotas,sc,posicion);
    }
    // Modulo que devuelve la cantidad de analgésicos recetados a una mascota
    public static int dosisMascota(Mascota[] mascotas,String nombre) {
        return mascotas[buscarmascota(mascotas,nombre)].calcularDosaje();
    }
    public static boolean verificarNombre(String nombre,Mascota[] mascotas, int limite) {
        boolean respuesta = false;
        for (int i = 0; i <= limite-1; i++) {
            if (mascotas[i].getNombre().equals(nombre)) {
                respuesta = true;
            }
        }
        return respuesta;
    }
}
