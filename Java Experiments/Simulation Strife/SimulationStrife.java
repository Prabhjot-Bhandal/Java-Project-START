import java.util.Scanner;
//Prabhjot Bhandal
//January 13th, 2022
/*Simulates a text and turn-based battle against an enemy, but everytime the program runs, 
 it's a different scenario*/

public class SimulationStrife {
    //Static variables that can be used across the enitre program
    //Input
    static Scanner in = new Scanner(System.in);
    //Player stats
    static int playerHP = 100;
    static int playerMP = 10;
    //Enemy stats
    static int enemyHP = 100;
 public static void main(String[] args) throws InterruptedException {
    //Game loop boolean
    boolean run = introduction();
    
    //Keeps running game 
    do {

    } while (run == true); //Game loop
 } //main

 public static boolean introduction() throws InterruptedException{
    //Introduces the game, asks the user if they want to play, returns a boolean
    System.out.println("Welcome to Simulation Strife!\n\nThis program simulates a text and turn-based battle (or strife), similar to many battles found in RPG games today. In Simulation Strife, each battle is against a singular, randomized enemy and your job is to defeat your enemy in battle. However, each move is a one-time use and your list of moves shuffles each time you play. This means that if you use one move, you cannot use that move again and the next move in the cycle replaces the move you just used. In addition to that, specific enemy attacks make it more difficult for you to defeat the enemy. If you’re not careful, your enemy will defeat you, so think your moves through and play carefully.");
    //Initializes runQuestion
    String runQuestion = "";
    Thread.sleep(4000);
    //Loop keeps running if the user does not input Y or N
    do {
      //Updates runQuestion with user input
      System.out.print("\nDo you want to play? (Y/N): ");
      runQuestion = in.next();
    } while (!runQuestion.equalsIgnoreCase("Y") && !runQuestion.equalsIgnoreCase("N")); //End of do-while

    //If the user wants to play (responds with Y), returns true
    if (runQuestion.equalsIgnoreCase("Y")) {
      return true;
    }
    //If the user responds with anything else, returns false
    else {
      return false;
    }
 } //introduction
}
