import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Hilo extends Frame implements WindowListener, ActionListener {
    private TextArea a1, a2;
    private Button b;
    private Hilos h1, h2;

    public Hilo(){
        super("Manejo de Hilos");
        setLayout(new BorderLayout());

        a1 = new TextArea();
        a2 = new TextArea();
        a1.setEditable(false);
        a2.setEditable(false);
        b = new Button("Accion");
        b.addActionListener(this);

        h1 =  new Hilos(1000, a1);
        h2 =  new Hilos(2000, a2);

        h1.start();
        h2.start();

        add ("North", a1);
        add ("Center", a2);
        add ("South", b);

        setSize(300, 300);

        addWindowListener(this);
    }

    class Hilos extends Thread{
        private int tiempo, contador;
        private TextArea area;
        public boolean bandera;

        public Hilos(int t,TextArea ar){
            contador = 0;
            tiempo = t;
            area = ar;
            bandera= true;
        }

        public void cambiaBandera (){

            bandera = !bandera;
        }

        public synchronized  void play (){
            cambiaBandera();
            this.notify();
        }

        public void run (){
            while (true){
                if (!bandera) {
                    synchronized (this) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                area.append(contador+"\n");
                contador++;

                try {
                    sleep(tiempo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main (String[] args){
        Hilo h = new Hilo();
        h.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent arg0) {

    }

    @Override
    public void windowClosing(WindowEvent arg0) {

        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent arg0) {

    }

    @Override
    public void windowIconified(WindowEvent arg0) {

    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {

    }

    @Override
    public void windowActivated(WindowEvent arg0) {

    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (h1.bandera)
            h1.cambiaBandera();
        else
            h1.play();
    }
}
