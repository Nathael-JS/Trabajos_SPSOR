import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Chat extends Frame implements WindowListener, ActionListener{

    private TextField campoIP;
    private TextField campoMensaje;
    private TextArea areaChat;
    private Button b;
    private Receptor ar;

    public Chat (){
        super ("Chat version PREMIUM");
        setLayout(new BorderLayout());

        areaChat = new TextArea();
        areaChat.setEditable(false);

        ar = new Receptor();
        ar.start();

        b = new Button("Enviar");
        b.addActionListener(this);
        PanelSuperior ps = new PanelSuperior();

        add ("North", ps);
        add ("Center", areaChat);
        add ("South", b);

        addWindowListener(this);
        setSize(500, 500);

    }

    class PanelSuperior extends Panel{
        public PanelSuperior (){
            add (new Label("IP: "));
            campoIP = new TextField(16);
            add (campoIP);

            add (new Label("Mensaje: "));
            campoMensaje = new TextField(25);
            add (campoMensaje);
        }
    }

    class Receptor extends Thread{
        private DatagramSocket socketRecepcion;

        public void run (){
            int puertoEntrada = 3122; //al usar el otro chat, usar el puerto 3123
            DatagramPacket dp;

            try {
                socketRecepcion = new DatagramSocket(puertoEntrada);
                byte[] buffer = new byte[1024];

                dp = new DatagramPacket(buffer, buffer.length);

                while(true){
                    try {
                        socketRecepcion.receive(dp);
                        areaChat.append("IP emsora: "+dp.getAddress().getHostAddress()+": ");
                        areaChat.append((new String(buffer, 0, dp.getLength()))+"\n");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main (String[] args){
        Chat ventanaChat = new Chat();
        ventanaChat.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ip = campoIP.getText();
        String mensaje = campoMensaje.getText();

        byte[] buffer;
        buffer = mensaje.getBytes();

        try {
            DatagramSocket socketEmision = new DatagramSocket();
            DatagramPacket dp;
            try {
                dp = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), 3122);
                try {
                    socketEmision.send(dp);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                socketEmision.close();
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
    }
}
