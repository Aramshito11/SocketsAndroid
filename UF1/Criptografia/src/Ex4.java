import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Ex4 {
    private static byte[] concatenateArrays(byte[] a, byte[] b) {
        byte[] result = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static void main(String[] args) {
        String text = "aram mateos andres";

        try {
            SecureRandom saltSegur = new SecureRandom();
            byte[] salt = new byte[16];
            saltSegur.nextBytes(salt);

            byte[] bytes = concatenateArrays(salt, text.getBytes(StandardCharsets.UTF_8));

            MessageDigest instancia = MessageDigest.getInstance("SHA-512");
            byte[] hash = instancia.digest(bytes);

            StringBuilder hexString = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }

            String hashSHA512 = hexString.toString();

            System.out.println("Hash SHA-512 de \"" + text + "\" amb el salt: " + hashSHA512);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
