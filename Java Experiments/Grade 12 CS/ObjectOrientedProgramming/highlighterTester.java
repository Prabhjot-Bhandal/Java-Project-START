package ObjectOrientedProgramming;

public class highlighterTester {
    public static void main(String[] args) {
        Highlighter highlighter = new Highlighter();
        Highlighter avgHighlighter = new Highlighter("red");
        Highlighter avgCopy = avgHighlighter;

        System.out.println("\nRadius: " + avgHighlighter.getRadius() + "\nHeight: " + avgHighlighter.getHeight());
        System.out.println("\nWords Left: " + avgHighlighter.remainingNumOfWords(avgHighlighter.getHeight(), avgHighlighter.getRadius(), 60000));
    }
}
