package WordlePrototype;
//Names: Prabhjot Bhandal, Sreyo Biswas and Bhuvan Ashwar
//Date: March 8, 2024
//Purpose: To create a wordle game that reads from a file of words

import java.util.Scanner;
import java.io.*;

public class WordlePrototype {
  //can be used across all class methods
  static BufferedReader readFile;
  //Initializes the scanner object to get input
  static Scanner input = new Scanner(System.in);
  //Initializes the selectedWord variable, holds the selected word String
  static String selectedWord = "";

  public static void main(String[] args) throws IOException {
    //Welcome message, explains how the formatting works and what it means
    System.out.println("Welcome to this Wordle Prototype!\nIt has the same rules as the regular game, however,\nletters regularly printed are not in the word,\nletters surrounded by \"*\" are in the word but not in the right spot and\nletters surrounded by \"!\" are in the word and in the right spot.\nLet's Play!");

    //Initializes selectedWordLine so that it can be checked in a do while loop
    int selectedWordLine = -1;

    do {
      //get random word from the list of words in text file
      selectedWordLine = (int) (Math.random() * getFileLineLength());
    } while (selectedWordLine == 0); //Ensures that the selected line is not 0
    

    //Reopens the file, if this statement isn't written then the computer does not go to that file to look at it
    readFile = new BufferedReader (new FileReader ("Grade 12 CS\\WordlePrototype\\possibleWords.txt"));

    //Gets the random word from the file using the random int generated
    String[] priorWordsToSelectedWord = new String[selectedWordLine];

    //Writes all the words up to the selected one into an array
    for (int index = 0; index < priorWordsToSelectedWord.length; index++) {
        priorWordsToSelectedWord[index] = readFile.readLine();
    }
    //Sets the selected word equal to the last element of this array
    selectedWord = priorWordsToSelectedWord[priorWordsToSelectedWord.length - 1];
    //Closes the file
    readFile.close();

    //Array of the user's guesses of the random word. The user has 6 guesses
    String[] userGuesses = new String[6];

    //For terminating the loop early if the user gets the right answer
    boolean terminateEarly = false;

    //Runs for all of the user's guesses
    for (int currentGuess = 0; currentGuess < userGuesses.length; currentGuess++) {
      //Calls the getUserWord method to get the user's guess and store it into their array of guesses
      userGuesses[currentGuess] = getUserWord();
      //Compares every user's guess to the selected word
      terminateEarly = compareAllGuessesToWord(userGuesses, currentGuess);

      //If terminateEarly is true, terminates the for loop early because the user got the selected word
      if (terminateEarly) {
        break;
      }

    }//Outer loop for running through each user's guess

    //Prints out the word if the user doesn't get it
    System.out.println("\nThe selected word was " + selectedWord + "!");
  } // main

  public static int getFileLineLength() throws IOException {
    /*Action: Gets the possibleWords.txt file's length (how many lines it has)
    Input: possibleWords.txt
    Output: Total number of lines in a file*/
    //Sets the path to read the file declare and initialize a variable readFile as a BufferedReader that reads data from the file possibleWords.txt, opens the file
    readFile = new BufferedReader(new FileReader("Grade 12 CS\\WordlePrototype\\possibleWords.txt"));
    int lines = 0;
    while (readFile.readLine() != null) {
      lines++;
      
    }
    readFile.close();
    return lines;
  } // getFileLineLength

  //Method to facilitate user input
  public static String getUserWord(){
    //Initializes the inputtedWord variable to store which word the user is inputting
    String inputtedWord = "";

    do {
      //get word from the user
      System.out.print("What is your guess?: ");
      //initialize variable for the word from the user, converts it to upper case and takes out spaces before and after the guessed word
      inputtedWord = input.next().toUpperCase().trim();

    } while (inputtedWord.length() != 5); //If the word is not 5 letters, forces the user to put in a word that is 5 letters

    //return the word value
    return inputtedWord;
  } //getUserWord

