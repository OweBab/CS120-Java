import java.util.Scanner;

public class Assignment7A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String repeat;

        do {
            int count = 0;

            // Ask how many numbers (1-10) with validation
            while (true) {
                System.out.print("How many numbers do you want to enter (1-10): ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer between 1 and 10.");
                    scanner.next();
                    continue;
                }
                count = scanner.nextInt();
                if (count >= 1 && count <= 10) {
                    break;
                }
                System.out.println("Please enter a number between 1 and 10.");
            }

            // Array that can hold up to 10 numbers
            double[] numbers = new double[10];

            // Read the numbers with validation
            for (int i = 0; i < count; i++) {
                while (true) {
                    System.out.print("Enter number " + (i + 1) + ": ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                        continue;
                    }
                    numbers[i] = scanner.nextDouble();
                    break;
                }
            }

            // Calculate sum with a loop, then mean
            double sum = 0;
            for (int i = 0; i < count; i++) {
                sum += numbers[i];
            }
            double mean = sum / count;

            // Display the numbers entered
            System.out.print("Numbers entered: ");
            for (int i = 0; i < count; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();

            // Display the mean
            System.out.println("Mean: " + mean);

            System.out.print("Do you want to perform another calculation? (y/n): ");
            repeat = scanner.next();
        } while (repeat.equalsIgnoreCase("y"));

        System.out.println("Goodbye!");
        scanner.close();
    }
}
