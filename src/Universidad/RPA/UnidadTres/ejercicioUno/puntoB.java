package Universidad.RPA.UnidadTres.ejercicioUno;

import java.util.Scanner;

public class puntoB {
    public static void main(String[] args) {
        String primero = "primero";
        String segundo = "segundo";
        String tercero = "tercero";
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el radio del primer circulo expresado en milimetros");
        double radio = sc.nextDouble();
        imprimirPerimetro(calcularPerimetro(radio), primero);
        System.out.println("Introduzca el radio del segundo circulo expresado en milimetros");
        radio = sc.nextDouble();
        imprimirPerimetro(calcularPerimetro(radio), segundo);
        System.out.println("Introduzca el radio del tercer circulo expresado en milimetros");
        radio = sc.nextDouble();
        imprimirPerimetro(calcularPerimetro(radio), tercero);
    }
    public static double calcularPerimetro(double radio){
        return radio*2*Math.PI;
    }
    public static void imprimirPerimetro(double perimetro, String numeracion){
        System.out.println("El perimetro del " + numeracion + " circulo es: " + perimetro);
    }
}
