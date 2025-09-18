package Universidad.DesarrolloAlgoritmo.TDA;

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
    // Verifica si la fecha es anterior a otra
    public boolean esFechaAnterior(Fecha miFecha) {
        if (this.year < miFecha.year) return true;
        if (this.year > miFecha.year) return false;
        if (this.month < miFecha.month) return true;
        if (this.month > miFecha.month) return false;
        return this.day < miFecha.day;
    }
    public void calcularFecha(int cantidadDias) {
        while (cantidadDias > 0) {
            int limiteMes = (this.month == 2 && esBisiesto(this.year)) ? 29 : DIAS_MES[this.month];
            if (this.day < limiteMes) {
                this.day++;
            } else {
                this.day = 1;
                if (this.month == 12) {
                    this.month = 1;
                    this.year++;
                } else {
                    this.month++;
                }
            }
            cantidadDias--;
        }
    }
    public boolean esBisiesto() {
        return esBisiesto(this.year);
    }
    //metodo static auxiliar para utilizar dentro de otros metodos propios de la clase
    private static boolean esBisiesto(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}
