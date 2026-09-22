import java.util.Scanner;

class Assignment3C
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        double num1 = input.nextDouble();
        System.out.print("Enter number 2: ");
        double num2 = input.nextDouble();
        System.out.print("Enter number 3: ");
        double num3 = input.nextDouble();
        System.out.print("Enter number 4: ");
        double num4 = input.nextDouble();
        System.out.print("Enter number 5: ");
        double num5 = input.nextDouble();

        double average = (num1 + num2 + num3 + num4 + num5) / 5;

        System.out.println("The average is " + average);
    }
}
