import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: February 28, 2024
//Purpose: Create a calendar using 2D array concepts, Use Read and Write Files

public class CalendarAppWithYear {
    static Scanner in = new Scanner(System.in);
    static int[] dateData = new int[4];
    public static void main(String[] args) {
        //Stores the days of the week in an array
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        //Initializes the monthCalander with the maximum number of rows and columns
        int[][] monthCalander = new int[5][7];
        int maximumDays = -1;
        //To make it appear cleaner and seperated from the user's input
        System.out.println("\n\n");
        //To center the month and year 
        System.out.print("\t\t    ");

        //Keeps looping if the user does not put in a valid month for their date
        do {
            //Calls getDateData() to load the static one-dimensional array which stores all of the date data that the user inputted
            getDateData();
            //Using the dateData array that was filled by getDateData, determines the maximum number of days for a given month
            maximumDays = getMaximumDays();
        } while (maximumDays < 0);

        //Prints out the days of the week header for the calander
        printDaysOfTheWeek(daysOfWeek);

        /*Gets the offset for the first week of the month and assigns it as the initial value of the daysOfWeekCounter 
        so the loop that prints the calander skips those many days*/
        int daysOfWeekCounter = getWeekOffset();

        //Prints out tabs to skip the days that are not included on the calender
        for (int index = 0; index < daysOfWeekCounter - 1; index++) {
            System.out.print("\t");
        }

        //Fills the monthCalander with all of the data available to generate it
        monthCalander = fillAndPrintmonthCalander(monthCalander, maximumDays, daysOfWeekCounter);

    } //main

    public static void getDateData() {
        /*Action: Gets user to input the current date, then loads this data into a static 1D array called dateData. 
        The return type is void because the array is static across the entire class, so the values do not need to be returned and such.
         Input: User inputs 4 integers corresponding to the current day of the week, day of the month, month and year
         Output: Loads all this data for the current date into a static 1D array called dateData*/

        //Prompts user to input the current date with instruction on how to do so
        System.out.print("Please input the current day month and year with a space seperating the day, month and year.\nPlease write the current weekday as an integer of 1-7 (0 as in Sunday, 6 as in Saturday).\nFormat in 'DayOfWeek DD MM YYYY' (ex. Saturday February 3, 2024: 6 3 2 2024): ");
        
        /*Stores all the date data in an array, 
        0 stores day of the week 
        1 stores the day of the month
        2 stores the month
        3 stores the year*/
        for (int index = 0; index < dateData.length; index++) {
            dateData[index] = in.nextInt();
        }
    } //getDateData

    public static int getMaximumDays() {
        /*Action: Based on the current month stored in the dateData array, this method determines how many days the current month should have, depending
        on what month it is.
         Input: The current month stored in dateData
         Output: maximumDays' value*/

        switch (dateData[2]) {
            case 1: 
                //Prints month name and current year
                System.out.println("JANUARY " + dateData[3] + "\n");
                //Stores one more than the maximum number of days in the month, better for the for loop when printing
                return 32;
            case 2: 
                //Sets 29 days in February if it's a leap year (the year is divisible by 4)
                if (dateData[3] % 4 == 0)
                {
                    System.out.println("FEBRUARY " + dateData[3] + "\n");
                    return 30;
                } else {
                    System.out.println("FEBRUARY " + dateData[3] + "\n");
                    return 29;
                }
            case 3: 
                System.out.println("MARCH " + dateData[3] + "\n");
                return 32;
            case 4:
                System.out.println("APRIL " + dateData[3] + "\n");
                return 31;
            case 5:
                System.out.println("MAY " + dateData[3] + "\n");
                return 32;
            case 6:
                System.out.println("JUNE " + dateData[3] + "\n");
                return 31;
            case 7:
                System.out.println("JULY " + dateData[3] + "\n");
                return 32;
            case 8:
                System.out.println("AUGUST " + dateData[3] + "\n");
                return 32;
            case 9:
                System.out.println("SEPTEMBER " + dateData[3] + "\n");
                return 31;
            case 10:
                System.out.println("OCTOBER " + dateData[3] + "\n");
                return 32;
            case 11:
                System.out.println("NOVEMBER " + dateData[3] + "\n");
                return 31;
            case 12:
                System.out.println("DECEMBER " + dateData[3] + "\n");
                return 32;
            //If a valid month is not inputted into the 
            default:
                return -1;
        }
    } //getMaximumDays

    public static void printDaysOfTheWeek(String[] daysOfWeek) {
        /*Action: Prints out the days of the week header for the calander
         Input: daysOfWeek array
         Output: Prints out the days of the week in succession*/

        //Loops through every index of daysOfWeek and prints it out
        for(int currentIndex = 0; currentIndex < daysOfWeek.length; currentIndex++) {
            //If currentIndex is less than 6 (not Saturday), prints within same line
            if (currentIndex < daysOfWeek.length - 1) {
                System.out.print(daysOfWeek[currentIndex] + "\t");
            } else {
                System.out.println(daysOfWeek[currentIndex]);
            }
        }

    } //printDaysOfTheWeek

    public static int getWeekOffset() {
        /*Action: Gets the week offset for how many days the calander should skip in the first week before it actually starts loading in 
        the days that actually occur for a month in a specific year.
        Input: The dateData array for the current day of the month
        Output: The number of days that should be skipped before loading the array to appropriate load the array for the month.*/

        //Sets the currentDay to the current day of the month
        int currentDay = dateData[1];
        //Keeps subtracting until we get the first instance of that day of the week in the current month
        while (currentDay >= 7) {
            currentDay -= 7;
        }
        
        //Subtracts the first instance of some day of the week by the weekday's index + 2 to get the starting day of the week for the month
        return Math.abs(currentDay - (dateData[0] + 2));
    } //getWeekOffset

    public static int[][] fillAndPrintmonthCalander(int[][] monthCalander, int maximumDays, int daysOfWeekCounter) {
        /*Action: Fills in the monthCalander array according to the current month and year
         Input: monthCalander, maximumDays, daysOfWeekCounter
         Output: A filled monthCalander
        */
        
        //Initializes the variable that will be used for filling the correct days in the calander
        int assignDay = 1;

        //Starts at (0, 0), ensures it goes through every row
        for(int currentRow = 0; currentRow < monthCalander.length; currentRow++) {
            /*Starts at (0, 0), goes through every column in the currentRow and assigns the assignDay, 
            increments one with each loop*/
            for(int currentColumn = 0; currentColumn < monthCalander[currentRow].length && assignDay < maximumDays; currentColumn++, assignDay++, daysOfWeekCounter++) {
                //Loads assignDay to the currentRow and currentColumn loop is on
                monthCalander[currentRow][currentColumn] = assignDay;
                //If the day is not on a Saturday, will print in one line and concatenate a space
                if (daysOfWeekCounter < 7) {
                    System.out.print(monthCalander[currentRow][currentColumn] + "\t");
                } else {
                    System.out.println(monthCalander[currentRow][currentColumn]);
                    daysOfWeekCounter = 0;
                }
            }
        }

        return monthCalander;
    } //fillAndPrintmonthCalander
}