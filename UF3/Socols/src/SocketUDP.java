import java.net.*;

public class SocketUDP {
    private int portEnviar;
    private int portEscoltar;

    public SocketUDP(int portEnviar, int portEscoltar){
        this.portEnviar = portEnviar;
        this.portEscoltar = portEscoltar;
    }

    public int getPortEnviar() {
        return portEnviar;
    }

    public void setPortEnviar(int portEnviar) {
        this.portEnviar = portEnviar;
    }

    public int getPortEscoltar() {
        return portEscoltar;
    }

    public void setPortEscoltar(int portEscoltar) {
        this.portEscoltar = portEscoltar;
    }

    public void enviarMissatge(String ip, String missatge){
        try {
            DatagramSocket socket = new DatagramSocket();

            byte[] mensaje = missatge.getBytes();

            InetAddress adrecaDesti = InetAddress.getByName(ip);
            DatagramPacket paquet = new DatagramPacket(mensaje, mensaje.length, adrecaDesti, portEnviar);

            socket.send(paquet);

            System.out.println("Misatge enviat correctament");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enviarMissatgeMultisocket(String ip, String missatge){
        try {
            MulticastSocket socket = new MulticastSocket(portEnviar);

            byte[] mensaje = missatge.getBytes();

            InetAddress adrecaDesti = InetAddress.getByName(ip);
            DatagramPacket paquet = new DatagramPacket(mensaje, mensaje.length, adrecaDesti, portEnviar);

            socket.send(paquet);

            System.out.println("Misatge enviat correctament");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rebreMissatge() {
        try {
            DatagramSocket socket = new DatagramSocket(portEscoltar);
            socket.setSoTimeout(3000);

            byte[] buffer = new byte[1024];
            DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);

            socket.receive(paquet);

            String missatge = new String(paquet.getData(), 0, paquet.getLength());
            InetAddress adrecaEnviador = paquet.getAddress();
            int portEnviador = paquet.getPort();

            System.out.println("Missatge rebut: " + missatge);
            System.out.println("IP de l'enviador: " + adrecaEnviador.getHostAddress());
            System.out.println("Port de l'enviador: " + portEnviador);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rebreMissatgeMultiSocket() {
        try {
            MulticastSocket socket = new MulticastSocket(portEscoltar);

            NetworkInterface net = NetworkInterface.getByName("localhost");

            InetSocketAddress group = new InetSocketAddress(InetAddress.getByName("localhost"), portEscoltar);
            socket.joinGroup(group, net);

            byte[] buffer = new byte[1024];
            DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);

            socket.receive(paquet);

            String missatge = new String(paquet.getData(), 0, paquet.getLength());
            InetAddress adrecaEnviador = paquet.getAddress();
            int portEnviador = paquet.getPort();

            System.out.println("Missatge rebut: " + missatge);
            System.out.println("IP de l'enviador: " + adrecaEnviador.getHostAddress());
            System.out.println("Port de l'enviador: " + portEnviador);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
