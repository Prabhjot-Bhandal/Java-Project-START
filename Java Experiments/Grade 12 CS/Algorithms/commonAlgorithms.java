package Algorithms;

public class commonAlgorithms {
    public static void main(String[] args) {
        int[] ages = {7, 2, 5, 33, 19, 16, 15, 36, 46, 72};

        //int indexOfValue = linearSearch(72, ages);
        //System.out.println("\nThe index will be: " + indexOfValue);


    }

    public static int linearSearch(int searchValue, int[] array) {
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

    public static void printOneDIntArray (int[] intArray) {
        /*Action: Prints out an int one dimensional array.
          Input: A one-dimensional int array
          Output: The array printed to the console.*/
        
        for (int index = 0; index < intArray.length; index++) {
            System.out.print(intArray[index] + ", ");
        }
    }

    public static int[] insertionSort(int[] intArray) {
        /*Action: Sorts a given array using the insertionSort algorithm
          Input: One dimensional int array
          Output: The sorted one dimensional array*/

        //Loops through the entire given int array
        for (int index = 1 ; index < intArray.length ; index++) {
            //Stores the current element the loop is on in an int variable
            int item = intArray[index];
            //Stores the current index in a seperate variable so that it can be used to swap later on
            int toPlace = index;

            /*While loop runs through all previous indices before the current one and compares the 
            current element to all the previous ones*/
            while (toPlace > 0 && item < intArray[toPlace - 1]) {
                //Assigns previous (and thus lower) elements before the current element in the aray
                intArray[toPlace] = intArray[toPlace - 1];
                //Subtracts 1 so that we can look at the next element, works from the current index to the first
                toPlace--;
            } //While loop stops once the current comparison item is no longer smaller than the one before it

            //Switches the current element to the index where all of the ones after it are greater than it
            intArray[toPlace] = item;
         }//for index

        //Returns the array
        return intArray;
        
    } //insertionArray

    public static int[] sortB(int[] intArray) {
        /*Action: Sorts an int one-dimensional array using the _______
          Input: intArray
          Output: The sorted intArray*/

        int temp;
        for (int index1 = 0; index1 < intArray.length; index1++){
            for(int index2 = 1; index2 < intArray.length; index2++){
                    
                temp = intArray[index2-1];
                if(intArray[index2]<intArray[index2-1]){
                                        
                    intArray[index2-1] = intArray[index2];
                    intArray[index2]  = temp;			
                }//if			
            }//for index2 	
        }//for index1
        return intArray;

    } //sortB

    
}
