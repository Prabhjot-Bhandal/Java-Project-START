import java.util.Scanner;
//Prabhjot Bhandal
//December 16th, 2022
/*Asks the user if they want to properly format their word or reverse their word.
 According to what the user picks, the program will either properly format or reverse the word.*/

public class WordFormatting {
    //Creates scanner object
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //Initializes properOrReverse
        String properOrReverse = "";

        //Loops back if the user does not input word or numbers when prompted
        do {
            //Gets properOrReverse
            System.out.print("\nWould you like to properly format your word or reverse it?\nPlease enter either \"proper\" or \"reverse\" as your answer: ");
            //Takes all the spaces out of the string and turns the string lowercase
            properOrReverse = in.nextLine().replaceAll(" ", "").toLowerCase();

            //Returns an error message if the user enters an incorrect input
            if (!properOrReverse.equalsIgnoreCase("proper") && !properOrReverse.equalsIgnoreCase("reverse")) {
                System.out.println("You must input either \"proper\" or \"reverse\" for your answer. Please try again.\n");
            }

        } while (!properOrReverse.equalsIgnoreCase("proper") && !properOrReverse.equalsIgnoreCase("reverse"));

        //Gets userWord
        System.out.print("\nPlease input a word: ");
        //Takes out any spaces the user may input
        String userWord = in.next().replaceAll(" ", "");

        //If user wants to properly format
        if (properOrReverse.equalsIgnoreCase("proper")) {
            //Calls properWordFormatting() method and assigns it to wordFormatted
            String wordFormatted = properWordFormatting(userWord);

            //Outputs userWord and wordFormatted
            System.out.println("The word you put in was " + userWord + ". The proper formatting of this word is " + wordFormatted + ".");
        }
        //If user wants to reverse their word
        else if (properOrReverse.equalsIgnoreCase("reverse")) {
            //Calls wordReverser() method and assigns it to wordReversed
            String wordReversed = wordReverser(userWord);

            //Outputs userWord and wordReversed
            System.out.println("The word you put in was " + userWord + ". Your reversed word will be " + wordReversed + ".");
        }
    }

//Methods that alters the user's words
    public static String properWordFormatting(String word) {
        //Gets first character of the word, makes it upper case
        //Then creates a substring of the rest of the word, and makes it lowercase
        word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();

        return word;
    } //properWordFormatting

    public static String wordReverser(String word) {
        //Initializes wordReversed
        String wordReversed = "";
        /*Sets counter equal to word length, runs while counter is above/equal to 0, counter subtracts 
        by 1 each time */
        /*We subtract 1 from the word length because if we start the for loop at the word length, 
         it will be out of bounds since the indices of the word includes 0 while the lengths does not.*/
        for (int counter = word.length() - 1; counter >= 0; counter--) {
            //Appends each letter from the last one to the first one to wordReversed
            wordReversed += word.substring(counter, counter + 1);
        }

        return wordReversed;
    } //wordReverser
}
