package Universidad.DesarrolloAlgoritmo.TDA;
import java.time.LocalDate;

public class Fecha {
    private int day;
    private int month;
    private int year;
    //Array constante con la cantidad de días de cada mes (año no bisiesto)
    private static final int[] DIAS_MES = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public Fecha(int day, int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Mes inválido");
        }
        if (year < 1) {
            throw new IllegalArgumentException("Año inválido");
        }
        int limiteMes = (month == 2 && esBisiesto(year)) ? 29 : DIAS_MES[month];
        if (day < 1 || day > limiteMes) {
            throw new IllegalArgumentException("Día inválido");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }
    // Observadores y Modificadores
    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }
    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    // Propios
    public int calcularEdad(){
        // Obtener la fecha actual del sistema
        LocalDate hoy = LocalDate.now();
        int edad = hoy.getYear() - this.year;
        // Si aún no cumplió años en este año, le resto 1
        if (hoy.getMonthValue() < this.month || (hoy.getMonthValue() == this.month && hoy.getDayOfMonth() < this.day)) {
            edad--;
        }
        return edad;
    }
    // Se calcula la cantidad de dias que transcurrieron en el año actual
    public int diasTranscurridos() {
        int dias = this.day;
        for (int i = 1; i < this.month; i++) {
            dias += DIAS_MES[i];
        }
        if (esBisiesto(this.year) && this.month > 2) {
            dias++;
        }
        return dias;
    }
    // Verifica si la fecha es anterior a otra ingresada
    public boolean esFechaAnterior(Fecha miFecha) {
        boolean verificado = false;
        if (this.year < miFecha.year){
            verificado = true;
        } else if (this.month < miFecha.month){
            verificado = true;
        } else if (this.day < miFecha.day) {
            verificado = true;
        }
        return verificado;
    }
    // Calcula cual sera la fecha dentro de una cantidad de dias ingresados
    public void calcularFecha(int cantidadDias) {
        while (cantidadDias > 0) { // Se van sumando los dias de uno en uno a la fecha
            int limiteMes = (this.month == 2 && esBisiesto(this.year)) ? 29 : DIAS_MES[this.month];
            if (this.day < limiteMes) { // Si todavia no se llega a fin de mes se aumente el dia de la fecha
                this.day++;
            } else {
                this.day = 1;           // Si era el ultimo dia del mes, se reinicia los dias de la fecha al primero
                if (this.month == 12) { // Se considera si es año nuevo, se aumenta el año y se reinicia a uno el mes
                    this.month = 1;
                    this.year++;
                } else {
                    this.month++;       // Si no es diciembre se aumenta en uno el mes
                }
            }
            cantidadDias--; // Se actulizan la cantidad de dias ingresados
        }
    }
    public boolean esBisiesto() {
        return esBisiesto(this.year);   // Metodo propio de la clase
    }
    // Metodo static auxiliar para utilizar dentro de otros metodos propios de la clase
    private static boolean esBisiesto(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    @Override
    public String toString() {  // Se utiliza un formato tal que las fechas queden con la forma xx/xx/xxxx sin faltante de digitos. Ej: dia=9, mes=2 y año=2025 queda 09/02/2025
        return String.format("%02d/%02d/%04d", day, month, year); // Se utiliza el @Override para eliminar cualquier otro formato anterior que hubiera
    }
}
