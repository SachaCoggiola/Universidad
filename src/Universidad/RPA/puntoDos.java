package Universidad.RPA;

import java.util.Scanner;

public class puntoDos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una temperatura en fahrenheit (solo ingrese el numero)");
        float fahrenheit = sc.nextFloat();
        System.out.println("La temperatura expresada en grados Celcius: " + celciusToFahrenheit(fahrenheit));
    }
    public static float celciusToFahrenheit(float celcius) {
        return celcius * 9/5 + 32;
    }
}
