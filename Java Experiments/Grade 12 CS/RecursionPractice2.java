import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: March 20, 2024
//Purpose: To practice recursion with these recursive algorithms


public class RecursionPractice2 {
    //Creates the scanner object that can be used across all methods
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //Initialized the user's response with -1, will be used to force the user to enter a valid number
        int userResponse = -1;

        //Forces the user to keep putting in a number until they put in a valid one
        do {
            userResponse = whichAlgorithm();
        } while (userResponse < 0 || userResponse > 4); //Their choice must be within the list, only 4 options


        switch(userResponse) {
            default:
            System.out.println("Rerun the program, an error has occured.");
            case 4:
                System.out.print("");
        }

    } //main

    public static int whichAlgorithm() {
        //Tells the user to pick an algorithm and lists them
        System.out.print("Please select whihc algorithm you want to run:\n1. Broken Calculator\n2. Recursive Powers\nYour Answer: ");
        //Gets and stores the integer the user types in
        int response = in.nextInt();

        //Returns the user's response
        return response;
    } //whichAlgorithm

    public static int geometricSequence(int firstTerm, int commonRatio, int numOfTerms) {
        /*Action: Generates the final term geometeric sequence of numbers based on the first term given and 
        the common ratio. The user specifies how many terms in this sequence will be printed.
        Input: The first term of the sequence, the sequence's common ratio and the total number of terms.
        Output: The final term in the sequence.*/

        //BASE CASE: Returns the first term if our current term number in the sequence is 1.
        if (numOfTerms == 1) {
            return firstTerm;
        } 
        /*RECURSIVE CASE: If it is any other term in the sequence, calls the method for the one before it
        multiplied by the commonRatio, as that would get the current term.*/
        else {
            return geometricSequence(firstTerm, commonRatio, numOfTerms - 1) * commonRatio;
        }

    } //geometricSequence
}
