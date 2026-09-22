import java.util.Scanner;

public class Assignment8E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Build the first 8 rows of Pascal's triangle
        int[][] pascal = new int[8][8];
        for (int row = 0; row < 8; row++) {
            pascal[row][0] = 1;
            pascal[row][row] = 1;
            for (int col = 1; col < row; col++) {
                pascal[row][col] = pascal[row - 1][col - 1] + pascal[row - 1][col];
            }
        }

        int choice = 1;

        do {
            // Display the triangle as a centered pyramid
            for (int row = 0; row < 8; row++) {
                for (int s = 0; s < (7 - row); s++) {
                    System.out.print("   ");
                }
                for (int col = 0; col <= row; col++) {
                    System.out.printf("%4d   ", pascal[row][col]);
                }
                System.out.println();
            }

            System.out.print("Enter 1 to display again, or 0 to exit: ");
            while (true) {
                if (!scanner.hasNext()) {
                    choice = 0;
                    break;
                }
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter 1 or 0.");
                    scanner.next();
                    System.out.print("Enter 1 to display again, or 0 to exit: ");
                    continue;
                }
                choice = scanner.nextInt();
                if (choice == 0 || choice == 1) {
                    break;
                }
                System.out.println("Invalid input. Please enter 1 or 0.");
                System.out.print("Enter 1 to display again, or 0 to exit: ");
            }
        } while (choice != 0);

        System.out.println("Goodbye!");
        scanner.close();
    }
}
