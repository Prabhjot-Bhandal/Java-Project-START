import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: December 2nd, 2022
/*This program follows a process for determining the product of two positive integers using only 
multiplication by two, division by two, and addition.*/

public class DoubleAndHalveMultiplication {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Initializes num1, num2 and product
            int num1;
            int num2;
            int totalProduct = 0;
            //While num1 and num2 do not equal zero, keep asking for input and go through the process
            do {
                //Gets num1 and num2
                System.out.print("Please enter your first integer: ");
                num1 = in.nextInt();
                System.out.print("Please enter your second integer: ");
                num2 = in.nextInt();

                //Always output 0 is either num1 or num2 is 0
                if (num1 == 0 || num2 == 0) {
                    System.out.println("The product of " + num1 + " and " + num2 + " is 0.\n\n");
                }
                //Forces re-run of program because the user put in negative integers
                else if (num1 < 0 || num2 < 0) {
                    //Prints invalid
                    System.out.println("Your integers are invalid. Your integers must be positive.\n\n");
                }
                //If all integers get past all the validity checks
                else {
                    //Prints format for the chart
                    System.out.println("\nnum1 | num2\n");

                    //Will stop for loop if num2Calculation is equal to less than 1 and num2Calculation is divided by 2 each time
                    //Must run num1Calculation as a for loop parameter since if we put the command is in the loop, it only runs it once
                    for (int num2Calculation = num2, num1Calculation = num1; num2Calculation > 0; num2Calculation /= 2, num1Calculation *= 2) {
                        //If num2 is currently odd, adds num1Calculation to totalProduct
                        if (num2Calculation % 2 == 1) {
                            totalProduct += num1Calculation;
                            //Prints this round
                            System.out.println(num1Calculation + " | " + num2Calculation);
                        } 
                        //If num 2 is currently even, does not add num1Calculation to totalProduct and crosses out this round
                        else if (num2Calculation % 2 == 0) {
                            //Prints this round
                            System.out.println(num1Calculation + " | " + num2Calculation + "--CROSS");
                        }
                    }
                    
                    //Outputs num1, num2 and totalProduct
                    System.out.println("\nThe product of " + num1 + " and " + num2 + " is " + totalProduct + ".\n\n");
                }

            }// || operator is used instead of && because && breaks the logic of the code and would cause it to go on forever
            // || basically says to re-run this block while num1 and num2 do not have the desired values (which is 0)
            while (num1 != 0 || num2 != 0); //End of do-while


            //Tells the user that the program has ended
            System.out.println("Exit program.");
        } 
    }
}
