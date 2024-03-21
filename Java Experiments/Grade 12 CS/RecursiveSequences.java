import java.util.Scanner;

//Name: Prabhjot Bhandal
//Date: March 13, 2024
//Purpose: A collection of recursive methods modelling several recursive sequences to practice recursive programming.

class RecursiveSequences {
    //Makes scanner static so it can be used across all methods
    static Scanner in = new Scanner(System.in);
    //Makes the number of terms the user will input static so we can print all terms in one line
    static double numOfTerms;
    static double[] currentTermVal;
    public static void main(String[] args) {
        //Initializes userResponse
        int userResponse = 0;

        do {
            //Gets the user's response
            userResponse = getRecursiveSequence();
        } while (userResponse < 1 || userResponse > 5); //Keeps running until user puts in a valid number

        //Gets the starting term from the user
        System.out.print("How many terms do you want to print out?: ");
        //Gets the maximum number of terms the user desires
        numOfTerms = in.nextDouble();
        currentTermVal = new double[(int)numOfTerms];
        

        //Picks to run which algorithm
        switch (userResponse) {
            case 1:
                //Calls the the method
                addPowersOfTwo(numOfTerms);
            case 2:
                posAndNegPowersOfTwo(numOfTerms - 1);
            default:
                break;
        }
    } //main


    public static int getRecursiveSequence() {
        /*Action: Gets which recursive algorithm the user wants to run, then returns the number to the main method to selected which algorithm to run.
        Input: None
        Output: An integer pertaining to which algorithm the user wants to run.*/

        //Options and asks the user which algorithm they want to run
        System.out.println("1. Terms of the Sequence, Add Powers of 2\n2. Terms of the Sequence, Positive and Negative Exponents on 2");
        System.out.print("Which recursive algorithm do you desire to run?: ");
        //Gets the number from the user
        int response = in.nextInt();

        return response;
    } //getRecursiveSequence


    public static double addPowersOfTwo(double currentTerm) {
        /*Action: Prints out the last term in a sequence of numbers that increases by the next term number's power of 2
         * Input: The maximum number of terms in the sequence
         * Output: The sequence containing the maximum number of terms*/
        //Has a return type so the method can use recursion, void = no recursion

        //Sets the current term to the maximum term inputted
        double currentTermVal;

        //BASE CASE: If the currentTerm is 0, returns 1 as any power with an exponent of 0 is 1
        if (currentTerm == 0) {
            //Prints out the base case
            System.out.print(1 + ", ");
            //Returns the base case
            return 1;
        }
        //RECURSIVE CALL: Since it must add onto the previous term to get the current term, calls the method again to get the previous term
        else {
            //Sets the current term's value to the recursive call so every term can be printed
            currentTermVal = addPowersOfTwo(currentTerm - 1) + (Math.pow(2, currentTerm));

            //Prints out the current term's value
            if (currentTerm < numOfTerms) {
                System.out.print((int)(currentTermVal) + ", ");
            } //If the current term is not the last term, prints it in the same line
            else {
                System.out.println((int)(currentTermVal));
            } //If the current term is the last term, creates a new line

            //Returns the current term's value
            return currentTermVal;
        }

    } //addPowersOfTwo
    
    public static double posAndNegPowersOfTwo(double currentTerm) {
        /*Action: Prints out a sequence of numbers where all terms divisible by 2 have negative
        exponents while the others have positive exponents.
        Input: The user inputs the maximum number of terms.
        Output: The sequence up to the maximum number of terms.*/

        //Stores 1 and 2 as the first two essential variables
        currentTermVal[0] = 1;
        currentTermVal[1] = 2;

        //BASE CASE: If the current term is 2, will return 
        if (currentTerm <= 2) {
            return currentTermVal[0] / currentTermVal[1];
        }
        //RECURSIVE CASE: Keeps calling on the function until the current term (exponent) is 0
        else {
            currentTermVal[(int) currentTerm] = Math.pow(currentTermVal[(int)posAndNegPowersOfTwo(currentTerm - 1)], -1) * currentTermVal[(int)posAndNegPowersOfTwo(currentTerm - 2)];

            //Prints out the current term's value
            if (currentTerm < numOfTerms - 1) {
                System.out.print((currentTermVal[(int)currentTerm] + ", "));
            } //If the current term is not the last term, prints it in the same line
            else {
                System.out.println(currentTermVal[(int)currentTerm]);
            } //If the current term is the last term, creates a new line

            //Returns the current term rather than the value because we aren't adding onto a sum, just need term num
            return currentTermVal[(int) currentTerm];
        }

    } //reciprocalPowersOfTwo

}