import java.io.*;
import java.util.Scanner;

public class ReadingToAFileDemo {
    static BufferedReader readFile;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        //Reads the file, so it knows it exists
        readFile = new BufferedReader (new FileReader ("C:\\Users\\prabh\\Documents\\GitHub\\Java-Project-START\\Java Experiments\\Grade 12 CS\\namesList.txt"));
        
        //Prompt for number of students in class
        int numStudents = in.nextInt();
        String[] itemsList = new String[numStudents];

        //Writes each index in the array based on the names stored in the file
        for (int index = 0; index < itemsList.length; index++) {
            itemsList[index] = readFile.readLine();
        }
        readFile.close();

    }

    public static String[] addSuffix(String[] array) throws IOException{
        //Reads the file, so it knows it exists
        readFile = new BufferedReader (new FileReader ("C:\\Users\\prabh\\Documents\\GitHub\\Java-Project-START\\Java Experiments\\Grade 12 CS\\namesList.txt"));

        for (int index = 0; index < array.length; index++) {
            array[index] = readFile.readLine() + "ikashay";
        }

        return array;
    }
}
