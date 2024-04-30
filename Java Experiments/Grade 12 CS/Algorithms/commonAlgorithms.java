package Algorithms;

public class commonAlgorithms {
    public static void main(String[] args) {
        int[] ages = {7, 2, 5, 33, 19, 16, 15, 36, 46, 72};

        //int indexOfValue = linearSearch(72, ages);
        //System.out.println("\nThe index will be: " + indexOfValue);
        //selectionSort(ages);
        printOneDIntArray(ages);
        System.out.println(verifySortingInt(ages));
        System.out.println(binarySearch(4, ages));
        //System.out.println(binarySearchRecursive(ages, 4, 0, ages.length - 1));

    } //main

    public static void printOneDIntArray (int[] intArray) {
        /*Action: Prints out an int one dimensional array.
          Input: A one-dimensional int array
          Output: The array printed to the console.*/
        
        for (int index = 0; index < intArray.length; index++) {
            System.out.print(intArray[index] + ", ");
        }
    } //printOneDIntArray

    public static boolean verifySortingInt(int[] intArray) {
        /*Action: Checks if an array is sorted by looking at an element and checking if the
          element before is greater than the current element.
          Input: intArray
          Output: A boolean denoting if the array is sorted or not.*/

        //Starts at index 1 so that it can compare to the element before the current one
        for (int index = 1; index < intArray.length; index++) {
            //If the element before the current one is greater, the array is NOT sorted
            if (intArray[index] < intArray[index - 1]) {
                return false;
            }
        }

        //If the loop runs fine, that means the entire array IS sorted
        return true;
    } //verifySortingInt

    public static boolean verifySortingChar(char[] charArray) {
        /*Action: Checks if an array is sorted by looking at an element and checking if the
          element before is greater than the current element.
          Input: charArray
          Output: A boolean denoting if the array is sorted or not.*/

        //Starts at index 1 so that it can compare to the element before the current one
        for (int index = 1; index < charArray.length; index++) {
            //If the element before the current one is greater, the array is NOT sorted
            if (charArray[index] < charArray[index - 1]) {
                return false;
            }
        }

        //If the loop runs fine, that means the entire array IS sorted
        return true;
    } //verifySortingChar


    public static boolean verifySortingStr(String[] strArray) {
        /*Action: Checks if an array is sorted by looking at an element and checking if the
          element before is greater than the current element.
          Input: strArray
          Output: A boolean denoting if the array is sorted or not.*/

        //Starts at index 1 so that it can compare to the element before the current one
        for (int index = 1; index < strArray.length; index++) {
            //If the element before the current one is greater, the array is NOT sorted
            if (strArray[index].compareToIgnoreCase(strArray[index - 1]) < 0) {
                return false;
            }
        }

        //If the loop runs fine, that means the entire array IS sorted
        return true;
    } //verifySortingStr
    
    public static int linearSearch(int searchValue, int[] intArray) {
        /*Action: Searches through an array for a given value.
          Input: searchValue and the array.
          Ouput: The index at which the value was found in the array.*/

        //Creates a for loop to search for a given value
        for (int currentIndex = 0; currentIndex < intArray.length; currentIndex++) {
            //If the value was found, it will return the index at which the value was found in the  array
            if (searchValue == intArray[currentIndex]) {
                return currentIndex;
            }
        }

        //If the value was not found in the array, it will return a value of -1
        return -1;
    }

    public static int binarySearch(int searchValue, int[] intArray) {
        /*Action: Searches for a selected value in an integer array using the binary search algorithm.
          Input: The desired search value and the integer array.
          Output: The index at which the value is in the array.*/

        //Sets the first start index to 0, the first index in ALL arrays
        int startIndex = 0;
        //Sets the first end index to the last index in the array
        int endIndex = intArray.length - 1;

        /*The loop keeps running until the startIndex is greater endIndex, 
          which occurs when the given search value cannot be found in the given array.*/
        while (startIndex <= endIndex) {
            //Finds the middle index by taking the average of the start and end indices
            int midIndex = (startIndex + endIndex) / 2;

            //If the search value is equal to the middle value's index, then it has been found
            if (searchValue == intArray[midIndex]) {
                return midIndex;
            } 
            /*If the search value is less than the middle index, middle index becomes the new end index,
              discards the second half of the array*/
            else if (searchValue < intArray[midIndex]) {
                /*Subtracts one as we already checked the middle element, so we don't need to check it 
                again in our search. If not done, the loop runs forever for elements not in the array.*/
                endIndex = midIndex - 1;
            }
            /*If the search value is greater than the middle index, middle index becomes new start index,
             discards the first half of the array*/
            else if (searchValue > intArray[midIndex]) {
                /*Adds one as we already checked the middle element, so we don't need to check it 
                again in our search. If not done, the loop runs forever for elements not in the array.*/
                startIndex = midIndex + 1;
            }
        } 

        //If the search value wasn't found in the integer array, returns -1
        return -1;

    }//binarySearch

