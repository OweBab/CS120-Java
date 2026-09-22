public class Assignment8B {
    public static void main(String[] args) {
        int[][] scores = {
            {87, 73, 88, 92},
            {65, 57, 69, 60},
            {52, 57, 62, 63}
        };

        // Average for each student (each row)
        for (int student = 0; student < scores.length; student++) {
            int sum = 0;
            for (int test = 0; test < scores[student].length; test++) {
                sum += scores[student][test];
            }
            double average = (double) sum / scores[student].length;
            System.out.println("Student " + (student + 1) + " average: " + average);
        }

        System.out.println();

        // Average for each test (each column)
        for (int test = 0; test < scores[0].length; test++) {
            int sum = 0;
            for (int student = 0; student < scores.length; student++) {
                sum += scores[student][test];
            }
            double average = (double) sum / scores.length;
            System.out.println("Test " + (test + 1) + " average: " + average);
        }
    }
}
