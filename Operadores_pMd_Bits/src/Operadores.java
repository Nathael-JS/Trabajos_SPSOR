public class Operadores {

    public static void main (String args[]){
        Operadores c = new Operadores();

            byte b = (byte) 0xF3;
            short s = (short) 0xAA7A;
            int e = 0x7A7A7A7A;
            long l = 0x7A7A7A7A7A7A7A7Al;

            c.convierte (b);
            c.convierte (s);
            c.convierte (e);
            c.convierte (l);

    }

    private void convierte(byte b) {
        int aux = 0x80;

        //System.out.print("|");

        for (int i = 0; i < 8; i++){

            if (i % 8 == 0)
                System.out.print("|");
            if ((b & aux ) == 0)
                System.out.print("0");
            else
                System.out.print("1");
            aux = aux >>> 1;

        }
        System.out.print("|");
        System.out.println();
    }
    private void convierte(short s) {
        int aux = 0x8000;

        //System.out.print("|");

            for (int i = 0; i < 16; i++){

                if (i % 8 == 0)
                    System.out.print("|");
                if ((s & aux ) == 0)
                    System.out.print("0");
                    else
                        System.out.print("1");
                    aux = aux >>> 1;

            }
        System.out.print("|");
        System.out.println();
    }
    private void convierte(int e) {
        int aux = 0x80000000;

        //System.out.print("|");

        for (int i = 0; i < 32; i++){

            if (i % 8 == 0)
                System.out.print("|");
            if ((e & aux ) == 0)
                System.out.print("0");
            else
                System.out.print("1");
            aux = aux >>> 1;

        }
        System.out.print("|");
        System.out.println();
    }
    private void convierte(long l) {
        long aux = 0x8000000000000000l;

        //System.out.print("|");

        for (int i = 0; i < 64; i++){

            if (i % 8 == 0)
                System.out.print("|");
            if ((l & aux ) == 0)
                System.out.print("0");
            else
                System.out.print("1");
            aux = aux >>> 1;

        }
        System.out.print("|");
        System.out.println();
    }
}
