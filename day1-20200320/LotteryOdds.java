import java.util.*;

public class LotteryOdds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many numbers do you need to draw?");
        int k = in.nextInt();
        System.out.println("What is the highest number you can draw?");
        int n = in.nextInt();

        int lotteryodds = 1;
        for (int i = 0; i < k; i++)
            lotteryodds = lotteryodds * (n - i) / (i + 1);
        System.out.println("Your odds are 1 in " + lotteryodds);
    }
}