    public static int binarySearchRecursive(int[] intArray, int searchValue, int startIndex, int endIndex) {
        /*Action: Searches for a given value in an integer array using a recursive version of the binary search algorithm.
          Input: The integer array, the search value, the start index and the end index
          Output: The index at which the element that was being searched for is.*/

        //Finds the middle index by taking the average of the startIndex and endIndex
        int midIndex = (startIndex + endIndex) / 2;

        //Only runs if the start index is less than or equal to the end index, end is smaller when an element isn't found
        if (startIndex <= endIndex) {
            //If the search value is equal to the middle index, that means the element has been found
            if (searchValue == intArray[midIndex]) {
                //Returns middle index
                return midIndex;
            }
            /*If the search value is less than the middle element, then the ladder half of the array is discarded*/
            else if (searchValue < intArray[midIndex]) {
                /*Subtracts one as we already checked the middle element, so we don't need to check it 
                again in our search. If not done, the loop runs forever for elements not in the array.*/
                return binarySearchRecursive(intArray, searchValue, startIndex, midIndex - 1);
            }
            /*If the search value is greater than the middle element, the first half of the array is discarded*/
            else {
                /*Adds one as we already checked the middle element, so we don't need to check it 
                again in our search. If not done, the loop runs forever for elements not in the array.*/
                return binarySearchRecursive(intArray, searchValue, midIndex, endIndex + 1);
            }
        } 
        //If the endIndex becomes smaller than the startIndex, the element is NOT in the array
        else {
            //Returns -1 if the search value is not in the array
            return -1;
        }

    } //binarySearchRecursive

    public static int[] selectionSortInt(int[] intArray) {
        /*Action: Sorts a given integer array using the selection sort algorithm.
          Input: An unsorted integer array.
          Output: An integer array sorted in ascending order.*/

        //Loops through the entire array so that we get the smallest index compared to each index
        for (int comparisonIndex = 0; comparisonIndex < intArray.length - 1; comparisonIndex++) {
            //Holds the index that has the smallest value in the array COMPARED TO the current comparison index
            //The initial smallestElement is the current comparison index's value
            int smallestElement = intArray[comparisonIndex];
            //Initial smallestIndex is the current comparison index
            int smallestIndex = comparisonIndex;

            /*Loops through all the indices after the current comparison index and compares them
              to the current comparison index, finds the smallest value in that current instance.
              The comparingToIndex is 1 above the comparisonIndex*/
            for (int comparingToIndex = comparisonIndex + 1; comparingToIndex < intArray.length; comparingToIndex++) {
                //If the current comparingToIndex has an element smaller than the current smallest element, overwrites them
                if (intArray[comparingToIndex] < smallestElement) {
                    //Sets the smallestElement to the current comparingTo index
                    smallestElement = intArray[comparingToIndex];
                    //Sets the smallestIndex to the index in the array that has the new smallest element
                    smallestIndex = comparingToIndex;

                } //Overwriting smallestElement and Index if statement

            } //comparingTo for loop

            //Creates a temporary int variable to hold the value of the comparisonIndex in the array
            int temp = intArray[comparisonIndex];
            //Sets the comparisonIndex's element to the new smallest element
            intArray[comparisonIndex] = smallestElement;
            //Sets the index that had the smallest element equal to the element that was at the comparisonIndex prior to overwriting
            intArray[smallestIndex] = temp;

        } //comparisonIndex for loop

        //Returns the array after going through all the indices
        return intArray;
        
    } //selectionSortInt

