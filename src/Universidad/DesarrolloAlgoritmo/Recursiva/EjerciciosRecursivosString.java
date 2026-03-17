package Universidad.DesarrolloAlgoritmo.Recursiva;

public class EjerciciosRecursivosString{
    public static void main(String[] args) {
        /*System.out.println(comprimirTextoRLE("abcaaabbbba",0));
        */
        int num = 2232;
        if(esPalindromoEntero(num,contarDigitos(num))){
            System.out.println("El número ingresado "+num+", es palindromo.");
        }else{
            System.out.println("El número ingresado "+num+", no es palindromo.");
        }
        /*
        String cadena = "Radar";
        if(esPalindromo(cadena.toLowerCase(),0,cadena.length()-1)){
            System.out.println("El texto ingresado es palindromo");
        }else{
            System.out.println("El texto ingresado no es palindromo");
        }
        System.out.println("La cantidad de palabras ingresadas es: "+contarPalabras(palabras+" ",0));
        String palabras = "Hola mundo, como estas?.";
        String patron = "";
        if(containsCasero(palabras,patron,0,0)){
            System.out.println("El string "+palabras+" contiene al string "+patron);
        }else{
            System.out.println("El string "+palabras+" no contiene al string "+patron);
        }
        String oracion = "Hola comocomocomo estascomo como";
        String subCadena = "como";
        System.out.println("La cantidad de veces que "+subCadena+" se repite en "+oracion+" es de "+contarSubcadenas(oracion,subCadena,0,0));
        String terminaCon = "Hola mundo";
        String subTerminaCon = "mundo";
        if(endsWith(terminaCon,subTerminaCon,terminaCon.length()-1,subTerminaCon.length()-1)) {
            System.out.println("El string "+terminaCon+" termina con la subcadena "+subTerminaCon);
        }else{
            System.out.println("El string "+terminaCon+" no termina con la subcadena "+subTerminaCon);
        }
        String repetidos = "ccccaaaaabbcccccqcc";
        System.out.println(eleminarCaracteresConsecutivos(repetidos,0));
        String secuencia = "programacion";
        String subSecuencia = "pam";
        if(esSubsecuencia(secuencia,subSecuencia,0,0)){
            System.out.println("La secuencia "+secuencia+" tiene como subsecuencia a "+subSecuencia);
        }else{
            System.out.println("La secuencia "+secuencia+" no tiene como subsecuencia a "+subSecuencia );
        }
        */
    }
    public static String comprimirTextoRLE(String texto, int i){
        char aux;
        int cantidad;
        String resultado="";
        if(i<texto.length()){
            aux = texto.charAt(i);
            cantidad = contarRepeticiones(texto,aux,i);
            if(cantidad<texto.length()){
                resultado = aux+""+cantidad+comprimirTextoRLE(texto,i+cantidad);
            }else{
                resultado = aux+""+cantidad;
            }
        }
        return resultado;
    }
    public static int contarRepeticiones(String texto, char caracter, int i) {
        int contador = 0;
        char aux;
        if(i<texto.length()){
            aux = texto.charAt(i);
            if(aux==caracter){
                contador = 1 + contarRepeticiones(texto,caracter,i+1);
            }
        }
        return contador;
    }
    public static int contarDigitos(int num){
        int cantidad;
        if(num/10==0){
            cantidad = 1;
        }else{
            cantidad = 1+contarDigitos(num/10);
        }
        return cantidad;
    }
    public static boolean esPalindromoEntero(int num, int cantDigitos){
        boolean esPalindromo = false;           //boolean bandera que indica si el numero es palindromo o no, es lo que se retorna
        int cantActual = contarDigitos(num);    //cantidad de digitos del numero actualmente
        int multiplicador = (int) Math.pow(10, cantDigitos-1);
        int numRecursivo=num;

        if(cantActual != cantDigitos){    //comparo la cantodad de digitos actual con la que deberia de haber, para saber si habia un cero adelante
            if (num % 10 == 0) {          //en caso de haber un cero adelante considero el caso en el que siga siendo palindromo. Ej:
                esPalindromo = true;      //mas adelante se utiliza como condicion para seguir haciendo la llamada recursiva
                numRecursivo = num/10;    //le saco el cero del principio para poder seguir con los siguientes digitos en la siguiente llamada recursiva. Ej: 101101 => 110 => 11
            }
        }else{
            if (num / multiplicador == num % 10) {      //comparo el primer digito con el ultimo
                esPalindromo = true;
                numRecursivo = (num%multiplicador)/10;  //acomodo el numero para la siguiente llamada recursiva sacando el primer e ultimo digito
            }
        }
        if(esPalindromo&&cantDigitos>1){    //solo se realiza la llamada si esPalindromo es verdad, caso contrario no tiene sentido seguir realizando llamadas porque ya sabemos que es falso
            //tambien se debe cumplir que la cantidad de digitos sea mayor a 1, porque ya sea un numero de cantidad de digitos impar o no queden mas numeros, se deben de terminar las llamadas recursivas
            esPalindromo = esPalindromoEntero(numRecursivo,cantDigitos-2);  //se realiza la llamada recursiva con el numero ya recortado y restandole dos a la cantidad de digitos
        }
        return esPalindromo;
    }
    public static boolean esPalindromo(String texto, int ini, int fin){
        boolean esPalindromo = true;
        if(ini<fin){
            if(texto.charAt(ini)==texto.charAt(fin)){
                esPalindromo = esPalindromo(texto,ini+1,fin-1);
            }else{
                esPalindromo = false;
            }
        }
        return esPalindromo;
    }
    public static int contarPalabras(String texto, int i){
        int contador = 0;
        char aux = ' ';
        if(i<texto.length()-1){
            if(texto.charAt(i)!=aux&&texto.charAt(i+1)==aux){
                contador = 1 + contarPalabras(texto,i+1);
            }else{
                contador = contarPalabras(texto,i+1);
            }
        }
        return contador;
    }
    public static boolean containsCasero(String texto, String patron, int i, int j){
        boolean contains = false;
        if(i<texto.length() && j<patron.length()){
            if(texto.charAt(i)==patron.charAt(j)){
                contains = containsCasero(texto, patron, i + 1, j + 1);
            }else{
                contains = containsCasero(texto,patron,i+1,0);
            }
        }else if(j>=patron.length()){
            contains = true;
        }
        return contains;
    }
    public static int contarSubcadenas(String texto, String patron, int i, int j){
        int contador = 0;
        if(i<texto.length() && j<patron.length()){
            if(texto.charAt(i)==patron.charAt(j)){
                contador = contador + contarSubcadenas(texto, patron, i + 1, j + 1);
            }else{
                contador = contador + contarSubcadenas(texto, patron, i + 1, 0);
            }
        }else if(j>=patron.length() && i<=texto.length()){
            contador = contador + 1 + contarSubcadenas(texto, patron, i, 0);
        }
        return contador;
    }
    public static boolean endsWith(String texto, String patron, int i, int j){
        boolean terminaCon;
        if(i>=0 && j >=0){
            if(texto.charAt(i)==patron.charAt(j)){
                terminaCon = endsWith(texto,patron,i-1,j-1);
            }else{
                terminaCon = false;
            }
        }else{
            terminaCon = true;
        }
        return terminaCon;
    }
    public static String eleminarCaracteresConsecutivos(String cadena, int i){
        String sinRepetidos;
        if(i<cadena.length()-1){
            if(cadena.charAt(i)==cadena.charAt(i+1)){
                sinRepetidos = eleminarCaracteresConsecutivos(cadena.substring(0,i)+cadena.substring(i+1),i);
            }else{
                sinRepetidos = eleminarCaracteresConsecutivos(cadena,i+1);
            }
        }else{
            sinRepetidos = cadena;
        }
        return sinRepetidos;
    }
    public static boolean esSubsecuencia(String texto, String patron, int i, int j){
        boolean esSubsec = false;
        if(i<texto.length() && j<patron.length()){
            if(texto.charAt(i)==patron.charAt(j)){
                esSubsec = esSubsecuencia(texto,patron,i+1,j+1);
            }else{
                esSubsec = esSubsecuencia(texto,patron,i+1,j);
            }
        } else if (j>= patron.length()) {
            esSubsec = true;

        }
        return esSubsec;
    }
    //public static int cadConsecutivaMayor(String texto, int i, int mayor){

    //}
}
