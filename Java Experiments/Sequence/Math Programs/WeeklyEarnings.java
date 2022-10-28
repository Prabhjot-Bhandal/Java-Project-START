import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 3rd, 2022
/*Write a program that determines the 5% commision on the amount of weekly sales someone was 
 * able to achieve
*/

public class WeeklyEarnings {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //User inputs their weekly sales
            System.out.print("Type in your weekly sales: $");
            //Gets weeklySales
            double weeklySales = in.nextDouble();
            //Their 5% commision is determined by multiplying their weeklySales by 0.05
            double weeklyCommision = weeklySales * 0.05;
            //Rounds weeklyCommision to nearest hundredth
            double roundedWeeklyComission = Math.round(weeklyCommision * 100.0) / 100.0;
            //Their weekly earnings are then determined by adding their base salary ($300) and their 5% commision
            double weeklyEarnings = 300 + weeklyCommision;
            //Rounds weeklyEarnings to the nearest hundredth
            double roundedWeeklyEarnings = Math.round(weeklyEarnings * 100.0) / 100.0;
            //Outputs the user's weeklySales, roundedWeeklyCommision and roundedWeeklyEarnings
            System.out.println("Your weekly sales was $" + weeklySales + " and the 5% commision from those sales is $" + roundedWeeklyComission + ".\n Therefore, your weeklyEarnings is $" + roundedWeeklyEarnings + ".");
        }
    }
}
