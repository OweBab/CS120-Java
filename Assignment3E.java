import java.util.Scanner;

class Assignment3E
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first side length: ");
        double side1 = input.nextDouble();
        System.out.print("Enter the second side length: ");
        double side2 = input.nextDouble();

        double hypotenuse = Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
        double angle1 = Math.toDegrees(Math.atan2(side1, side2));
        double angle2 = Math.toDegrees(Math.atan2(side2, side1));

        System.out.println("Hypotenuse = " + hypotenuse);
        System.out.println("First acute angle = " + angle1 + " degrees");
        System.out.println("Second acute angle = " + angle2 + " degrees");
    }
}
