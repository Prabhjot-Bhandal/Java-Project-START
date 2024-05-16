package ObjectOrientedProgramming.ShapeHierachy;

public class Shape {
    //Instance Variables
    public String name; //Name of the shape
    private double size;
    private int numDims; //Number of dimensions a shape has

    //Constructors
    public Shape() {
        //Default values for any Shape object
        name = "shape";
        size = 0.1;
    } //Default Shape Constructor 

    //Getters and Setters
    public double getSize() {
        //Returns the current Shape object's size
        return size;
    } //getSize getter

    public void setSize() {
        //If the size is greater than 0, is valid and will be set as that size
        if (size > 0) {
            this.size = size;
        }
        //If size inputted was invalid, sets 0.1 as the basic size
        this.size = 0.1;
    } //setSize setter

    //Comparsion

    //toString
    public String toString() {
        //Returns the Shape object's name and size
        return ("This shape's name is " + name + ".\nThis shape's size is " + size + ".");
    } //toString method


} //Shape class
