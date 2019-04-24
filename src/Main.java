import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        System.out.println(factorial(100000L).divide(factorial(3L).multiply(factorial(99997L))));
    }

    public static BigInteger factorial(Long a) {
        BigInteger start = BigInteger.ONE;
        for (int i = 1; i <= a; ++i) {
            start = start.multiply(BigInteger.valueOf(i));
        }
        return start;
    }
}
