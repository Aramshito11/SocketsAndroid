import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        String texto = "Hola caracola";

        try {
            MessageDigest sha256Digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = sha256Digest.digest(texto.getBytes());
            byte[] claveAESBytes = Arrays.copyOf(hash, 16);

            SecretKey claveAES = new SecretKeySpec(claveAESBytes, "AES");
            byte[] claveHexBytes = claveAES.getEncoded();
            StringBuilder claveHexadecimal = new StringBuilder();
            for (byte b : claveHexBytes) {
                String hex = String.format("%02x", b);
                claveHexadecimal.append(hex);
            }

            System.out.println("Clave AES en hexadecimal: " + claveHexadecimal);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
