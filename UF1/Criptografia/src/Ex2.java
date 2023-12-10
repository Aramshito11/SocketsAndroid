import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ex2 {
    public static void main(String[] args) {
        String texto = "aram mateos andres";

        try {
            MessageDigest instancia = MessageDigest.getInstance("SHA-512");

            byte[] bytes = texto.getBytes(StandardCharsets.UTF_8);

            byte[] hash = instancia.digest(bytes);

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            String hashSHA512 = hexString.toString();

            System.out.println("Hash SHA-512 de \"" + texto + "\": " + hashSHA512);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
