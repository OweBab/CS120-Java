import java.util.Scanner;

public class Assignment8A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] students = {"Amy", "Bill", "Carmen", "Dave", "Ellen"};

        // Rows = periods (0-4), columns = students (0-4)
        int[][] marks = {
            {95, 56, 67, 89, 78},
            {91, 59, 63, 82, 80},
            {97, 55, 61, 85, 72},
            {88, 67, 69, 81, 76},
            {94, 62, 58, 91, 87}
        };

        int choice = 0;

        do {
            System.out.println("1 - View all marks");
            System.out.println("2 - Modify a mark");
            System.out.println("3 - Exit");
            System.out.print("Enter your choice (1-3): ");

            if (!scanner.hasNext()) {
                break;
            }
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                scanner.next();
                System.out.print("Enter your choice (1-3): ");
                if (!scanner.hasNext()) {
                    break;
                }
            }
            if (!scanner.hasNext()) {
                break;
            }
            choice = scanner.nextInt();

            if (choice == 1) {
                printTable(students, marks);
            } else if (choice == 2) {
                System.out.println("Select a student:");
                for (int i = 0; i < students.length; i++) {
                    System.out.println((i + 1) + " - " + students[i]);
                }
                System.out.print("Enter student (1-5): ");
                int student = readIntInRange(scanner, 1, 5);
                if (student == -1) {
                    break;
                }

                System.out.print("Enter period (1-5): ");
                int period = readIntInRange(scanner, 1, 5);
                if (period == -1) {
                    break;
                }

                System.out.print("Enter the new mark: ");
                while (!scanner.hasNextInt()) {
                    if (!scanner.hasNext()) {
                        break;
                    }
                    System.out.println("Invalid input. Please enter an integer mark.");
                    scanner.next();
                    System.out.print("Enter the new mark: ");
                }
                if (!scanner.hasNext()) {
                    break;
                }
                int newMark = scanner.nextInt();

                marks[period - 1][student - 1] = newMark;
                System.out.println("Updated " + students[student - 1]
                    + " Period " + period + " to " + newMark + ".");
                printTable(students, marks);
            } else if (choice != 3) {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } while (choice != 3);

        System.out.println("Goodbye!");
        scanner.close();
    }

    // Print the full marks table
    public static void printTable(String[] students, int[][] marks) {
        System.out.printf("%-8s%-8s%-8s%-8s%-8s%-8s%n",
            "Period", "Amy", "Bill", "Carmen", "Dave", "Ellen");
        for (int p = 0; p < marks.length; p++) {
            System.out.printf("%-8d", p + 1);
            for (int s = 0; s < marks[p].length; s++) {
                System.out.printf("%-8d", marks[p][s]);
            }
            System.out.println();
        }
    }

    // Read an integer in the range min-max; returns -1 if input ends
    public static int readIntInRange(Scanner scanner, int min, int max) {
        while (true) {
            if (!scanner.hasNext()) {
                return -1;
            }
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number "
                    + min + "-" + max + ".");
                scanner.next();
                if (!scanner.hasNext()) {
                    return -1;
                }
            }
            int value = scanner.nextInt();
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Invalid selection. Please enter "
                + min + "-" + max + ".");
        }
    }
}
