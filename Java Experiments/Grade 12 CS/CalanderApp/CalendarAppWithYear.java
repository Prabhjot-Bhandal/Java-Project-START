package CalanderApp;
import java.io.*;
import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: February 28, 2024
//Purpose: Create a calendar using 2D array concepts, Use Read and Write Files

public class CalendarAppWithYear {
    //Creates a scanner object for input that can be used across the entire class
    static Scanner in = new Scanner(System.in);
    //Creates a 1D int array that holds the data of the user's current date
    static int[] dateData = new int[4];
    //Stores the current month as a string
    static String monthString;
    //Stores the offset for printing the monthCalander
    static int holdOffset;
    //Creates a writer object for writing to a file
    static BufferedWriter writeFile;

    public static void main(String[] args) throws IOException {
        //Stores the days of the week in an array
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        //Initializes the monthCalander with the maximum number of rows and columns
        int[][] monthCalander = new int[5][7];
        //Initializes maximumDays at -1
        int maximumDays = -1;

        //Keeps looping if the user does not put in a valid month for their date
        do {
            //Calls getDateData() to load the static one-dimensional array which stores all of the date data that the user inputted
            getDateData();
            //Using the dateData array that was filled by getDateData, determines the maximum number of days for a given month
            maximumDays = getMaximumDays();
        } while (maximumDays < 0);

        //Calls getMonthTasks() to get the user's current monthly tasks
        String[]monthTasks = getMonthTasks();

        //Prints out the current month and year
        System.out.println("\n\n\t\t    " + monthString + " " + dateData[3] + "\n");

        //Prints out the days of the week header for the calander
        printDaysOfTheWeek(daysOfWeek);

        /*Gets the offset for the first week of the month and assigns it as the initial value of the daysOfWeekCounter 
        so the loop that prints the calander skips those many days*/
        int daysOfWeekCounter = getWeekOffset();
        holdOffset = daysOfWeekCounter;

        //Prints out tabs to skip the days that are not included on the calender
        for (int index = 0; index < daysOfWeekCounter - 1; index++) {
            System.out.print("\t");
        }

        //Fills the monthCalander with all of the data available to generate it
        monthCalander = fillAndPrintmonthCalander(monthCalander, maximumDays, daysOfWeekCounter);

        //Prints out the user's month tasks
        printMonthTasks(monthTasks);

        //Creates a calander file and writes the calander and tasks to it
        createCalanderFile(daysOfWeek, monthCalander, maximumDays, monthTasks);

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
                //Stores the current month as a string
                monthString = "JANUARY";
                //Stores one more than the maximum number of days in the month, better for the for loop when printing
                return 32;
            case 2: 
                monthString = "FEBRUARY";
                //Sets 29 days in February if it's a leap year (the year is divisible by 4)
                if (dateData[3] % 4 == 0)
                {
                    return 30;
                } else {
                    return 29;
                }
            case 3: 
                monthString = "MARCH";
                return 32;
            case 4:
                monthString = "APRIL";
                return 31;
            case 5:
                monthString = "MAY";
                return 32;
            case 6:
                monthString = "JUNE";
                return 31;
            case 7:
                monthString = "JULY";
                return 32;
            case 8:
                monthString = "AUGUST";
                return 32;
            case 9:
                monthString = "SEPTEMBER";
                return 31;
            case 10:
                monthString = "OCTOBER";
                return 32;
            case 11:
                monthString = "NOVEMBER";
                return 31;
            case 12:
                monthString = "DECEMBER";
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
         Output: A filled monthCalander*/
        
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

    public static void createCalanderFile(String[] daysOfWeek, int[][] monthCalander, int maximumDays, String[] monthTasks) throws IOException {
        /*Action: Creates a calander file that saves the current month calander made from the current date that the
        user inputted to a file labelled with the current month and year. It is the same method used to print the month,
        but instead of printing to the console, it writes it to a new file.
        Input: dateData[3] (current year), monthString, monthCalander
        Output: Creates a txt file that will house the current month that was generated*/

        //Creates the file and file path for where the current month calander will be written to
        writeFile = new BufferedWriter (new FileWriter ("C:\\Users\\prabh\\Documents\\GitHub\\Java-Project-START\\Java Experiments\\Grade 12 CS\\CalanderApp\\" + monthString + dateData[3] + "Calander.txt"));

        //Writes the current month and year, have to split up types of input as the .write() method can only handle one data type
        writeFile.write("\t\t    ");
        writeFile.write(monthString);
        writeFile.write(" ");
        writeFile.write(String.valueOf(dateData[3]));
        writeFile.newLine();

        //Writes the days of the week
        //Loops through every index of daysOfWeek and writes it to the file
        for(int currentIndex = 0; currentIndex < daysOfWeek.length; currentIndex++) {
            //If currentIndex is less than 6 (not Saturday), prints within same line
            if (currentIndex < daysOfWeek.length - 1) {
                writeFile.write(String.valueOf(daysOfWeek[currentIndex]));
                writeFile.write(" \t");
            } else {
                writeFile.write(String.valueOf(daysOfWeek[currentIndex]));
                writeFile.newLine();
            }
        }

        //Writes tabs to skip the days that are not included on the calender
        for (int index = 0; index < holdOffset - 1; index++) {
            writeFile.write("  \t\t");
        }

        //Writes the calander for the month the way we printed it; not based on the array but how it's printed
        //Starts at (0, 0), ensures it goes through every row
        for(int currentRow = 0; currentRow < monthCalander.length; currentRow++) {
            /*Starts at (0, 0), goes through every column in the currentRow and assigns the assignDay, 
            increments one with each loop*/
            //Subtracts maximumDays until it reaches 1, then stops writing days to the calander
            for(int currentColumn = 0; currentColumn < monthCalander[currentRow].length && maximumDays > 1; currentColumn++, maximumDays--, holdOffset++) {
                //If the day is not on a Saturday, will print in one line and concatenate a space
                if (holdOffset < 7) {
                    //Produced errors with integers, changed them to strings with the .valueOf() string method
                    writeFile.write(String.valueOf(monthCalander[currentRow][currentColumn]));
                    writeFile.write(" \t\t");
                } else {
                    writeFile.write(String.valueOf(monthCalander[currentRow][currentColumn]));
                    writeFile.newLine();
                    //Resets the offset
                    holdOffset = 0;
                }
            }
        }
        
        //Writes two new lines to the file
        writeFile.newLine();

        writeFile.write("\n\nThis Month's Tasks:\n");

        //Runs for the whole array
        for (int currentIndex = 0; currentIndex < monthTasks.length; currentIndex++) {
            //Writes all the elements of the array in successive new lines
            writeFile.write(monthTasks[currentIndex]);
            writeFile.newLine();
        }

        //Closes the writing so it saves to the file
        writeFile.close();
    } //createCalanderFile

    public static String[] getMonthTasks () {
        /*Action: Gets the monthly tasks the user desires to get done within the current month. This will be both printed and 
        written to the month's calander file.
        Input: User input of the number of tasks and what the tasks will be
        Output: Creates the monthTasks array that houses the user's tasks
        */

        //Gets the amount of tasks the user desires to get done
        System.out.print("\nHow many tasks do you plan to get done this month?: ");
        int numTasks = in.nextInt();
        //Creates the array that will house all of the tasks the user wants to get done this month
        String[] monthTasks = new String[numTasks];

        //Gets all the tasks the user wants to get done and stores them to the monthTasks array
        for (int currentTask = 0; currentTask < numTasks; currentTask++) {
            //Prints the current task that the user is filling out
            System.out.println("Task " + (currentTask + 1) + ": ");
            //Stores the user's answer in the array with all their monthly tasks
            monthTasks[currentTask] = in.next();
        }

        return monthTasks;
    } //getMonthTasks

    public static void printMonthTasks(String[] monthTasks) {
        /*Action: Prints out all of the user's month tasks and writes these tasks to the file
         Input: monthTasks array
         Output: The printing of the entire array*/

        System.out.println("\n\nThis Month's Tasks:");

        //Runs for the whole array
        for (int currentIndex = 0; currentIndex < monthTasks.length; currentIndex++) {
            //Prints all the elements of the array in successive new lines
            System.out.println(monthTasks[currentIndex]);
        }

    } //printMonthTasks
}