import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: February 22, 2024
//Purpose: Create a calendar using 2D array concepts

public class CalendarApp {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //Stores the days of the week in an array
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        System.out.println("Please input the current day month and year: ");
        //Gets the current month and year from the user
        //String currentMonthAndYear = in.nextLine();

        //Initializes the days of the month with the maximum number of rows and columns
        int[][] daysOfMonth = new int[5][7];

        //Loops through every index of daysOfWeek and prints it out
        for(int currentIndex = 0; currentIndex < daysOfWeek.length; currentIndex++) {
            //If currentIndex is less than 6 (not Saturday), prints within same line
            if (currentIndex < daysOfWeek.length - 1) {
                System.out.print(daysOfWeek[currentIndex] + "\t");
            } else {
                System.out.println(daysOfWeek[currentIndex]);
            }
        }

        //Sets the currentDay to 1 so it starts assiging days at 1
        int currentDay = 1;

        //Starts at (0, 0), ensures it goes through every row
        for(int currentRow = 0; currentRow < daysOfMonth.length; currentRow++) {
            /*Starts at (0, 0), goes through every column in the currentRow and assigns the currentDay, 
            increments one with each loop*/
            for(int currentColumn = 0; currentColumn < daysOfMonth[currentRow].length && currentDay < 32; currentColumn++, currentDay++) {
                //Loads currentDay to the currentRow and currentColumn loop is on
                daysOfMonth[currentRow][currentColumn] = currentDay;
                //If the day is not on a Saturday, will print in one line and concatenate a space
                if (currentColumn < daysOfMonth[currentRow].length - 1) {
                    System.out.print(daysOfMonth[currentRow][currentColumn] + "\t");
                } else {
                    System.out.println(daysOfMonth[currentRow][currentColumn]);
                }
            }
        }

    }
}
