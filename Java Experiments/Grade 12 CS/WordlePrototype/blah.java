package WordlePrototype;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class blah {
    
 
  //for (int index = 0; index<=userInputtedWords.length; index++){
    //userInputtedWords[index] = inputtedWord;
  
//Method to facilitate user input
  public static String getUserWord(){
    //get word from the user
    System.out.print("Enter the word: ");
    //initialize variable for the word from the user, converts it to upper case and takes out spaces before and after the guessed word
    String inputtedWord = input.next().toUpperCase().trim();
     //return the word value
    return inputtedWord;
    
  } //getUserWord

  public static void compareGuessToWord(String guess, String selectedWord) throws IOException {
    //Sets the file path
    readFile = new BufferedReader (new FileReader ("src/main/java/possibleWords.txt"));
    
    //Iterates through the guess string  
    for (int guessIndex = 0; guessIndex < guess.length(); guessIndex++) {
      //Iterates through the selected word string
      for (int selectedStrIndex = 0; selectedStrIndex < selectedWord.length(); selectedStrIndex++) {
        
        //Checks if the letter is in the word and if it is in the right spot
        if (guess.charAt(guessIndex) == selectedWord.charAt(selectedStrIndex) && guessIndex == selectedStrIndex) {
          printLetter(2, guess.charAt(guessIndex));
        }
        //Checks if the letter is in the word but not in the right spot
        else if (guess.charAt(guessIndex) == selectedWord.charAt(selectedStrIndex) && guessIndex != selectedStrIndex) {
          printLetter(1, guess.charAt(guessIndex));
        }
        //If the letter is not in the word at all
        else {
          printLetter(-1, guess.charAt(guessIndex));
        } //if statement
        
      } //selectedStrIndex for loop
      
    } //userStrIndex for loop
    
  } //compareGuessToWord

  
  public static void printLetter (int num, char currentUserLetter) {
    if (letterCount < 5) {
        if (num == -1) {
            System.out.print(currentUserLetter + " ");
            letterCount++;
          }
          else if (num == 1) {
            System.out.print("*" + currentUserLetter + "* ");
            letterCount++;
          }
          else if  (num == 2){
            System.out.print("!" + currentUserLetter + "! ");
            letterCount++;
          }
    }
    //Prints new line when printing the last letter
    else {
        if (num == -1) {
            System.out.println(currentUserLetter);
            letterCount++;
          }
          else if (num == 1) {
            System.out.println("*" + currentUserLetter + "*");
            letterCount++;
          }
          else if  (num == 2){
            System.out.println("!" + currentUserLetter + "! ");
            letterCount++;
          }
    }
    
    
    
  } //printLetter
  
}

}
