import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 21st, 2022
//Purpose: Takes the spaces out of the phrase

public class Task3 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Get a phrase
            System.out.println("Enter a phrase");
            String phrase = in.nextLine();
                    
            //Prints length of the phrase
            System.out.println("The phrase entered has "+ phrase.length() + " characters including spaces.\n");

            //Process for removing the spaces
            String phraseNoSpace = phrase.replaceAll(" ", ""); 

            //Show the phrase with spaces removed
            System.out.println("The phrase without spaces is:\n" + phraseNoSpace + "\n");
            //Show the number of characters in the phrase with after removing the spaces
            System.out.println("Your phrase without spaces has " + phraseNoSpace.length() + " characters.");
        }
    }
}
