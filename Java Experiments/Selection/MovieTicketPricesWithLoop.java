import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 15th, 2022
/*Purpose: Determines the total movie ticket price for the user and their group.*/

public class MovieTicketPricesWithLoop {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Introduction
            System.out.println("Hello! This program calculates the total price for you and your group to go to the movie theater.");

            //Gets group
            System.out.print("Let's get started!\nPlease input the number of people in your group: ");
            int group = in.nextInt();
            //Counter for loop, used for which person we are on
            int counter = 1; 
            //Initializes each age category's number of people
            int infantsAndToddlers = 0;
            int children = 0;
            int teens = 0;
            int adults = 0;
            int seniors = 0;
            //Initializes movieBalance
            double movieBalance = 0;


            for (int loops = group; loops > 0; loops--) {
                System.out.println("Please enter the the age of person " + counter + ": ");
                int age = in.nextInt();

                if (age < 0 && age > 121) {
                    System.out.println("Your age is invalid. Please enter a valid age.");
                    loops++;
                }
                //Infant and Toddler
                else if (age >= 0 && age < 4) {
                    //Adds $0.00 to movieBalance
                    movieBalance += 0;
                    //Adds 1 to how many infantsAndToddlers are going to the movies
                    infantsAndToddlers++;
                    //Adds 1 to counter for the next person
                    counter++;
                }
                //Child
                else if (age >= 4 && age < 13) {
                    //Adds an $8.00 child ticket to movieBalance
                    movieBalance += 8.00;
                    //Adds 1 to how many children are going to the movies
                    children++;
                    //Adds 1 to the counter for the next person
                    counter++;
                }
                //Teen
                else if (age >= 13 && age < 20) {
                    //Adds a $16.00 teen ticket to movieBalance
                    movieBalance += 16.00;
                    //Adds 1 to how many teens are going to the movies
                    teens++;
                    //Adds 1 to the counter for the next person
                    counter++;
                }
                //Adult
                else if (age >= 20 && age < 65) {
                    //Adds a $21.00 adult ticket to movieBalance
                    movieBalance += 21.00;
                    //Adds 1 to how many adults are going to the movies
                    adults++;
                    //Adds 1 to the counter for the next person
                    counter++;
                }
                //Senior
                else if (age >= 65 && age <= 121) {
                    //Adds a $16.00 senior ticket to movieBalance
                    movieBalance += 16.00;
                    //Adds 1 to how many seniors are going to the movies
                    seniors++;
                    //Adds 1 to the counter for the next person
                    counter++;
                }
                //End of loop
            }

            //Adds tax onto the movieBalance
            movieBalance *= 1.13;

            System.out.println("There are " + group + " people in your group.");
            System.out.println("There are " + infantsAndToddlers + " infants and toddlers, " + children + " children, " + teens + " teens, " + adults + " adults and " + seniors + " seniors in your group.");
            System.out.println("Therefore, your total movie ticket balance will be $" + movieBalance + ".");
        }
    }
}