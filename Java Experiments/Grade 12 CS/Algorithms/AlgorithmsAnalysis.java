package Algorithms;
//Imports the java IO library for writing to a file
import java.io.*;

class AlgorithmsAnalysis {
    //Creates the variables that will read and write a desired file
    static BufferedReader readFile;
    static BufferedWriter writeFile;
    public static void main(String[] args) throws IOException {
        
        //int[] randNums = createRandNums();
        //writeNumsToFile(randNums);
    } //main

    public static int[] createRandNums() {
        /*Action: Creates an array of random integers.
          Input: None
          Output: The int array*/

        //Creates an empty int array that will house all the randomly generated integers
        int[] randNums = new int[1000000];
        //Runs the for loop for the entire array
        for (int index = 0; index < randNums.length; index++) {
            //Fills the entire array with a random number from 0 to ten thousand
            randNums[index] = ((int) (Math.random() * 1000000));
        }

        //Returns the randNums int array
        return randNums;
        
    } //creatRandNums

    public static void writeNumsToFile(int[] randNums) throws IOException {
        /*Action: Writes all the numbers in the randNums array to a file.
          Input: randNums integer array
          Output: The file with all the integers
        */

        //Writes the contents of its one dimensional array of Strings to a file
        writeFile = new BufferedWriter (new FileWriter ("Java Experiments\\Grade 12 CS\\Algorithms\\randomNumbers.txt") );
        for (int index = 0; index < randNums.length; index++) {
            //Writes the current array index to the new file
            writeFile.write(String.valueOf(randNums[index]));
            //Goes to next line to write
            writeFile.newLine();
        }
    
    //Closes writing 
    writeFile.close();
    } //writeNumsToFile

    public static void timeElapsed() throws IOException {
        /*Action: Runs the selected sorting algorithm and times how long it takes it to sort
                  a large amount of integers.
          Input: The file of randomized integers.
          Output: The file is sorted in ascending order.*/

        long start = System.currentTimeMillis();
        commonAlgorithms.insertionSortInt();



    } //timeElapsed

    public static int[] getData() throws IOException {

    } //getData
}