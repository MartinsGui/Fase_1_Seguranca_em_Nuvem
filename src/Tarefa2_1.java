import java.math.BigInteger;
import java.security.SecureRandom;

public class Tarefa2_1 {
    public static void main(String[] args) {
        BigInteger p = new BigInteger("1041607122029938459843911326429539139964006065005940226363139");
        BigInteger g = BigInteger.TEN;

        // Gerando um valor aleatório b com pelo menos 40 dígitos e menor que p
        SecureRandom random = new SecureRandom();
        BigInteger b = new BigInteger(130, random).mod(p);

        // Calculando B = g^b mod p
        BigInteger B = g.modPow(b, p);

        System.out.println("Valor de b: " + b);
        System.out.println("Valor de B: " + B);
    }
}
