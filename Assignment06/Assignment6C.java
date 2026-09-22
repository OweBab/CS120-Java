import java.util.Scanner;

public class Assignment6C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char playAgain;

        do {
            System.out.print("Enter a positive integer: ");
            int number = scanner.nextInt();

            int sum = 0;
            int temp = number;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            System.out.println("The sum of the digits of " + number + " is " + sum + ".");

            System.out.print("Do you want to check another number? (y/n): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Goodbye!");
    }
}
