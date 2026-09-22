import java.util.Scanner;
import java.util.Random;

public class Assignment7C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String repeat;

        do {
            int rolls = 0;
            boolean gotRolls = false;

            // Ask how many rolls with validation
            while (!gotRolls) {
                System.out.print("How many times do you want to roll two dice? ");
                if (!scanner.hasNext()) {
                    System.out.println("Goodbye!");
                    return;
                }
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter 0 or a positive integer.");
                    scanner.next();
                    continue;
                }
                rolls = scanner.nextInt();
                if (rolls >= 0) {
                    gotRolls = true;
                } else {
                    System.out.println("Please enter 0 or a positive integer.");
                }
            }

            // Fresh frequency array for each simulation
            int[] frequency = new int[13];

            // Simulate the dice rolls
            for (int i = 0; i < rolls; i++) {
                int die1 = random.nextInt(6) + 1;
                int die2 = random.nextInt(6) + 1;
                int sum = die1 + die2;
                frequency[sum]++;
            }

            // Display frequencies for sums 2-12
            for (int sum = 2; sum <= 12; sum++) {
                System.out.println(sum + ":" + frequency[sum]);
            }

            System.out.print("Run another simulation? (y/n): ");
            if (scanner.hasNext()) {
                repeat = scanner.next();
            } else {
                repeat = "n";
            }
        } while (repeat.equalsIgnoreCase("y"));

        System.out.println("Goodbye!");
        scanner.close();
    }
}
