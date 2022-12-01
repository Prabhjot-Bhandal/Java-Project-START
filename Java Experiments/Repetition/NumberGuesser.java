import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: December 1st, 2022
/*Purpose: Write a program that generates a random integer between 10 and 30 
including 10 and 30 and then asks the user to guess the number that was 
generated.*/

public class NumberGuesser {
    public static void main(String[] args)throws InterruptedException{
        try (Scanner in = new Scanner(System.in)) {
            //Generates randomNum withn 10 and 30
            //Adds 11 since Math.random starts at 0
            int randomNum = (int) (Math.random() * 20 + 11);
            //Initializes userNum
            int userNum = 0;
            //Initializes attempts
            int attempts = 0;
            //Introduction
            System.out.println("Welcome to Number Guesser!\nThis is a game where the computer generates an integer between 10 and 30 adn you have to guess it!\nGood luck!\n\n");
            Thread.sleep(5000);

            //While userNum does not equal the randomNum
            do {
                //Gets user's input for userNum
                System.out.print("Guess a number between 10 and 30: ");
                userNum = in.nextInt();
                //Adds one attempt whenever the loop runs
                attempts++;

                //Runs the loop again and tells the user to enter a valid number 
                if (userNum < 10 || userNum > 30) {
                    System.out.print("Please enter a valid number.\n");
                    //Subtracts an attempt because this attempt is invalid
                    attempts--;
                }

                //If userNum is less than randomNum
                if (userNum < randomNum) {
                    System.out.println("Your number is too low!\n");
                }
                //If userNum is greater than randomNum
                else if (userNum > randomNum) {
                    System.out.println("Your number is too high!\n");
                }
            } while (userNum != randomNum);
            //End of do-while
                
            //Outputs what the random number was when the user gets the number
            switch (attempts) {
                //If the user got it one attempt
                case 1:
                    System.out.println("You got it! The random number was " + randomNum + "!\nYou got it in " + attempts + " attempt!"); 
                    break;

                //If the user got it in more than one attempt
                default:
                    System.out.println("You got it! The random number was " + randomNum + "!\nYou got it in " + attempts + " attempts!");
                    break;
            } //End of switch
        }
    }
}