import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: February 12th, 2024
//Purpose: To demonstrate how 2D arrays work.

public class TwoDArrayDemo {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        //Regular array
        int[][] table;
        table = new int[6][9]; //6 rows, 9 coloumns

        //Irregular array
        int[][] steps;
        steps = new int[5][]; //First column is rows, second is columns

        //Makes the number of columns in each row random
        steps = makeRagged(steps);

        //Assigns the value that the user inputs
        steps = assignFromUser(steps);

        //Prints only one element in the table array
        //System.out.println(table[0][1]);

        //Prints all
        printIntTwoDArray(steps);
    } //main

    public static int[][] makeRagged(int[][] twoDArray) {
        //Action: Makes random # of columns per row
        //Input: twoDArray
        //Output: twoDArray that is ragged
        for (int currentRow = 0; currentRow < twoDArray.length; currentRow++) {
            twoDArray[currentRow] = new int[(int)(Math.random() * 5)];
        }
        return twoDArray;
    }

    public static int[][] assignFromUser(int[][] twoDArray) {
        System.out.print("Please type in a desired integer value: ");
        int userValue = in.nextInt();
        for (int currentRow = 0; currentRow < twoDArray.length; currentRow++) {
            for (int currentCol = 0; currentCol < twoDArray[currentRow].length; currentCol++) {
                twoDArray[currentRow][currentCol] = userValue;
            } //For Columns
        } //For Rows
        return twoDArray;
    }

    public static void assign10(int[][] twoDArray) {
        //Action: Assigns a value of 10 to all of twoDArray's elements
        //Input: twoDArray
        //Output: twoDArray's rows and columns each hold a value of 10

        for (int row = 0; row < twoDArray.length; row++) {
            for (int col = 0; col < twoDArray[row].length; col++) {
                twoDArray[row][col] = 10;
            } //for columns
        } //for rows
    }

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