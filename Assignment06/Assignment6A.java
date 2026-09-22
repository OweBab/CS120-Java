import java.util.Scanner;

public class Assignment6A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char playAgain;

        do {
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();

            if (number % 2 == 0) {
                System.out.println(number + " is divisible by 2.");
            } else {
                System.out.println(number + " is not divisible by 2.");
            }

            System.out.print("Do you want to check another number? (y/n): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Goodbye!");
    }
}
