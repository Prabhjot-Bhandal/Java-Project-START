//Name: Prabhjot Bhandal
//Date: May 31, 2024

package ObjectOrientedProgramming;

public class HighlighterSet extends Highlighter{
  //INSTANCE VARIABLES
  private Highlighter[] highlighterArray; //Actually holds the array
  private int arrayLength; //Length of the highlighter array


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

  public HighlighterSet(String[] colourOptions, String[] tipTypeOptions) {
    /*Action: Constructs an array of highlighter objects using the randomized highlighter constructor.
      This will create a randomized number of highlighters with randomized features.
      Input: colourOptions array, tipTypeOptions array
      Output: A filled highlighterArray of randomized highlighters.*/

      /*Determines a random array length from 0 to 15 elements*/
      arrayLength = (int) (Math.random() * 16);
      //Instatiates the array's elements with the proper length of the array
      highlighterArray = new Highlighter[arrayLength];

      //Goes through each index of the highlighterArray and creates a blank highlighter for each index
      for (int index = 0; index < highlighterArray.length; index++) {
          highlighterArray[index] = new Highlighter(colourOptions, tipTypeOptions);
      }

  } //HighlighterSet Constructor: Randomized Highlighters

  public HighlighterSet(String[] colourOptions, String[] tipTypeOptions, int arrayLength) {
    /*Action: Constructs an array of highlighter objects using the randomized highlighter constructor.
      This will create a set number of highlighters with randomized features.
      Input: colourOptions array, tipTypeOptions array, arrayLength
      Output: A filled highlighterArray of randomized highlighters.*/

      //Instatiates the array's elements with the proper length of the array
      highlighterArray = new Highlighter[arrayLength];

      //Goes through each index of the highlighterArray and creates a blank highlighter for each index
      for (int index = 0; index < highlighterArray.length; index++) {
          highlighterArray[index] = new Highlighter(colourOptions, tipTypeOptions);
      }

  } //HighlighterSet Constructor: A Set Amount of Randomized Highlighters


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
    String returnString = ("This set has " + this.highlighterArray.length + " highlighters. \n");
    //Instantiates a string variable that will hold the current highlighter object's string representation
    String currentHighlighter;

    //Goes through each element in the highlighterArray
    for (int index = 0; index < this.highlighterArray.length; index++) {
      /*Numbers the current highlighter and appends the the current highlighter's string representation
        to its number.*/
      currentHighlighter = ("\n\nHighlighter " + index + ":\n" + this.highlighterArray[index].toString());
      //Concatenates the current highlighter's string representation to the string that will be returned
      returnString += currentHighlighter; 
    }

