import java.util.Scanner;

public class Assignment6G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Enter an integer:");
            int number = scanner.nextInt();

            if (number <= 1) {
                System.out.println(number + ": Not prime");
            } else {
                boolean isPrime = true;
                for (int i = 2; i * i <= number; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    System.out.println(number + ": Prime");
                } else {
                    System.out.println(number + ": Not prime");
                }
            }

            System.out.println("Enter 0 to quit, or any other number to continue:");
            choice = scanner.nextInt();
        } while (choice != 0);

        System.out.println("Goodbye!");
        scanner.close();
    }
}
