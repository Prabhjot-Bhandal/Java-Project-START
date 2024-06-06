package ObjectOrientedProgramming;

public class highlighterTester {
    public static void main(String[] args) {
        HighlighterSet highlighterArr = new HighlighterSet();
        System.out.println(highlighterArr.toString());
        highlighterArr.insertionSortHighlighterHeight(highlighterArr.getHighlighterArray());
        System.out.println("****************SORTED********************");
        System.out.println(highlighterArr.toString());
    }
}
