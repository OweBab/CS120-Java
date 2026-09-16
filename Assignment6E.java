import java.util.Scanner;

public class Assignment6E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Enter an integer:");
            int number = scanner.nextInt();
            int temp = number;
            int ones = 0;
            int twos = 0;

            while (temp > 0) {
                int digit = temp % 10;
                if (digit == 1) {
                    ones++;
                } else if (digit == 2) {
                    twos++;
                }
                temp /= 10;
            }

            if (ones == twos + 1) {
                System.out.println(number + ": Qualifies");
            } else {
                System.out.println(number + ": Does not qualify");
            }

            System.out.println("Enter 0 to quit, or any other number to continue:");
            choice = scanner.nextInt();
        } while (choice != 0);

        System.out.println("Goodbye!");
        scanner.close();
    }
}
