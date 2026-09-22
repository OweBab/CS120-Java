import java.util.Scanner;

class Assignment3E
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number for first side: ");
        double side1 = input.nextDouble();
        System.out.print("Enter number for second side: ");
        double side2 = input.nextDouble();

        double sum = side1 * side1 + side2 * side2;
        double hypotenuse = Math.sqrt(sum);
        System.out.println("The hypotenuse is: " + hypotenuse);
        double angle1 = (Math.toDegrees(Math.atan2(side1, side2)));
        double angle2 = (Math.toDegrees(Math.atan2(side2, side1)));
        double acuteangles = (Math.toDegrees(Math.asin(side1 / hypotenuse)));
        double acuteangles2 = (Math.toDegrees(Math.asin(side2 / hypotenuse)));
        System.out.println("The acute angle is: " + acuteangles + "\u00B0 and " + acuteangles2 + "\u00B0");
    }
}
