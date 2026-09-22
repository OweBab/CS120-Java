import java.util.Scanner;

public class Assignment6H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Enter an integer:");
            int n = scanner.nextInt();

            if (n <= 1) {
                System.out.println(n + " has no prime factors.");
            } else {
                System.out.println("Distinct prime factors of " + n + ":");
                int temp = n;

                for (int i = 2; i * i <= temp; i++) {
                    if (temp % i == 0) {
                        System.out.println(i);
                        while (temp % i == 0) {
                            temp /= i;
                        }
                    }
                }

                if (temp > 1) {
                    System.out.println(temp);
                }
            }

            System.out.println("Enter 0 to quit, or any other number to continue:");
            choice = scanner.nextInt();
        } while (choice != 0);

        System.out.println("Goodbye!");
        scanner.close();
    }
}
