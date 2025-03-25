import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Tarefa1_2 {
    public static void main(String[] args) {
        try {
            // Chave fornecida (em hexadecimal)
            String chaveHex = "33A18467DB4AF474B051523A73DDA955";
            byte[] chaveBytes = hexStringToByteArray(chaveHex);

            // Texto claro (seu nome completo)
            String textoClaro = "Guilherme Martins";

            // IV aleatório (exemplo gerado)
            String ivHex = "4F8C9A7F4B2C0D4A6E1F9E56B9B2D74E";
            byte[] ivBytes = hexStringToByteArray(ivHex);

            // 🚀 Ajustar o tamanho do texto para ser múltiplo de 16 bytes (com espaços)
            int blockSize = 16;
            while (textoClaro.getBytes(StandardCharsets.UTF_8).length % blockSize != 0) {
                textoClaro += " ";
            }

            // Criar a chave secreta
            SecretKeySpec chave = new SecretKeySpec(chaveBytes, "AES");

            // Criar o IV (contador) a partir do IV hex fornecido
            IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

            // Configurar o algoritmo AES em modo CTR
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, chave, ivSpec);

            // Cifrar o texto claro
            byte[] textoCifradoBytes = cipher.doFinal(textoClaro.getBytes(StandardCharsets.UTF_8));

            // Converter o texto cifrado para hexadecimal
            String textoCifradoHex = byteArrayToHexString(textoCifradoBytes);

            // Exibir os resultados
            System.out.println("IV (Counter) em hexadecimal: " + ivHex);
            System.out.println("Texto Cifrado em hexadecimal: " + textoCifradoHex);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Função para converter string hexadecimal para array de bytes
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    // Função para converter array de bytes para string hexadecimal
    public static String byteArrayToHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString().toUpperCase();
    }
}
