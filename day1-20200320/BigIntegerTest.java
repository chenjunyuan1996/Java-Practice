import java.math.*;
import java.util.*;

public class BigIntegerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.println("What is the highest number?");
        int n = in.nextInt();

        BigInteger lotteryOdds = BigInteger.valueOf(1);
        for (int i = 1; i <= k; i++)
            lotteryOdds = lotteryOdds.divide(BigInteger.valueOf(i)).multiply(BigInteger.valueOf(n - i + 1));

        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
    }
}
