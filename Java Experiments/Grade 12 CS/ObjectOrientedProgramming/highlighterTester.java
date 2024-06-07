package ObjectOrientedProgramming;

public class highlighterTester {

    //Array containing the possible colours of highlighter
    final static String[] COLOURS = {"red", "blue", "yellow", "green", "purple", "orange", "grey", "black", "white"};
    //Array containing all possible tip types
    final static String[] TIP_TYPES = {"chisel", "window", "bullet", "double-ended"};
    public static void main(String[] args) {
        HighlighterSet highlighterArr = new HighlighterSet(5);
        Highlighter highlighter = new Highlighter("orange");
        System.out.println("" + highlighterArr.totalVolume());
        
    }
}
