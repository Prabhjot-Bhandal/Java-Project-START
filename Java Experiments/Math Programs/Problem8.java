import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 6th, 2022
/*Kierthan’s Garden Gallery ships orders of flower pots to customers. A large box holds 9 pots, 
a medium box holds 4 pots and a small pot holds 1 pot. Write a program to ship orders using the least 
number of boxes.*/

public class Problem8 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Introduction
            System.out.print("Enter the number of pots: ");
            //Gets numberOfPots
            int numberOfPots = in.nextInt();
            //Calculates numberOfLargeBoxes
            int numberofLargeBoxes = numberOfPots / 9;
            //Calculates the remaining pots
            int remainingPotsFromLarge = numberOfPots % 9;
            //Calculates numberOfMediumBoxes
            int numberOfMediumBoxes = remainingPotsFromLarge / 4;
            //Calculates numberOfSmallBoxes
            int numberOfSmallBoxes = remainingPotsFromLarge % 4;
            //Prints the numberOfPots, numberOfLargeBoxes, numberOfMediumBoxes, numberOfSmallBoxes
            System.out.println("Since we have a total of" + numberOfPots + " pots, we will need " + numberofLargeBoxes + " large boxes, " + numberOfMediumBoxes + " medium boxes and " + numberOfSmallBoxes + " small boxes to transport them all.");
        }
}
}