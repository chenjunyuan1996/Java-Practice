/**
 * This program shows how to store tabular data in a 2D array.
 * P87
 */
import java.util.*;

public class CompoundInterest {
    public static void main(String[] args) {
        // final 表示常数
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;

        // set interest rates to 10 ... 15%
        double[] interestRate = new double[NRATES];
        for (int j = 0; j < interestRate.length; j++)
            interestRate[j] = (STARTRATE + j) / 100;

        double[][] balances = new double[NYEARS][NRATES];

        // set initial balance to 10000
        /*for (int j = 0; j < balances[0].length; j++)
            balances[0][j] = 10000;*/
        Arrays.fill(balances[0], 10000);

        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++)
                balances[i][j] = balances[i - 1][j] * (interestRate[j] + 1);
        }

        for (int j = 0; j < interestRate.length; j++)
            System.out.printf("%9.0f%%", 100 * interestRate[j]);

        System.out.println();

        for (double[] row : balances) {
            for (double element : row)
                System.out.printf("%10.2f", element);
            System.out.println();
        }
    }
}
