import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 12th, 2022
/*Write the process for determining the distance between two points on the Cartesian plane.*/

public class Problem5 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Intro for x1
            System.out.print("Input x1: ");
            //Gets x1
            double x1 = in.nextDouble();
            //Intro for y1
            System.out.print("Input y1: ");
            //Gets y1
            double y1 = in.nextDouble();
            //Intro for x2
            System.out.print("Input x2: ");
            //Gets x2
            double x2 = in.nextDouble();
            //Intro for y2
            System.out.print("Input y2: ");
            //Gets y2
            double y2 = in.nextDouble();

            //Determines xSquared which has the square of the difference of x1 and x2
            double xSquared = Math.pow((x2 - x1), 2);
            //Determines ySquared which has the square of the difference of y1 and y2
            double ySquared = Math.pow((y2 - y1), 2);
            //Calculates distance by adding up xSquared and ySquared, then gets the square root of the sum
            double distance = Math.sqrt((xSquared + ySquared));

            //Prints x1, x2, y1, y2 and distance
            System.out.println("Your first point was (" + x1 + ", " + y1 + ") and your second point was (" + x2 + ", " + y2 + ").\nTherefore, the distance between these two points is ~" + distance + " units.");
        }
    }
}
