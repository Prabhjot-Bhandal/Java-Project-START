import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 20th, 2022
/*Purpose: Get the name of both parents. Next, get the first letter for the baby’s name
The complete baby’s name is: Join second two characters of both parents’ name to the first character 
of the baby’s name */

public class Task2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //partner1 Introduction
            System.out.print("Please enter the first partner's name: ");
            //Gets partner1's name
            String partner1 = in.next();
            //partner2 Introduction
            System.out.print("Please enter the second partner's name: ");
            //Gets partner2's name
            String partner2 = in.next();
            //babyFirstLetter Introduction
            System.out.print("Please enter the first letter of the baby's name: ");
            //Gets the babyFirstLetter
            String babyFirstLetter = in.next();

            //Determine's the babyName by joining baybFirstLetter, and the second letters of the parents' names
            String babyName = babyFirstLetter + partner1.charAt(1) + partner2.charAt(1);

            //Prints the parents' names, the babyFirstLetter and the babyName
            System.out.println("The parents' names are " + partner1 + " and " + partner2 + ".\nThe first letter of the baby's name is " + babyFirstLetter + ".\nTherefore, the baby's name will be " + babyName + ".");
        }
    }
}
