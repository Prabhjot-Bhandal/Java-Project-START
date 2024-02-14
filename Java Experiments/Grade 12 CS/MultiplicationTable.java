import java.util.Scanner;
//Name: Prabhjot Bhandal
//

public class MultiplicationTable {
    //Creates the scanner object in the class
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] timesTable;
        System.out.print("How big do you want your table to be: ");
        int tableSize = in.nextInt();

        timesTable = makeTimesTable(tableSize);
        printIntTwoDArray(timesTable);
    } //main

    public static int[][] makeTimesTable(int tableSize) {
        /*Action: Makes a times table of the requested size through repeated addition.
        Input: tableSize
        Output: A curated timesTable that is the user's desired size.*/

        //Creates an empty 2D array that is the user's desired size
        int[][] timesTable = new int[tableSize][tableSize];

        //For loop 
        for (int currentRow = 0, coreNumber = currentRow + 1; currentRow < timesTable.length; currentRow++, coreNumber++) {
            timesTable[currentRow][0] = coreNumber;
            for (int currentColumn = 0, add = coreNumber; currentColumn < timesTable[currentRow].length; currentColumn++, add += coreNumber) {
                timesTable[currentRow][currentColumn] += add;
            }
        }

        return timesTable;
    } //makesTimesTable

    public static void printIntTwoDArray(int[][] twoDArray) {
        /*Action: Prints our all elements in a two dimensional integer array.
        Input: twoDArray
        Output: Printing of all of twoDArray's elements*/

        for (int row = 0; row < twoDArray.length; row++) {
            for (int col = 0; col < twoDArray[row].length; col++) {
                System.out.print(twoDArray[row][col] + "\t");
            } //for columns
            System.out.println();
        } //for rows
    } //printIntTwoDArray
}
