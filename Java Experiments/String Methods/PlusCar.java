import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 26th, 2022
/*Write a program that gets a word from the user and creates a new word by inserting the word “car” after the 
first and third characters of the original word. The program should output the original word and the new 
word.*/

public class PlusCar {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Introduction for word
            System.out.print("Enter a word: ");
            //Gets word
            String word = in.next();

            //Adds "car" after the first and third characters
            String newWord = word.substring(0, 1) + "car" + word.substring(1, 3) + "car" + word.substring(3, word.length());

            //Prints word and newWord
            System.out.println("The word you entered in was " + word + ". \nYour new word is " + newWord + ".");
        }
    }
}