  public static boolean compareAllGuessesToWord(String[] userGuesses, int currentGuess) throws IOException {
    //Stores the numbers for each letter in the guessed word that indicate if they're in the word or not
    int[] guessCharInOrNot = new int[selectedWord.length()];
    /*Calls the compareCurrentGuessLetterToWord method, which compares each letter of the guess to the selected word
    and also calls the printLetter method to print if it is in the word and if it is in the correct
    spot*/
    for (int currentGuessStrIndex = 0; currentGuessStrIndex < selectedWord.length(); currentGuessStrIndex++) {
      //Stores if a letter is in the selected word or not into an array at the same index
      guessCharInOrNot[currentGuessStrIndex] = compareCurrentGuessLetterToWord(userGuesses[currentGuess], selectedWord, currentGuessStrIndex);
      /*Puts in the returned value that indicates if the current character of the user's guess is in the word or not 
      and if it is in the right place with the current char to print a representation of it being not in the word,
      in the word but not in the right place or in the word and in the right place for the user to see*/
      printLetter(guessCharInOrNot[currentGuessStrIndex], userGuesses[currentGuess].charAt(currentGuessStrIndex), currentGuessStrIndex);
      //Gets how many points the user gets for the current word they put in
      int points = getPoints(guessCharInOrNot);

      //If the user achieves the 10 points (the maximum), it terminates the loop early and says they got it
      if (points > 9) {
        System.out.println("You got it!");
        //Goes back to the main method early since the user got the right answer
        //If returns true, terminates early
        return true;
      }
    }//For loop that is looping through each letter of the user's guess

    //If returns false, keeps looping for all guesses
    return false;
  } //compareAllGuessesToWord

  public static int compareCurrentGuessLetterToWord(String guess, String selectedWord, int currentGuessIndex) throws IOException {
    //Holds the number that signifies if a letter is in the word and if it is in the right spot, used for printing
    //Initializes at -1 because if it meets none of these conditions, meaning it's not in the word, then it will say it is not in the word
    int inOrNot = -1; // Default value: letter is not in the word

    //Tracks if the guessed letter is found in the selected word
    boolean letterFound = false;

    //Tracks the index of the last occurrence where the guessed letter was found in the selected word
    int lastIndexFound = -1;

    //Goes through every letter of the selected word
    for (int selectedStrIndex = 0; selectedStrIndex < selectedWord.length(); selectedStrIndex++) {
      //If the letter is in the word
      if (guess.charAt(currentGuessIndex) == selectedWord.charAt(selectedStrIndex)) {
          //Says that the letter has been found
          letterFound = true;

          //Checks if the guessed letter is in the right spot
          if (currentGuessIndex == selectedStrIndex) {
            //Letter is in the right spot
            inOrNot = 2;
          } else {
            //Letter is found but not in the right spot
            inOrNot = 1;
          }

          //Update the last index where the guessed letter was found
          lastIndexFound = selectedStrIndex;
      }
    } //If the guessed letter is found, continue searching for subsequent occurrences, don't need to break out early

    //If the guessed letter is found but not in the right spot, and there are more occurrences in the word
    if (letterFound && inOrNot == 0) {
        //Continue searching for subsequent occurrences of the guessed letter
        for (int nextSelectedStrIndex = lastIndexFound + 1; nextSelectedStrIndex < selectedWord.length(); nextSelectedStrIndex++) {
            if (guess.charAt(currentGuessIndex) == selectedWord.charAt(nextSelectedStrIndex)) {
              //Letter is found but not in the right spot
                inOrNot = 1; 
                //Return as soon as we find the letter
                return inOrNot; 
            }
        }
    }

    //If letterFound is false, it means the guessed letter is not in the selected word
    if (!letterFound) {
      //Letter is not in the word
      inOrNot = -1; 
    }

    //Returns inOrNot if the letter is in fact not in the word
    return inOrNot;
    
  } //compareCurrentGuessLetterToWord

  
  public static void printLetter (int num, char currentUserLetter, int letterIndex) {
    //If not the last letter 
    if (letterIndex < 4) {
      //If not in the word, prints regularly
      if (num == -1) {
        System.out.print(currentUserLetter + " ");
      }
      //If the letter is in the word, but not in the right spot, prints with asterisks
      else if (num == 1) {
        System.out.print("*" + currentUserLetter + "* ");
      }
      //If the letter is in the word and in the right spot, prints with exclamation marks
      else if  (num == 2){
        System.out.print("!" + currentUserLetter + "! ");
      }
    }
    //If the last letter
    else {
      //If not in the word, prints regularly
      if (num == -1) {
        System.out.println(currentUserLetter);
      }
      //If the letter is in the word, but not in the right spot, prints with asterisks
      else if (num == 1) {
          System.out.println("*" + currentUserLetter + "*");
      }
      //If the letter is in the word and in the right spot, prints with exclamation marks
      else if  (num == 2) {
          System.out.println("!" + currentUserLetter + "! ");
      }
    }
  } //printLetter

  public static int getPoints(int[] guessCharInOrNot) {
    //Initializes a sum variable that holds how many points the user gains from their current guessed word, 10 = they got it
    int sum = 0;
    //Loops through every index of the array that holds the points for each letter
    for (int currentLetter = 0; currentLetter < guessCharInOrNot.length; currentLetter++) {
      //Adds each letter's score to the sum
      sum += guessCharInOrNot[currentLetter];
    }

    return sum;
  } //getPoints
} 