import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: February 24, 2024
//Purpose: To create algorithms that print two dimensional arrays in various ways

public class TwoDArrayProblems {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int twoDArray[][] = new int[5][6];

        System.out.print("How do you want to fill the twoDArray?\n1. In Reverse\n2. Snake Pattern\n3. With Squares\n4. With Squares starting with how many columns there are\n5. Each row has an ascending tens value\nSkipping one number at the end when counting\nYour choice: ");
        int twoDArrayFillChoice = in.nextInt();
        switch (twoDArrayFillChoice) {
            //Fill in reverse
            case 1:
                //twoDArray = reverseFill(twoDArray);

            //Fill with the snake pattern
            case 2: 
                //twoDArray = snakeFill(twoDArray);
            
            //Fills with the squares of each index
            case 3:
                //twoDArray = squareFill(twoDArray);

            //Starts filling in each index with squares starting from the total number of columns in the twoDArray
            case 4: 
                //twoDArray = numOfColumnsPlusCurrentIndexSquareFill(twoDArray);
            
            //Fills the array with numbers that have an increasing tens value depending which row the index is in
            case 5:
                //twoDArray = ascendingTensFill(twoDArray);

            //Fills the array 
            case 6:
                //twoDArray = skipEndFill(twoDArray);
        }

    } //main
}
