package ObjectOrientedProgramming;

public class highlighterTester {
    public static void main(String[] args) {
        //Just because you declare an object DOES NOT MEAN IT EXITS
        Highlighter physicsHighlighter;

        //Calls the constructor method and sets the initial values of the objects initial values
        physicsHighlighter = new Highlighter();

        //Gives a memory address
        System.out.println(physicsHighlighter);

        //Finds the physicsHighlighter's height
        System.out.println(physicsHighlighter.height);

        //Creates a highlighter with specified parameters to auto-set the colour
        Highlighter specificHighlighter = new Highlighter(255, 16, 240);
        specificHighlighter.red = 0;

        //Checks if the radius is valid, if not then will set an automatic value
        physicsHighlighter.setRadius(-6);
        physicsHighlighter.setRGB(-7, 256, 255);

        System.out.println(physicsHighlighter.toString());
    }
}
