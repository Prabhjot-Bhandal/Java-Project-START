import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 21st, 2022
/*Purpose: Gets user to input their password, locks them out after 5 tries.*/

public class PasswordCheck {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Creates the password
            String password = "Mona";
            //Initializes userInput, run and tries for the loop
            String userInput = "";
            boolean run = true;
            int tries = 0;
            //While userInput is not equal to password AND when run is true, run loop
            while (!userInput.equals(password) && run == true) {
                //Get userInput
                System.out.println("Please type in your password: ");
                userInput = in.next();
                //Adds to the number of tries it takes the user to enter the password
                tries++;
                //If user has tried more than 5 times, breaks loop
                if (tries > 5) {
                    run = false;
                }
            }
            //Lets in user if they input the correct password
            if (userInput.equals(password)) {
                System.out.println("\nWelcome!");
            }
            //Locks user out if they cannot input the correct password within 5 tries
            else {
                System.out.println("Too many password attempts. Your account has been locked.");
            }
        }
    }
}