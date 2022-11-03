import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 3rd, 2022
/*Write a program that creates a simple minigame where two people roll dice. The person who gets the 
higher dice roll wins.*/

public class MiniIfGame {
    public static void main(String[] args) throws InterruptedException{
        try (Scanner in = new Scanner(System.in)) {
            //Dice Battle Introduction
            System.out.println("Welcome to Dice Battle!! \nThis game requires two players. \nTo win, you must get a higher dice roll than your opponent! \nPlease enter your names!");
            //Asks players if they want to play
            System.out.println("Do you want to play? (Y/N)");
            //Gets if the players want to play again
            String yesOrNo = in.nextLine();

            
            //Intro for player1
            System.out.print("\nEnter player 1's name: ");
            //Gets player1
            String player1 = in.nextLine();
            //Intro for player2
            System.out.print("\nEnter player 2's name: ");
            //Gets player2
            String player2 = in.nextLine();

            //Rolling of player 1's dice
            System.out.println("\n" + player1 + " rolls...");
            //Creates dice1 for player1
            int dice1 = (int) (Math.round(Math.random() * 6 + 1));
            //Initializes player1Score
            int player1Score = 0;
            //Rolling of player 2's dice
            System.out.println(player2 + " rolls...");
            //Creates dice2 for player2
            int dice2 = (int) (Math.round(Math.random() * 6 + 1));
            //Initializes player2Score
            int player2Score = 0;
            //Pauses for 2 seconds
            Thread.sleep(2000);


            //While the players say Y or Yes
            while (yesOrNo.equalsIgnoreCase("Y") || yesOrNo.equalsIgnoreCase("Yes")) {
                //If both dice rolls are the same
                if (dice1 == dice2) {
                    //Prints dice1 and dice2
                    System.out.println("\n" + player1 + "'s roll was " + dice1 + ". \n" + player2 + "'s roll was " + dice2 + ". \n");
                    System.out.println("\nDraw. No one wins.");
                    System.out.println("Do you want to play again? (Y/N)");
                    //Updates yesOrNo to see if the players want to play again
                    yesOrNo = in.next();
                }
                //If dice1 is greater than dice2
                else if (dice1 > dice2) {
                    //Prints dice1 and dice2
                    System.out.println("\n" + player1 + "'s roll was " + dice1 + ". \n" + player2 + "'s roll was " + dice2 + ". \n");
                    System.out.println(player1 + " wins this round!\n");
                    //Adds 1 to player1Score
                    player1Score++;
                    System.out.println("Do you want to play again? (Y/N)");
                    yesOrNo = in.next();
                } 
                //If dice1 is less than dice2
                else if (dice1 < dice2) {
                    //Prints dice1 and dice2
                    System.out.println("\n" + player1 + "'s roll was " + dice1 + ". \n" + player2 + "'s roll was " + dice2 + ". \n");
                    System.out.println(player2 + " wins this round!\n");
                    //Adds 1 to player2Score
                    player2Score++;
                    System.out.println("Do you want to play again? (Y/N)");
                    yesOrNo = in.next();
                }
                //For invalid input
                //THIS DOES NOT WORK
                else {
                    System.out.println("Your input was invalid.");
                    System.out.println("Do you want to play again? (Y/N)");
                    yesOrNo = in.next();
                }
            //End of loop
            Thread.sleep(1000);


            //Prints player1's score and player 2's score
            System.out.println("\n" + player1 + "'s score was " + player1Score + ". \n" + player2 + "'s score was " + player1Score + ". \n");
            //If both scores are the same
            if (player1Score == player2Score) {
               System.out.println("Draw, no one wins.");
            } 
            //If player 1's score is bigger than player 2's
            else if (player1Score > player2Score) {
                System.out.println(player1 + " wins!");
            }
            //If player 2's score is bigger than player 1's
            else if (player1Score < player2Score) {
                System.out.println(player2 + " wins!");
            }
}}}}