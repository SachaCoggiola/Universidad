package Universidad.DesarrolloAlgoritmo.TDA;
import java.util.Scanner;

public class testMascota {
    public static void main(String[] args) {
        Mascota perrito = new Mascota(1);
        Scanner sc = new Scanner(System.in);
        perrito.setNombre("Marley");
        System.out.println("Ingrese el peso de la mascota: ");
        perrito.setPeso(sc.nextDouble());
        System.out.println("Ingrese la edad de la mascota: ");
        perrito.setEdad(sc.nextInt());
        mostrarNombreMascota(perrito);
        mostrarDatosMascota(perrito);
        aumentarEdadMascota(perrito);
        mostrarDatosMascota(perrito);
        System.out.println("Ingrese el peso actualizado de la mascota: ");
        actualizarPesoMascota(sc.nextDouble(), perrito);
        mostrarDatosMascota(perrito);
    }
    public static void mostrarNombreMascota(Mascota mascota){
        System.out.println(mascota.getNombre());
    }
    public static void aumentarEdadMascota(Mascota mascota){
        mascota.setEdad(mascota.getEdad() + 1);
    }
    public static void actualizarPesoMascota(double peso,Mascota mascota){
        mascota.setPeso(peso);
    }
    public static void mostrarDatosMascota(Mascota mascota){
        System.out.println("El nombre de la mascota: "+mascota.getNombre());
        System.out.println("Edad de la mascota: "+mascota.getEdad());
        System.out.println("Peso de la mascota: "+mascota.getPeso());
    }
}
