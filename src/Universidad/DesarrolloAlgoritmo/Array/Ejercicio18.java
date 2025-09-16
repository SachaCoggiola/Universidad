package Universidad.DesarrolloAlgoritmo.Array;
import java.util.Scanner;
import java.math.*;
import static Universidad.DesarrolloAlgoritmo.Modulos.*;

public class Ejercicio18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] empleados;
        double[] salarios;
        int largo;
        char respuesta;
        System.out.println("Ingrese la cantidad de empleados que tenga: ");
        largo = sc.nextInt();
        empleados = new String[largo];
        salarios = new double[largo];
        cargarArray(empleados,sc);
        cargarArray(salarios,sc);
        do{
            System.out.println("Menu selectivo:");
            System.out.println("Ingrese \"a\" para buscar la persona que tiene el mayor sueldo.");
            System.out.println("Ingrese \"b\" listar todas los empleados empleados que cobren un monto.");
            System.out.println("Ingrese \"c\" aumentar en 10% el sueldo de los empleados cuyos sueldos sean menores a $10000.00.");
            System.out.println("Ingrese \"d\" verificar si existe un empleado.");
            System.out.println("Ingrese \"n\" si no desea realizar ninguna accion.");
            respuesta = sc.next().charAt(0);
            switch (respuesta){
                case 'a':
                    int posicion = mayorSueldo(empleados,salarios);
                    System.out.println("El empleado "+empleados[posicion]+" es el empleado que mayor sueldo cobra, con un total de: $"+salarios[posicion]);
                    break;
                case 'b':
                    System.out.println("Ingrese el monto por el cual desea consultar: ");
                    double monto = sc.nextDouble();
                    mostrarEmpleadosXMonto(empleados,salarios,monto);
                    break;
                case 'c':
                    aumentarSalario(salarios);
                    break;
                case 'd':
                    System.out.println("Ingrese el nombre del empleado a buscar: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    int i = buscarEmpleado(empleados,nombre);
                    if(buscarEmpleado(empleados,nombre)==-1){
                        System.out.println("El empleado "+nombre+" no existe");
                    }else{
                        System.out.println("El empleado "+nombre+" cobra un sueldo de "+salarios[i]);
                    }
                    break;
            }
        }while(respuesta!='n');
    }
    public static int mayorSueldo(String[] empleados, double[] salarios) {
        int posicion = 0;
        double mayor = salarios[0];
        int i;
        for ( i = 1; i < empleados.length; i++) {
            if(mayor < salarios[i]) {
                mayor = salarios[i];
                posicion = i;
            }
        }
        return posicion;
    }
    public static void aumentarSalario(double[] salarios) {
        for (int i = 0; i < salarios.length; i++) {
            if(salarios[i]<10000){
                salarios[i]=salarios[i]*1.1;
            }
        }
    }
    public static void mostrarEmpleadosXMonto(String[] empleados,double[] salarios,double monto) {
        int contador = 0;
        System.out.println("Lista de empleados que cobran $"+monto+":");
        for (int i = 0; i < salarios.length; i++) {
            if(salarios[i]==monto){
                contador++;
                System.out.println(empleados[i]);
            }
        }
        System.out.println("Un total de "+contador+" empleados cobran $"+monto+".");
    }
    public static int buscarEmpleado(String[] empleados,String nombre){
        int posicion = -1;
        for (int i = 0; i < empleados.length; i++) {
            if(empleados[i].equals(nombre)){
                posicion = i;
            }
        }
        return posicion;
    }
}
