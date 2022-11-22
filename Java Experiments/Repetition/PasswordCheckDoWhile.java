import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 22nd, 2022
/*Purpose: Gets user to input their password, locks them out after 5 tries.*/

public class PasswordCheckDoWhile {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Creates the password
            String password = "Mona";
            //Initializes tries with 1 since we at the start we are on our first try
            int tries = 1;
            //Initializes userInput with an empty string
            String userInput = "";
            do {
                //First attempt
                if (tries == 1) {
                    //Get userInput
                    System.out.println("\nPlease type in your password: ");
                    userInput = in.next();
                    //Adds to the number of tries it takes the user to enter the password
                    tries++;
                }
                //Any other attempts
                else {
                    //Get userInput
                    System.out.println("\nIncorrect. Please try again.\nPlease type in your password: ");
                    userInput = in.next();
                    //Adds to the number of tries it takes the user to enter the password
                    tries++;
                }
            //Only runs while userInput is not equal to password and when tries is less than or equal to 5
            } while (!userInput.equals(password) && tries <= 5);
            //End of loop

            //Lets in user if they input the correct password
            if (userInput.equals(password)) {
                System.out.println("\nWelcome!");
            }
            //Locks user out if they cannot input the correct password within 5 tries
            else {
                System.out.println("\nToo many password attempts. Your account has been locked.");
            }
        }
    }
}