package ObjectOrientedProgramming.ShapeHierachy;

public class Circle extends TwoDShape{
    //Instance Variables
    private double radius;
 
    //Constructor(s)
    public Circle() {
        radius = 5.3;
    }
            
    //Accessor and Mutator Methods
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        if(radius>0) {
            this.radius = radius;
        }
        this.radius = 5.3;
    }
    
    //Determine circumference
    
    public double circumference() {
        double circumference = (2*(Math.PI)*radius);
        return circumference;
    }
    
    public double area () {
        double area = (radius*(Math.PI)*radius);
        return area;
    }
    
        
    //toString
    
    public String toString() {
        return ("The radius of the circle is: "+radius);
    }
 
 }