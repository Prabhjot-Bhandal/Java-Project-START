import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 16th, 2022
/*Compares desired mark to actual mark and determines if the goal has been met, not met or surpassed.*/

public class MarkGoalChecker {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Introduction
            System.out.println("Time to see if you've reached your goal!");


            //Gets desiredMark
            System.out.print("To get started, please enter your desired mark: ");
            int desiredMark = in.nextInt();
            //Gets actualMark
            System.out.print("Now enter in your actual mark: ");
            int actualMark = in.nextInt();


            //Invalid marks if they are less than zero or greater than 100
            if (actualMark < 0 || actualMark > 100 || desiredMark < 0 || desiredMark > 100 ) {
                System.out.println("Please restart the program and enter in a valid mark.");
            }
            //Met
            else if (actualMark == desiredMark) {
                System.out.println("Congratulations!\nYou have reached your desired mark goal!");
            }
            //Not Met
            else if (actualMark < desiredMark) {
                System.out.println("You did not reach your goal...\nBetter luck next time!");
            }
            //Surpassed
            else if (actualMark > desiredMark) {
                System.out.println("GREAT WORK! You have surpassed your goal!\nKeep it up!");
            }
        }
    }
}
