import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 7th, 2022
//Create a multiple choice that scores a person a certain amount of points for the answer they pick

public class MultipleChoiceSurvey {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Intro for survey
            System.out.println("Welcome to this multiple choice survey! To begin, please enter your full name below!");
            //Gets name
            String name = in.nextLine();
            //Initialized userScore
            int userScore = 0;
            System.out.println("Let's get started! \n");


            //Question 1
            System.out.println("What relaxation method relaxes you the most? \nA. Going outside for a walk \nB. Listening to music \nC. Engaging in your hobbies \nD. Other");
            String answer = in.next();
            //If A
            if (answer.equalsIgnoreCase("A")) {
                //Adds 10 points
                userScore += 10;
            } 
            //If B
            else if (answer.equalsIgnoreCase("B")) {
                //Adds 15 points
                userScore += 15;
            }
            //If C
            else if (answer.equalsIgnoreCase("C")) {
                //Adds 25 points
                userScore += 25;
            }
            //If D
            else if (answer.equalsIgnoreCase("D")) {
                //Adds 40 points
                userScore += 40;
            }

            //Outputs score
            System.out.println("\n\n" + name + "'s score for this survey is " + userScore + " points");
        }
    }
}
