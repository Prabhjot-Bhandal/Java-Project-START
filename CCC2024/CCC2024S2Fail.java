package CCC2024;

//CCC 2024 S2: Heavy-Light Composition
import java.util.Scanner;

public class CCC2024S2Fail {
static Scanner in = new Scanner(System.in);
static String[] strings;
static boolean alternateOrNot = false;
static int T;
static int N;
    public static void main(String[] args) throws Exception{
        //# of Strings
        T = in.nextInt();
        //The length of each string
        N = in.nextInt();

        //Sets the length of the strings array to be how many strings we have
        strings = new String[T];

        //Gets input for all the strings
        for(int i = 0; i < strings.length; i++) {
            strings[i] = in.next();
        }

        //Loops through all the given strings in the array
        //for(int i = 0; i < strings.length; i++) {
            //Current string we are working with
            String string = strings[2];
            char stringChars[] = selectionSort(string);
            

        //}

    } //main

    public static char[] selectionSort(String string) {
        //Converts the current string to a character array to make it easier to sort and search through
        char[] stringChars = string.toCharArray();
        for(int j = 0; j < stringChars.length; j++) {
            int swapForMinIndex = findMin(string, stringChars, j);
            stringChars = swap(stringChars, swapForMinIndex, j);
        }

        return stringChars;
        
    } //selectionSort

    public static int findMin(String string, char[] chars, int currentIndex) {
        //Sets the minimum index and minChar to the current index of the array loop
        int minIndex = currentIndex;

        String minChar = string.substring(minIndex, minIndex + 1);
        //Goes through the whole array from minIndex to the end
        for (int i = 1; i < string.length(); i++) {
            if (minChar.compareToIgnoreCase(string.substring(i, i + 1)) < 0) {
                chars[minIndex] = chars[minIndex + 1];
            }
            else {
                minIndex = i;
                minChar = string.substring(minIndex, minIndex + 1);
            }
        }
        return minIndex;
    } //findMin

    public static char[] swap(char[] chars, int minIndex, int secondIndex) {
        //Holds former char, replaces it with the other and then replaces that
        char hold = chars[minIndex];
        chars[minIndex] = chars[secondIndex];
        chars[secondIndex] = hold;
        return chars;
    } //swap
}
