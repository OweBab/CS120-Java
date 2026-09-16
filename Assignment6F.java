import java.util.Scanner;

public class Assignment6F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer (n <= 9999):");
        int n = scanner.nextInt();
        int count = 0;

        for (int i = 1; i <= n; i++) {
            int temp = i;
            int ones = 0;
            int twos = 0;

            while (temp > 0) {
                int digit = temp % 10;
                if (digit == 1) {
                    ones++;
                } else if (digit == 2) {
                    twos++;
                }
                temp /= 10;
            }

            if (ones == twos + 1) {
                count++;
            }
        }

        System.out.println("Count: " + count);
        scanner.close();
    }
}
