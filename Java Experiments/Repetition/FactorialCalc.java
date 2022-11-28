import java.util.Scanner;
//Prabhjot Bhandal
//November 28th, 2022
//Write a program that determines the factorial of a number

public class FactorialCalc {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int factorial = 1; // n! = 1x2x3x4x5x6...

            //Gets userNum
            System.out.print("Please enter a positive integer: ");
            int userNum = in.nextInt();

            //Loop runs for userNum times (factorial length)
            for (int counter = 1; counter <= userNum; counter += 1) {
                //Loop multiplies factorial by counter each time it runs (or userNum times)
               factorial *= counter;
            }

            //Outputs factorial
            System.out.println(userNum + "! = " + factorial);
        }
    }
}
