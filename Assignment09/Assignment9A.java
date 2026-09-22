import java.util.Scanner;

public class Assignment9A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String repeat;

        do {
            double num1 = inputNumber(scanner, "Enter the first number: ");
            double num2 = inputNumber(scanner, "Enter the second number: ");

            double sum = calculateSum(num1, num2);
            double product = calculateProduct(num1, num2);
            double quotient = calculateQuotient(num1, num2);
            double difference = calculateDifference(num1, num2);

            displayResults(sum, product, quotient, difference);

            System.out.print("Do you want to calculate again? (y/n): ");
            while (true) {
                if (!scanner.hasNext()) {
                    repeat = "n";
                    break;
                }
                repeat = scanner.next();
                if (repeat.equalsIgnoreCase("y") || repeat.equalsIgnoreCase("n")) {
                    break;
                }
                System.out.print("Please enter y or n: ");
            }
        } while (repeat.equalsIgnoreCase("y"));

        System.out.println("Goodbye!");
        scanner.close();
    }

    // Ask for a number and return it
    public static double inputNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNext()) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }

    // Return the sum of a and b
    public static double calculateSum(double a, double b) {
        return a + b;
    }

    // Return the product of a and b
    public static double calculateProduct(double a, double b) {
        return a * b;
    }

    // Return a divided by b (NaN if b is zero)
    public static double calculateQuotient(double a, double b) {
        if (b == 0) {
            return Double.NaN;
        }
        return a / b;
    }

    // Return a minus b
    public static double calculateDifference(double a, double b) {
        return a - b;
    }

    // Display all four results
    public static void displayResults(double sum, double product,
                                      double quotient, double difference) {
        System.out.println();
        System.out.println("Results");
        System.out.println("-------");
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        if (Double.isNaN(quotient)) {
            System.out.println("Quotient: undefined (cannot divide by zero)");
        } else {
            System.out.println("Quotient: " + quotient);
        }
        System.out.println("Difference: " + difference);
        System.out.println();
    }
}
