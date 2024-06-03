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


    //TOSTRING METHOD
    public String toString() {
      /*Action: */
        

      
    }


    //INSTANCE METHODS
    public Highlighter[] selection
}
