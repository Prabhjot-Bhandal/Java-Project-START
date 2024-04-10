package Algorithms;

public class linearSearch {
    public static void main(String[] args) {
        int[] ages = {7, 2, 5, 33, 19, 16, 15, 36, 46, 72};

        int indexOfValue = linearSearching(72, ages);

        System.out.println("\nThe index will be: " + indexOfValue);
    }

    public static int linearSearching(int searchValue, int[] array) {
        /*Action: Searches through an array for a given value.
          Input: searchValue and the array.
          Ouput: The index at which the value was found in the array.
        */

        //Creates a for loop to search for a given value
        for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
            //If the value was found, it will return the index at which the value was found in the  array
            if (searchValue == array[currentIndex]) {
                return currentIndex;
            }
        }

        //If the value was not found in the array, it will return a value of -1
        return -1;
    }
}
