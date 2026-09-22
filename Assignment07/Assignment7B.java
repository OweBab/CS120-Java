import java.util.Scanner;

public class Assignment7B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Three parallel arrays: same index = same planet
        String[] names = {"Mercury", "Venus", "Earth", "Mars", "Jupiter",
                          "Saturn", "Uranus", "Neptune", "Pluto"};
        int[] moons = {0, 0, 1, 2, 16, 18, 15, 8, 1};
        int[] distances = {58, 108, 150, 228, 778, 1427, 2869, 4498, 5900};

        int choice = 0;

        do {
            System.out.println("Select a planet:");
            for (int i = 0; i < names.length; i++) {
                System.out.println((i + 1) + " - " + names[i]);
            }
            System.out.println("0 - Quit");
            System.out.print("Enter your choice (0-9): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number 0-9.");
                scanner.next();
                System.out.print("Enter your choice (0-9): ");
            }
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 9) {
                int index = choice - 1;
                System.out.println("Planet: " + names[index]);
                System.out.println("Moons: " + moons[index]);
                System.out.println("Distance from Sun: " + distances[index] + " million km");
            } else if (choice != 0) {
                System.out.println("Invalid choice. Please enter 0-9.");
            }
        } while (choice != 0);

        System.out.println("Goodbye!");
        scanner.close();
    }
}
