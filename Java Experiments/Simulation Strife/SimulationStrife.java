import java.util.Scanner;
//Prabhjot Bhandal
//January 13th, 2022
/*Simulates a text and turn-based battle against an enemy, but everytime the program runs, 
 it's a different scenario*/

public class SimulationStrife {
    //Static variables that can be used across the enitre program
    static Scanner in = new Scanner(System.in);
 public static void main(String[] args) throws InterruptedException {
    //Game loop boolean
    boolean run = introduction();
 } //main

 public static boolean introduction() throws InterruptedException{
    //Introduces the game, asks the user if they want to play, returns a boolean
    System.out.println("");
    //Initializes runQuestion
    String runQuestion = "";
    Thread.sleep(3000);
    //Loop keeps running if the user does not input Y or N
    do {
      //Updates runQuestion with user input
      System.out.print("\nDo you want to play? (Y/N): ");
      runQuestion = in.next();

    } while (runQuestion.equalsIgnoreCase("Y") || runQuestion.equalsIgnoreCase("N")); //End of do-while
    
 } //Introductions
}
