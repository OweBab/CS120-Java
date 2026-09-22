# CS 120 Java Coursework

My coursework for CS 120 (introductory Java). Each program is a standalone
`.java` file with its own `main` method, organized by assignment. There is
also a Conway's Game of Life capstone project.

## Contents

| Folder         | Files                                              | Topics                                                      |
|----------------|----------------------------------------------------|-------------------------------------------------------------|
| `Hello/`       | `Hello.java`                                       | Starter program (prints a greeting; not an assignment)      |
| `Assignment02/`| `Assignment2A`–`Assignment2C`                      | Console output, variables, arithmetic, `printf` formatting  |
| `Assignment03/`| `Assignment3A`–`Assignment3E`                      | `Scanner` input, arithmetic, powers, averages, circle area, right-triangle math |
| `Assignment04/`| `Assignment4A`–`Assignment4D`                      | `for` loops, running totals, `Math.sqrt`, formatted tables  |
| `Assignment05/`| `Assignment5A`–`Assignment5D`                      | `if`/`else`, `switch` menus, sentinel loops, number-guessing game, rock-paper-scissors |
| `Assignment06/`| `Assignment6A`–`Assignment6H`                      | Modulus/divisibility, digit extraction and digit sums, prime testing, prime factors |
| `Assignment07/`| `Assignment7A`–`Assignment7C`                      | 1D arrays, parallel arrays, dice simulation with a frequency array |
| `Assignment08/`| `Assignment8A`–`Assignment8E`                      | 2D arrays: editable marks table, row/column averages, tic-tac-toe, standard deviation, Pascal's triangle |
| `Assignment09/`| `Assignment9A`–`Assignment9D`                      | Methods: calculator, temperature converter, length converter, Heron's formula |
| `Assignment10/`| `Assignment10A`, `Assignment10B`                   | Bubble sort (ascending/descending), multi-key sort of player records |
| `Assignment11/`| `Assignment11A`                                    | String comparison (`compareToIgnoreCase`), alphabetical ordering |
| `GameOfLife/`  | `GameOfLife.java`                                  | Capstone project (see below)                                |

## Game of Life capstone

`GameOfLife/GameOfLife.java` implements Conway's Game of Life on a
22 rows × 80 columns grid (`*` = alive, space = dead). It includes a main
menu (random population, manual placement, preset patterns), the classic
Block, Blinker, and Glider presets, continuous and step-by-step simulation
modes, a live population count, and automatic stops when the population
dies out or stabilizes.

## How to compile and run

Requires a Java JDK (21 or compatible). Each assignment is standalone —
compile and run it from inside its own folder:

```text
cd Assignment07
javac Assignment7A.java
java Assignment7A
```

Same pattern for the capstone:

```text
cd GameOfLife
javac GameOfLife.java
java GameOfLife
```

## Notes

* Compiled `.class` files are build artifacts and are ignored by Git
  (see `.gitignore`). Only `.java` source files are tracked.
* File and folder names match the course assignment numbers.
