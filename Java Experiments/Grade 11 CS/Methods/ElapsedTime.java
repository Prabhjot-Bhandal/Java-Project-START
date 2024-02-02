import java.util.Scanner;
//Prabhjot Bhandal
//December 15th, 2022
//Write a method called elapsedTime() that returns the difference of two integer parameters

public class ElapsedTime {
    //Makes in and actvity class variables
    static Scanner in = new Scanner(System.in);
    static String activity = "";
    public static void main(String[] args) {
        //Initializes startTime, endTime and activity
        //Initialized at -1 since 0 is a valid time
        int startTime = -1;
        int endTime = -1;

        //Get activity
        System.out.print("\nPlease enter the name of the activity you were doing: ");
        activity = in.nextLine().replaceAll(" ", "");

        //Calls getHour() method to get both start and end time
        startTime = getHour("start time");
        endTime = getHour("end time");

        //Calls getElapsedTime() and sets the return value to elapsedTime
        int elapsedTime = getElapsedTime(startTime, endTime);

        //Prints out activity, startTime, endTime and elapsedTime
        System.out.println("\nYou started your " + activity + " activity at hour " + startTime + " and stopped at hour " + endTime + ".\nThus, you spent " + elapsedTime + " hours doing your " + activity + " activity.");
    } //main
    

    public static int getHour(String timeString) {
        /*Takes in a string to tell the user whether they are inputting the start or end time of their 
        activity.
        Returns the start or end time the user inputs and verifies if the user has put in a legitimate hour*/

        //Initializes hour
        int hour;
        //Loops back if either startTime are not within the 24-hour clock
        do {
            //Gets hour
            System.out.print("\nPlease enter the " + timeString + " of your " + activity + " activity (in the 24-hour clock): ");
            hour = in.nextInt();
             //Tells user input is invalid if endTime is less than 0 or greater than 23
             if (hour < 0 || hour > 23) {
                System.out.print("Invalid input. Please input a vaild hour (0-23).\n\n");
            }

        } while (hour < 0 || hour > 23);
        return hour;
    } //getHour

    public static int getElapsedTime(int start, int end) {
        /*Takes in the starting hour of the activity and the ending hour of the activity,
         returns how long someone has spent doing their activity*/

        //Initializes elpasedTime at -1 since 0 is a valid integer
        int elapsedTime = -1;

        //If start is less than end
        if (start < end) {
            //We get absolute value so it doesn't return a negative elapsedTime, which is inadmissible
            elapsedTime = Math.abs(start - end);
        }
        //If start is greater than end
        else if (start > end) {
            //Adds 24 to end when start > end because we are going to the next day
            elapsedTime = Math.abs(start - (end + 24));
        }

        return elapsedTime;

    } //getElapsedTime
}
