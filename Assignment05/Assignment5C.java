import java.util.Scanner;

public class Assignment5C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = (int) (Math.random() * 100) + 1;
            int guesses = 0;
            int guess = 0;

            while (guess != secretNumber) {
                System.out.println("Guess a number from 1 to 100:");

                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                } else {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                    continue;
                }

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number from 1 to 100.");
                    continue;
                }

                guesses++;

                if (guess < secretNumber) {
                    System.out.println("guess higher");
                } else if (guess > secretNumber) {
                    System.out.println("guess lower");
                }
            }

            System.out.println("Correct!");
            System.out.println("Total guesses: " + guesses);
            System.out.println("Play again? (y/n):");

            String response = scanner.next();
            if (!response.equalsIgnoreCase("y")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
