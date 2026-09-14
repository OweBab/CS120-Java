import java.util.Scanner;

public class Assignment5B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.println("Enter the first number:");
            int num1 = scanner.nextInt();

            System.out.println("Enter the second number:");
            int num2 = scanner.nextInt();

            System.out.println("Choose an operation:");
            System.out.println("1 - Add");
            System.out.println("2 - Multiply");
            System.out.println("Enter your choice (1 or 2):");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("Result: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Result: " + (num1 * num2));
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

            System.out.println("Do you want to continue? (y/n):");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        System.out.println("Goodbye!");
        scanner.close();
    }
}
