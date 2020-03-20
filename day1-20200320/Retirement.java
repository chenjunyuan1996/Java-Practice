import java.util.*;

public class Retirement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How much money do you need to retire?");
        double goal = in.nextDouble();

        System.out.println("How much money will you contribute every year?");
        double payment = in.nextDouble();

        System.out.println("Interest rate in %: ");
        double interestRate = in.nextDouble() / 100;

        double balance = 0;
        int years = 0;
        while (balance < goal) {
            balance += payment;
            double interest = balance * interestRate;
            balance += interest;
            years++;
        }

        System.out.printf("You can retire in %d years.", years);
        System.out.println();
        System.out.println("You can retire in " + years + " years.");
    }
}
