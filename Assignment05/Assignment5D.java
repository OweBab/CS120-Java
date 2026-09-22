import java.util.Scanner;
import java.util.Random;

public class Assignment5D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain;

        System.out.println("=================================");
        System.out.println("   Rock, Paper, Scissors!");
        System.out.println("=================================");
        System.out.println("Instructions:");
        System.out.println("  You play against the computer.");
        System.out.println("  Rock beats Scissors.");
        System.out.println("  Scissors beats Paper.");
        System.out.println("  Paper beats Rock.");
        System.out.println("  Enter 1 for Rock, 2 for Paper, or 3 for Scissors.");
        System.out.println("=================================");

        // Main game loop - repeats until the player chooses to quit
        do {
            int wins = 0;
            int losses = 0;
            int ties = 0;
            String roundChoice;

            // Round loop - play rounds until the player types "quit"
            do {
                System.out.print("\nEnter your choice (1=Rock, 2=Paper, 3=Scissors, or 'quit'): ");
                roundChoice = scanner.next();

                // Check if the player wants to stop this set of rounds
                if (roundChoice.equalsIgnoreCase("quit")) {
                    break;
                }

                // Validate input - must be 1, 2, or 3
                if (!roundChoice.equals("1") && !roundChoice.equals("2") && !roundChoice.equals("3")) {
                    System.out.println("Invalid input. Please enter 1, 2, or 3.");
                    continue;
                }

                int playerChoice = Integer.parseInt(roundChoice);

                // Computer randomly picks 1=Rock, 2=Paper, 3=Scissors
                int computerChoice = random.nextInt(3) + 1;

                // Convert numbers to readable names for output
                String playerName = "";
                String computerName = "";

                if (playerChoice == 1) {
                    playerName = "Rock";
                } else if (playerChoice == 2) {
                    playerName = "Paper";
                } else {
                    playerName = "Scissors";
                }

                if (computerChoice == 1) {
                    computerName = "Rock";
                } else if (computerChoice == 2) {
                    computerName = "Paper";
                } else {
                    computerName = "Scissors";
                }

                System.out.println("You chose: " + playerName);
                System.out.println("Computer chose: " + computerName);

                // Determine the winner using nested decisions
                if (playerChoice == computerChoice) {
                    System.out.println("It's a tie!");
                    ties++;
                } else if (playerChoice == 1 && computerChoice == 3) {
                    // Rock beats Scissors
                    System.out.println("You win this round!");
                    wins++;
                } else if (playerChoice == 2 && computerChoice == 1) {
                    // Paper beats Rock
                    System.out.println("You win this round!");
                    wins++;
                } else if (playerChoice == 3 && computerChoice == 2) {
                    // Scissors beats Paper
                    System.out.println("You win this round!");
                    wins++;
                } else {
                    // All other cases mean the computer wins
                    System.out.println("Computer wins this round!");
                    losses++;
                }

                // Display running score
                System.out.println("Score -> You: " + wins + " | Computer: " + losses + " | Ties: " + ties);

            } while (true); // Loop until player types "quit"

            // Display final results for this set of rounds
            System.out.println("\n--- Round Summary ---");
            System.out.println("Wins: " + wins + " | Losses: " + losses + " | Ties: " + ties);

            if (wins > losses) {
                System.out.println("Overall: You beat the computer!");
            } else if (losses > wins) {
                System.out.println("Overall: Computer wins this session.");
            } else {
                System.out.println("Overall: It's an even match!");
            }

            System.out.print("\nPlay another session? (y/n): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("\nThanks for playing Rock, Paper, Scissors!");
        scanner.close();
    }
}
