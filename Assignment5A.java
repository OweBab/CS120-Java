import java.util.Scanner;

public class Assignment5A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int SENTINEL = -1;

        System.out.println("Enter a number to compare to 50 (or -1 to quit):");

        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();

            if (number == SENTINEL) {
                break;
            }

            if (number > 50) {
                System.out.println(number + " is greater than 50.");
            } else if (number < 50) {
                System.out.println(number + " is less than 50.");
            } else {
                System.out.println(number + " equals 50:");
            }

            System.out.println("Enter a number to compare to 50 (or -1 to quit):");
        }

        System.out.println("Goodbye!");
    }
}
