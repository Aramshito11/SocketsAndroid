import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServidor {
    public static void main(String[] args) {
        final int port = 12345;

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Servidor en línia. Esperant connexions...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connectat des de: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String missatgeRebut = in.readLine();
            System.out.println("Missatge rebut del client: " + missatgeRebut);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String respostaServidor = "Aquesta és una resposta del servidor";
            out.println(respostaServidor);

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
