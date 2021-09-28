import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrador {

    private static Integer contador;
    private Hashtable <Integer, Materia> tabla;
    //private int contador;

    static class Materia{
        public String clave, nombre;
        public Materia (String c, String n){
            clave = c;
            nombre = n;
        }
    }

    public Administrador(){
        tabla = new Hashtable <Integer, Materia> ();
        contador = 1;
    }

    public static void main (String[] args) {
        Administrador ca = new Administrador();
        Scanner s = new Scanner(System.in);

        ca.alta("I7029", "SISTEMAS OPERATIVOS");
        ca.alta("I7030", "SEMINARIO DE SISTEMAS OPERATIVOS");
        ca.alta("I7033", "SISTEMAS OPERATIVOS DE RED");
        ca.alta("I7024", "SEMINARIO DE SISTEMAS OPERATIVOS DE RED");

        int salir = 0;
        try {
            while (salir != 5) {
                System.out.println("Que desea hacer: ");
                System.out.println("1. Alta de materia");
                System.out.println("2. Consultar materia");
                System.out.println("3. Baja de materia");
                System.out.println("4. Imprimir Tabla");
                System.out.println("5. Salir");
                int opcion = 0;

                opcion = s.nextInt();

                switch (opcion) {
                    case 1: {
                        System.out.println("Dame la clave de la Materia: ");
                        String clave = s.next();

                        System.out.println("Dame el nombre de la Materia: ");
                        String nombre = s.next();

                        int idSecuencial = ca.alta(clave, nombre);
                        break;
                    }
                    case 2: {
                        System.out.println("Dame el ID de la Materia a Consultar: ");
                        int id = s.nextInt();

                        Materia m = ca.consulta(id);

                        if (m == null) {
                            System.out.println("Esa Materia no existe!" );
                            System.out.println("Por favor Verifique de nuevo el ID.2");
                        }
                        else {

                            System.out.println("Clave de la materia consultada: " + m.clave);
                            System.out.println("Nombre de la materia consultada: " + m.nombre);
                        }

                        break;
                    }
                    case 3: {
                        System.out.println("Dame el ID de la Materia a Eliminar: ");
                        int id = s.nextInt();

                        ca.baja(id);

                        System.out.println("Materia Eliminada.");

                        break;
                    }
                    case 4: {
                        ca.imprimeTabla();

                        break;
                    }
                    case 5: {
                        salir = 5;

                        break;
                    }
                    default: {
                        System.out.println("Opcion Incorrecta! - Vuelva a intentarlo.");

                        break;
                    }
                }
            }
        }
        catch(InputMismatchException e){
            System.out.println("Ese dato no es valido");
        }
    }

    private void baja(int id) {
        tabla.remove(id);
        imprimeTabla();
    }

    private Materia consulta(int id) {
        Materia m = tabla.get(id);

        return m;
    }

    private int alta(String clave, String nombre) {
        Materia m = new Materia(clave,nombre);
        tabla.put(contador, m);

        imprimeTabla();

        return contador++;
    }

    private void imprimeTabla() {
        Enumeration <Integer> llaves = tabla.keys();
        Enumeration <Materia> datos = tabla.elements();

        System.out.println("ID_Sec | Clave | Nombre Materoia ");

        while (llaves.hasMoreElements()){
            Materia m =  datos.nextElement();
            System.out.println(llaves.nextElement() + "      | " + m.clave + " | " + m.nombre);
        }
    }
}
