import java.util.Scanner;

class Assignment3A
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the first number: ");
        int value1 = input.nextInt();
        System.out.print("Please enter the second number: ");
        int value2 = input.nextInt();

        int sum = value1 + value2;
        int product = value1 * value2;
        int difference = value1 - value2;
        double quotient = (double) value1 / value2;

        System.out.println("The sum of " + value1 + " and " + value2 + " is " + sum);
        System.out.println("The product of " + value1 + " and " + value2 + " is " + product);
        System.out.println("The difference of " + value1 + " and " + value2 + " is " + difference);
        System.out.println("The quotient of " + value1 + " and " + value2 + " is " + quotient);
    }
}
