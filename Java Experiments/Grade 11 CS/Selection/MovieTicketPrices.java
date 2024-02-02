import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 14th, 2022
/*Purpose: Determines the total movie ticket price for the user and their group.*/

public class MovieTicketPrices {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Introduction
            System.out.println("Hello! This program calculates the total price for you and your group to go to the movie theater.");

            
            //Gets group
            System.out.print("Let's get started!\nPlease input the number of people in your group: ");
            int group = in.nextInt();
            //Gets infants
            System.out.println("Please enter the number of infants in the group: ");
            int infants = in.nextInt();
            //Gets toddlers
            System.out.println("Please enter the number of toddlers in the group: ");
            int toddlers = in.nextInt();
            //Gets children
            System.out.println("Please enter the number of children in the group: ");
            int children = in.nextInt();
            //Gets teens
            System.out.println("Please enter the number of teens in the group: ");
            int teens = in.nextInt();
            //Gets adults
            System.out.println("Please enter the number of adults in the group: ");
            int adults = in.nextInt();
            //Gets seniors
            System.out.println("Please enter the number of seniors in the group: ");
            int seniors = in.nextInt();
            //Determines movieBalance
            double movieBalance = (children * 8) + (teens * 16) + (adults * 20) + (seniors * 16);

            //Outputs group, number of people in different age classes and total movie ticket balance
            System.out.println("There are " + group + " people in your group.");
            System.out.println("There are " + infants + " infants, " + toddlers + " toddlers, " + children + " children, " + teens + " teens, " + adults + " adults and " + seniors + " seniors in your group.");
            System.out.println("Therefore, your total movie ticket balance will be $" + movieBalance + ".");
        }
    }
}