import java.util.Scanner;
//Name: prabhjot Bhandal
//Date: October 11, 2022
//Purpose: To showcase different math methods

public class MathMethodsDemo {
    public static void main(String[] args) {
      try (Scanner in = new Scanner(System.in)) {
        //Intro to square root
        System.out.println("Enter in a number to square root: ");
        //Gets num
        double num = in.nextDouble();
        //Squre roots num using Math.sqrt() method
        double sqrtNum = Math.sqrt(num);
        //Prints the square root of a given number
        System.out.println("The square root of " + num + " is " + sqrtNum + ".\n");

        //Intro to base of the power
        System.out.println("Enter in the base of the power: ");
        //Gets base
        double base = in.nextDouble();
        //Intro to exponent to the power
        System.out.println("Enter in the exponent of the power: ");
        //Gets exponent
        double exponent = in.nextDouble();
        //Calculates the answer of the power using the Math.pow() method
        double answer = Math.pow(base, exponent);
        System.out.println(base + " to the exponent of " + exponent + " is equal to " + answer + ".");

        //Conventional rounding
        System.out.println(Math.round(7.825));
        //Rounding up
        System.out.println(Math.ceil(7.825));
        //Rounding down
        System.out.println(Math.floor(7.825));

        //Random between 0 and 1
        //Multiplying increases the range
        //Adding moves the minimal number up
        System.out.println(Math.random());
        double rnd = Math.random();
        System.out.println(rnd);
        //Multiplies rnd by 3 and multiplies it by 2
        rnd = rnd * 10 + 5;
        System.out.println(rnd);
        int rndInt = (int)(rnd);
        System.out.println(rndInt);
      }
      }
}
