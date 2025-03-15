import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;

public class Tarefa1_1 {
    public static void main(String[] args) {
        try {
            // Dados fornecidos no enunciado
            String chaveHex = "240B31B44A27BEC5062B3A74C63271A4";
            String ivHex = "C4AB0DF3D808D72AAADBC68206483B18";
            String textoCifradoHex = "EF794476D605765572683CE849FBD4555CE8EC1382019662E277F31B8035E2857"
                    + "87C1DA9D2CC5B3441F5CB900C41BA70902A932209C3966B83FB4387ABBC95E0";

            // Converter hexadecimal para bytes
            byte[] chave = hexStringToByteArray(chaveHex);
            byte[] iv = hexStringToByteArray(ivHex);
            byte[] textoCifrado = hexStringToByteArray(textoCifradoHex);

            // Configurar o objeto de descriptografia
            SecretKeySpec chaveSecreta = new SecretKeySpec(chave, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, chaveSecreta, ivSpec);

            // Descriptografar
            byte[] textoClaro = cipher.doFinal(textoCifrado);
            String resultado = new String(textoClaro, "UTF-8");

            // Imprimir o resultado
            System.out.println("Texto claro (UTF-8): " + resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para converter hexadecimal para bytes
    public static byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i+1), 16));
        }
        return data;
    }
}
