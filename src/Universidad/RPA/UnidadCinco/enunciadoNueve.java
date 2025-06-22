package Universidad.RPA.UnidadCinco;

import java.util.Scanner;
import static Universidad.RPA.modulos.*;

public class enunciadoNueve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String contra;
        do {
            System.out.println("Ingrese su contraseña: ");
            contra = sc.nextLine();
        }while(!validarContra(contra));
        System.out.println("La contraseña ingresada es valida.");
    }

}
