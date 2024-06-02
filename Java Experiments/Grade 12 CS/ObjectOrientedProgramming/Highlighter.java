//Name: Prabhjot Bhandal
//Date: May 29th
package ObjectOrientedProgramming;

public class Highlighter {
    //Represents a template for creating objects of type highlighter

    //Instance variables, the FEATURES, all numeric variables are in cm
    //private makes it so that it can't be updated OUTSIDE this class, only accessed here
    private double height;
    private double radius; 
    private double tipWidth; 
    //Made strings public as they don't have important calculations
    public String tipType;
    public String colour;

    /*This constant is based on the following statistics:
      Average Ink Volume: 10 mL
      Highlighter Dimensions for this Ink Volume:
      Height: 12.8 cm 
      Radius: 0.35 cm*/
    //Multiply this constant by any volume to get how much ink 
    final double INK_VOL_CONSTANT = 10 / (Math.pow(0.35, 2) * 12.8 * Math.PI);

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

        /*This refers the the object's parameter. Every constructor made with the colour given, 
        its colour values will be the given ones. These measruements are based off of the average
        highlighter.*/
        this.radius = 0.35;
        this.height = 12.8;
        this.tipType = "chisel";
        this.tipWidth = 0.3;
        this.colour = colour;
    } //Highlighter overloaded constructor

    public Highlighter(double height, double radius, double tipWidth, String colour, String tipType) {
      /*Action: Creates a highlighter object that has all of its features defined by a user/external data source.
        Input: height, radius, tipWidth, colour, tipType
        Output: A highlighter object with all of its features defined by the user.*/

        //Sets the objects features to the  data put in by the user/program
        this.radius = radius;
        this.height = height;
        this.tipType = tipType;
        this.tipWidth = tipWidth;
        this.colour = colour;

    } //Highlighter overloaded constructor #2


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

        /*If the tipWidth inputted is above 0 cm and less than or equal to 2 cm, sets the current 
        highlighter's tipWidth to the one inputted*/
        if (tipWidth > 0 && tipWidth <= 2) {
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
        return("This highlighter has the following features,\nHeight: " + height + "cm \nRadius: " + radius + " cm \nTip Type: " + tipType + "\nTip Width: " + tipWidth + " cm\nColour: " + colour);
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
    public double areaHighlighted(double tipWidth, double numOfRows) {
      /*Action: Finds the area (in cm^2) that the user has highlighted based on their highlighter's
        tipWidth and the number of rows highlighted.
        Input: tipWidth and numOfRows
        Output: The area the user has highlighted in cm^2.*/

      /*Finds the area by multiplying the highlighter's tipwidth by the number of rows highlighted.
        1 row is 17 cm.*/
      return tipWidth * (17 * numOfRows);

    } //areaHighlighted

    public double highlighterVolume(double height, double radius) {
      /*Action: Finds the volume (in mL, 1 cm^3 = 1 mL) of a highlighter object.
        Input: height and radius
        Output: It's volume*/

      //Uses a cylinder formula as most highlighters are cylinders
      return Math.PI * Math.pow(radius, 2) * height;

    } //highlighterVolume

    public double startingInkVol(double height, double radius) {
      /*Action: Finds the volume of ink in mL a highlighter object starts with based on its volume.
        Input: height and radius.
        Output: The highlighter's starting volume of ink in mL.*/

      /*Multiplies the highlighter's volume by the ink constant, constant determined with the data of
        how much ink a highlighter has based on its volume*/
      return INK_VOL_CONSTANT * highlighterVolume(height, radius);

    } //startingInkVol

    public int startingNumOfWords(double height, double radius) {
      /*Action: Finds the total number of words a brand new highlighter can highlight.
        Input: height and radius.
        Output: The total number of words a brand new highlighter can highlight.*/

      /*On average, 0.0002 mL of ink is used to highlight a word, so it will be the volume
        of ink in the highlighter divided by how many mL's of ink is used per word*/
      return (int) (startingInkVol(height, radius) / 0.0002);

    } //startingInkVol

    public double remainingInkVol(double height, double radius, int wordsHighlighted) {
      /*Action: Finds the remaining volume of ink (in mL) left in a highlighter object, based on
        the number of words its highlighted.
        Input: Height, Radius, wordsHighlighted
        Output: The remaining amount of ink left in the highlighter in mL.*/

        /*On average, 0.0002 mL of ink is used to highlight a word, so the remaining amount of
        ink left would be its starting volume subtracted by volume of ink already used.*/
        double inkLeft = startingInkVol(height, radius) - (0.0002 * wordsHighlighted);

        //If the inkLeft is negative, just returns 0, otherwise, returns the amount of inkLeft
        if (inkLeft <= 0) {
          return 0;
        }
        else {
          return inkLeft;
        }

    } //remainingInkVol

    public double remainingInkVol(double height, double radius, double inkVolUsed) {
      /*Action: Finds the remaining volume of ink (in mL) left in a highlighter object, based on
        the amount of ink used in mL.
        Input: Height, Radius, inkVolUsed
        Output: The remaining amount of ink left in the highlighter in mL.*/

      /*Subtract the amount of ink used by the starting amount to get the amount remaining.*/
      double inkLeft = startingInkVol(height, radius) - inkVolUsed;

      //If the inkLeft is negative, just returns 0, otherwise, returns the amount of inkLeft
      if (inkLeft <= 0) {
        return 0;
      }
      else {
        return inkLeft;
      }

    } //remainingInkVol

    public int remainingNumOfWords(double height, double radius, int wordsHighlighted) {
      /*Action: Finds the remaining number of words the current highlighter can highlight,
        based on the number of words highlighted.
        Input: height, radius, wordsHighlighted
        Output: The remaining number of words the current highlighter can highlight.*/

      /*Gets the remaining number of words left in a highlighter object's lifespan by
        subtracting from its starting amount with the number of words that have already 
        been highlighted.*/
      int wordsLeft = (int) (startingNumOfWords(height, radius) - wordsHighlighted);

      //If the wordsLeft is negative, just returns 0, otherwise, returns the amount of inkLeft
      if (wordsLeft <= 0) {
        return 0;
      }
      else {
        return wordsLeft;
      }

    } //remainingNumOfWords

    public int remainingNumOfWords(double height, double radius, double inkVolUsed) {
      /*Action: Finds the remaining number of words the current highlighter can highlight,
        based on the volume of ink used in mL.
        Input: height, radius, inkVolUsed
        Output: The remaining number of words the current highlighter can highlight.*/

      /*Finds the number of words highlighted from the amount of ink used. Then, it subtracts the
        starting number of words by that quotient.*/
      int wordsLeft =  (int) (startingNumOfWords(height, radius) - (inkVolUsed / 0.0002));

      //If the wordsLeft is negative, just returns 0, otherwise, returns the amount of inkLeft
      if (wordsLeft <= 0) {
        return 0;
      }
      else {
        return wordsLeft;
      }

    } //remainingNumOfWords
  
} //highlighter class
