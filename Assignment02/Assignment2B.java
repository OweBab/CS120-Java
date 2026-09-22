class Assignment2B
{
    public static void main(String[] args)
    {
        int n1=1, n2=2, n3=3, n4=4, n5=5;
        double answer = 0.5;

        System.out.printf("The average of %d, %d, %d, %d, and %d is %d.\n", n1, n2, n3, n4, n5, (n1 + n2 + n3 + n4 + n5) / 5);
        System.out.printf("The sum of %d and %d is %d.\n", n2, n3, n2 + n3);
        System.out.printf("The product of %d and %d is %d.\n", n2, n2, n2 * n2);
        System.out.printf("The fraction %d divided by %d is %.1f.\n", n1, n2, (double) n1 / n2);
    }
}
