package ObjectOrientedProgramming;

public class Highlighter {
    //Represents a template for creating objects of type highlighter

    //Area highlighted
    //Longevity based on Ink Volume
    //Determine the brightness based on how much ink is left
    //Distance highlighted
    //Applied force for bleeding
    //Instance variables, the FEATURES
    private double height;
    private double radius;
    private double tipWidth; 
    private String colour;
    private boolean capOrNot; //private makes it so that it can't be updated OUTSIDE this class, only accessed here

    //Constructer: Sets the initial values for highlighter objects
    //Class name will be your object's name
    //public means that the method can be called wherever
    public Highlighter() {
        //No parameters for this constructor method

        height = 0;
        radius = 0;
        tipWidth = 0;
        colour = "none";
        capOrNot = false;

    }

    /*We can make multiple constructor methods because we may want to make specific types of objects.
    Depends on what parameters the constructor method has*/

    //You NEED to call the constructor in order to create that specifc object
    public Highlighter(int red, int blue, int green) {

        //This refers the the object's parameter
        //Every constructor made with the colour given, its colour values will be the given ones
        this.colour = "white";

    } //Highlighter

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
    }

    public void setHeight(double height) {
      this.height = height;
    }

    public void setTipWidth(double tipWidth) {
      this.tipWidth = tipWidth;
    }

    public void setColour(String colour) {
      this.colour = colour;
    }

    public boolean isCapOrNot() {
      return capOrNot;
    }

    public void setCapOrNot(boolean capOrNot) {
      this.capOrNot = capOrNot;
    }

    //Mutators (setters) - updates the value of an instance variable if it does not meet certain conditions
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
        //If the radius isn't valid, updates that object's radius with a value of 1
        else {
            this.radius = 1;
        }
    } //setRadius

    public String toString() {
        //Returns a string representation of the value of each feature of the object

        return("This is a " + height + " cm highlighter");
    } //toString

    public boolean isEqual(Highlighter highlighter) {
        /*Action: Compares two objects that are the same object.
          Input: A highlighter object, highlighter.
          Output: A boolean refering to if the objects are the same or not
        */

        //This refers to the object that is doing .equals
        //If both highlighters have the same height and radius, they are the same
        if ((this.height == highlighter.height) && (this.radius == highlighter.radius) && (this.colour.equalsIgnoreCase(highlighter.colour)))  {
            return true;
        }

        //If both highlighters do not have the same values for the above features, they are not the same
        return false;

    } //isEqual

    public double areaHighlighted(double tipWidth, double lengthHighlighted, int numOfRows) {
      /*Action: Finds the area (in cm^2) that the user has highlighted based on their highlighter's
        tipWidth and the length that they highlighted.
        Input: tipWidth and lengthHighlighted
        Output: The area the user has highlighted in cm^2.*/

      //area = 
      
    } //areaHighlighted

} //highlighter
