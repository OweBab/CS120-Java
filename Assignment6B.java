import java.util.Scanner;

public class Assignment6B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char playAgain;

        do {
            System.out.print("Enter the first integer: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second integer: ");
            int num2 = scanner.nextInt();

            if (num2 == 0) {
                System.out.println("Cannot divide by zero.");
            } else if (num1 % num2 == 0) {
                System.out.println(num1 + " is divisible by " + num2 + ".");
            } else {
                System.out.println(num1 + " is not divisible by " + num2 + ".");
            }

            System.out.print("Do you want to check another pair? (y/n): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Goodbye!");
    }
}
