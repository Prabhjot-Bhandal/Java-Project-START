package ReadingToAFileDemo;
import java.io.*;
import java.util.Scanner;

public class ReadingToAFileDemo {
    static BufferedReader readFile;
    static BufferedWriter writeFile;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        //Prompt for number of students in class
        System.out.print("How many students do you want in the array: ");
        int numStudents = in.nextInt();
        String[] itemsList = new String[numStudents];
        //For the different filling methods
        System.out.print("Do you want to:\n1. Do a regular fill\n2. Do a suffix fill\n3. Insert a substring into every name and fill it with those names\n4. Fill the array with reversed names\nAnswer: ");
        int fillChoice = in.nextInt();

        //For selecting how the user wants to fill the array
        switch (fillChoice) {
            case 1:
                itemsList = regularFill(itemsList);
                break;
            case 2:
                itemsList = addSuffix(itemsList);
                break;
            case 3:
                itemsList = insertSubString(itemsList);
                break;
            case 4:
                itemsList = reverseNames(itemsList);
                break;
            case 5:
            //If the user puts in an invalid number, program ends and says that they had an invalid number
            default:
                System.out.print("Invalid choice made, rerun the program.");
                break;
        }

        //Writes the new and altered array of names to a new file
        writeToFile(itemsList);

        //Prints itemsList
        //printArray(itemsList);
    } //main


    public static void printArray(String[] array) {
        /*Action: Prints a 1D array
         Input: A filled string 1D array
         Output Printing of the 1D array*/

        //Runs for all elements, breaks when the index is greater than the indices available
        for (int index = 0; index < array.length; index++) {
            //If the current index is not the last element, adds a comma, if not, just prints the last element
            if (index < array.length - 1) {
                System.out.print(array[index] + ", ");
            }
            else {
                System.out.println(array[index]);
            }
        }
    } //printArray

    public static String[] regularFill(String[] array) throws IOException{
        /*Action: Fills an empty 1D array with names from a file
         Input: An empty string array
         Output A filled string array with names from the file*/

        //Reads the file, so it knows it exists
        readFile = new BufferedReader (new FileReader ("Grade 12 CS\\ReadingToAFileDemo\\namesList.txt"));

        //Writes each index in the array based on the names stored in the file
        for (int index = 0; index < array.length; index++) {
            array[index] = readFile.readLine();
        }
        //Closes reading the file so any other variables are not written with the data in the file
        readFile.close();

        return array;
    } //regularFill

    public static String[] addSuffix(String[] array) throws IOException{
        /*Action: Fills an empty 1D array with names from a file that have a suffix of ikashay
         Input: An empty string array
         Output A filled string array with names from the file with the added suffix to each name*/

        //Reads the file, so it knows it exists
        readFile = new BufferedReader (new FileReader ("Grade 12 CS\\ReadingToAFileDemo\\namesList.txt"));

        //Takes in each name from the file and sets each array's index equal to some name in the file
        for (int index = 0; index < array.length; index++) {
            //Sets some element in the array equal to the current name in the file and appends ikashay to the end of it
            array[index] = readFile.readLine() + "ikashay";
        }
        //Closes reading the file so any other variables are not written with the data in the file
        readFile.close();

        return array;
    } //addSuffix

    public static String[] insertSubString(String[] array) throws IOException {
        /*Action: Fills an empty 1D array with names from a file and adds "ology" into each name
         Input: An empty string array
         Output A filled string array with names from the file with the added substring in the middle of each name*/

        //Reads the file, so it knows it exists
        readFile = new BufferedReader (new FileReader ("Grade 12 CS\\ReadingToAFileDemo\\namesList.txt"));

        //Takes in each name from the file and sets each array's index equal to some name in the file
        for (int index = 0; index < array.length; index++) {
            //Sets some element in the array equal to the current name in the file
            array[index] = readFile.readLine();
            //Makes some substring out of the first two letters in the element's string, then appends "ology" and then adds the rest of the name after
            array[index] = array[index].substring(0, 3) + "ology" + array[index].substring(3);
        }
        //Closes reading the file so any other variables are not written with the data in the file
        readFile.close();

        return array;
    } //insertSubString

    public static String[] reverseNames(String[] array) throws IOException {
        /*Action: Fills an empty 1D array with names from a file and reverses them
         Input: An empty string array
         Output A filled string array with the reverses of the names from the file*/

        //Reads the file, so it knows it exists
        readFile = new BufferedReader (new FileReader ("Grade 12 CS\\ReadingToAFileDemo\\namesList.txt"));

        //Takes in each name from the file and sets each array's index equal to some name in the file
        for (int index = 0; index < array.length; index++) {
            //Creates a holder variable to hold the string we are currently looking at
            String holdString = readFile.readLine();
            //So that the element in the array is not null
            array[index] = "";

            for (int stringIndex = holdString.length(); stringIndex > 0; stringIndex--) {
                //Goes from the last letter to the first letter of the string from the file to assign the last letter as the first in the current array's element
                array[index] += holdString.substring(stringIndex - 1, stringIndex);
            }
        }
        //Closes reading the file so any other variables are not written with the data in the file
        readFile.close();

        return array;
    } //reverseNames

    public static void writeToFile(String[] array) throws IOException{
        /*Action: Writes the altered array to a new file
         Input: A one dimensional String array
         Output: Writes the data in the string 1D array to a new file
        */

        //Writes the contents of its one dimensional array of Strings to a file
        writeFile = new BufferedWriter (new FileWriter ("Grade 12 CS\\ReadingToAFileDemo\\namesListUpdated.txt") );
        
        for (int index = 0 ; index < array.length ; index++)
        {
            //Writes the current array index to the new file
            writeFile.write(array[index]);
            //Goes to next line to write
            //
            writeFile.newLine();
        }
        writeFile.close();//end of the writing
    } //writeToFile
}
