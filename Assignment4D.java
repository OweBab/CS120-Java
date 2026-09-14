public class Assignment4D {
    public static void main(String[] args) {
        System.out.println("Squares and cubes of 1-10");
        System.out.printf("%-9s%-9s%-9s%n", "Number", "Square", "Cube");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%-9d%-9d%-9d%n", i, i * i, i * i * i);
        }
    }
}
