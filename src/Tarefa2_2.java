import java.math.BigInteger;

public class Tarefa2_2 {
    public static void main(String[] args) {
        BigInteger p = new BigInteger("1041607122029938459843911326429539139964006065005940226363139");
        BigInteger A = new BigInteger("105008283869277434967871522668292359874644989537271965222162");

        // Valor de b obtido na Tarefa 2.1
        BigInteger b = new BigInteger("613868968585053812715713601158506120704");  // Substitua pelo valor gerado na parte 2_1

        // Calculando v = A^b mod p
        BigInteger v = A.modPow(b, p);

        System.out.println("Valor de v: " + v);
    }
}
