package Algorithms;
//Imports the java IO library for writing to a file
import java.io.*;

class AlgorithmsAnalysis {
    //Creates the variables that will read and write a desired file
    static BufferedReader readFile;
    static BufferedWriter writeFile;
    public static void main(String[] args) throws IOException {

    } //main

    public static void createRandNums() throws IOException {

        //Writes the contents of its one dimensional array of Strings to a file
        writeFile = new BufferedWriter (new FileWriter ("Java Experiments\\Grade 12 CS\\Algorithms\\randomNumbers.txt") );
        for (int number = 0; number < 10000; number++) {
            
        }
    
    //Closes writing 
    writeFile.close();
    } //creatRandNums
}

//Create a method that creates 10000 random elements and writes it to a file