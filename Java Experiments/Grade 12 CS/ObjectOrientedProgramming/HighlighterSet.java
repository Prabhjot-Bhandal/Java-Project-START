//Name: Prabhjot Bhandal
//Date: May 31, 2024

package ObjectOrientedProgramming;

public class HighlighterSet {
  //INSTANCE VARIABLES
  private Highlighter[] highlighterArray; //Actually holds the array
  private int arrayLength; //Length of the highlighter array
  final String[] COLOURS = {"red", "blue", "yellow", "green", "purple", "orange", "grey", "black", "white"}; //Array containing the possible colours of highlighter


  //CONSTRUCTORS
  public HighlighterSet() {
      /*Action: Constructs an array of highlighter objects using the default highlighter constructor.
        This will be a set of blank highlighters.
        Input: None
        Output: A filled highlighterArray of blank highlighters.*/

      /*Determines a random array length from 0 to 15 elements*/
      arrayLength = (int) (Math.random() * 16);
      //Instatiates the array's elements with the proper length of the array
      highlighterArray = new Highlighter[arrayLength];

      //Goes through each index of the highlighterArray and creates a blank highlighter for each index
      for (int index = 0; index < highlighterArray.length; index++) {
          highlighterArray[index] = new Highlighter();
      }

  } //HighlighterSet Constructor: Blank

  public HighlighterSet(int arrayLength) {
      /*Action: Constructs a set of highlighters with random colours and average dimensions IF the array length is not 9.
        Input: arrayLength
        Output: A filled highlighterArray with average size highlighters with random colouring,
                otherwise, it is an array of 9 highlighter objects, each with average dimensions and different
                colours.*/
      
      //Sets the the current array's arrayLength to the one given
      this.arrayLength = arrayLength; 
      //Instatiates the array's elements with the proper length of the array
      highlighterArray = new Highlighter[arrayLength];

      /*If the array length is equal to the length of the colours array, it will create a set of average-size
        highlighters each with a different colour.*/
      if (arrayLength == COLOURS.length) {
          /*Goes through each index of the array and creates a highlighter object with average dimensions
            a colour.*/
          for (int index = 0; index < highlighterArray.length; index++) {
              highlighterArray[index] = new Highlighter(COLOURS[index]);
          }
      }  

      /*Goes through each index of the highlighter array, generates a random colour and creates
        an average size highlighter with that colour*/
      for (int index = 0; index < highlighterArray.length; index++) {
          highlighterArray[index] = new Highlighter(COLOURS[(int)(Math.random() * COLOURS.length)]);
      }

  } //HighlighterSet Constructor: Average Dimensions with Random Colours or A Complete Highlighter Set


  //GETTERS
  public Highlighter[] getHighlighterArray() {
      /*Action: Gets an entire highlighter array.
        Input: A highlighterSet
        Output: The array.*/
      return highlighterArray;

  } //getHighlighterArray

  public int getArrayLength() {
      /*Action: Gets the length of a specific highlighter array as it cannot be changed outside
        of the highlighterSet class.
        Input: A highlighterSet
        Output: The length of the array.*/
      return arrayLength;

  } //getArrayLength

  
  //SETTERS
  public void setArrayLength(int arrayLength) {
    /*Action: Sets the array length to whatever the user inputs IF it is between 0 and 16 elements.
      Otherwise, it sets an automatic value of 3.
      Input: An integer
      Output: An altered arrayLength.*/

    //If inputted arrayLength is within the valid range, sets the arrayLength to the new one
    if (arrayLength > 0 && arrayLength < 16) {
      this.arrayLength = arrayLength;
    } 
    //If an invalid arrayLength is inputted, sets the arrayLength to an automatic number of 2
    else {
      arrayLength = 2;
    }

  } //setArrayLength


  //TOSTRING METHOD
  public String toString() {
    /*Action: Creates a string representation of the array of highlighters.
      Input: The array of highlighters (highlighterSet)
      Output: The highlighterSet's array length and the features of each highlighter object
      the array holds.*/

    //Creates a string that will hold the string that will be returned
    String returnString = ("This set has " + arrayLength + " highlighters. \n");
    //Instantiates a string variable that will hold the current highlighter object's string representation
    String currentHighlighter;

    //Goes through each element in the highlighterArray
    for (int index = 0; index < highlighterArray.length; index++) {
      /*Numbers the current highlighter and appends the the current highlighter's string representation
        to its number.*/
      currentHighlighter = ("\n\nHighlighter " + index + ":\n" + highlighterArray[index].toString());
      //Concatenates the current highlighter's string representation to the string that will be returned
      returnString += currentHighlighter; 
    }

    //Returns the now filled returnString will all string representations of every highlighter in the array
    return returnString;

  } //toString


