package Universidad.EstructuraDatos.test.testLineales;

import Universidad.EstructuraDatos.TDA.Alumno;
import Universidad.EstructuraDatos.lineal.dinamico.Pila;

import java.util.Scanner;

public class TestAlumno {
    public static void main(String[] args) {
        Pila alumnos = new Pila();
        cargarPila(alumnos);
    }
    public static void cargarPila(Pila unaPila) {
        boolean flag = true;
        String res;
        Scanner sc = new Scanner(System.in);
        while(flag) {
            unaPila.apilar(crearAlumno());
            System.out.println("Desea ingresar otro alumno, ingrese si o no");
            res=sc.nextLine();
            if(!res.equals("si")){
                flag = false;
            }
        }
    }
    public static Alumno crearAlumno() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su legajo");
        String legajo = sc.nextLine();
        System.out.println("Ingrese su nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su apellido");
        String apellido = sc.nextLine();
        System.out.println("Ingrese tipo de su documento");
        String tipoDNI = sc.nextLine();
        System.out.println("Ingrese el numero de su documento");
        int DNI = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el nombre de la calle donde vive");
        String calle = sc.nextLine();
        System.out.println("Ingrese la altura de la calle donde vive");
        int numCalle = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese la ciudad donde vive");
        String ciudad = sc.nextLine();
        System.out.println("Ingrese su numero de telefono");
        int telefono = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el usuario");
        String usuario = sc.nextLine();
        System.out.println("Ingrese la contraseña");
        String password = sc.nextLine();
        return new Alumno(legajo,nombre,apellido,tipoDNI,DNI,calle,numCalle,ciudad,telefono,usuario,password);
    }
}
