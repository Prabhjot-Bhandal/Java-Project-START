import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 6th, 2022
/*Write a program to show the coins necessary to return change to a customer after a purchase. 
The change can be made of: Quarters(0.25), Dimes(0.10), Nickels(0.05) and Pennies(0.01). 
Assume the change is less than $1.00 . The program prints the minimum number of coins needed.*/

public class Problem9 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Introduction
            System.out.print("Enter your change in cents (ex. 85): ");
            //Gets change
            int change = in.nextInt();
            //Calculates numberOfQuarters
            int numberOfQuarters = change / 25;
            //Calculates the quartersRemainder to see how much change is left after 
            int quartersRemainder = change % 25;
            //Calculates numberOfDimes by dividing the remaining change after the numberOfQuarters is calculates by 0.10
            int numberOfDimes = quartersRemainder / 10;
            //Calculates the left over change after determining the number of dimes
            int dimesRemainder = quartersRemainder % 10;
            //Calculates numbrOfNickels
            int numberOfNickels = dimesRemainder / 5;
            //Calculates numberOfPennies by getting the remainder of the remaining change left after calculating the numberOfDimes
            int numberOfPennies = dimesRemainder % 5;
            //Prints change, numberOfQuarters, numberOfDimes, numberOfNickels and numberOfPennies
            System.out.println("Since our total change is $" + change + ", we will have " + numberOfQuarters + " quarters, " + numberOfDimes + " dimes, " + numberOfNickels + " nickels and " + numberOfPennies + " pennies to make up the amount of change we have.");
        }
}
}