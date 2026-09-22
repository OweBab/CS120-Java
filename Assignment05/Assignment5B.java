import java.util.Scanner;

public class Assignment5B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;

        do {
            System.out.println("Enter the first number:");
            int num1 = scanner.nextInt();
            System.out.println("Enter the second number:");
            int num2 = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Result: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Result: " + (num1 * num2));
                    break;
            }

            System.out.println("1 - Add");
            System.out.println("2 - Multiply");
            System.out.println("0 - Quit");
            choice = scanner.nextInt();
        } while (choice != 0);

        System.out.println("Goodbye!");
        scanner.close();
    }
}
