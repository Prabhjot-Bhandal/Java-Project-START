import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: February 12th, 2024
//Purpose: To demonstrate how 2D arrays work.

public class TwoDArrayDemo {
    public static void main(String[] args) {

        //Regular array
        int[][] table;
        table = new int[6][9]; //6 rows, 9 coloumns

        //Irregular array
        int[][] steps;
        steps = new int[4][];

        steps[0] = new int[1]; //first row, one coloumn
        steps[1] = new int[2];
        steps[2] = new int[3];
        steps[3] = new int[4];

        //Prints only one element in the table array
        System.out.println(table[0][1]);

        //Prints all
        printIntTwoDArray(steps);
    } //main

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