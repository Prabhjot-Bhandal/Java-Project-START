import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 1st, 2022

public class SelectionDemoNum {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Introduction
            System.out.println("Welcome to my Selection Demo with numbers.");
            System.out.println("\n\n You will be prompted for two numbers.");
            System.out.println("This program will indicate which integer is larger than the other. \n\n");

            //Prompt for the num1
            System.out.print("Please enter the first integer: ");
            int num1 = in.nextInt();
            //Prompt for the num2
            System.out.print("\nPlease enter the second integer: ");
            int num2 = in.nextInt();

            //If both numbers are the same
            if (num1 == num2) {
                //Prints that both integers are the same
                System.out.println("\nBoth integers are the same.");
            } 
            //If num1 is less than num2
            else if (num1 < num2) {
                System.out.println("\n" + num1 + " is less than " + num2 + ".");
            }
            //If num1 is greater than num2
            else if (num1 > num2) {
                System.out.println("\n" + num1 + " is greater than " + num2 + ".");
            };

            //Marks the end of the program
            /*If none of the conditons are fulfilled, the program skips if statement and goes 
            straight to the end*/
            System.out.println("Fin.");
        }
    }
}
