import java.util.Random;
import java.util.Scanner;

public class GameOfLife {
    private static final int ROWS = 22;
    private static final int COLS = 80;
    private static final int MAX_GENERATIONS = 200;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int choice = 0;

        do {
            System.out.println("===============================");
            System.out.println("       CONWAY'S GAME OF LIFE");
            System.out.println("===============================");
            System.out.println();
            System.out.println("1. Random starting population");
            System.out.println("2. Manually place cells");
            System.out.println("3. Load a preset pattern");
            System.out.println("4. Exit");
            System.out.println();
            choice = readIntInRange(scanner, "Enter your choice: ", 1, 4);
            if (choice == Integer.MIN_VALUE) {
                break;
            }

            if (choice == 1) {
                char[][] grid = new char[ROWS][COLS];
                initializeGrid(grid);
                int density = readIntInRange(scanner,
                    "Enter population density (0-100): ", 0, 100);
                if (density == Integer.MIN_VALUE) {
                    density = 0;
                }
                randomizeGrid(grid, density, random);
                runSimulation(scanner, grid);
            } else if (choice == 2) {
                char[][] grid = new char[ROWS][COLS];
                initializeGrid(grid);
                manualPlacement(scanner, grid);
                runSimulation(scanner, grid);
            } else if (choice == 3) {
                char[][] grid = new char[ROWS][COLS];
                initializeGrid(grid);
                if (loadPreset(scanner, grid)) {
                    runSimulation(scanner, grid);
                }
            }
        } while (choice != 4);

