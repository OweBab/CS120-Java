import java.util.Scanner;

public class Assignment11A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String repeat;

        do {
            System.out.print("Enter first word: ");
            String first = scanner.next();
            System.out.print("Enter second word: ");
            String second = scanner.next();

            System.out.println();
            System.out.println("Alphabetical order:");
            if (first.compareToIgnoreCase(second) <= 0) {
                System.out.println(first);
                System.out.println(second);
            } else {
                System.out.println(second);
                System.out.println(first);
            }
            System.out.println();

            System.out.print("Do you want to enter another pair? (y/n): ");
            while (true) {
                if (!scanner.hasNext()) {
                    repeat = "n";
                    break;
                }
                repeat = scanner.next();
                if (repeat.equalsIgnoreCase("y") || repeat.equalsIgnoreCase("n")) {
                    break;
                }
                System.out.print("Invalid input. Please enter y or n: ");
            }
        } while (repeat.equalsIgnoreCase("y"));

        System.out.println("Goodbye!");
        scanner.close();
    }
}