    public static char[] selectionSortChar(char[] charArray) {
        /*Action: Sorts a given char array using the selection sort algorithm.
          Input: An unsorted char array.
          Output: An char array sorted in ascending order.*/

        //Loops through the entire array so that we get the smallest index compared to each index
        for (int comparisonIndex = 0; comparisonIndex < charArray.length - 1; comparisonIndex++) {
            //Holds the index that has the smallest value in the array COMPARED TO the current comparison index
            //The initial smallestElement is the current comparison index's value
            char smallestElement = charArray[comparisonIndex];
            //Initial smallestIndex is the current comparison index
            int smallestIndex = comparisonIndex;

            /*Loops through all the indices after the current comparison index and compares them
              to the current comparison index, finds the smallest value in that current instance.
              The comparingToIndex is 1 above the comparisonIndex*/
            for (int comparingToIndex = comparisonIndex + 1; comparingToIndex < charArray.length; comparingToIndex++) {
                //If the current comparingToIndex has an element smaller than the current smallest element, overwrites them
                if (charArray[comparingToIndex] < smallestElement) {
                    //Sets the smallestElement to the current comparingTo index
                    smallestElement = charArray[comparingToIndex];
                    //Sets the smallestIndex to the index in the array that has the new smallest element
                    smallestIndex = comparingToIndex;

                } //Overwriting smallestElement and Index if statement

            } //comparingTo for loop

            //Creates a temporary char variable to hold the value of the comparisonIndex in the array
            char temp = charArray[comparisonIndex];
            //Sets the comparisonIndex's element to the new smallest element
            charArray[comparisonIndex] = smallestElement;
            //Sets the index that had the smallest element equal to the element that was at the comparisonIndex prior to overwriting
            charArray[smallestIndex] = temp;

        } //comparisonIndex for loop

        //Returns the array after going through all the indices
        return charArray;
        
    } //selectionSortChar

    public static String[] selectionSortStr(String[] strArray) {
        /*Action: Sorts a given string array using the selection sort algorithm.
          Input: An unsorted string array.
          Output: An string array sorted in ascending order.*/

        //Loops through the entire array so that we get the smallest index compared to each index
        for (int comparisonIndex = 0; comparisonIndex < strArray.length - 1; comparisonIndex++) {
            //Holds the index that has the smallest value in the array COMPARED TO the current comparison index
            //The initial smallestElement is the current comparison index's value
            String smallestElement = strArray[comparisonIndex];
            //Initial smallestIndex is the current comparison index
            int smallestIndex = comparisonIndex;

            /*Loops through all the indices after the current comparison index and compares them
              to the current comparison index, finds the smallest value in that current instance.
              The comparingToIndex is 1 above the comparisonIndex*/
            for (int comparingToIndex = comparisonIndex + 1; comparingToIndex < strArray.length; comparingToIndex++) {
                //If the current comparingToIndex has an element smaller than the current smallest element, overwrites them
                //Less than for strings .compareTo is negative
                if (strArray[comparingToIndex].compareTo(smallestElement) < 0) {
                    //Sets the smallestElement to the current comparingTo index
                    smallestElement = strArray[comparingToIndex];
                    //Sets the smallestIndex to the index in the array that has the new smallest element
                    smallestIndex = comparingToIndex;

                } //Overwriting smallestElement and Index if statement

            } //comparingTo for loop

            //Creates a temporary string variable to hold the value of the comparisonIndex in the array
            String temp = strArray[comparisonIndex];
            //Sets the comparisonIndex's element to the new smallest element
            strArray[comparisonIndex] = smallestElement;
            //Sets the index that had the smallest element equal to the element that was at the comparisonIndex prior to overwriting
            strArray[smallestIndex] = temp;

        } //comparisonIndex for loop

        //Returns the array after going through all the indices
        return strArray;
        
    } //selectionSortStr



    public static int[] insertionSortInt(int[] intArray) {
        /*Action: Sorts a given integer array using the insertionSort algorithm
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
        
    } //insertionSortInt

    public static char[] insertionSortChar(char[] charArray) {
        /*Action: Sorts a given char array using the insertionSort algorithm
          Input: One dimensional int array
          Output: The sorted one dimensional array*/

        //Loops through the entire given char array
        for (int index = 1 ; index < charArray.length ; index++) {
            //Stores the current element the loop is on in an char variable
            char item = charArray[index];
            //Stores the current index in a seperate variable so that it can be used to swap later on
            int toPlace = index;

            /*While loop runs through all previous indices before the current one and compares the 
            current element to all the previous ones*/
            while (toPlace > 0 && item < charArray[toPlace - 1]) {
                //Assigns previous (and thus lower) elements before the current element in the array
                charArray[toPlace] = charArray[toPlace - 1];
                //Subtracts 1 so that we can look at the next element, works from the current index to the first
                toPlace--;
            } //While loop stops once the current comparison item is no longer smaller than the one before it

            //Switches the current element to the index where all of the ones after it are greater than it
            charArray[toPlace] = item;
         }//for index

        //Returns the array
        return charArray;
        
    } //insertionSortChar

