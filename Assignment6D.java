public class Assignment6D {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            int sum = 0;
            int temp = i;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            System.out.println(i + ": " + sum);
        }
    }
}
