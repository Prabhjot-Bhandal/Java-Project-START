import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: December 3rd, 2022
//Purpose: Simulates a game of Rock, Paper, Scissors

public class RockPaperScissors {
    public static void main(String[] args) throws InterruptedException {
        try (Scanner in = new Scanner(System.in)) {
            //Intro for RPS, explains rules
            System.out.println("Welcome to Rock, Paper Scissors! This program simulates this classic game of chance where your opponent is the computer!\nYou probably already know the rules, but let me summarize them for you:\nRock beats scissors, paper beats rock and scissors beats paper. If both players choose the same thing, there is a draw with no winner.");
            //Sleep for 5 seconds so the user can read the intro and rules
            Thread.sleep(5000);
            //Tells the user the game is starting
            System.out.println("Now then, let's play!");
            Thread.sleep(1000);
            //Initializes playConfirmation, run, userChoice, userChoiceStr, computerChoiceStr, roundNumber, draws, userPoints and computerPoints
            String playConfirmation;
            boolean run = true;
            int userChoice;
            String userChoiceStr;
            String computerChoiceStr;
            int roundNumber = 0;
            int draws = 0;
            int userPoints = 0;
            int computerPoints = 0;
            do {
                //Will repeat if user does not enter either 1, 2 or 3
                do {
                    //Gets userChoice
                    System.out.print("\n\nPlease pick either rock (1), paper (2) or scissors (3): ");
                    userChoice = in.nextInt();
                } while (userChoice != 1 && userChoice != 2 && userChoice != 3);
                //End of do-while for user's choice
                //Sets userChoiceInt depending on what thing the user has picked
                switch (userChoice) {
                    case 1:
                        userChoiceStr = "rock";
                        break;
                    case 2:
                        userChoiceStr = "paper";
                        break;
                    case 3:
                        userChoiceStr = "scissors";
                        break;
                    default:
                        userChoiceStr = "nothing";
                        break;
                }
                //Tells the user what they have picked
                System.out.println("\nYou have chosen " + userChoiceStr.toUpperCase() + "!");

                //Calculates the computer's choice, which is randomized
                int computerChoice = (int) (Math.random() * 3 + 1);
                Thread.sleep(2000);
                //Sets computerChoiceStr to which ever thing computer picked
                switch (computerChoice) {
                    case 1:
                        computerChoiceStr = "rock";
                        break;
                    case 2:
                        computerChoiceStr = "paper";
                        break;
                    case 3:
                        computerChoiceStr = "scissors";
                        break;
                    default:
                        computerChoiceStr = "Nothing";
                        break;
                }
                //Tells the user what the computer has picked
                System.out.println("\nThe computer has chosen " + computerChoiceStr.toUpperCase() + "!\n\n");

                //If both choices are the same, calls a draw
                if (userChoice == computerChoice) {
                    System.out.println("Draw! No one wins!");
                    draws++;
                    roundNumber++;
                }
                //If user picks rock
                else if (userChoice == 1) {
                    //User: Rock, Computer: Scissors
                    //User wins
                    if (computerChoice == 3) {
                        System.out.println("You win this round!");
                        userPoints++;
                        roundNumber++;
                    }
                    //User: Rock, Computer: Paper
                    //User loses
                    else if (computerChoice == 2) {
                        System.out.println("The computer wins this round!");
                        computerPoints++;
                        roundNumber++;
                    }
                }
                //If user picks paper
                else if (userChoice == 2) {
                    //User: Paper, Computer: Rock
                    //User wins
                    if (computerChoice == 1) {
                        System.out.println("You win this round!");
                        userPoints++;
                        roundNumber++;
                    }
                    //User: Paper, Computer: Scissors
                    //User loses
                    else if (computerChoice == 3) {
                        System.out.println("The computer wins this round!");
                        computerPoints++;
                        roundNumber++;
                    }
                }
                //If user picks scissors
                else if (userChoice == 3) {
                    //User: Scissors, Computer: Paper
                    //User wins
                    if (computerChoice == 2) {
                        System.out.println("You win this round!");
                        userPoints++;
                        roundNumber++;
                    }
                    //User: Scissors, Computer: Rock
                    //User loses
                    else if (computerChoice == 1) {
                        System.out.println("The computer wins this round!");
                        computerPoints++;
                        roundNumber++;
                    }
                }

                //Asks for another round
                //Will repeat if user does not reply with y or n
                do {
                    System.out.println("\n\nDo you want to play another round? (Y/N)");
                    //Makes sure to get the first index and turns the string lower case in case the user types in upper case
                    playConfirmation = in.next().substring(0, 1).toLowerCase();
                    //Turns the run boolean false, which causes the game loop to exit
                    if (playConfirmation.equals("n")) {
                        run = false;
                    }
                } while (!playConfirmation.equals("y") && !playConfirmation.equals("n"));
                //End of do-while for playConfirmation
            } while (run == true);
            //End of do-while for the whole game

            //Determines who wins this session
            //Outputs userPoints, computerPoints and roundNumber
            if (userPoints == computerPoints) {
                System.out.println("\n\nDuring this session:\nYou scored " + userPoints + " points and the computer scored " + computerPoints + " points.\nYou played a total of " + roundNumber + " rounds and had " + draws + " draws.");
                System.out.println("\nThus, this is a draw. No one wins this session!");
            }
            else if (userPoints > computerPoints) {
                System.out.println("\n\nDuring this session:\nYou scored " + userPoints + " points and the computer scored " + computerPoints + " points.\nYou played a total of " + roundNumber + " rounds and had " + draws + " draws.");
                System.out.println("\nThus, you win this session! Good job!");
            }
            else if (userPoints < computerPoints) {
                System.out.println("\n\nDuring this session:\nYou scored " + userPoints + " points and the computer scored " + computerPoints + " points.\nYou played a total of " + roundNumber + " rounds and had " + draws + " draws.");
                System.out.println("\nThus, the computer win this session! Better luck next time!");
            }
        }
    }
}
