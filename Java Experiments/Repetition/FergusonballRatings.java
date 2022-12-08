import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: December 7th, 2022
/*Purpose: Asks the user for the number of players on a Fergusonball Team and how many points and fouls each player has,
 then the program calculates how many players have more than 40 stars and if the team is a gold team.*/

public class FergusonballRatings {
    public static void main(String[] args) throws InterruptedException{
        try (Scanner in = new Scanner(System.in)) {
            //Initializes playerPoints, playerFouls and playersMoreThan40
            int playerPoints = 0;
            int playerFouls = 0;
            int playersAbove40 = 0;


            //Gets numOfPlayers
            System.out.print("Please enter the number of players on the team: ");
            int numOfPlayers = in.nextInt();
            System.out.println();

            //Loops until the info of all players have been entered
            for (int counter = 1; counter <= numOfPlayers; counter++) {
                //Repeats if any negative integers are entered
                do {
                    //Gets playerPoints
                    System.out.print("\nPlease enter player " + counter + "'s number of points: ");
                    playerPoints = in.nextInt();
                    //Gets playerFouls
                    System.out.print("Please enter player " + counter + "'s number of fouls: ");
                    playerFouls = in.nextInt();
                } while (playerPoints < 0 || playerFouls < 0);

                //Players earn 5 stars for each point they earn and lose 3 stars for each foul they commit
                int playerStars = (playerPoints * 5) - (playerFouls * 3);

                //Adds 1 to the number of players that have more than 40 stars if the player has more than 40 stars
                if (playerStars > 40) {
                    playersAbove40++;
                }
            }


            //All players have a star rating above 40
            if (playersAbove40 == numOfPlayers) {
                //Outputs playersAbove40
                System.out.println("\n\nThe star rating of this Fergusonball team is " + playersAbove40 + "+.\nThis is a GOLD TEAM!");
            } 
            //NOT all players have a star rating above 40
            else {
                //Outputs playersAbove40
                System.out.println("\n\nThe star rating of this Fergusonball team is " + playersAbove40 + ".\nOnly " + playersAbove40 + " player(s) have a star rating above 40.");
            }
        }
    }
}