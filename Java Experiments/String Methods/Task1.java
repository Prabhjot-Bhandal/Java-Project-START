import java.util.Scanner;
//Name: Prabhjot Bhandal
//Fate: October 20th, 2022
/*Purpose: Get a String from the user
Generate a random integer that is one of the indices of the user’s input 
Show the character at the random index*/

public class Task1 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //userStr Introduction
            System.out.print("Please type in a word: ");
            //Gets userStr
            String userStr = in.next();

            //Generates a randomIndex between 0 and the length of the user's string and rounds it
            double randomIndex = Math.round(Math.random() * userStr.length());
            
            //Prints randomIndex and the corresponding character to that index
            System.out.println("The random integer that was produced was " + ((int) randomIndex) + ".\nThe corresponing index to this integer is " + userStr.charAt((int) randomIndex) + ".");
            }
    }
}
