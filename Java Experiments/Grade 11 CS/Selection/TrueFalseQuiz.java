import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 7th, 2022
//Create a true/false quiz with two questions

public class TrueFalseQuiz {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Intro for quiz
            System.out.println("Welcome to my true/false quiz! To begin, please enter your full name below!");
            //Gets name
            String name = in.nextLine();
            //Initialized userScore
            int userScore = 0;
            System.out.println("Let's get started! \n");


            //Question 1
            System.out.println("It's good to never put comments in your code. (T/F)");
            String question1Answer = in.next();
            //If correct
            if (question1Answer.equalsIgnoreCase("T") || question1Answer.equalsIgnoreCase("True")) {
                System.out.println("Correct! \n");
                //Adds 1 to userScore
                userScore++;
            }
            //If incorrect
            else {
                System.out.println("Incorrect! It's good to put comments in your code so that you know what different parts of your code do. \n\n");
            }

            //Question 2
            System.out.println("You do not have to put a semicolon (;) after each command in your code. (T/F)");
            String question2Answer = in.next();
            //If correct
            if (question2Answer.equalsIgnoreCase("F") || question2Answer.equalsIgnoreCase("False")) {
                System.out.println("Correct! \n");
                //Adds 1 to userScore
                userScore++;
            }
            //If incorrect
            else {
                System.out.println("Incorrect! You MUST put a semicolon after each command in your code, or else you will receive an error. \n\n");
            }

            //Outputs score
            System.out.println(name + " has scored a " + userScore + "/2 on this quiz.");
        }
    }
}
