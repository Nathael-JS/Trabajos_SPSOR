import java.util.Random;

public class Arreglo {
    public static void main (String[] args){
        char[] arreglo;

        Random r = new Random();
        int tam = r.nextInt(150);

        System.out.println("Tamaño: " + tam);

        if (tam == 0)
            tam = 1;
        arreglo =  new char [tam];

        String  abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < tam; i++)
            arreglo [i] = abc.charAt(r.nextInt(abc.length()));

        for (int i = 0; i < tam; i++)
            System.out.print(arreglo [i]);

        metodo (arreglo);

        System.out.println();

        for (int i = 0; i < tam; i++)
            System.out.print(arreglo [i]);
        
    }

    private static void metodo(char[] arreglo) {
        String cadenaX = "NOHUBOEXAMENELVIERNESPASADO";
        int espacio = arreglo.length;
        int i = 0;

        while (espacio > cadenaX.length()){
            for (int j = 0; j < cadenaX.length(); j++){
                arreglo [i] =  cadenaX.charAt(j);
                i++;
                espacio--;
            }
        }
    }
}
