import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 12th, 2022
/*Write a program that simulates the rolling of a fair die. Output what shows on the face that is up.*/

public class Problem4 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Intro for a
            System.out.print("Input a: ");
            //Gets a
            double a = in.nextDouble();
            //Intro for b
            System.out.print("Input b: ");
            //Gets b
            double b = in.nextDouble();
            //Intro for c
            System.out.print("Input c: ");
            //Gets c
            double c = in.nextDouble();

            //Determines discriminant, discriminant must be positive or else produces "NaN," stands for Not a Number
            double discriminant = Math.pow(b, 2) - (4 * a * c);
            //Determines one of the roots by adding to -b
            double posRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
            //Determines one of the roots by subtracting from -b
            double negRoot = (-b - Math.sqrt(discriminant)) / (2 * a);
            
            //Prints the user's data into a quadratic equation
            System.out.println("Your quadratic equation is y=" + a + "x^2+(" + b + "x)+(" + c + ").");
            //Prints the solutions to the user's quadratic equation
            System.out.println("Therefore, the solutions to this eqaution are " + posRoot + " and " + negRoot + ". \nIf the roots are NaN, that means there are no real roots because the discriminant is negative.");
        }
    }
}
