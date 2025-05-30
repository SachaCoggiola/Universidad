package Universidad.RPA;
import static java.lang.Math.*;

public class modulos {
    public static double calcularHipotenusa(double base, double altura) {return sqrt(base*base+altura*altura);}
    public static double calcularDistanciaRecorrida(int velocidad, double tiempo){return velocidad * tiempo;}
    public static double calcularPerimetroCirculo(double radio){return radio*2*Math.PI;}
    public static double calcularVolumenCuboide(double base, double altura, double profundidad){return base*altura*profundidad;}
    public static int convertirASeg(int horas, int minutos, int segundos){return (horas * 3600 + minutos * 60 + segundos);}
    public static double convertirCmAMtr(double centimetros){return centimetros /100;}
    public static int calcularPrecioFinal(int precio, int descuento) {return precio-(descuento*precio)/100;}
    public static int calcularTotal(int precioUno, int precioDos, int precioTres){return precioUno+precioDos+precioTres;}
    public static double calcularMonto(int precio, double cantidad){return precio*cantidad;}
    public static void imprimirLinea(){System.out.println("+---------------------+");}
    public static void imprimirMitad(){System.out.println("|    +-----------+    |");}
    public static void imprimirMitadBarra(){System.out.println("|    +-----|-----+    |");}
    public static void imprimirMitadMas(){System.out.println("|    +-----+-----+    |");}
    public static void imprimirVacio(){System.out.println("|                     |");}
    public static void imprimirTresLineas(){System.out.println("|    |     |     |    |");}
    public static void imprimirDosLineas(){System.out.println("|    |           |    |");}
    public static int devolverMayor(int numero, int numeroDos){if(numero> numeroDos){return numero;}else return numeroDos;}
    public static double calcularAreaRectangulo(double base, double altura){return base*altura;}
    public static int devolderMenor(int numero, int numeroDos){if(numero<numeroDos){return numero;}else return numeroDos;}
    public static double convertirMtrACm(double metros){return metros*100;}
    public static double calcularPorcentaje(double valor, double valorDos){return valorDos*100/valor;}
    public static double calcularPromedio(double numero, double numeroDos, double numeroTres){return (numero+numeroDos+numeroTres)/3;}
    public static boolean verificarPositivo(int numero){return numero>0;}
    public static boolean verificarNegativo(int numero){return numero<0;}
    public static boolean verificarCero(int numero){return numero==0;}
    public static boolean verificar18(int edad){return edad>17;}
    public static boolean verificarNota(double nota){return nota>5;}
    public static boolean esMultiplo(int multiplo, int numero){
        return multiplo % numero == 0;
    }
}
