package ObjectOrientedProgramming.ShapeHierachy;

public class ShapeTester {
    public static void main(String[] args) {
        //Though TwoDShape class is blank, looks up the hierarchy and uses Shape's base values
        TwoDShape twoD = new TwoDShape();
        System.out.println(twoD);
    } //main
} //ShapeTester class
