import java.util.Scanner;

public class Assignment9C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Length Converter");
            System.out.println("1 - Inches to centimeters");
            System.out.println("2 - Feet to centimeters");
            System.out.println("3 - Yards to meters");
            System.out.println("4 - Miles to kilometers");
            System.out.println("5 - Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                if (!scanner.hasNext()) {
                    System.out.println("Goodbye!");
                    return;
                }
                System.out.println("Invalid input. Please enter 1-5.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }
            choice = scanner.nextInt();

            if (choice == 1) {
                double inches = readMeasurement(scanner, "Enter inches: ");
                if (Double.isNaN(inches)) {
                    break;
                }
                System.out.println("Centimeters: " + inchesToCentimeters(inches));
            } else if (choice == 2) {
                double feet = readMeasurement(scanner, "Enter feet: ");
                if (Double.isNaN(feet)) {
                    break;
                }
                System.out.println("Centimeters: " + feetToCentimeters(feet));
            } else if (choice == 3) {
                double yards = readMeasurement(scanner, "Enter yards: ");
                if (Double.isNaN(yards)) {
                    break;
                }
                System.out.println("Meters: " + yardsToMeters(yards));
            } else if (choice == 4) {
                double miles = readMeasurement(scanner, "Enter miles: ");
                if (Double.isNaN(miles)) {
                    break;
                }
                System.out.println("Kilometers: " + milesToKilometers(miles));
            } else if (choice != 5) {
                System.out.println("Invalid choice. Please enter 1-5.");
            }
        } while (choice != 5);

        System.out.println("Goodbye!");
        scanner.close();
    }

    public static double inchesToCentimeters(double inches) {
        return inches * 2.54;
    }

    public static double feetToCentimeters(double feet) {
        return feet * 30;
    }

    public static double yardsToMeters(double yards) {
        return yards * 0.91;
    }

    public static double milesToKilometers(double miles) {
        return miles * 1.6;
    }

    // Read a measurement (decimals and negatives allowed); NaN if input ends
    public static double readMeasurement(Scanner scanner, String prompt) {
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
