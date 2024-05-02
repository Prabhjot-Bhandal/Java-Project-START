package ObjectOrientedProgramming;

public class highlighterTester {
    public static void main(String[] args) {
        //Just because you declare an object DOES NOT MEAN IT EXITS
        Highlighter physicsHighlighter;

        //Calls the constructor method and sets the initial values of the objects initial values
        physicsHighlighter = new Highlighter();

        //Gives a memory addresss
        System.out.println(physicsHighlighter);

        //Finds the physicsHighlighter's height
        System.out.println(physicsHighlighter.height);

        //Creates a highlighter with specified parameters to auto-set the colour
        Highlighter specificHighlighter = new Highlighter(255, 16, 240);
        Highlighter specificHighlighter2 = specificHighlighter;
        Highlighter specificHighlighter3 = new Highlighter(255, 16, 240);

        //Both false
        System.out.println(specificHighlighter == specificHighlighter3); //Memory reference
        System.out.println(specificHighlighter.equals(specificHighlighter3)); //Memory reference   

        //specificHighlighter.red = 0;

        //Checks if the radius is valid, if not then will set an automatic value
        physicsHighlighter.setRadius(-6);
        physicsHighlighter.setRGB(-7, 256, 255);

        System.out.println(physicsHighlighter.toString());

        //Refers to the same memory location as the first highlighter
        Highlighter physicsHighlighter2 = physicsHighlighter;

        System.out.println(physicsHighlighter2.getRadius());
        physicsHighlighter.setRadius(2.5);
    }
}
