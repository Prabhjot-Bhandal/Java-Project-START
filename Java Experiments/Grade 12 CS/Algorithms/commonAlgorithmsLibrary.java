//Name: Prabhjot Bhandal
//Date: May 6, 2024
//Purpose: To learn about common algorithms and how to implement

//Signifies the file directory, the folder the program is in
package Algorithms;
//Imports the library that builds the scanner object
import java.util.Scanner;

public class commonAlgorithmsLibrary {
    /*Creates a scanner object exclusive to this class and makes it available across all 
    his class' methods.*/
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //Asks the user if they want to use the ages array or create a random one and stores it
        System.out.print("Do you want to\n1. Use the ages array\n2. Create a random one\nAnswer: ");
        int genArrayOrNot = in.nextInt();

        /*Calls the selection screen for generating an array or for using the ages array 
        depending on the user's answer*/
        //Ages array
        if (genArrayOrNot == 1) {
            //For re-running the sort test with the SortTester objects
            boolean runAgesSortTestAgain = true;
            //For storing the user's answer
            String userRerun;

            do {
                //Calls the selection screen method for the ages array
                userSelectionScreenAges();
                //Keeps repeating if the user does not input a valid response
                do {
                    //Asks user if they want to do another test, stores user's answer
                    System.out.print("\nDo you want to perform another test (Y/N): ");
                    userRerun = in.next().toLowerCase();
                } while (!userRerun.equalsIgnoreCase("Y") && !userRerun.equalsIgnoreCase("N"));

                //If the user said no, sets the run variable to false to exit out of the loop
                if (userRerun.equalsIgnoreCase("N")) {
                    runAgesSortTestAgain = false;
                }
            } while (runAgesSortTestAgain == true); //Keeps running if true
        } 
        //Generate an array
        else {
            //Asks the user how long their SortTester array will be and stores it
            System.out.print("How many elements do you want your array to be?: ");
            int userArrayLength = in.nextInt();

            //Asks the user how long they want the strings in the SortTester objects to be
            System.out.print("How long do you want the objects' strings to be?: ");
            int userStringLength = in.nextInt();

            //Generates the sortTestArray according to the user's preferences
            SortTester[] sortTestArray = genSortTesterArray(userArrayLength, userStringLength);

            //For re-running the sort test with the SortTester objects
            boolean runSortTestAgain = true;
            //For storing the user's answer
            String userRerun;

            do {
                //Calls the selection screen method for a random (SortTester) array
                userSelectionScreenSortTester(sortTestArray);
                //Keeps repeating if the user does not input a valid response
                do {
                    //Asks user if they want to do another test, stores user's answer
                    System.out.print("\nDo you want to perform another test (Y/N): ");
                    userRerun = in.next().toLowerCase();
                } while (!userRerun.equalsIgnoreCase("Y") && !userRerun.equalsIgnoreCase("N"));

                //If the user said no, sets the run variable to false to exit out of the loop
                if (userRerun.equalsIgnoreCase("N")) {
                    runSortTestAgain = false;
                }
            } while (runSortTestAgain == true); //Keeps running if true
        }

    } //main

    public static void userSelectionScreenSortTester(SortTester[] sortTestArray) {
        /*Action: Allows the user to customize their sort test with an array of SortTester objects.
          Input: SortTester Array
          Output: The testing of various sorting algorithms*/

        //Creates the runAgain variable, will be used to keep running a do-while loop
        boolean runAgain = true;
        /*Instantiates the testWhichDataType variable, for converting our SortTester 
        array into the appropriate data type*/
        int testWhichDataType = -1;
        /*Instatiates the whichAlgorithm variable, for confirming which sorting algorithm
          will be tested.*/
        int whichAlgorithm = -1;
        //Instatiates the array that will hold the int features of all the SortTester array's objects
        int[] sortTestIntArray = new int[sortTestArray.length];
        //Instatiates the array that will hold the char features of all the SortTester array's objects
        char[] sortTestCharArray = new char[sortTestArray.length];
        //Instatiates the array that will hold the string features of all the SortTester array's objects
        String[] sortTestStrArray = new String[sortTestArray.length];

        //Ensures that the user picks a valid choice for testing some data type
        do {
            //Asks the user which data type they want to test and stores it
            System.out.print("\nWould you like to test integers (1), chars (2) or strings (3)?: ");
            testWhichDataType = in.nextInt();

            //If the user inputs a valid choice, breaks out of the loop
            if (testWhichDataType == 1 || testWhichDataType == 2 || testWhichDataType == 3) {
                runAgain = false;
            }
        } while (runAgain == true);

        //For testing integers
        if (testWhichDataType == 1) {
            //Gets each integer feature of every SortTester object and puts it into a new int array
            for (int index = 0; index < sortTestArray.length; index++) {
                sortTestIntArray[index] = sortTestArray[index].integer;
            } //for int

        } //if int
        //For testing chars
        else if (testWhichDataType == 2) {
            //Gets each char feature of every SortTester object and puts it into a new int array
            for (int index = 0; index < sortTestArray.length; index++) {
                sortTestCharArray[index] = sortTestArray[index].character;
            } //for char

        } //if char
        //For testing strings
        else if (testWhichDataType == 3) {
            //Gets each string feature of every SortTester object and puts it into a new int array
            for (int index = 0; index < sortTestArray.length; index++) {
                sortTestStrArray[index] = sortTestArray[index].string;
            } //for string

        } //if string

        //Ensures that the user picks a valid choice for testing a sorting algorithm
        do {
            //Asks the user which sorting algorithm they want to test and stores it
            System.out.print("\nWould you like to test the\n1. Selection Sort\n2. Insertion Sort\n3. Bubble Sort\n" + //
                                "Answer: ");
            whichAlgorithm = in.nextInt();

            //If the user inputs a valid choice, breaks out of the loop
            if (whichAlgorithm == 1 || whichAlgorithm == 2 || whichAlgorithm == 3) {
                runAgain = false;
            }
        } while (runAgain == true);

        //For Selection Sort
        if (whichAlgorithm == 1) {
            //Int
            if (testWhichDataType == 1) {
                //Prints out the unsorted array
                System.out.print("\nUnsorted: ");
                printOneDIntArray(sortTestIntArray);
                //Updates the array with its sorted self
                sortTestIntArray = selectionSortInt(sortTestIntArray);

                //Only prints if the array is sorted, uses the verify sort method
                if (verifySortingInt(sortTestIntArray) == true) {
                    //Prints out the sorted array
                    System.out.print("Sorted: ");
                    printOneDIntArray(sortTestIntArray);
                }
                //If not sorted
                else {
                    System.out.println("The array was not sorted!");
                }
            }
            //Char
            else if (testWhichDataType == 2) {
                //Prints out the unsorted array
                System.out.print("\nUnsorted: ");
                printOneDCharArray(sortTestCharArray);
                //Updates the array with its sorted self
                sortTestCharArray = selectionSortChar(sortTestCharArray);

                //Only prints if the array is sorted, uses the verify sort method
                if (verifySortingChar(sortTestCharArray) == true) {
                    //Prints out the sorted array
                    System.out.print("Sorted: ");
                    printOneDCharArray(sortTestCharArray);
                }
                //If not sorted
                else {
                    System.out.println("The array was not sorted!");
                }
            }
            //String
            else if (testWhichDataType == 3) {
                //Prints out the unsorted array
                System.out.print("\nUnsorted: ");
                printOneDStrArray(sortTestStrArray);
                //Updates the array with its sorted self
                sortTestStrArray = selectionSortStr(sortTestStrArray);

                //Only prints if the array is sorted, uses the verify sort method
                if (verifySortingStr(sortTestStrArray) == true) {
                    //Prints out the sorted array
                    System.out.print("Sorted: ");
                    printOneDStrArray(sortTestStrArray);
                }
                //If not sorted
                else {
                    System.out.println("The array was not sorted!");
                }
            }
        //For Insertion Sort
        } else if (whichAlgorithm == 2) {
            //Int
            if (testWhichDataType == 1) {
                //Prints out the unsorted array
                System.out.print("\nUnsorted: ");
                printOneDIntArray(sortTestIntArray);
                //Updates the array with its sorted self
                sortTestIntArray = insertionSortInt(sortTestIntArray);

                //Only prints if the array is sorted, uses the verify sort method
                if (verifySortingInt(sortTestIntArray) == true) {
                    //Prints out the sorted array
                    System.out.print("Sorted: ");
                    printOneDIntArray(sortTestIntArray);
                }
                //If not sorted
                else {
                    System.out.println("The array was not sorted!");
                }
            }
            //Char
            else if (testWhichDataType == 2) {
                //Prints out the unsorted array
                System.out.print("\nUnsorted: ");
                printOneDCharArray(sortTestCharArray);
                //Updates the array with its sorted self
                sortTestCharArray = insertionSortChar(sortTestCharArray);

                //Only prints if the array is sorted, uses the verify sort method
                if (verifySortingChar(sortTestCharArray) == true) {
                    //Prints out the sorted array
                    System.out.print("Sorted: ");
                    printOneDCharArray(sortTestCharArray);
                }
                //If not sorted
                else {
                    System.out.println("The array was not sorted!");
                }
            }
            //String
            else if (testWhichDataType == 3) {
                //Prints out the unsorted array
                System.out.print("\nUnsorted: ");
                printOneDStrArray(sortTestStrArray);
                //Updates the array with its sorted self
                sortTestStrArray = insertionSortStr(sortTestStrArray);

                //Only prints if the array is sorted, uses the verify sort method
                if (verifySortingStr(sortTestStrArray) == true) {
                    //Prints out the sorted array
                    System.out.print("Sorted: ");
                    printOneDStrArray(sortTestStrArray);
                }
                //If not sorted
                else {
                    System.out.println("The array was not sorted!");
                }
            }
        }
        //For Bubble Sort
        else if (whichAlgorithm == 3) {
            //Int
            if (testWhichDataType == 1) {
                //Prints out the unsorted array
                System.out.print("\nUnsorted: ");
                printOneDIntArray(sortTestIntArray);
                //Updates the array with its sorted self
                sortTestIntArray = bubbleSortInt(sortTestIntArray);

                //Only prints if the array is sorted, uses the verify sort method
                if (verifySortingInt(sortTestIntArray) == true) {
                    //Prints out the sorted array
                    System.out.print("Sorted: ");
                    printOneDIntArray(sortTestIntArray);
                }
                //If not sorted
                else {
                    System.out.println("The array was not sorted!");
                }
            }
            //Char
            else if (testWhichDataType == 2) {
                //Prints out the unsorted array
                System.out.print("\nUnsorted: ");
                printOneDCharArray(sortTestCharArray);
                //Updates the array with its sorted self
                sortTestCharArray = bubbleSortChar(sortTestCharArray);

                //Only prints if the array is sorted, uses the verify sort method
                if (verifySortingChar(sortTestCharArray) == true) {
                    //Prints out the sorted array
                    System.out.print("Sorted: ");
                    printOneDCharArray(sortTestCharArray);
                }
                //If not sorted
                else {
                    System.out.println("The array was not sorted!");
                }
            }
            //String
            else if (testWhichDataType == 3) {
                //Prints out the unsorted array
                System.out.print("\nUnsorted: ");
                printOneDStrArray(sortTestStrArray);
                //Updates the array with its sorted self
                sortTestStrArray = bubbleSortStr(sortTestStrArray);

                //Only prints if the array is sorted, uses the verify sort method
                if (verifySortingStr(sortTestStrArray) == true) {
                    //Prints out the sorted array
                    System.out.print("Sorted: ");
                    printOneDStrArray(sortTestStrArray);
                }
                //If not sorted
                else {
                    System.out.println("The array was not sorted!");
                }
            }
        }

    } //userSelectionScreenSortTester

    public static void userSelectionScreenAges() {
        /*Action: Creates a selection screen for the user to use the ages array to test various algorithms.
          Input: User input.
          Output: The testing of various algorithms.*/

        //Creates the ages array
        int[] ages = {7, 2, 5, 33, 19, 16, 15, 36, 46, 72};
        //Creates the runAgain variable, will be used to keep running a do-while loop
        boolean runAgain = true;
        /*Instantiates the searchOrSort variable, allows for choosing whether to use a search or sort algorithm.*/
        int searchOrSort = -1;
        /*Instatiates the whichAlgorithm variable, for confirming which sorting algorithm
          will be tested.*/
        int whichAlgorithm = -1;

        //Ensures that the user picks a valid choice for testing a sorting algorithm
        do {
            //Asks the user which sorting algorithm they want to test and stores it
            System.out.print("\nWould you like to test \n1. Searching Algorithms\n2. Sorting Algorithms\nAnswer: ");
            searchOrSort = in.nextInt();

            //If the user inputs a valid choice, breaks out of the loop
            if (searchOrSort == 1 || searchOrSort == 2) {
                runAgain = false;
            }
        } while (runAgain == true);

        //For searching algorithms
        if (searchOrSort == 1) {
            //Ensures that the user picks a valid choice for testing a sorting algorithm
            do {
                //Asks the user which sorting algorithm they want to test and stores it
                System.out.print("\nWould you like to test the\n1. Linear Search\n2. Binary Search\n3. Recursive Binary Search\n" + //
                                        "Answer: ");
                whichAlgorithm = in.nextInt();

                //If the user inputs a valid choice, breaks out of the loop
                if (whichAlgorithm == 1 || whichAlgorithm == 2 || whichAlgorithm == 3) {
                    runAgain = false;
                }
            } while (runAgain == true);

            //For Linear Search
            if (whichAlgorithm == 1) {
                //Prints out the array
                System.out.print("\nArray: ");
                printOneDIntArray(ages);

                //Has the user input what value the linear search should try to find in the ages array
                System.out.print("Input a search value to search for: ");
                int searchValue = in.nextInt(); 

                //Calls linearSearch and stores the index found in a variable
                int searchValueIndex = linearSearch(searchValue, ages);

                //If the value isn't in the array, says it isn't
                if (searchValueIndex == -1) {
                    System.out.println("The value " + searchValue + " was not in the ages array!");
                }
                //If the value is in the array, prints out value and its index in the array
                else {
                    System.out.println("The value " + searchValue + " was at index " + searchValueIndex + " in the ages array.");
                }
            }
            //For Binary Search
            else if (whichAlgorithm == 2) {
                //Sorts the array first since binary search only works on sorted arrays
                ages = insertionSortInt(ages);

                //Prints out the array
                System.out.print("\nArray: ");
                printOneDIntArray(ages);

                //Has the user input what value the linear search should try to find in the ages array
                System.out.print("Input a search value to search for: ");
                int searchValue = in.nextInt(); 

                //Calls binarySearch and stores the index found in a variable
                int searchValueIndex = binarySearch(searchValue, ages);

                //If the value isn't in the array, says it isn't
                if (searchValueIndex == -1) {
                    System.out.println("The value " + searchValue + " was not in the ages array!");
                }
                //If the value is in the array, prints out value and its index in the array
                else {
                    System.out.println("The value " + searchValue + " was at index " + searchValueIndex + " in the ages array.");
                }
            }
            //For Recursive Binary Search
            else if (whichAlgorithm == 3) {
                //Sorts the array first since binary search only works on sorted arrays
                ages = insertionSortInt(ages);

                //Prints out the array
                System.out.print("\nArray: ");
                printOneDIntArray(ages);

                //Has the user input what value the linear search should try to find in the ages array
                System.out.print("Input a search value to search for: ");
                int searchValue = in.nextInt(); 

                //Calls binarySearchRecursive and stores the index found in a variable
                int searchValueIndex = binarySearchRecursive(ages, searchValue, 0, ages.length - 1);

                //If the value isn't in the array, says it isn't
                if (searchValueIndex == -1) {
                    System.out.println("The value " + searchValue + " was not in the ages array!");
                }
                //If the value is in the array, prints out value and its index in the array
                else {
                    System.out.println("The value " + searchValue + " was at index " + searchValueIndex + " in the ages array.");
                }
            }   
        }

        //For sorting algorithms
        else {
            //Ensures that the user picks a valid choice for testing a sorting algorithm
            do {
                //Asks the user which sorting algorithm they want to test and stores it
                System.out.print("\nWould you like to test the\n1. Selection Sort\n2. Insertion Sort\n3. Bubble Sort\n" + //
                                        "Answer: ");
                whichAlgorithm = in.nextInt();

                //If the user inputs a valid choice, breaks out of the loop
                if (whichAlgorithm == 1 || whichAlgorithm == 2 || whichAlgorithm == 3) {
                    runAgain = false;
                }
            } while (runAgain == true);

            //For Selection Sort
            if (whichAlgorithm == 1) {
                //Prints out the unsorted array
                System.out.print("\nUnsorted: ");
                printOneDIntArray(ages);
                //Updates the array with its sorted self
                ages = selectionSortInt(ages);

                //Only prints if the array is sorted, uses the verify sort method
                if (verifySortingInt(ages) == true) {
                    //Prints out the sorted array
                    System.out.print("Sorted: ");
                    printOneDIntArray(ages);
                }
                //If not sorted
                else {
                    System.out.println("\nThe array was not sorted!");
                }
            //For Insertion Sort
            } else if (whichAlgorithm == 2) {
                //Prints out the unsorted array
                System.out.print("\nUnsorted: ");
                printOneDIntArray(ages);
                //Updates the array with its sorted self
                ages = insertionSortInt(ages);

                //Only prints if the array is sorted, uses the verify sort method
                if (verifySortingInt(ages) == true) {
                    //Prints out the sorted array
                    System.out.print("Sorted: ");
                    printOneDIntArray(ages);
                }
                //If not sorted
                else {
                    System.out.println("The array was not sorted!");
                }
            }
            //For Bubble Sort
            else if (whichAlgorithm == 3) {
                //Prints out the unsorted array
                System.out.print("\nUnsorted: ");
                printOneDIntArray(ages);
                //Updates the array with its sorted self
                ages = bubbleSortInt(ages);

                //Only prints if the array is sorted, uses the verify sort method
                if (verifySortingInt(ages) == true) {
                    //Prints out the sorted array
                    System.out.print("Sorted: ");
                    printOneDIntArray(ages);
                }
                //If not sorted
                else {
                    System.out.println("The array was not sorted!");
                }
            }
        }

    } //userSelectionScreenAges

    //Try to do intArray or sortTesterArray
    public static void printOneDIntArray (int[] intArray) {
        /*Action: Prints out an int one dimensional array.
          Input: A one-dimensional int array
          Output: The array printed to the console.*/

        //Goes through all the elements in the intArray
        for (int index = 0; index < intArray.length; index++) {
            //If the current printing element isn't last, print with a comma
            if (index < intArray.length - 1) {
                System.out.print(intArray[index] + ", ");
            }
            //If the current printing element is last, print with a new line after it
            else {
                System.out.println(intArray[index]);

            }
        }
    } //printOneDIntArray

    public static void printOneDCharArray (char[] charArray) {
        /*Action: Prints out a char one dimensional array.
          Input: A one-dimensional char array
          Output: The array printed to the console.*/
        
        //Goes through all the elements in the charArray
        for (int index = 0; index < charArray.length; index++) {
            //If the current printing element isn't last, print with a comma
            if (index < charArray.length - 1) {
                System.out.print(charArray[index] + ", ");
            }
            //If the current printing element is last, print with a new line after it
            else {
                System.out.println(charArray[index]);

            }
        }
    } //printOneDCharArray

    public static void printOneDStrArray (String[] strArray) {
        /*Action: Prints out a string one dimensional array.
          Input: A one-dimensional string array
          Output: The array printed to the console.*/
        
        //Goes through all the elements in the strArray
        for (int index = 0; index < strArray.length; index++) {
            //If the current printing element isn't last, print with a comma
            if (index < strArray.length - 1) {
                System.out.print(strArray[index] + ", ");
            }
            //If the current printing element is last, print with a new line after it
            else {
                System.out.println(strArray[index]);

            }
        }
    } //printOneDStrArray

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

    //FIX: Runs forever for values not in the array, try looking for 3
    public static int binarySearchRecursive(int[] intArray, int searchValue, int startIndex, int endIndex) {
        /*Action: Searches for a given value in an integer array using a recursive version of the binary search algorithm.
          Input: The integer array, the search value, the start index and the end index
          Output: The index at which the element that was being searched for is.*/

        //Only runs if the start index is less than or equal to the end index, end is smaller when an element isn't found
        if (startIndex <= endIndex) {

            //Finds the middle index by taking the average of the startIndex and endIndex
            int midIndex = (startIndex + endIndex) / 2;

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
                return binarySearchRecursive(intArray, searchValue, midIndex + 1, endIndex);
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

    public static SortTester[] genSortTesterArray(int arrayLength, int stringLength) {
        /*Action: Creates an array of SortTester objects (they have a random int, string and char to
        test all sorts).
        Input: arrayLength and stringLength.
        Output: The randomly generated array of SortTester objects.*/

        //Instantiates the array
        SortTester testArray[] = new SortTester[arrayLength];

        //Makes the array according to how big the array is
        for (int index = 0; index < testArray.length; index++) {
            //Generates each element in the testArray using the SortTester class
            testArray[index] = new SortTester(stringLength);

        } //For loop for generating the array of SortTester objects

        //Returns the array of randomly generated SortTester objects
        return testArray;

    } //genSortTesterArray

    public static int intRandomizer(int range) {
        /*Action: Generates a random integer from 0 to an upper bound (integer).
          Input: An integer indicating the range of 
          Output: A randomizer integer.*/

        //Returns the random integer within the specified range
        return (int) (Math.random() * range);
        
    } //intRandomizer

} //commonAlgorithmsLibrary class