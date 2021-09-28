import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.StringWriter;

public abstract class Interfaz extends Frame implements WindowListener, ActionListener {
    private TextArea a;
    private  TextField c;
    private Button b1, b2, b3;

    public Interfaz() {
        super ("Titulo de la Ventana");
        setLayout (new BorderLayout());

        a = new TextArea();
        a.setEditable(false);
        c = new TextField();

        PanelBotnones pb = new PanelBotnones();

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        a.setEditable(false);


        add("Center", a);
        add("North", c);
        add("South", pb);

        addWindowListener(this);

        setSize(300,300);

    }

    public static  void main (String args[]) {
        Interfaz v = new Interfaz() {
        };
        v.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Object arg0 = null;
        String orden = arg0.getActionCommand();

        if (orden.equalsIgnoreCase("Boton 1"))
            a.append(c.getText() + "\n");

        if (orden.equalsIgnoreCase("Boton 2"))
            a.setText("");

        if (orden.equalsIgnoreCase("Boton 3")){
            c.setBackground(Color.BLUE);
            a.setBackground(Color.GRAY);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Ventana Abierta");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Ventana Cerrandose");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

        System.out.println("Ventana Cerrada");
    }

    @Override
    public void windowIconified(WindowEvent e) {

        System.out.println("Ventana Minimizada");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {

        System.out.println("Ventana Maximizada");
    }

    @Override
    public void windowActivated(WindowEvent e) {

        System.out.println("Ventana Activa");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

        System.out.println("Ventana Inactiva");
    }

    class PanelBotnones extends Panel {
        public PanelBotnones() {
            b1 = new Button("Boton 1");
            b2 = new Button("Boton 2");
            b3 = new Button("Boton 3");

            add(b1);
            add(b2);
            add(b3);

        }
    }

}
