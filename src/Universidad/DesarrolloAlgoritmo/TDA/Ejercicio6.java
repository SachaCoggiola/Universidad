package Universidad.DesarrolloAlgoritmo.TDA;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantIngr;
        char respuesta;
        System.out.println("Ingrese la cantidad de ingredientes individuales que tiene la receta: ");
        cantIngr = sc.nextInt();
        Ingrediente[] receta = new Ingrediente[cantIngr];
        cargarIngredientes(receta,sc,cantIngr);
        do {
            System.out.println("Ingrese 'l' para listar los ingredientes de la receta, o 'v' para verificar si un ingrediente esta en la receta.");
            respuesta = sc.next().charAt(0);
            if(respuesta=='v'){
                if(verificarIngrediente(receta[0],receta)){
                    System.out.println("El ingrediente se encuentra en la receta.");
                }else {
                    System.out.println("El ingrediente no se encuentra en la receta.");
                }
            } else if (respuesta=='l') {
                listarIngredientes(receta);
            }
        }while(respuesta!='n');
    }
    public static void listarIngredientes(Ingrediente[] receta){
        for (Ingrediente ingrediente : receta) {
            System.out.println(ingrediente.toString());
        }
    }
    public static boolean verificarIngrediente(Ingrediente ingrediente, Ingrediente[] receta){
        boolean respuesta = false;
        for (Ingrediente ingrediente2 : receta) {
            if (ingrediente.equals(ingrediente2)) {
                respuesta = true;
            }
        }
        return respuesta;
    }
    public static void cargarIngredientes(Ingrediente[] receta,Scanner sc,int cantIngr) {
        sc.nextLine();
        String nombreIngr;
        double cantIngrReceta;
        String unidadMedidaIngr;
        for (int i = 0; i < cantIngr; i++) {
            System.out.println("Ingrese el nombre del ingrediente: ");
            nombreIngr = sc.next();
            System.out.println("Ingrese la unidad de medida del ingrediente: ");
            unidadMedidaIngr = sc.next();
            System.out.println("Ingrese la cantidad a utilizar del ingrediente: ");
            cantIngrReceta = sc.nextDouble();
            receta[i] = new Ingrediente(nombreIngr,cantIngrReceta,unidadMedidaIngr);
        }
    }
}
