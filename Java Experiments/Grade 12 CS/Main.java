import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //Black = 0, Gold = 1
        //Find how much gold appears in their pattern

        //# of rows
        int m = in.nextInt();

        //# of col
        int n = in.nextInt();

        //# of choices made by the artist
        int k = in.nextInt();

        //Makes painting array of desired size
        int[][] paintingArray = new int[m][n];

        //Fills whole array of 0's, Black = 0, Gold = 1
        for (int currentRow = 0; currentRow < m; currentRow++) {
            for (int currentCol = 0; currentCol < n; currentCol++) {
                paintingArray[currentRow][currentCol] = 0;
            }
        }

        //Will take in all of the user's choices 
        for (int loopNum = 0; loopNum < k; loopNum++) {
            //Re-initializes the chosen row and columns so user can re-input what they want
            int chosenRow = -1;
            int chosenCol = -1;

            String rowOrCol = in.next();

            //Sees if it is a row or column
            if (rowOrCol.equals("R")) {
                chosenRow = in.nextInt();
                System.out.println("Chosen Row: " + chosenRow);
                //Subtracts 1 since it sees the first row as 1 instead of 0
                chosenRow -= 1;
            }
            else {
                chosenCol = in.nextInt();
                System.out.println("Chosen Col: " + chosenCol);
                //Subtracts 1 since it sees the first column as 1 instead of 0
                chosenCol -= 1;
            }
        }

        
    }
}
