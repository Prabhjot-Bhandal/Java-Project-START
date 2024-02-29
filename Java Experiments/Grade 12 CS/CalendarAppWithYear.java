import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: February 28, 2024
//Purpose: Create a calendar using 2D array concepts, SPLIT IT UP, Use Read and Write Files

public class CalendarAppWithYear {
    static Scanner in = new Scanner(System.in);
    static int[] dateData = new int[4];
    public static void main(String[] args) {
        //Stores the days of the week in an array
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        System.out.println("Please input the current day month and year with a space seperating the day, month and year.\nPlease write the current weekday as an integer of 1-7 (0 as in Sunday, 6 as in Saturday).\nFormat in 'DayOfWeek DD MM YYYY' (ex. 6 3 2 2024): ");
        
        /*Stores all the date data in an array, 
        0 stores day of the week 
        1 stores the day of the month
        2 stores the month
        3 stores the year*/
        for (int index = 0; index < dateData.length; index++) {
            dateData[index] = in.nextInt();
        }

        //Initializes the days of the month with the maximum number of rows and columns
        int[][] daysOfMonth = new int[5][7];
        int maximumDays = 0;
        //To make it appear cleaner and seperated from the user's input
        System.out.println("\n\n");
        //To center the month and year 
        System.out.print("\t\t    ");

        //For printing the current month and year
        switch (dateData[2]) {
            case 1: 
                //Prints month name and current year
                System.out.println("JANUARY " + dateData[3] + "\n");
                //Stores one more than the maximum number of days in the month, better for the for loop when printing
                maximumDays = 32;
                break;
            case 2: 
                //Sets 29 days in February if it's a leap year
                if (dateData[3] % 4 == 0)
                {
                    System.out.println("FEBRUARY " + dateData[3] + "\n");
                    maximumDays = 30;
                } else {
                    System.out.println("FEBRUARY " + dateData[3] + "\n");
                    maximumDays = 29;
                }
                
                break;
            case 3: 
                System.out.println("MARCH " + dateData[3] + "\n");
                maximumDays = 32;
                break;
            case 4:
                System.out.println("APRIL " + dateData[3] + "\n");
                maximumDays = 31;
                break;
            case 5:
                System.out.println("MAY " + dateData[3] + "\n");
                maximumDays = 32;
                break;
            case 6:
                System.out.println("JUNE " + dateData[3] + "\n");
                maximumDays = 31;
                break;
            case 7:
                System.out.println("JULY " + dateData[3] + "\n");
                maximumDays = 32;
                break;
            case 8:
                System.out.println("AUGUST " + dateData[3] + "\n");
                maximumDays = 32;
                break;
            case 9:
                System.out.println("SEPTEMBER " + dateData[3] + "\n");
                maximumDays = 31;
                break;
            case 10:
                System.out.println("OCTOBER " + dateData[3] + "\n");
                maximumDays = 32;
                break;
            case 11:
                System.out.println("NOVEMBER " + dateData[3] + "\n");
                maximumDays = 31;
                break;
            case 12:
                System.out.println("DECEMBER " + dateData[3] + "\n");
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
        
        //Initializes the variable that will be used for filling the correct days in the calander
        int assignDay = 1;
        //Sets the currentDay to the current day of the month, keeps subtracting until we get the first instance of some day of the week in a month
        int currentDay = dateData[1];
        while (currentDay >= 7) {
            currentDay -= 7;
        }
        
        //Subtracts the first instance of some day of the week by the weekday's index + 2 to get the starting day of the week for the month
        int daysOfWeekCounter = Math.abs(currentDay - (dateData[0] + 2));

        //Prints out tabs to skip the days that are not included on the calender
        for (int index = 0; index < daysOfWeekCounter - 1; index++) {
            System.out.print("\t");
        }

        //Starts at (0, 0), ensures it goes through every row
        for(int currentRow = 0; currentRow < daysOfMonth.length; currentRow++) {
            /*Starts at (0, 0), goes through every column in the currentRow and assigns the assignDay, 
            increments one with each loop*/
            for(int currentColumn = 0; currentColumn < daysOfMonth[currentRow].length && assignDay < maximumDays; currentColumn++, assignDay++, daysOfWeekCounter++) {
                //Loads assignDay to the currentRow and currentColumn loop is on
                daysOfMonth[currentRow][currentColumn] = assignDay;
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
