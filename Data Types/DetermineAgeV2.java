//Name: Prabhjot Bhandal
//Date: September 30th, 2022
/*Purpose: Calculates a person's age with keyboard input*/

public class DetermineAgeV2 {
    public static void main(String[] args) {
        //Gets what year they were born
        int yearOfBirth = 2006;
        //Gets what the current year is
        int currentYear = 2022;
        //Calculates age by subtracting currentYear by yearOfBirth
        int age = currentYear - yearOfBirth;
        
        //Prints yearOfBirth, currentYear and age
        System.out.println("\nYou were born in " + yearOfBirth + " and the current year is " + currentYear + ". Therefore, you are " + age + " years old.");
}
