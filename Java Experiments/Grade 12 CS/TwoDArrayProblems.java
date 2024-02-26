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
                //Calls the reverseFill method
                twoDArray = reverseFill(twoDArray);
                //Prints the two dimensional array in the print method
                printTwoDArray(twoDArray);

            //Fill with the snake pattern
            case 2: 
                //Calls the snakeFill method
                twoDArray = snakeFill(twoDArray);
                //Prints the two dimensional array in the print method
                printTwoDArray(twoDArray);
            
            //Fills with the squares of each index
            case 3:
                //Calls the squareFill method
                twoDArray = squareFill(twoDArray);
                //Prints the two dimensional array in the print method
                printTwoDArray(twoDArray);

            //Starts filling in each index with squares starting from the total number of columns in the twoDArray
            case 4: 
                //twoDArray = numOfColumnsPlusCurrentIndexSquareFill(twoDArray);
            
            //Fills the array with numbers that have an increasing tens value depending which row the index is in
            case 5:
                //twoDArray = ascendingTensFill(twoDArray);

            //Fills the array with consecutively increasing numbers, but skips a number when it's a new row
            case 6:
                //twoDArray = skipEndFill(twoDArray);
        }

    } //main

    public static void printTwoDArray(int[][] twoDArray) {
        /*Action: Prints out the entire twoDArray
         Input: A filled twoDArray
         Output: The printing of the twoDArray*/

         //Starts at (0, 0), ensures it goes through every row
        for(int currentRow = 0; currentRow < twoDArray.length; currentRow++) {
            /*Starts at (0, 0), goes through every column in the currentRow and prints it, 
            increments one with each loop*/
            for(int currentColumn = 0; currentColumn < twoDArray[currentRow].length; currentColumn++) {
                //If the day is not on a last element in the row, will print in one line and concatenate a space
                if (currentColumn < twoDArray[currentRow].length - 1) {
                    System.out.print(twoDArray[currentRow][currentColumn] + "\t");
                } else {
                    System.out.println(twoDArray[currentRow][currentColumn]);
                }
            }
        }

    } //printTwoDArray

    public static int[][] reverseFill(int[][] twoDArray) {
        /*Action: Fills the twoDArray in reverse order of the tiles' numbers
         Input: An empty twoDArray
         Output: A twoDArray filled with the tile numbers in reverse order*/

        //Initializes count to start filling at the maximum number possible, which is the total number of tiles
        int countDown = (twoDArray.length) * (twoDArray[0].length);

        //Loops through each row, increments once every tile in the row has been filled
        for (int currentRow = 0; currentRow < twoDArray.length; currentRow++) {
            //Loops through each tile in each row, subtracts from count every time
            for (int currentCol = 0; currentCol < twoDArray[currentRow].length; currentCol++, countDown--) {
                //Sets the current tile to the number the count is on, which starts from the maximum number of tiles
                twoDArray[currentRow][currentCol] = countDown;
            }
        }

        return twoDArray;

    } //reverseFill

    public static int[][] snakeFill(int[][] twoDArray) {
        /*Action: Fills the twoDArray in reverse order of the tiles' numbers in a snake pattern
         Input: An empty twoDArray
         Output: A twoDArray filled with the reverse order of the tiles' numbers in a snake pattern*/
        
        //Initializes count to start filling at the maximum number possible, which is the total number of tiles
        int countDown = (twoDArray.length) * (twoDArray[0].length);
        //Seperate count variable to be used to countUp in odd rows
        int countUp = 0;

        for (int currentRow = 0; currentRow < twoDArray.length; currentRow++) {
            for (int currentCol = 0; currentCol < twoDArray[0].length; currentCol++) {
                //If row is even, prints in countDown order, if odd, prints in ascending order starting from the prior row's last tile's number subtracted by 6
                if (currentRow % 2 == 0) {
                    //Sets the current tile to the number the count is on, which starts from the maximum number of tiles
                    twoDArray[currentRow][currentCol] = countDown;
                    //Subtracts 1 from countDown everytime for even
                    countDown--;
                } else {
                    //If it's the first col in the odd row, subtracts 5 from countDown to get snake pattern
                    if (currentCol == 0) {
                        countDown -= 6;
                        //Assigns countDown to countUp so that countDown isn't affected by the counting up in odd rows
                        countUp = countDown + 1;
                    }
                    twoDArray[currentRow][currentCol] = countUp;
                    //Counts up for odd rows
                    countUp++;
                }
            }
        }

        return twoDArray;
    } //snakeFill

    public static int[][] squareFill(int[][] twoDArray) {
        /*Action: Fills the twoDArray with the squares of each tile's respective tile number
         Input: An empty twoDArray
         Output: A twoDArray filled with the squares of each tile's respective tile number*/

        //Starts counting up from 1
        int countUp = 1;

        //Loops through each row, increments once every tile in the row has been filled
        for (int currentRow = 0; currentRow < twoDArray.length; currentRow++) {
            //Loops through each tile in each row, subtracts from count every time
            for (int currentCol = 0; currentCol < twoDArray[currentRow].length; currentCol++, countUp++) {
                //Sets the current tile to the square of the number the countUp is on, which starts from the maximum number of tiles
                twoDArray[currentRow][currentCol] = countUp * countUp;
            }
        }

        return twoDArray;
    }
}
