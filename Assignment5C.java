import java.util.Scanner;
import java.util.Random;

public class Assignment5C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char playAgain;

        do {
            int secretNumber = random.nextInt(100) + 1;
            int guess = 0;
            int guessCount = 0;

            System.out.println("I'm thinking of a number between 1 and 100.");

            while (guess != secretNumber) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                guessCount++;

                if (guess == secretNumber) {
                    System.out.println("You got it in " + guessCount + " guesses!");
                } else if (guess < secretNumber) {
                    System.out.println("guess higher");
                } else {
                    System.out.println("guess lower");
                }
            }

            System.out.print("Play again? (y/n): ");
            playAgain = scanner.next().charAt(0);
        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