    public static String[] insertionSortStr(String[] strArray) {
        /*Action: Sorts a given String array using the insertionSort algorithm
          Input: One dimensional String array
          Output: The sorted one dimensional array*/

        //Loops through the entire given char array
        for (int index = 1 ; index < strArray.length ; index++) {
            //Stores the current element the loop is on in an char variable
            String item = strArray[index];
            //Stores the current index in a seperate variable so that it can be used to swap later on
            int toPlace = index;

            /*While loop runs through all previous indices before the current one and compares the 
            current element to all the previous ones*/
            //Less than for strings .compareTo is negative
            while (toPlace > 0 && item.compareTo(strArray[toPlace - 1]) < 0) {
                //Assigns previous (and thus lower) elements before the current element in the array
                strArray[toPlace] = strArray[toPlace - 1];
                //Subtracts 1 so that we can look at the next element, works from the current index to the first
                toPlace--;
            } //While loop stops once the current comparison item is no longer smaller than the one before it

            //Switches the current element to the index where all of the ones after it are greater than it
            strArray[toPlace] = item;
         }//for index

        //Returns the array
        return strArray;
        
    } //insertionSortStr

    public static int[] bubbleSortInt(int[] intArray) {
        /*Action: Sorts an int one-dimensional array using the bubble sort algorithm
          Input: An unsorted intArray
          Output: The sorted intArray in ascending order*/

        //Creates a temporary variable to hold the element at the comparison index
        int temp;
        //Looks at the first index
        for (int index1 = 0; index1 < intArray.length; index1++){
            //Looks at the index right after the first index
            for(int index2 = 1; index2 < intArray.length; index2++){
                //Sets the temp variable equal to the value before index 2 in the array
                temp = intArray[index2 - 1];
                //Compares index 2's element to the one before it
                if(intArray[index2] < intArray[index2-1]){
                    //If the one before index 2 is larger then it, they swap
                    intArray[index2 - 1] = intArray[index2];
                    //Swaps the element before index2 in the array to index2
                    intArray[index2]  = temp;			
                }//if			
            }//for index2 	
        }//for index1

        //Returns the array
        return intArray;

    } //bubbleSortInt

    public static char[] bubbleSortChar(char[] charArray) {
        /*Action: Sorts a char one-dimensional array using the bubble sort algorithm
          Input: An unsorted charArray
          Output: The sorted charArray in ascending order*/

        //Creates a temporary variable to hold the element at the comparison index
        char temp;
        //Looks at the first index
        for (int index1 = 0; index1 < charArray.length; index1++){
            //Looks at the index right after the first index
            for(int index2 = 1; index2 < charArray.length; index2++){
                //Sets the temp variable equal to the value before index 2 in the array
                temp = charArray[index2 - 1];
                //Compares index 2's element to the one before it
                if(charArray[index2] < charArray[index2 - 1]){
                    //If the one before index 2 is larger then it, they swap
                    charArray[index2 - 1] = charArray[index2];
                    //Swaps the element before index2 in the array to index2
                    charArray[index2]  = temp;			
                }//if			
            }//for index2 	
        }//for index1

        //Returns the array
        return charArray;

    } //bubbleSortChar

    public static String[] bubbleSortStr(String[] strArray) {
        /*Action: Sorts a string one-dimensional array using the bubble sort algorithm
          Input: An unsorted strArray
          Output: The sorted strArray in ascending order*/

        //Creates a temporary variable to hold the element at the comparison index
        String temp;
        //Looks at the first index
        for (int index1 = 0; index1 < strArray.length; index1++){
            //Looks at the index right after the first index
            for(int index2 = 1; index2 < strArray.length; index2++){
                //Sets the temp variable equal to the value before index 2 in the array
                temp = strArray[index2 - 1];
                //Compares index 2's element to the one before it
                if(strArray[index2].compareTo(strArray[index2 - 1]) < 0){
                    //If the one before index 2 is larger then it, they swap
                    strArray[index2 - 1] = strArray[index2];
                    //Swaps the element before index2 in the array to index2
                    strArray[index2]  = temp;			
                }//if			
            }//for index2 	
        }//for index1

        //Returns the array
        return strArray;

    } //bubbleSortStr

}


