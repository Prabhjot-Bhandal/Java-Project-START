import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 11th, 2022
/*Purpose: Classifies a person depending on their age*/

public class AgeClassification {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Introduction
            System.out.println("Hello! This program gets your age, then uses your age to put you into a specific age category.");

            
            //Intro for age
            System.out.print("Let's get started!\nPlease input your age: ");
            //Gets age
            int age = in.nextInt();


            //Invalid age
            if (age < 0 && age > 121) {
                System.out.println("Your age is invalid. Please restart the program and enter a valid age.");
            }
            //Infant
            else if (age >= 0 && age < 2) {
                System.out.println("You are a infant.");
            }
            //Toddler
            else if (age >= 2 && age < 4) {
                System.out.println("You are a toddler.");
            }
            //Child
            else if (age >= 4 && age < 13) {
                System.out.println("You are a child.");
            }
            //Teen
            else if (age >= 13 && age < 20) {
                System.out.println("You are a teen.");
            }
            //Adult
            else if (age >= 20 && age < 65) {
                System.out.println("You are an adult.");
            }
            //Senior
            else if (age >= 65 && age <= 121) {
                System.out.println("You are a senior.");
            }
        }
    }
}