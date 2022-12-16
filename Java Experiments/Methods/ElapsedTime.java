import java.util.Scanner;
//Prabhjot Bhandal
//December 15th, 2022
//Write a method called elapsedTime() that returns the difference of two integer parameters

import javax.print.event.PrintEvent;

public class ElapsedTime {
    //Makes in a class variable
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //Initializes startTime, endTime and activity
        //Initialized at -1 since 0 is a valid time
        int startTime = -1;
        int endTime = -1;
        String activity = "";

        //Get activity
        System.out.print("\nPlease enter the name of the activity you were doing: ");
        activity = in.next().replaceAll(" ", "");

        //Loops back if either startTime are not within the 24-hour clock
        do {
            //Get startTime
            System.out.print("\nPlease enter the start time of your " + activity + " activity (in the 24-hour clock): ");
            startTime = in.nextInt();
            //Tells user input is invalid if startTime is less than 0 or greater than 23
            if (startTime < 0 || startTime > 23) {
                System.out.print("Invalid input. Please input a vaild hour (0-23).\n\n");
            }

        } while (startTime < 0 || startTime > 23);

        //Loops back if either endTime are not within the 24-hour clock
        do {
            //Get endTime 
            System.out.print("\nPlease enter the end time of your " + activity + " activity (in the 24-hour clock): ");
            endTime = in.nextInt();
             //Tells user input is invalid if endTime is less than 0 or greater than 23
             if (endTime < 0 || endTime > 23) {
                System.out.print("Invalid input. Please input a vaild hour (0-23).\n\n");
            }

        } while (endTime < 0 || endTime > 23);

        //Calls getElapsedTime() and sets the return value to elapsedTime
        int elapsedTime = getElapsedTime(startTime, endTime);

        //Prints out activity, startTime, endTime and elapsedTime
        System.out.println("\nYou started your " + activity + " activity at hour " + startTime + " and stopped at hour " + endTime + ".\nThus, you spent " + elapsedTime + " hours doing your " + activity + " activity.");
    } //main
    

    public static int getElapsedTime(int start, int end) {
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
