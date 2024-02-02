import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 1st, 2022
/*Write a program that creates a simple minigame where two people roll dice. The person who gets the 
higher dice roll wins.*/

public class DiceMinigame {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Dice Battle Introduction
            System.out.println("Welcome to Dice Battle!! \nThis game requires two players. \nTo win, you must get a higher dice roll than your opponent! \nPlease enter your names!");

            //Intro for player1
            System.out.print("\nEnter player 1's name: ");
            //Gets player1
            String player1 = in.nextLine();
            //Intro for player2
            System.out.print("\nEnter player 2's name: ");
            //Gets player2
            String player2 = in.nextLine();

            //Creates dice1 for player1
            double dice1 = (int) (Math.round(Math.random() + 1 * 6));
            //Initializes player1Score
            int player1Score = 0;
            //Creates dice2 for player2
            double dice2 = (int) (Math.round(Math.random() + 1 * 6));
            //Initializes player2Score
            int player2Score = 0;

            //If both dice rolls are the same
            if (dice1 == dice2) {
                System.out.print("\nDraw. No one wins.\n");
            }
            //If dice1 is greater than dice2
            else if (dice1 > dice2) {
                System.out.println(player1 + " wins this round!\n");
                //Adds 1 to player1Score
                player1Score++;
            } 
            //If dice1 is less than dice2
            else if (dice1 < dice2) {
                System.out.println(player2 + " wins this round!\n");
                //Adds 1 to player2Score
                player2Score++;
            }

            //Prints player1Score and player2Score
            System.out.println(player1 + "'s score was " + player1Score + ". \n" + player2 + "'s score was " + player2Score + ". \n");

            //If both players' scores are the same
            if (player1Score == player2Score) {
                System.out.println("Both players had the same score. Draw!");
            }
            //If player1's score greater than player2's score
            else if (player1Score > player2Score) {
                System.out.println(player1 + " wins!");
            } 
            //If player1's score is less than player2's score
            else if (player1Score < player2Score) {
                System.out.println(player2 + " wins!");
            } 
        }
    }
}