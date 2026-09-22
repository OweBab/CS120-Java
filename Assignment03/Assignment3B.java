import java.util.Scanner;

class Assignment3B
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        double num = input.nextDouble();

        double square = Math.pow(num, 2);
        double cube = Math.pow(num, 3);
        double fourth = Math.pow(num, 4);

        System.out.println("The square of " + num + " is " + square);
        System.out.println("The cube of " + num + " is " + cube);
        System.out.println("The fourth power of " + num + " is " + fourth);
    }
}
