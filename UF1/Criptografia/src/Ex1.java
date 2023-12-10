import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class Ex1 {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");

        keyGenerator.init(56);

        SecretKey clau = keyGenerator.generateKey();

        byte[] clauBytes = clau.getEncoded();

        String clauBase64 = Base64.getEncoder().encodeToString(clauBytes);

        System.out.println("Clau DES en Base64: " + clauBase64);
    }
}