  //INSTANCE METHODS
  public void insertionSortHighlighterHeight (Highlighter[] highlighterArray) {
    /*Action: Sorts a given array of highlighters (from smallest to biggest) based on their 
              heights.
      Input: One dimensional highlighter object array.
      Output: The sorted one dimensional highlighter object array.*/

      //Loops through the entire given highlighter object array
      for (int index = 1 ; index < highlighterArray.length ; index++) {
        //Stores the current element the loop is on in an empty highlighter object
        Highlighter item = highlighterArray[index];
        //Stores the current index in a seperate variable so that it can be used to swap later on
        int toPlace = index;

        /*While loop runs through all previous indices before the current one and compares the 
        current object's height to the heights of all the previous ones*/
        while (toPlace > 0 && item.getHeight() < highlighterArray[toPlace - 1].getHeight()) {
            //Assigns previous (and thus smaller) elements before the current element in the aray
            highlighterArray[toPlace] = highlighterArray[toPlace - 1];
            //Subtracts 1 so that we can look at the next element, works from the current index to the first
            toPlace--;
        } //While loop stops once the current comparison item is no longer smaller than the one before it

        //Switches the current element to the index where all of the ones after it are greater than it
        highlighterArray[toPlace] = item;
      }//for index

      //Returns the array
      this.highlighterArray = highlighterArray;

  } //insertionSortHighlighterHeight

  public Highlighter[] insertionSortHighlighterRadius (Highlighter[] highlighterArray) {
    /*Action: Sorts a given array of highlighters (from smallest to biggest) based on their 
              radii.
      Input: One dimensional highlighter object array.
      Output: The sorted one dimensional highlighter object array.*/

      //Loops through the entire given highlighter object array
      for (int index = 1 ; index < highlighterArray.length ; index++) {
        //Stores the current element the loop is on in an empty highlighter object
        Highlighter item = highlighterArray[index];
        //Stores the current index in a seperate variable so that it can be used to swap later on
        int toPlace = index;

        /*While loop runs through all previous indices before the current one and compares the 
        current object's radius to the radii of all the previous ones*/
        while (toPlace > 0 && item.getRadius() < highlighterArray[toPlace - 1].getRadius()) {
            //Assigns previous (and thus smaller) elements before the current element in the aray
            highlighterArray[toPlace] = highlighterArray[toPlace - 1];
            //Subtracts 1 so that we can look at the next element, works from the current index to the first
            toPlace--;
        } //While loop stops once the current comparison item is no longer smaller than the one before it

        //Switches the current element to the index where all of the ones after it are greater than it
        highlighterArray[toPlace] = item;
      }//for index

      //Returns the array
      return highlighterArray;

  } //insertionSortHighlighterRadius

  public Highlighter[] insertionSortHighlighterTipWidth (Highlighter[] highlighterArray) {
    /*Action: Sorts a given array of highlighters (from smallest to biggest) based on their 
              tip widths.
      Input: One dimensional highlighter object array.
      Output: The sorted one dimensional highlighter object array.*/

      //Loops through the entire given highlighter object array
      for (int index = 1 ; index < highlighterArray.length ; index++) {
        //Stores the current element the loop is on in an empty highlighter object
        Highlighter item = highlighterArray[index];
        //Stores the current index in a seperate variable so that it can be used to swap later on
        int toPlace = index;

        /*While loop runs through all previous indices before the current one and compares the 
        current object's tip width to the tip widths of all the previous ones*/
        while (toPlace > 0 && item.getTipWidth() < highlighterArray[toPlace - 1].getTipWidth()) {
            //Assigns previous (and thus smaller) elements before the current element in the aray
            highlighterArray[toPlace] = highlighterArray[toPlace - 1];
            //Subtracts 1 so that we can look at the next element, works from the current index to the first
            toPlace--;
        } //While loop stops once the current comparison item is no longer smaller than the one before it

        //Switches the current element to the index where all of the ones after it are greater than it
        highlighterArray[toPlace] = item;
      }//for index

      //Returns the array
      return highlighterArray;

  } //insertionSortHighlighterTipWidth


}
