package Universidad.RPA.UnidadTres.ejercicioUno;

public class modulos {
    public static double calcularHipotenusa(double base, double altura) {
        return base*base+altura*altura;
    }
    public static double calcularDistanciaRecorrida(int velocidad, double tiempo){
        return velocidad * tiempo;
    }
    public static double calcularPerimetroCirculo(double radio){
        return radio*2*Math.PI;
    }
    public static double calcularVolumenCuboide(double base, double altura, double profundidad){
        return base*altura*profundidad;
    }
    public static int convertirASeg(int horas, int minutos, int segundos){
        return (horas * 3600 + minutos * 60 + segundos);
    }
    public static double convertirCmAMtr(double distancia){
        return distancia/100;
    }
    public static int calcularPrecioFinal(int precio, int descuento){
        return precio-(descuento*precio)/100;
    }
    public static int calcularTotal(int precioUno, int precioDos, int precioTres){
        return precioUno+precioDos+precioTres;
    }
}
