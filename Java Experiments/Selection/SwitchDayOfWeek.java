import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 15th, 2022
/*Purpose: Determines the total movie ticket price for the user and their group.*/

public class SwitchDayOfWeek {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Introduction
            System.out.println("Hello! Please enter a day number from 1 to 7.");
            //gets dayNum
            int dayNum = in.nextInt();

            //Initializes dayName
            String dayName = "";

            //Assign a day name based on the number entered
            switch (dayNum) {
                case 1:
                    dayName = "Sunday";
                    System.out.println(dayName);
                    break;

                case 2:
                    dayName = "Monday";
                    System.out.println(dayName);
                    break;

                case 3:
                    dayName = "Tuesday";
                    System.out.println(dayName);
                    break;

                case 4:
                    dayName = "Wednesday";
                    System.out.println(dayName);
                    break;

                case 5:
                    dayName = "Thursday";
                    System.out.println(dayName);
                    break;

                case 6:
                    dayName = "Friday";
                    System.out.println(dayName);
                    break;

                case 7:
                    dayName = "Saturday";
                    System.out.println(dayName);
                    break;
    
                default: dayName = "Invalid day number";
                System.out.println(dayName);
                break;
            }
        }
    }
}