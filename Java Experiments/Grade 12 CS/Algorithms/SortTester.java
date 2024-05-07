//Name: Prabhjot Bhandal
//Date: May 3rd, 2024

//For the file directory, says that the current class is in the Algoritms file
package Algorithms;

public class SortTester {
  /*Purpose: These objects will be used for testing different sorting algorithms, 
  and will be randomly generated for each test.*/

  //Instance variables, the feature of the object
  int integer;
  String string;
  char character;
  
  //Houses the the available characters, static so that it only stays in this class
  static String availableChars = "0123456789abcdefghijklmnopqrstuvwxyz";

  //CONSTRUCTOR
  //Parameter is stringLength, basically for the user picking how long they want the strings to be
  public SortTester(int stringLength) {
    /*Action: Constructs a SortTester object that has a random, int, string and char.
      Input: None.
      Output: The object with its randomly generated values.*/

    //Randomly generates an integer from 0 to 100
    integer = (int) (Math.random() * 100);

    //Randomly generates a string with a specified length from the user
    string = stringRandomizer(stringLength);

    //Randomly generates a char from the availableChars string
    character = availableChars.charAt((int) (Math.random() * availableChars.length()));

  } //SortTester Constructor


  public static String stringRandomizer(int stringLength) {
    /*Action: Generates a string of random characters within the alphabet and numbers.
      Input: The string length for all randomly generated strings.
      Output: The randomized string.*/

      //Creates a string builder object that will house all of the selected characters
      StringBuilder randStr = new StringBuilder();

      //Generates each character individually, specifies how many chars will be generated
      for (int index = 0; index < stringLength; index++) {
        //Generates an index within the availableChars string
        int charIndex = (int) (Math.random() * availableChars.length());

        /*Gets the generated char using the index that was generated from the availableChars 
        string, stores it into the StringBuilder object*/
        randStr.append(availableChars.charAt(charIndex));
      } //for loop for generating the string

      //Converts all the chars that the StringBuilder object contained into a string object
      String generatedString = randStr.toString();

      //Returns the randomly generated string
      return generatedString;

  } //stringRandomizer

} //SortTester class
