import java.util.Scanner;

class Assignment3D
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter a radius: ");
        double radius = input.nextDouble();

        double area = Math.PI * Math.pow(radius, 2);

        System.out.println("The area of a circle with radius " + radius + " is " + area);
    }
}
