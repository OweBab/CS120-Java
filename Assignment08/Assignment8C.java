import java.util.Scanner;

public class Assignment8C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char player = 'X';

        while (true) {
            System.out.println("Player " + player + "'s turn.");
            int row = readCoordinate(scanner, "Enter row (1-3): ");
            if (row == -1) {
                break;
            }
            int col = readCoordinate(scanner, "Enter column (1-3): ");
            if (col == -1) {
                break;
            }

            board[row - 1][col - 1] = player;
            printBoard(board);

            if (checkWin(board, player)) {
                System.out.println("Player " + player + " wins!");
                break;
            }

            if (isBoardFull(board)) {
                System.out.println("It's a draw!");
                break;
            }

            if (player == 'X') {
                player = 'O';
            } else {
                player = 'X';
            }
        }

        scanner.close();
    }

    // Display the board
    public static void printBoard(char[][] board) {
        for (int r = 0; r < 3; r++) {
            System.out.println(" " + board[r][0] + " | " + board[r][1] + " | " + board[r][2]);
            if (r < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    // Return true if the player has 3 in a row, column, or diagonal
    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    // Return true if every cell is filled
    public static boolean isBoardFull(char[][] board) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Read a 1-3 coordinate; returns -1 if input ends
    public static int readCoordinate(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNext()) {
                return -1;
            }
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                scanner.next();
                System.out.print(prompt);
                if (!scanner.hasNext()) {
                    return -1;
                }
            }
            int value = scanner.nextInt();
            if (value >= 1 && value <= 3) {
                return value;
            }
            System.out.println("Invalid input. Please enter 1, 2, or 3.");
        }
    }
}
