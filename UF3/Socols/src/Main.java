import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        SocketUDP socket1 = new SocketUDP(1234, 4321);
        SocketUDP socket2 = new SocketUDP(4321, 1234);


        String missatge1 = "Hola, sòcol 2!";
        String adrecaDesti1 = "localhost";

        socket1.enviarMissatge(adrecaDesti1, missatge1);
        socket2.rebreMissatge();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String missatge = scanner.nextLine();
            if (missatge.equals("/")) {
                break;
            }
        }



        SocketUDP socket1 = new SocketUDP(5555, 5555);
        SocketUDP socket2 = new SocketUDP(5555, 5555);


        String missatge1 = "Hola, sòcol 2!";
        String adrecaDesti1 = "localhost";

        socket1.enviarMissatgeMultisocket(adrecaDesti1, missatge1);
        socket2.rebreMissatgeMultiSocket();

         */


        SocketTCPServidor servidor = new SocketTCPServidor();
        SocketTCPClient client = new SocketTCPClient();
    }
}