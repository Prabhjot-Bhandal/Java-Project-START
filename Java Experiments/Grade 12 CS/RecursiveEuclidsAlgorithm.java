import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: March 21, 2024
//Purpose: To find the greatest common denominator (or factor) of two given numbers

public class RecursiveEuclidsAlgorithm {
    //Creates a scanner object for user input that can be used across all methods
    static Scanner in = new Scanner(System.in);
    /*Initializes num1 and num2 for a do-while loop to get valid input and so that we can use the original
     across all methods.*/
    static int num1 = -1;
    static int num2 = -1;
    public static void main(String[] args) {
        //Keeps repeating until the user enters a non-negative integer
        do {
            //Tells the user to input the first number
            System.out.print("\nPlease enter your first number: ");
            num1 = in.nextInt();
        } while (num1 < 0);
        
        //Keeps repeating until the user enters a non-negative integer
        do {
            //Tells the user to input the first number
            System.out.print("\nPlease enter your second number: ");
            num2 = in.nextInt();
        } while (num1 < 0);

        //Goes to the getGCD method to get the gcd
        getGCD(num1, num2);

    } //main


    //If we were to return an int for this method, we would want to add a return statement to every method call
    public static void getGCD(int num1GCD, int num2GCD) {
        /*Action: Gets the gcd of two given integers.
         Input: Two integer numbers.
         Output: The gcd of both numbers.*/

        /*BASE CASE: If the two integers get to the point where they both equal each other, it returns one 
        of them since this is the gcd of the two numbers given at the start*/
        if (num1GCD == num2GCD) {
           //Prints out the two numbers and their gcd
            System.out.println("\nThe greatest common denominator (or factor) between " + num1 + " and " + num2 + " is " + num1GCD + ".");
        }
        /*RECURSIVE CASE 1: If the first number is less then the second, it calls the method again, but swaps 
        them this time*/
        else if (num1GCD < num2GCD) {
            getGCD(num2GCD, num1GCD);
        }
        /*RECURSIVE CASE 2: If the second number is less then the first, it calls the method again, but 
        subtracts the first number by the second number*/
        else {
            getGCD(num1GCD - num2GCD, num2GCD);
        }
        
    } //getGCD
}