    //Returns the now filled returnString will all string representations of every highlighter in the array
    return returnString;

  } //toString


  //INSTANCE METHODS
  public Highlighter[] insertionSortHighlighterHeight() {
    /*Action: Sorts a given array of highlighters (from smallest to biggest) based on their 
              heights.
      Input: One dimensional highlighter object array.
      Output: The sorted one dimensional highlighter object array.*/

      //Loops through the entire given highlighter object array
      for (int index = 1 ; index < this.highlighterArray.length ; index++) {
        //Stores the current element the loop is on in an empty highlighter object
        Highlighter item = this.highlighterArray[index];
        //Stores the current index in a seperate variable so that it can be used to swap later on
        int toPlace = index;

        /*While loop runs through all previous indices before the current one and compares the 
        current object's height to the heights of all the previous ones*/
        while (toPlace > 0 && item.getHeight() < this.highlighterArray[toPlace - 1].getHeight()) {
            //Assigns previous (and thus smaller) elements before the current element in the aray
            this.highlighterArray[toPlace] = this.highlighterArray[toPlace - 1];
            //Subtracts 1 so that we can look at the next element, works from the current index to the first
            toPlace--;
        } //While loop stops once the current comparison item is no longer smaller than the one before it

        //Switches the current element to the index where all of the ones after it are greater than it
        this.highlighterArray[toPlace] = item;
      }//for index

      //Returns the array
      return highlighterArray;

  } //insertionSortHighlighterHeight

  public Highlighter[] insertionSortHighlighterRadius() {
    /*Action: Sorts a given array of highlighters (from smallest to biggest) based on their 
              radii.
      Input: One dimensional highlighter object array.
      Output: The sorted one dimensional highlighter object array.*/

      //Loops through the entire given highlighter object array
      for (int index = 1 ; index < this.highlighterArray.length ; index++) {
        //Stores the current element the loop is on in an empty highlighter object
        Highlighter item = this.highlighterArray[index];
        //Stores the current index in a seperate variable so that it can be used to swap later on
        int toPlace = index;

        /*While loop runs through all previous indices before the current one and compares the 
        current object's radius to the radii of all the previous ones*/
        while (toPlace > 0 && item.getRadius() < this.highlighterArray[toPlace - 1].getRadius()) {
            //Assigns previous (and thus smaller) elements before the current element in the aray
            this.highlighterArray[toPlace] = this.highlighterArray[toPlace - 1];
            //Subtracts 1 so that we can look at the next element, works from the current index to the first
            toPlace--;
        } //While loop stops once the current comparison item is no longer smaller than the one before it

        //Switches the current element to the index where all of the ones after it are greater than it
        this.highlighterArray[toPlace] = item;
      }//for index

      //Returns the array
      return highlighterArray;

  } //insertionSortHighlighterRadius

  public Highlighter[] insertionSortHighlighterTipWidth() {
    /*Action: Sorts a given array of highlighters (from smallest to biggest) based on their 
              tip widths.
      Input: One dimensional highlighter object array.
      Output: The sorted one dimensional highlighter object array.*/

      //Loops through the entire given highlighter object array
      for (int index = 1 ; index < this.highlighterArray.length ; index++) {
        //Stores the current element the loop is on in an empty highlighter object
        Highlighter item = this.highlighterArray[index];
        //Stores the current index in a seperate variable so that it can be used to swap later on
        int toPlace = index;

        /*While loop runs through all previous indices before the current one and compares the 
        current object's tip width to the tip widths of all the previous ones*/
        while (toPlace > 0 && item.getTipWidth() < this.highlighterArray[toPlace - 1].getTipWidth()) {
            //Assigns previous (and thus smaller) elements before the current element in the aray
            this.highlighterArray[toPlace] = this.highlighterArray[toPlace - 1];
            //Subtracts 1 so that we can look at the next element, works from the current index to the first
            toPlace--;
        } //While loop stops once the current comparison item is no longer smaller than the one before it

        //Switches the current element to the index where all of the ones after it are greater than it
        this.highlighterArray[toPlace] = item;
      }//for index

      //Returns the array
      return highlighterArray;

  } //insertionSortHighlighterTipWidth

  public int linearSearchHighlighterColour(String findColour) {
    /*Action: Searches through the highlighter set for a highlighter with the given colour.
      Input: The colour to find and the highlighter object.
      Ouput: The index at which the the colour highlighter is in the array.*/

    //Creates a for loop to search for the highlighter with the given colour
    for (int currentIndex = 0; currentIndex < this.highlighterArray.length; currentIndex++) {
        /*If the highlighter with the desired colour is found, it will return the index at which 
        the highlighter was found in the array*/
        if (findColour.equals(this.highlighterArray[currentIndex].colour)) {
            return currentIndex;
        }
    }

    //If the value was not found in the array, it will return a value of -1
    return -1;

  } //linearSearchHighlighterColour

  public double totalVolume() {
    /*Action: Finds the total volume of all of the highlighters in the array.
      Input: A highlighter set.
      Output: The total volume of all the highlighters.*/
  
    //Instantiates the variable that holds the total volume of all the highlighters
    double totalVolume = 0;

    //Goes through every highlighter in the set
    for (int index = 0; index < this.highlighterArray.length; index++) {
      //Finds the volume of the current highlighter and adds it to the total volume
      totalVolume += this.highlighterArray[index].highlighterVolume();
    } 

    //Returns the total volume of all the highlighters
    return totalVolume;

  } //totalVolume

  public double totalInkVol() {
    /*Action: Finds the total ink volume of all of the highlighters in the array.
      Input: A highlighter set.
      Output: The total ink volume of all the highlighters.*/
  
    //Instantiates the variable that holds the total ink volume of all the highlighters
    double totalInkVol = 0;

    //Goes through every highlighter in the set
    for (int index = 0; index < this.highlighterArray.length; index++) {
      //Finds the ink volume of the current highlighter and adds it to the total volume
      totalInkVol += this.highlighterArray[index].startingInkVol();
    } 

    //Returns the total ink volume of all the highlighters
    return totalInkVol;

  } //totalInkVol

  public double totalNumOfWords() {
    /*Action: Finds the total number of words of all of the highlighters in the array.
      Input: A highlighter set.
      Output: The total number of words of all the highlighters.*/
  
    //Instantiates the variable that holds the total number of words of all the highlighters
    double totalNumOfWords = 0;

    //Goes through every highlighter in the set
    for (int index = 0; index < this.highlighterArray.length; index++) {
      //Finds the number of words of the current highlighter and adds it to the total number of words
      totalNumOfWords += this.highlighterArray[index].startingNumOfWords();
    } 

    //Returns the total number of words of all the highlighters
    return totalNumOfWords;

  } //totalNumOfWords

} //highlighterSet class
