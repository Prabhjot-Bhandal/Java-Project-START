import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 26th, 2022
/*Write a program called MiddleThree that gets a string with at least three characters from the user and 
displays the three letters in the middle of the string.*/

public class MiddleThree {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Introduction for word
            System.out.println("Enter a word that contains at least 3 characters and has an odd number of characters:");
            //Gets word
            String word = in.next();

            /*Determines the middle number of the length of the string.
            We do not need to add 1 to the division because we would have to subtract 1 to determine the 
            middle index to include index 0.*/
            int middleIndex = word.length() / 2;
            /*Determines the middleThree characters in word.
            We add 2 to middleIndex because the substring that will be made does not include the second index
            parameter but rather goes up to it.*/
            String middleThree = word.substring(middleIndex - 1, middleIndex + 2);

            //Prints word and middleThree
            System.out.println("The word you entered in was " + word + ". \nTherefore, the middle three characters of " + word + " is " + middleThree + ".");
        }
    }
}
