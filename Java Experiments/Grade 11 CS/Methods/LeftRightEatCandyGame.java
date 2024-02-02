import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: December 20th, 2022
//Purpose: 

public class LeftRightEatCandyGame {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String player1Name = getName(" player 1's ");
        String player2Name = getName(" player 2's ");
    } //main


    public static String getName(String whichPlayer) {
        //Takes in which player's name is being put in, gets the player's name from the user, returns the name

        //Get playerName
        System.out.print("Please enter " + whichPlayer + " name: ");
        String playerName = in.next();

        return playerName;
    } //getName

    public static int getCommand() {
        int command = 0;

        return command;
    }
}
