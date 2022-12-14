import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 16th, 2022
//Create a multiple choice that scores a person a certain amount of points for the answer they pick

public class MultipleChoiceWithSwitch {
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
            switch (answer.toUpperCase()) {
                case "A":
                    //Adds 10 points
                    userScore += 10;
                    break;
                
                case "B":
                    //Adds 15 points
                    userScore += 15;
                    break;
                
                case "C":
                    //Adds 25 points
                    userScore += 25;
                    break;
                
                case "D":
                    //Adds 40 points
                    userScore += 40;
                    break;
                
                default:
                    System.out.println("Please enter a valid character.");
            }
            System.out.println("\n\n" + name + "'s score for this survey is " + userScore + " points.");
        }
    }
}
