import java.util.Scanner;

public class Assignment9B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Temperature Converter");
            System.out.println("1 - Fahrenheit to Celsius");
            System.out.println("2 - Celsius to Fahrenheit");
            System.out.println("3 - Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                if (!scanner.hasNext()) {
                    System.out.println("Goodbye!");
                    return;
                }
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }
            choice = scanner.nextInt();

            if (choice == 1) {
                double f = readTemperature(scanner, "Enter Fahrenheit temperature: ");
                if (Double.isNaN(f)) {
                    break;
                }
                double c = fahrenheitToCelsius(f);
                System.out.println("Celsius: " + c);
            } else if (choice == 2) {
                double c = readTemperature(scanner, "Enter Celsius temperature: ");
                if (Double.isNaN(c)) {
                    break;
                }
                double f = celsiusToFahrenheit(c);
                System.out.println("Fahrenheit: " + f);
            } else if (choice != 3) {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } while (choice != 3);

        System.out.println("Goodbye!");
        scanner.close();
    }

    // Convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return 5 * (fahrenheit - 32) / 9;
    }

    // Convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    // Read a temperature (negatives allowed); NaN if input ends
    public static double readTemperature(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNext()) {
                return Double.NaN;
            }
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }
}
