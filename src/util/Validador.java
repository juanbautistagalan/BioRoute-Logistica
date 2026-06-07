package util;
public class Validador { public static boolean textoNoVacio(String texto){return texto!=null && !texto.trim().isEmpty();} public static boolean numeroPositivo(int numero){return numero>0;} public static boolean precioValido(double precio){return precio>=0;} }
