import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class Tarefa1_2 {
    public static void main(String[] args) {
        try {
            // Chave fornecida para AES
            String chaveHex = "33A18467DB4AF474B051523A73DDA955";
            byte[] chaveBytes = hexStringToByteArray(chaveHex);

            // Texto claro (seu nome completo, exemplo: "Guilherme Martins")
            String textoClaro = "Guilherme Martins";

            // IV (contador aleatório, exemplo gerado)
            String ivHex = "4F8C9A7F4B2C0D4A6E1F9E56B9B2D74E";
            byte[] ivBytes = hexStringToByteArray(ivHex);

            // Criar chave secreta a partir da chave hex fornecida
            SecretKeySpec chave = new SecretKeySpec(chaveBytes, "AES");

            // Criar o IV (counter) a partir do IV hex fornecido
            IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

            // Configurar o algoritmo AES em modo CTR
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, chave, ivSpec);

            // Cifrar o texto claro
            byte[] textoCifradoBytes = cipher.doFinal(textoClaro.getBytes("UTF-8"));

            // Converter o texto cifrado para hexadecimal
            String textoCifradoHex = byteArrayToHexString(textoCifradoBytes);

            // Exibir o IV e o texto cifrado em hexadecimal
            System.out.println("IV (Counter) em hexadecimal: " + ivHex);
            System.out.println("Texto Cifrado em hexadecimal: " + textoCifradoHex);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Função para converter uma string hexadecimal para um array de bytes
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    // Função para converter um array de bytes para uma string hexadecimal
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