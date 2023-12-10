import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketTCPClient {
    public static void main(String[] args) {
        final String servidorIP = "localhost";
        final int port = 12345;

        try {
            Socket clientSocket = new Socket(servidorIP, port);
            System.out.println("Connectat al servidor " + servidorIP + " al port " + port);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String missatgeAEnviar = "Aquest és un missatge de prova del client";
            out.println(missatgeAEnviar);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String respostaServidor = in.readLine();
            System.out.println("Resposta del servidor: " + respostaServidor);

            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
