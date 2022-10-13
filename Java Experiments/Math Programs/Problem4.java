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
            double a = in.nextInt();
            //Intro for b
            System.out.print("Input b: ");
            //Get b
            double b = in.nextInt();
            //Intro for c
            System.out.print("Input c: ");
            //Get c
            double c = in.nextInt();

            double posRoot = ((b * -1) + Math.sqrt(Math.pow(b, 2) - (4 * a * c)))/(2 * a);
            double negRoot = ((b * -1) - Math.sqrt(Math.pow(b, 2) - (4 * a * c)))/(2 * a);

            System.out.println("Your quadratic equation is y=" + a + "x^2+" + b + "x+" + c);
            System.out.println("Therefore, the solutions to this eqaution are " + posRoot + " and " + negRoot + ".");
        }
    }
}
