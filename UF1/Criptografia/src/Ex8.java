import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class Ex8 {
    public static KeyPair generarParClavesAsimetricas() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

            keyPairGenerator.initialize(2048);

            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            return keyPair;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        KeyPair parClaves = generarParClavesAsimetricas();

        if (parClaves != null) {
            System.out.println("Claus generades");
            System.out.println("Clau publica: " + parClaves.getPublic());
            System.out.println("Clau privada: " + parClaves.getPrivate());
        } else {
            System.out.println("Error al generar les claus");
        }
    }
}
