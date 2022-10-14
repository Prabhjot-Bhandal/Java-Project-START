import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 12th, 2022
/*Assuming you’ve slept an average of 8 hours each night since the day you were born. Write a program that 
prints the total number of hours you’ve slept to date. Assume 365 days/year and 30 days/month.*/

public class Problem10 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter your birth year: ");
            //gets birthYear
            int birthYear = in.nextInt();
            System.out.print("Enter your birth month: ");
            //gets birthMonth
            int birthMonth = in.nextInt();
            System.out.print("Enter the day you were born (ex. 10): ");
            //gets birthDay
            int birthDay = in.nextInt();
            System.out.print("Enter the current year: ");
            //gets currentYear
            int currentYear = in.nextInt();
            System.out.print("Enter the current month: ");
            //gets currentMonth
            int currentMonth = in.nextInt();
            System.out.print("Enter the current day (ex. 10): ");
            //gets currentDay
            int currentDay = in.nextInt();

            //Subtracts currentYear by birthYear, then multipies difference by 365 to get the number of days according to their age
           int yearDays = (currentYear - birthYear) * 365;
           //Calculates minusBirthDays to subtract from their age in days
           int minusBirthDays = ((birthMonth - 1) * 30) + birthDay;
           //Calculates plusCurrentDays to add to their age in days
           int plusCurrentDays = ((currentMonth - 1) * 30) + currentDay;
           //Calculates daysAlive
           int daysAlive = (yearDays - minusBirthDays) + plusCurrentDays;
           //Calculates totalHoursSlepy by multiplying daysAlive by 8 hours of sleep per day
           int totalHoursSlept = daysAlive * 8;

           //Prints birthMonth, birthDay, birthYear, currentMonth, currentDay, currentYear and totalHoursSlept
           System.out.println("Your date of birth is " + birthMonth + "/" + birthDay + "/" + birthYear + " and the current date is " + currentMonth + "/" + currentDay + "/" + currentYear + ".\nThus, you have slept for a total of " + totalHoursSlept + " hours in your entire life.");
        }
}
}