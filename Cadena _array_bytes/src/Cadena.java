public class Cadena {

    public static void main (String[] args){
        byte[] arreglo;

        String cadena = "Hoy es viernes 3 de septiembre y estoy haciendo tarea";
        arreglo = new byte [cadena.length() + 1];
        byte[] arre = cadena.getBytes();
        arreglo[0] = (byte) cadena.length();

        System.arraycopy(arre, 0, arreglo, 1, cadena.length());

        for (int i = 0; i < arreglo.length; i++)
            System.out.print("" + arreglo [1] + "");

        System.out.println();

        metodo (arreglo);
    }

    private static void metodo(byte[] arreglo) {
        String armada = new String(arreglo, 1, arreglo[0]);
        System.out.println("Cadena rearmada: " + armada);
        
    }

}
