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

            if (age < 0) {
                System.out.println("Your age is invalid. Please restart the program and enter a valid age.");
            }
            else if (age >= 0 && age < 2) {
                
            }
        }
    }
}