        System.out.println("Goodbye!");
        scanner.close();
    }

    // Fill every cell with a space (dead)
    public static void initializeGrid(char[][] grid) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                grid[r][c] = ' ';
            }
        }
    }

    // Randomly set cells alive based on density (0-100 percent)
    public static void randomizeGrid(char[][] grid, int density, Random random) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (random.nextInt(100) < density) {
                    grid[r][c] = '*';
                } else {
                    grid[r][c] = ' ';
                }
            }
        }
    }

    // Let the user place cells with 1-based row/column coordinates
    public static void manualPlacement(Scanner scanner, char[][] grid) {
        System.out.println("Enter row (1-22), or 0 to finish.");
        while (true) {
            int row = readIntInRange(scanner, "Enter row (1-22), or 0 to finish: ", 0, ROWS);
            if (row == 0 || row == Integer.MIN_VALUE) {
                break;
            }
            int col = readIntInRange(scanner, "Enter column (1-80): ", 1, COLS);
            if (col == Integer.MIN_VALUE) {
                break;
            }
            grid[row - 1][col - 1] = '*';
            System.out.println("Cell (" + row + ", " + col + ") is now alive.");
        }
    }

    // Show the preset menu and place the chosen pattern near the center
    // Returns false if the user goes back without picking a pattern
    public static boolean loadPreset(Scanner scanner, char[][] grid) {
        System.out.println("Preset Patterns");
        System.out.println();
        System.out.println("1. Block");
        System.out.println("2. Blinker");
        System.out.println("3. Glider");
        System.out.println("4. Back to main menu");
        System.out.println();
        int choice = readIntInRange(scanner, "Enter your choice: ", 1, 4);
        if (choice == Integer.MIN_VALUE) {
            return false;
        }

        int midRow = ROWS / 2;
        int midCol = COLS / 2;

        if (choice == 1) {
            // Block: stable 2x2 square
            grid[midRow][midCol] = '*';
            grid[midRow][midCol + 1] = '*';
            grid[midRow + 1][midCol] = '*';
            grid[midRow + 1][midCol + 1] = '*';
            return true;
        } else if (choice == 2) {
            // Blinker: horizontal three-cell oscillator
            grid[midRow][midCol - 1] = '*';
            grid[midRow][midCol] = '*';
            grid[midRow][midCol + 1] = '*';
            return true;
        } else if (choice == 3) {
            // Glider: standard five-cell glider, moves diagonally
            grid[midRow - 1][midCol] = '*';
            grid[midRow][midCol + 1] = '*';
            grid[midRow + 1][midCol - 1] = '*';
            grid[midRow + 1][midCol] = '*';
            grid[midRow + 1][midCol + 1] = '*';
            return true;
        }
        return false;
    }

    // Count the living neighbours around one cell (no wrapping)
    public static int countNeighbors(char[][] grid, int row, int col) {
        int count = 0;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) {
                    continue;
                }
                int r = row + dr;
                int c = col + dc;
                if (r >= 0 && r < ROWS && c >= 0 && c < COLS) {
                    if (grid[r][c] == '*') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // Build the next generation from the current one
    public static void updateGeneration(char[][] current, char[][] next) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int neighbors = countNeighbors(current, r, c);
                if (current[r][c] == '*') {
                    if (neighbors == 2 || neighbors == 3) {
                        next[r][c] = '*';
                    } else {
                        next[r][c] = ' ';
                    }
                } else {
                    if (neighbors == 3) {
                        next[r][c] = '*';
                    } else {
                        next[r][c] = ' ';
                    }
                }
            }
        }
    }

    // Copy one grid into another
    public static void copyGrid(char[][] source, char[][] destination) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                destination[r][c] = source[r][c];
            }
        }
    }

    // Check whether two grids are identical
    public static boolean gridsEqual(char[][] a, char[][] b) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (a[r][c] != b[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Count all living cells
    public static int countLiving(char[][] grid) {
        int count = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '*') {
                    count++;
                }
            }
        }
        return count;
    }

    // Display the grid with generation info
    public static void displayGrid(char[][] grid, int generation) {
        System.out.println("==================================================");
        System.out.println("Generation: " + generation);
        System.out.println("Living cells: " + countLiving(grid));
        System.out.println("==================================================");
        for (int r = 0; r < ROWS; r++) {
            System.out.print("|");
            for (int c = 0; c < COLS; c++) {
                System.out.print(grid[r][c]);
            }
            System.out.println("|");
        }
        System.out.println("==================================================");
    }

    // Run the simulation loop for one starting population
    public static void runSimulation(Scanner scanner, char[][] grid) {
        char[][] next = new char[ROWS][COLS];
        initializeGrid(next);

        int generation = 0;
        displayGrid(grid, generation);

        if (countLiving(grid) == 0) {
            System.out.println();
            System.out.println("All cells are dead. Simulation ended.");
            return;
        }

        int choice = 0;
        do {
            System.out.println("1. Run continuously");
            System.out.println("2. Step one generation");
            System.out.println("3. Return to main menu");
            choice = readIntInRange(scanner, "Enter your choice: ", 1, 3);
            if (choice == Integer.MIN_VALUE) {
                break;
            }

            if (choice == 1) {
                int delay = readIntInRange(scanner,
                    "Enter delay in milliseconds (50-1000): ", 50, 1000);
                if (delay == Integer.MIN_VALUE) {
                    break;
                }
                boolean stopped = false;
                for (int i = 0; i < MAX_GENERATIONS; i++) {
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        // Ignore and continue with the next generation
                    }
                    updateGeneration(grid, next);
                    boolean stable = gridsEqual(grid, next);
                    copyGrid(next, grid);
                    generation++;
                    displayGrid(grid, generation);
                    if (countLiving(grid) == 0) {
                        System.out.println();
                        System.out.println("All cells are dead. Simulation ended.");
                        stopped = true;
                        break;
                    }
                    if (stable) {
                        System.out.println();
                        System.out.println("Population has stabilized. Simulation ended.");
                        stopped = true;
                        break;
                    }
                }
                if (!stopped) {
                    System.out.println();
                    System.out.println("Maximum generations reached. Simulation ended.");
                }
            } else if (choice == 2) {
                System.out.println("Press Enter to advance, or type Q and press Enter to stop.");
                while (true) {
                    if (!scanner.hasNextLine()) {
                        break;
                    }
                    String line = scanner.nextLine();
                    if (line.equalsIgnoreCase("q")) {
                        break;
                    }
                    updateGeneration(grid, next);
                    boolean stable = gridsEqual(grid, next);
                    copyGrid(next, grid);
                    generation++;
                    displayGrid(grid, generation);
                    if (countLiving(grid) == 0) {
                        System.out.println();
                        System.out.println("All cells are dead. Simulation ended.");
                        break;
                    }
                    if (stable) {
                        System.out.println();
                        System.out.println("Population has stabilized. Simulation ended.");
                        break;
                    }
                    System.out.println("Press Enter to advance, or type Q and press Enter to stop.");
                }
            }
        } while (choice != 3);
    }

    // Read an integer in the range min-max; reprompts on bad input
    public static int readIntInRange(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNext()) {
                return Integer.MIN_VALUE;
            }
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                if (value >= min && value <= max) {
                    return value;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Please enter a number "
                + min + "-" + max + ".");
        }
    }
}
