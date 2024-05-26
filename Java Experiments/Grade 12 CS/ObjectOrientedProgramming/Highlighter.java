package ObjectOrientedProgramming;

public class Highlighter {
    //Represents a template for creating objects of type highlighter

    //Area highlighted
    //Longevity based on Ink Volume, average ink volume is 10 mL
    //Determine the brightness based on how much ink is left
    //Distance highlighted
    //Applied force for bleeding
    //Instance variables, the FEATURES, all numeric variables are in cm
    private double height;
    private double radius; //private makes it so that it can't be updated OUTSIDE this class, only accessed here
    private double tipWidth; 
    private String tipType;
    private String colour;

    //Constructer: Sets the initial values for highlighter objects
    //Class name will be your object's name
    //public means that the method can be called wherever
    public Highlighter() {
        //No parameters for this constructor method
        height = 0;
        radius = 0;
        tipWidth = 0;
        colour = "none";
        tipType = "none"; //Valid types: chisel, widnow, bullet, double-ended
    } //Highlighter

    /*We can make multiple constructor methods because we may want to make specific types of objects.
    Depends on what parameters the constructor method has*/

    //You NEED to call the constructor in order to create that specifc object
    public Highlighter(String colour) {
      /*Action: If a highlighter object is created with this constructor (only a colour is assigned),
        then, the highlighter's features will default to that of a regular Sharpie highlighter.
        Input: A colour string.
        Output: A highlighter object that has the same features as a Sharpie highlighter*/

        //This refers the the object's parameter
        //Every constructor made with the colour given, its colour values will be the given ones
        this.radius = 0.6;
        this.height = 11.9;
        this.tipType = "chisel";
        this.tipWidth = 0.5;
    } //Highlighter overloaded constructor


    //Accessors (getters) - to show the value of a variable declared private
    public double getRadius () {
        /*Action: Accesses the radius instance variable.
          Input: A highlighter object
          Output: The highlighter's radius*/
        return radius;
    } //getRadius

    public double getHeight() {
      /*Action: Acceseses the height instance variable.
        Input: A highlighter object
        Output: The highligher's height*/
      return height;
    } //getHeight

    public double getTipWidth() {
      /*Action: Acceseses the tipWidth instance variable.
        Input: A highlighter object
        Output: The highligher's tip width.*/
      return tipWidth;
    } //getTipWidth

    public String getColour() {
       /*Action: Acceseses the getColour instance variable.
        Input: A highlighter object
        Output: The highligher's colour*/
      return colour;
    } //getColour


    //Mutators (setters) - updates the value of an instance variable if it does not meet certain conditions
    public void setHeight(double height) {
      /*Action: Checks if the inputted height of the highlighter is valid.
        Input: A highlighter object and a height.
        Output: Ensures the highlighter object has a valid height.*/
      
      /*If the height inputted is above 3 cm, sets the current highlighter's
        height to the one inputted*/
      if (height > 3) {
        this.height = height;
      } 
      else {
        //If an invalid height was put in, sets the height to a default of 3 cm
        this.height = 3;
      }
    } //setHeight

    public void setTipWidth(double tipWidth) {
      /*Action: Checks if the inputted tipWidth of the highlighter is valid.
        Input: A highlighter object and a tipWidth.
        Output: Ensures the highlighter object has a valid tipWidth.*/

        /*If the tipWidth inputted is above 0 cm, sets the current highlighter's
        tipWidth to the one inputted*/
        if (tipWidth > 0) {
          this.tipWidth = tipWidth;
        }
        else {
          //If an invalid tipWidth was put in, sets the tipWidth to a default of 0.1 cm
          this.tipWidth = 0.1;
        }
    } //setTipWidth

    public void setRadius (double radius) {
        /*Action: Updates the value of an instance variable (usually private) if it does not meet certain
          conditions.
          Input: radius
          Output: A verified radius*/

        //If the radius is greater than 0 cm and less than 3 cm, it is valid
        if (radius > 0 && radius < 3) {
            //This object's radius will be the given one, updates the given object's radius
            this.radius = radius;
        }
        //If the radius isn't valid, updates that object's radius with a value of 1 cm
        else {
            this.radius = 1;
        }
    } //setRadius

    //TOSTRING METHOD
    public String toString() {
        /*Action: Returns a string representation of the value of each feature of the object.
          Input: A highlighter object.
          Output: The highlighter object's features.*/
        return("This highlighter has the following features,\nHeight: " + height + "cm \nRadius: " + radius + " cm \nTip Type: " + tipType + "\n Tip Width: " + tipWidth + " cm\nColour: " + colour);
    } //toString


    //COMPARISON METHODS
    public boolean isEqual(Highlighter highlighter) {
        /*Action: Checks if two objects are the same or not.
          Input: A highlighter object, highlighter.
          Output: A boolean refering to if the objects are the same or not
        */

        //This refers to the object that is doing .equals
        //If both highlighters have the same values for all their instance variables, they are the same
        if ((this.height == highlighter.height) && (this.radius == highlighter.radius) && (this.tipWidth == highlighter.tipWidth) && (this.colour.equalsIgnoreCase(highlighter.colour) == true) && (this.tipType.equalsIgnoreCase(highlighter.tipType) == true))  {
            return true;
        }

        //If both highlighters do not have the same values for the above features, they are not the same
        return false;

    } //isEqual

    public boolean isSmallerThan(Highlighter highlighter) {
      /*Action: Checks if one highlighter is smaller than another.
        Input: A highlighter object, highlighter.
        Output: A boolean refering to if the current highlighter is smaller than the other.*/

      /*If one of the current highlighter's numerical features are less than the the argument highlighter, 
      then the current highlighter is less than the argument highlighter.*/
      if ((this.height < highlighter.height) || (this.radius < highlighter.radius) || (this.tipWidth < highlighter.tipWidth))  {
          return true;
      }

      //If no features of the current highlighter's numerical features is less than the argument highlighter, it is not smaller
      return false;

  } //isSmallerThan

    public boolean isGreaterThan(Highlighter highlighter) {
      /*Action: Checks if one highlighter is greater than another.
        Input: A highlighter object, highlighter.
        Output: A boolean refering to if the current highlighter is greater than the other.*/

      /*If one of the current highlighter's numerical features are greater than the the argument highlighter, 
      then the current highlighter is greater than the argument highlighter.*/
      if ((this.height > highlighter.height) || (this.radius > highlighter.radius) || (this.tipWidth > highlighter.tipWidth))  {
          return true;
      }

      //If no features of the current highlighter's numerical features is greater than the argument highlighter, it is not greater
      return false;

    } //isGreaterThan


  //SPECIAL METHODS
  public double areaHighlighted(double tipWidth, int numOfRows) {
    /*Action: Finds the area (in cm^2) that the user has highlighted based on their highlighter's
      tipWidth and the number of rows highlighted.
      Input: tipWidth and numOfRows
      Output: The area the user has highlighted in cm^2.*/

    /*Finds the area by multiplying the highlighter's tipwidth by the number of rows highlighted.
      1 row is 17 cm.*/
    return tipWidth * (17 * numOfRows);

  } //areaHighlighted

     

} //highlighter
