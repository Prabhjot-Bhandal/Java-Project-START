import java.util.Scanner;

//Name: Prabhjot Bhandal
//Date: September 30th, 2022
/*Purpose: Calculates a person's age with keyboard input*/

public class DetermineAgeV2 
{
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner (System.in)) {
            System.out.print("What year were you born? \n");
            //Gets what year they were born
            int yearOfOrigin = sc.nextInt();
            System.out.print("What year is is it currently? \n");
            //Gets what the current year is
            int currentYear = sc.nextInt();
            //Calculates age by subtracting currentYear by yearOfBirth
            int age = currentYear - yearOfOrigin;
            
            //Prints yearOfBirth, currentYear and age
            System.out.println("\nYou were born in " + yearOfOrigin + " and the current year is " + currentYear + ". Therefore, you are " + age + " years old.");
        }
}
}
