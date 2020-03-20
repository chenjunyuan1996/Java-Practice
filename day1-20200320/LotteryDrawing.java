import java.util.*;

/**
 * This program demostrate array manipulation
 * @version 1.1
 * @author chen
 */

public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you need to draw?");
        System.out.print("k: ");
        int k = in.nextInt();

        System.out.println("What is the highest number you can draw?");
        System.out.print("n( > " + k + "): ");
        int n = in.nextInt();

        // fill an array with numbers 1 2 3 ... n
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = i + 1;

        // draw k numbers and put them into a second array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // make a random index between 0 and n - 1
            int u = (int) (Math.random() * n);
            result[i] = numbers[u];
            n--;
            numbers[u] = numbers[n];
        }

        // print the sorted array
        Arrays.sort(result);
        System.out.println("Bet the following combination. It'll make you rich!");
        System.out.println(Arrays.toString(result));
        /*for (int u : result)
            System.out.println(u);*/
    }
}
