public class Assignment10A {
    public static void main(String[] args) {
        int[] numbers = {97, 81, 12, 34, 56, 21, 75, 44};

        int[] ascending = numbers.clone();
        sortAscending(ascending);

        int[] descending = numbers.clone();
        sortDescending(descending);

        System.out.println("Ascending:");
        printArray(ascending);

        System.out.println();
        System.out.println("Descending:");
        printArray(descending);
    }

    // Bubble sort from smallest to largest
    public static void sortAscending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Bubble sort from largest to smallest
    public static void sortDescending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Print array values on one line separated by spaces
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
