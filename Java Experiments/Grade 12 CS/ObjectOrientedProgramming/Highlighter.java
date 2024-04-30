package ObjectOrientedProgramming;

public class Highlighter {
    //Represents a template for creating objects of type highlighter

    //Instance variables, the FEATURES
    double height;
    double radius;
    double thickness;
    //For colours
    int red;
    int blue;
    int green;
    double brightness; //private makes it so that it can't be updated OUTSIDE this class, only accessed here
    boolean capOrNot;

    //Constructer: Sets the initial values for highlighter objects
    //Class name will be your object's name
    //public means that the method can be called wherever
    public Highlighter() {
        //No parameters for this constructor method

        height = 0;
        radius = 0;
        thickness = 0;
        red = 0;
        blue = 0;
        green = 0;
        brightness = 0;
        capOrNot = false;

    }

    /*We can make multiple constructor methods because we may want to make specific types of objects.
    Depends on what parameters the constructor method has*/

    //You NEED to call the constructor in order to create that specifc object
    public Highlighter(int red, int blue, int green) {

        //This refers the the object's parameter
        //Every constructor made with the red, blue and green given, its red, blue AND green values will be the given ones
        this.red = red;
        this.blue = blue;
        this.green = green;

    }

} //highlighter
