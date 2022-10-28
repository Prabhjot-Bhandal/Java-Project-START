import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 25th, 2022
/*Purpose: For this version of the game decide on the number of players. Next, get a sentence from the 
first player. Apply a variety of String methods to one or more String methods as the phrase is 
“whispered” to the next player so the message is changed in some way. Apply String methods to the 
updated message and keep whispering to the next player. Finally, show the original message and the 
message received by the last player.*/

public class Task4 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Introduction for the numberOfPlayers
            System.out.print("Please enter the number of players that are currently playing: ");
            //Gets numberOfPlayers
            int numberOfPlayers = in.nextInt();
            //Introduction to player1Phrase
            System.out.println("Please enter a phrase:");
            //Gets numberOfPlayers
            String player1Phrase = in.next();
            
        }
    }
}