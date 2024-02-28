import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: February 22, 2024
//Purpose: Create a calendar using 2D array concepts

public class CalendarApp {
    static Scanner in = new Scanner(System.in);
    static int[] dateData = new int[3];
    public static void main(String[] args) {
        //Stores the days of the week in an array
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        System.out.println("Please input the current day month and year with a space seperating the day, month and year.\nPlease write the current weekday as an integer of 1-7 (1 as in Sunday, 7 as in Saturday).\nFormat in 'DayName DD MM YYYY' (ex. 7 2 2 2024): ");
        //Stores the starting weekday
        int startDay = in.nextInt();
        //Stores what the current day is, this will be used in conjuction to the year
        //int currentDay = in.nextInt();
        //Stores what the current month is
        int currentMonth = in.nextInt();
        //Stores what the current year is
        int currentYear = in.nextInt();

        //Initializes the days of the month with the maximum number of rows and columns
        int[][] daysOfMonth = new int[5][7];
        int maximumDays = 0;
        //To make it appear cleaner and seperated from the user's input
        System.out.println("\n\n");
        //To center the month and year 
        System.out.print("\t\t    ");

        //For printing the current month and year
        switch (currentMonth) {
            case 1: 
                //Prints month name and current year
                System.out.println("JANUARY " + currentYear + "\n");
                //Stores one more than the maximum number of days in the month, better for the for loop when printing
                maximumDays = 32;
                break;
            case 2: 
                System.out.println("FEBRUARY " + currentYear + "\n");
                maximumDays = 29;
                break;
            case 3: 
                System.out.println("MARCH " + currentYear + "\n");
                maximumDays = 32;
                break;
            case 4:
                System.out.println("APRIL " + currentYear + "\n");
                maximumDays = 31;
                break;
            case 5:
                System.out.println("MAY " + currentYear + "\n");
                maximumDays = 32;
                break;
            case 6:
                System.out.println("JUNE " + currentYear + "\n");
                maximumDays = 31;
                break;
            case 7:
                System.out.println("JULY " + currentYear + "\n");
                maximumDays = 32;
                break;
            case 8:
                System.out.println("AUGUST " + currentYear + "\n");
                maximumDays = 32;
                break;
            case 9:
                System.out.println("SEPTEMBER " + currentYear + "\n");
                maximumDays = 31;
                break;
            case 10:
                System.out.println("OCTOBER " + currentYear + "\n");
                maximumDays = 32;
                break;
            case 11:
                System.out.println("NOVEMBER " + currentYear + "\n");
                maximumDays = 31;
                break;
            case 12:
                System.out.println("DECEMBER " + currentYear + "\n");
                maximumDays = 32;
                break;

        }

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
        //So the program knows how many days it should skip at the start of the month but printing blank tabs for them
        int daysOfWeekCounter = startDay;

        //Prints out tabs to skip the days that are not included on the calender
        for (int index = 0; index < daysOfWeekCounter - 1; index++) {
            System.out.print("\t");
        }

        //Starts at (0, 0), ensures it goes through every row
        for(int currentRow = 0; currentRow < daysOfMonth.length; currentRow++) {
            /*Starts at (0, 0), goes through every column in the currentRow and assigns the currentDay, 
            increments one with each loop*/
            for(int currentColumn = 0; currentColumn < daysOfMonth[currentRow].length && currentDay < maximumDays; currentColumn++, currentDay++, daysOfWeekCounter++) {
                //Loads currentDay to the currentRow and currentColumn loop is on
                daysOfMonth[currentRow][currentColumn] = currentDay;
                //If the day is not on a Saturday, will print in one line and concatenate a space
                if (daysOfWeekCounter < 7) {
                    System.out.print(daysOfMonth[currentRow][currentColumn] + "\t");
                } else {
                    System.out.println(daysOfMonth[currentRow][currentColumn]);
                    daysOfWeekCounter = 0;
                }
            }
        }

    }
}
