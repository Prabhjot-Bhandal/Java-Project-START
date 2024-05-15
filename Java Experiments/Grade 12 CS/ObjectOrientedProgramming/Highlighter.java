package ObjectOrientedProgramming;

public class Highlighter {
    //Represents a template for creating objects of type highlighter

    //Area highlighted
    //Longevity based on Ink Volume
    //Determine the brightness based on how much ink is left
    //Distance highlighted
    //Applied force for bleeding
    //Instance variables, the FEATURES
    double height;
    double radius;
    double tipWidth; 
    String colour;
    boolean capOrNot; //private makes it so that it can't be updated OUTSIDE this class, only accessed here

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
        /*Action: Accesses a private variable, returns it.
          Input: The object
          Output: The object's radius*/
        return radius;
    } //getRadius

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

    /*public void setRGB (int red, int blue, int green) {
        /*Action: Checks if the given RGB values are valid.
          Input: The object's red, blue and green values.
          Output: Verified red, blue and green variables.*/

        //If red between 0 and 255, it is valid
      //  if (red >= 0 && red <= 255) {
            //Updates this object's red feature with the given red
      //      this.colour = red;
      //  }
        //If the red isn't valid
      //  else {
            //Updates this object's red value with a value of 255
      //      red = 255;
      //  }

        //If blue between 0 and 255, it is valid
     //   if (blue >= 0 && blue <= 255) {
            //Updates this object's blue feature with the given blue
      //      this.blue = blue;
     //   }
        //If the blue isn't valid
      //  else {
            //Updates this object's blue value with a value of 255
       //     blue = 1;
      //  }

        //If green between 0 and 255, it is valid
     //   if (green >= 0 && green <= 255) {
            //Updates this object's green feature with the given green
      //      this.green = green;
      //  }
        //If the green isn't valid
       // else {
            //Updates this object's green value with a value of 255
            //green = 1;
       // }

  //  } //setRGB*/

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
