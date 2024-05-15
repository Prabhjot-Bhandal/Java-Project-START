package ObjectOrientedProgramming.ShapeHierachy;

public class Rectangle extends TwoDShape{
    //Instance Variables
    private double length; //The length of the recatangle
    private double width; //The width of the rectangle

    //Constructors
    public Rectangle() {
        //Default settings 
        length = 0.1;
        width = 0.1;
    }

    //Setters and Getters 
    public double getLength() {
        return length;
    } //length getter

    public void setLength(double length) {
        //Valid if the length is greater than 0
        if (length > 0) {
            this.length = length;
        }
        //If invalid length inputted, sets the length to the default
        this.length = 0.1;
    } //length setter

    public double getWidth() {
        return width;
    } //width getter

    public void setWidth(double width) {
        //Valid if the width is greater than 0
        if (width > 0) {
            this.width = width;
        }
        //If invalid width inputted, sets the width to the default
        this.width = 0.1;
    } //width setter

    //toString


    //Other Instance Methods


} //Rectangle
