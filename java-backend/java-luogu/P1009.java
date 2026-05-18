import java.util.Scanner;
import java.math.BigInteger;

public class P1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigInteger sum = BigInteger.ZERO;
        BigInteger fact = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
            sum = sum.add(fact);
        }

        System.out.println(sum);
    }
}