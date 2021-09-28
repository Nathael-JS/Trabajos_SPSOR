public class Proceso {

    public static void main (String[] args){

        Proceso p = new Proceso();
        int valor = 7;
        int[] arr = new int[1];
        arr[0] = valor;

        p.pValor(valor, valor);
        System.out.println("Valor en Main= " + valor);

        p.pReferencia(arr, arr);
        System.out.println("Valor en Main= " + arr[0]);
    }

    private void pReferencia(int[] arr, int[] arr1) {
        arr[0] = arr[0]*arr1[0];
        System.out.println("Valor = " + arr[0]);

        arr1[0] = arr[0]-arr1[0];
        System.out.println("Valor2 = " + arr1[0]);
    }

    private void pValor(int valor, int valor2) {
        valor = valor*valor2;
        System.out.println("Valor = " + valor);

        valor2 = valor-valor2;
        System.out.println("Valor2 = " + valor2);
    }
}
