import java.util.Scanner;

public class Assignment8D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;

        // Ask how many numbers (1-10) with validation
        while (true) {
            System.out.print("How many numbers do you want to enter (1-10): ");
            if (!scanner.hasNext()) {
                return;
            }
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer 1-10.");
                scanner.next();
                continue;
            }
            count = scanner.nextInt();
            if (count >= 1 && count <= 10) {
                break;
            }
            System.out.println("Please enter a number between 1 and 10.");
        }

        // 2D array: column 0 = number, column 1 = difference, column 2 = square
        double[][] data = new double[10][3];

        // Read the numbers into column 0
        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.print("Enter number " + (i + 1) + ": ");
                if (!scanner.hasNext()) {
                    return;
                }
                if (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                    continue;
                }
                data[i][0] = scanner.nextDouble();
                break;
            }
        }

        // Calculate the mean from column 0
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += data[i][0];
        }
        double mean = sum / count;

        // Fill columns 1 and 2, and total the squares
        double squareSum = 0;
        for (int i = 0; i < count; i++) {
            data[i][1] = data[i][0] - mean;
            data[i][2] = data[i][1] * data[i][1];
            squareSum += data[i][2];
        }

        // Population standard deviation (divide by n)
        double stdDev = Math.sqrt(squareSum / count);

        // Display the table
        System.out.printf("%-12s%-12s%-12s%n", "Number", "Difference", "Square");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-12.3f%-12.3f%-12.3f%n",
                data[i][0], data[i][1], data[i][2]);
        }

        System.out.printf("Mean = %.3f%n", mean);
        System.out.printf("Standard deviation = %.3f%n", stdDev);

        scanner.close();
    }
}
