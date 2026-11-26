package Universidad.Metodos;

import java.util.Scanner;

public class Euler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar h: ");
        double h = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingresar rango");
        System.out.println("Limite inferior (incluido): ");
        int limInferior = sc.nextInt();
        sc.nextLine();
        System.out.println("Limite superior (incluido): ");
        int limSuperior = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingresar valor inicial de y: ");
        int valorInicial = sc.nextInt();
        sc.nextLine();
        System.out.println();

        double[] res;
        res = euler(h, valorInicial, limInferior, limSuperior);
        for (double i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
        res = eulerModificado(h, valorInicial, limInferior, limSuperior);
        for (double i : res) {
            System.out.print(i + " ");
        }
    }

    public static double[] euler(double h, int valorInicial, int limInferior, int limSuperior) {
        double j = limInferior;
        int cant = 0;
        while(j <= limSuperior){
            j += h;
            cant++;
        }
        double[] euler = new double[(cant)];
        euler[0] = valorInicial;

        double x = valorInicial;
        double y = euler[0];

        for (int i = 1; i < euler.length; i++) {
            euler[i] = y + h*funcion(x,y);
            x += h;
            y = euler[i];
        }

        return euler;
    }

    public static double[] eulerModificado(double h, int valorInicial, int limInferior, int limSuperior) {
        double j = limInferior;
        int cant = 0;
        while(j <= limSuperior){
            j += h;
            cant++;
        }
        double[] euler = new double[(cant)];
        euler[0] = valorInicial;
        double[] eulerModificado = new double[(cant)];
        eulerModificado[0] = valorInicial;

        double x = valorInicial;
        double y = euler[0];

        for (int i = 1; i < euler.length; i++) {
            euler[i] = y + h*funcion(x,y);
            eulerModificado[i] = y + (h/2) * (funcion(x,y)+funcion(x+h,euler[i]));
            x += h;
            y = eulerModificado[i];
        }

        return eulerModificado;
    }

    public static double funcion(double x, double y) {
        return 2-2*y/5;
    }
}
