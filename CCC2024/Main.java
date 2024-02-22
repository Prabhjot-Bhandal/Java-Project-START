package CCC2024;

//CCC 2024 S2: Heavy-Light Composition
import java.util.Scanner;

public class Main {
static Scanner in = new Scanner(System.in);
static String[] strings;
static boolean alternateOrNot = false;
static int T;
static int N;
    public static void main(String[] args) throws Exception{
        //# of Strings
        T = in.nextInt();
        //The length of each string
        N = in.nextInt();

        //Sets the length of the strings array to be how many strings we have
        strings = new String[T];

        //Gets input for all the strings
        for(int i = 0; i < strings.length; i++) {
            strings[i] = in.next();
        }

        for(int currentString = 0; currentString < strings.length; currentString++) {
            String alternateOrNot = checkAlternate(strings[currentString]);
            System.out.println(alternateOrNot);
        }

    } //main

    public static String checkAlternate(String currentString) {
        String alternateOrNot;
            for(int currentChar = 0; currentChar < currentString.length(); currentChar++) {
                //If first char, looks at one after only
                if (currentChar == 0) {
                    if (currentString.substring(currentChar, currentChar + 1).equalsIgnoreCase(currentString.substring(currentChar + 1, currentChar + 2)) == true) {
                        return alternateOrNot = "F";
                    }
                }
                //If last char, only looks at one before
                else if (currentChar == currentString.length() - 1) {
                    if ((currentString.substring(currentChar).equalsIgnoreCase(currentString.substring(currentChar - 1, currentChar)) == true)) {
                        return alternateOrNot = "F";
                    }
                }
                else {
                    if ((currentString.substring(currentChar, currentChar + 1).equalsIgnoreCase(currentString.substring(currentChar - 1, currentChar)) == true) || (currentString.substring(currentChar, currentChar + 1).equalsIgnoreCase(currentString.substring(currentChar + 1, currentChar + 2)) == true)) {
                        return alternateOrNot = "F";
                    } 
                }
            }
        return alternateOrNot = "T";
    }
} //checkAlternate