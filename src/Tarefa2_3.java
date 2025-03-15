import java.math.BigInteger;
import java.security.MessageDigest;

public class Tarefa2_3 {
    public static void main(String[] args) {
        try {
            // Valor de v obtido na Tarefa 2.2
            BigInteger v = new BigInteger("78685183267910677780433639448588977254543122711284202682582");  // Substitua pelo valor gerado

            // Converter v para bytes
            byte[] vBytes = v.toString().getBytes("UTF-8");

            // Calcular SHA256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(vBytes);

            // Pegar os primeiros 128 bits (16 bytes) e convertê-los para hexadecimal
            StringBuilder chaveK = new StringBuilder();
            for (int i = 0; i < 16; i++) {
                chaveK.append(String.format("%02x", hash[i]));
            }

            System.out.println("Chave k (128 bits): " + chaveK.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
