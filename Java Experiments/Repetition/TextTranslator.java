import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 21st, 2022
/*Purpose: Write a program that will continually input a short form and output the translation.*/

public class TextTranslator {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Gets phrase
            System.out.print("Enter a phrase: ");
            String phrase = in.nextLine().toUpperCase().replaceAll(" ", "");

            
        }
    }
}