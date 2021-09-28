public class Parametros {

    public static void main (String[] args){
        Parametros p = new Parametros();
        short corto = 12357; //0x090A
        int entero = 123547854; //0x080C0D0E
        long largo = 0x0504570570698045L;

        byte[] shortEmpaquetado = p.empaqueta(corto);

        for (int i= 0; i < shortEmpaquetado.length; i++)
            System.out.print(shortEmpaquetado[i]+" ");

        byte[] ent = p.empaqueta(entero);

        System.out.println();
        for (int i = 0; i < ent.length; i++)
            System.out.print(ent[1]+" ");

        byte[] larg = p.empaqueta(largo);

        System.out.println();
        for (int i = 0; i < larg.length; i++)
            System.out.print(larg[1]+" ");

        short cortoArmado = p.rearmaCorto (shortEmpaquetado);
        System.out.println("\nCorto Rearmado: "+cortoArmado);

        int entertoArmado = p.rearmaEntero(ent);
        System.out.println("Entero Rearmado: "+entertoArmado);

        long largooArmado = p.rearmaLargo(larg);
        System.out.println("Largo Rearmado: "+largooArmado);

    }

    private int rearmaEntero(byte[] ent) {
        int aux;
        int valor = 0;

        for (int i = 3;i >= 0; i--){
            valor = valor<<8;

            aux = ent[i];
            aux = aux & 0x000000FF;
            valor = aux|valor;
        }

        return valor;
    }

    private long rearmaLargo(byte[] ent) {
        long aux;
        long valor = 0;

        for (int i = 7;i >= 0; i--){
            valor = valor<<8;

            aux = ent[i];
            aux = aux & 0x00000000000000FFL;
            valor = aux|valor;
        }

        return valor;
    }

    private short rearmaCorto(byte[] shortEmpaquetado) {
        int aux;
        short valor = 0;

        aux = shortEmpaquetado[1];
        aux = aux & 0x00FF;

        valor = (short) (aux|valor);
        valor = (short) (valor<<8);

        aux = shortEmpaquetado[0];
        aux = aux & 0x00FF;

        valor = (short) (aux|valor);

        return valor;
    }

    private byte[] empaqueta(int entero) {
        byte[] ent = new byte[4];

        for (int i = 0; i <ent.length; i++){
            ent[i] = (byte) entero;
            entero = entero>>>8;
        }

        return ent;
    }

    private byte[] empaqueta(long largo) {
        byte[] larg = new byte[8];

        for (int i = 0; i <larg.length; i++){
            larg[i] = (byte) largo;
            largo = largo>>>8;
        }

        return larg;
    }

    private byte[] empaqueta(short corto) {
        byte[] num = new byte[2];
        num[0] = (byte) corto;
        num[1] = (byte) (corto>>>8);

        return num;
    }
}
