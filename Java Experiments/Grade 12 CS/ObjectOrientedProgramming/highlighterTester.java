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
    }
}
