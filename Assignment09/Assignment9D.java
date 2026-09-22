import java.util.Scanner;

public class Assignment9D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Double a = readSide(scanner, "Enter side a (0 to quit): ");
            if (a == null || a == 0) {
                break;
            }
            Double b = readSide(scanner, "Enter side b: ");
            if (b == null) {
                break;
            }
            Double c = readSide(scanner, "Enter side c: ");
            if (c == null) {
                break;
            }

            if (!isValidTriangle(a, b, c)) {
                System.out.println("Invalid triangle.");
            } else {
                double area = calculateArea(a, b, c);
                System.out.println("Area: " + area);
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    // Return true only if all three strict triangle inequalities hold
    public static boolean isValidTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    // Heron's formula (call only with valid triangles)
    public static double calculateArea(double a, double b, double c) {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // Read a side length; returns null if input ends
    public static Double readSide(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNext()) {
                return null;
            }
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
    }
}
