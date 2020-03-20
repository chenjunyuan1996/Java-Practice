/**
 * This program demonstrates a triangular array.
 * @author chen
 * P90
 */

public class LotteryArray {
    public static void main(String[] args) {
        final int NMAX = 10;
        // allocate triangular array
        int[][] odds = new int[NMAX][];
        for (int i = 0; i < NMAX; i++)
            odds[i] = new int[i + 1];

        // fill the array
        for (int i = 0; i < odds.length; i++) {
            for (int j = 0; j < odds[i].length; j++) {
                int lotteryOdds = 1;
                for (int k = 1; k <= j; k++)
                    lotteryOdds = lotteryOdds * (i - k + 1) / k;
                odds[i][j] = lotteryOdds;
            }
        }

        // print triangular array
        for (int[] row : odds) {
            for (int element : row)
                System.out.printf("%4d", element);
            System.out.println();
        }
    }
}
