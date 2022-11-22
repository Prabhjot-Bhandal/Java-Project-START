import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 21st, 2022
/*Purpose: Gets user to input their password, locks them out after 5 tries.*/

public class PasswordCheck {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Creates the password
            String password = "Mona";
            //Initializes tries with 1 since we at the start we are on our first try
            int tries = 1;
            //Get userInput
            System.out.println("Please type in your password: ");
            String userInput = in.next();
            //While userInput is not equal to password AND when tries < 5, run loop
            while (!userInput.equals(password) && tries < 5) {
                //Get userInput if they have typed in the wrong password
                System.out.println("\nIncorrect. Please try again\nPlease type in your password: ");
                userInput = in.next();
                //Adds to the number of tries it takes the user to enter the password
                tries++;
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