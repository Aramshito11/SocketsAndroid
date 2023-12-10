import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex6 {
    public static void registrarUsuario(String usuario, String contrasena) {
        byte[] salto = generarSaltoAleatorio();

        byte[] saltedPassword = concatenateArrays(salto, contrasena.getBytes(StandardCharsets.UTF_8));

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] hashedPassword = digest.digest(saltedPassword);

            String hashHex = bytesToHex(hashedPassword);

            guardarEnBaseDeDatos(usuario, bytesToHex(salto), hashHex);
        } catch (NoSuchAlgorithmException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static byte[] generarSaltoAleatorio() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salto = new byte[16];
        secureRandom.nextBytes(salto);
        return salto;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            String hex = String.format("%02x", b);
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static void guardarEnBaseDeDatos(String usuario, String salto, String hash) throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/UF1CriptoAramMateosAndres";
        String dbUser = "root";
        String dbPassword = "nose";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String sql = "INSERT INTO usuarios (usuario, salto, hash) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, usuario);
                preparedStatement.setString(2, salto);
                preparedStatement.setString(3, hash);
                preparedStatement.executeUpdate();
            }
        }
    }

    private static byte[] concatenateArrays(byte[] a, byte[] b) {
        byte[] result = new byte[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static void main(String[] args) {
        String usuario = "aram";
        String contrasena = "patata";
        registrarUsuario(usuario, contrasena);
    }

}
