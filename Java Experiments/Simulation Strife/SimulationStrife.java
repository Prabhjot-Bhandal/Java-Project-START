import java.util.Scanner;
//Prabhjot Bhandal
//January 13th, 2022
/*Simulates a text and turn-based battle against an enemy, but everytime the program runs, 
 it's a different scenario*/

public class SimulationStrife {
    //Static variables that can be used across the entire program
    //Input
    static Scanner in = new Scanner(System.in);

    //Player stats and moves
    static int playerHP = 100;
    static int playerMP = 10;
    /*We'll have a move pool of 8 moves
    Even indices are Physical attacks
    Odd indices are Magic attacks
    Indices 7 and 8 are Neutral attacks
    Index 0 is heal
    Index 9 is for recharging MP*/
    static String playerMoves[] = {"Curaga", "Fire", "Upper Slash", "Gravira", "Aerial Slash", "Thunderaga", "Back Slash", "Groundbreaker", "Triple Rush", "Energy Recharge"};

    //Enemy stats
    static int enemyHP = 100;
    /*4 different types of enemies to choose from:
    Mr. Whammy-Bar - Physical damage dealer
    Doc. Slayer - Magic damage dealer
    BINKY - Physical damage leech
    SoulStrike - Magic damage leech*/
    static String enemyList[] = {"Mr. Whammy-Bar", "Doc. Slayer", "BINKY", "SoulStrike"};
    //Enemy move lists
    static String whammyMoves[] = {"Wack", "Wham-Hammer", "Bar Destroyer", "Whams and Bars"};
    static String slayerMoves[] = {"Ibuprofen", "Antibiotics", "Blood-Transmission", "MRI"};
    static String binkyMoves[] = {"Shove", "Buster", "Thwompper", "Brink of Extinction"};
    static String soulStrikeMoves[] = {"Soul Touch", "Death Call", "Grave Digger", "Soul Reaper"};
    

  public static void main(String[] args) throws InterruptedException {
    //Game loop boolean
    //Default case for run is false
    boolean run = false;
    run = introduction();
    
    //Keeps running game 
    while (run == true) {
      //Gets an integer between 0 and 3 for what the current enemy is
      int currentEnemyIndex = enemyRandomizer();
      String currentEnemy = enemyList[currentEnemyIndex];

      //Initializes stats so it refreshes everytime the player starts a new game
      playerHP = 100;
      playerMP = 10;
      enemyHP = 100;

      /*Intializes playerChoiceInt, playerMoveStr, playerMoveIndex
      Used for storing the move the player has selected*/
      int playerChoiceInt = 0;
      String playerMoveStr = "";
      int playerMoveIndex = -2;

      /*Intializes moveChoice 1, 2 and 3 and moveChoice indices
      Used to store randomized moves and display them*/
      String moveChoice1 = "";
      int moveChoice1Index = -1;
      String moveChoice2 = "";
      int moveChoice2Index = -1;
      String moveChoice3 = "";
      int moveChoice3Index = -1;

      //Main game loop, ends only when either playerHP or enemyHP go below 0
      do {
        //Gets a random index in playerMoves for each move choice
        moveChoice1Index = randomizer(playerMoves);
        moveChoice2Index = randomizer(playerMoves);
        moveChoice3Index = randomizer(playerMoves);
       
        //If statements for ensuring no duplicate moves
        //If move choice 1 and 2 are the same
        if (moveChoice1Index == moveChoice2Index) {
          //Rerolls moveChoice2Index until they aren't the same
          while (moveChoice1Index == moveChoice2Index) {
            moveChoice2Index = randomizer(playerMoves);
          }
        } 
        //If move choices 1 and 3 are the same
        else if (moveChoice1Index == moveChoice3Index) {
          //Rerolls moveChoice3Index until they aren't the same
          while (moveChoice1Index == moveChoice3Index) {
            moveChoice3Index = randomizer(playerMoves);
          }
        }
        //If move choices 2 and 3 are the same
        else if (moveChoice2Index == moveChoice3Index) {
          //Rerolls moveChoice3Index until they aren't the same
          while (moveChoice2Index == moveChoice3Index) {
            moveChoice3Index = randomizer(playerMoves);
          }
        }

        //Assigns move choice indexes to corresponding move choice
        moveChoice1 = playerMoves[moveChoice1Index];
        moveChoice2 = playerMoves[moveChoice2Index];
        moveChoice3 = playerMoves[moveChoice3Index];

        do {
          //Randomizes the first index of the cycle
          //Shows player's current stats and the enemy's currents stats
          System.out.println("\n\nHP: " + playerHP + "/100\t\t\t\t" + currentEnemy + "'s HP: " + enemyHP + "/100\nMP: " + playerMP + "/10\n");
          Thread.sleep(1000);
          //Gets player's current turn and displays which moves the player has to pick from
          System.out.print("YOUR TURN\n1) " + moveChoice1 + "\n2) " + moveChoice2 + "\n3) " + moveChoice3 + "\n4) Guard" + "\n\nYOUR CHOICE: ");
          playerChoiceInt = in.nextInt();

          //Keeps looping if user does not enter either 1, 2, 3 or 4
        } while(playerChoiceInt != 1 && playerChoiceInt != 2 && playerChoiceInt != 3 && playerChoiceInt != 4);

        //Switch case for the player picking which move they want to use and assigns the move's string to playerMoveStr and the move's index to playerMoveIndex
        switch (playerChoiceInt) {
          //If the player pressed 1
          case 1:
            playerMoveStr = moveChoice1;
            playerMoveIndex = moveChoice1Index;
            break;

          //If the player pressed 2
          case 2:
            playerMoveStr = moveChoice2;
            playerMoveIndex = moveChoice2Index;
            break;

          //If the player pressed 3
          case 3:
            playerMoveStr = moveChoice3;
            playerMoveIndex = moveChoice3Index;
            break;

          //If the player pressed 4 (will always be guard)
          case 4:
            playerMoveStr = "Guard";
            playerMoveIndex = -1;
            break;
        }

        //Tells player what move they picked
        System.out.println("\n\nYou have chosen to use " + playerMoveStr.toUpperCase() + "!");

        //After player picks a move, playerTurn will run
        int playerDMG = playerTurn(playerMoveIndex, currentEnemyIndex);

        //Player's limited resource system
        //Guard negates 10 HP from an enemy attack, takes no resources
        if (playerDMG == -1) {
          playerHP += 10;
          playerDMG = 0;
          System.out.println("You will NEGATE 10 HP from the enemy's upcoming attack!\n");
        }
        //Heal takes 2 MP, heals for 30 HP
        if (playerDMG == 30) {
          //If player has no MP left, sets damage to 0 and tells the player they have no MP
          if (playerMP == 0) {
            playerDMG = 0;
            System.out.println("YOU HAVE NO MP LEFT! You have regained ZERO HP!\n");
          }
          else {
            playerMP -= 2;
            playerHP += 30;
            playerDMG = 0;
            System.out.println("You have REGAINED 30 HP!\n");
          }
        }
        //Recharge takes 20 HP, recharges 4 MP
        else if (playerDMG == 4) {
          playerDMG = 0;
          playerHP -= 20;
          playerMP += 4;
          System.out.println("You have RECHARGED 4 MP!\n");
        }
        //Physical attacks take 20 HP, are 35 DMG
        else if (playerDMG == 35) {
          //If enemy is BINKY, gives BINKY 20 HP
          if (currentEnemyIndex == 2) {
            playerDMG = 0;
            enemyHP += 20;
            System.out.println("BINKY has ABSORBED 20 HP because he is a PHYSICAL DAMAGE LEECH!\n");
          }
          playerHP -= 20;
          System.out.println("You have done 35 DAMAGE!\n");
        }
        //Magic attacks take 2 MP, are 20 DMG
        else if (playerDMG == 20) {
          //If enemy is SoulStrike, gives SoulStrike 20 HP
          if (currentEnemyIndex == 3) {
            playerDMG = 0;
            enemyHP += 20;
            System.out.println("SoulStrike has ABSORBED 20 HP because he is a MAGIC DAMAGE LEECH!\n");
          }
          //If player has no MP left, sets damage to 0 and tells the player they have no MP
          else if (playerMP == 0) {
            playerDMG = 0;
            System.out.println("YOU HAVE NO MP LEFT! You have done ZERO DAMAGE!\n");
          }
          //If player has MP
          else {
            playerMP -= 2;
            System.out.println("You have done 20 DAMAGE!\n");
          }
        }
        //Neutral attacks take 2 MP and 10 HP, are 25 DMG
        else if (playerDMG == 25) {
          //If player has no MP left, sets damage to 0 and tells the player they have no MP
          if (playerMP == 0) {
            playerDMG = 0;
            System.out.println("YOU HAVE NO MP LEFT! You have done ZERO DAMAGE!\n");
          }
          else {
            playerMP -= 2;
            playerHP -= 10;
            System.out.println("You have done 25 DAMAGE!\n");
          }
        }

        //enemyHP subtracted by playerDMG
        enemyHP -= playerDMG;

        Thread.sleep(2000);

        //After player's turn runs, it's the enemy's turn
        //Gets enemyIndex for enemyMove and enemyDMG
        int enemyMoveIndex = (int) (Math.random() * 3);
        //With currentEnemy and enemyIndex, gets which move the enemy is doing
        String enemyMove = enemyMove(currentEnemyIndex, enemyMoveIndex);
        //With enemyIndex, gets how much damage the enemy has done
        int enemyDMG = enemyDMG(enemyMoveIndex);

        //Prints out currentEnemy, enemyMove and enemyDMG
        System.out.println("\n" + currentEnemy + " has decided to use " + enemyMove.toUpperCase() + "!\nYou have taken " + enemyDMG + " DAMAGE!" + "\n");
        //Subtracts playerHP with enemyDMG
        playerHP -= enemyDMG;

        //Keeps looping until either the playerHP or enemyHP is below zero
      } while (playerHP > 0 && enemyHP > 0);

      //If statements that show who won this round
      //If the enemy and player tie
      if (enemyHP == playerHP) {
        System.out.println("No way! HOW DID YOUR SIMULATION STRIFE WITH " + currentEnemy.toUpperCase() + " END IN A DRAW!?!");
      }
      //If the enemy loses
      else if (enemyHP < 0) {
        //Prints enemy's name in upper case
        System.out.println("\n\nCongratulations! You have defeated " + currentEnemy.toUpperCase() + " in this simulation strife!");

      } 
      //If the player loses
      else if (playerHP < 0) {
        //Prints that the player lost to their specific enemy, enemy name in upper case
        System.out.println("\n\nOh no! You were defeated by " + currentEnemy.toUpperCase() + " in this simulation strife! Better luck next time!");
      }

      //Initializes playAgain for play again inquiry
      String playAgain = "";
      //Loop keeps running if the user does not input y or n
      do {
        //Updates playAgain with user input
        System.out.print("\nWould you like to play again? (Y/N): ");
        //Takes all of the spaces out of user's response, changes its case to lower case and only gets the first character of the string
        playAgain = in.next().replaceAll(" ", "").toLowerCase().substring(0, 1);
      } while (!playAgain.equalsIgnoreCase("Y") && !playAgain.equalsIgnoreCase("N")); //End of do-while

      //If playAgain is yes, runs game loop again
      if (playAgain.equalsIgnoreCase("Y")) {
        run = true;
      }
      //If playAgain is no, breaks game loop
      else {
        run = false;
      }
      } //game loop

  } //main



  public static boolean introduction() throws InterruptedException{
    //Introduces the game, asks the user if they want to play, returns a boolean

    System.out.println("Welcome to Simulation Strife!\n\nThis program simulates a text and turn-based battle (or strife), similar to many battles found in RPG games today.\nIn Simulation Strife, each battle is against a singular, randomized enemy and your job is to defeat your enemy in battle.\nHowever, each time it is the player's turn, they have a randomized move set.\n");
    System.out.println("To add, there are 4 types of moves players can choose from healing/recharging, physical, magical and neutral.\nIt is important to know the types of each move as they spend a specific resource to use the move.\nHealing and magic moves require magic points (MP) to use, physical moves require health points (HP) to use and neutral moves take from both your MP and HP.\nYou should be careful when using physical attacks as they drain your HP, which is what you need to stay alive in the battle.\nSome may decide to only use magic moves since they only use your magic points, but are weak in comparison to physical moves, which focus on higher damage.\n");
    System.out.println("Healing and magic moves cost 2 MP.\nPhysical and recharging moves cost 20 HP.\nNeutral moves cost 2 MP and 10 HP.\n");
    System.out.println("Every time you play the game, it chooses from a pool of 4 different enemies and randomizes which enemy you will be fighting during that round.\nThere are also specific enemies that absorb the damage of the moves of a certain type, so be careful to keep track of which moves are healing/recharging, physical, magical and neutral.\nNeutral attacks will never be absorbed as they are a combination of both a physical attack and a magic attack and healing moves will never be absorbed since they do not affect the enemy at all.\n");
    System.out.println("If you're not careful, your enemy will defeat you, so think your moves through and play carefully.\n");
    
    //Initializes runQuestion
    String runQuestion = "";

    Thread.sleep(4000);

    //Loop keeps running if the user does not input y or n
    do {
      //Updates runQuestion with user input
      System.out.print("\nDo you want to play? (Y/N): ");
      //Takes all of the spaces out of user's response, changes its case to lower case and only gets the first character of the string
      runQuestion = in.next().replaceAll(" ", "").toLowerCase().substring(0, 1);
    } while (!runQuestion.equalsIgnoreCase("Y") && !runQuestion.equalsIgnoreCase("N")); //End of do-while

    //If the user wants to play (responds with Y), returns true
    if (runQuestion.equalsIgnoreCase("Y")) {
      return true;
    }
    //If the user responds with anything else, returns false
    else if (runQuestion.equalsIgnoreCase("N")){
      return false;
    }
    //Default case
    else {
      return false;
    }
  } //introduction



//Randomizers
  public static int randomizer(String[] array) {
    //Gets a random int for the playerMove's array index

    //Gets a random integer between the arrays first and last index
    int index = (int)(Math.random() * array.length);

    return index;
  } //moveRandomizer

  public static int enemyRandomizer() {
    //Gets a random int between 0 and 4
    int index = (int) (Math.random() * 4);

    return index;
  } //enemyRandomizer



//Player turn
  public static int playerTurn(int moveIndex, int enemyIndex) {
    //During player's turn, determines which move the player is using, the type of move and then 

    //Initializes moveType, which will store the move's type
    String moveType = "";
    //If statements to determine moveType
    //If moveIndex is equal to -1, guard
    if (moveIndex == -1) {
      moveType = "Guard";
    }
    //If moveIndex is equal to 0, heal
    else if (moveIndex == 0) {
      moveType = "Heal";
    }
    //If moveIndex is equal to 9, recharge MP
    else if (moveIndex == 9) {
      moveType = "Recharge";
    }
    //If moveIndex is equal to 7 or 8, neutral attack
    else if (moveIndex == 7 || moveIndex == 8) {
      moveType = "Neutral";
    }
    //If moveIndex is odd, magic attack
    else if (moveIndex % 2 == 1) {
      moveType = "Magic";
    }
    //If moveIndex is even, physical attack
    else if (moveIndex % 2 == 0) {
      moveType = "Physical";
    }

    //Initializes playerDMG for determining how much damage the player will do base on the selected move
    int playerDMG = 0;
    //If statements to determine how much damage the selected move will do
    //Guarding should negate 10 HP from the enemy's attack
    if (moveType.equals("Guard")) {
      playerDMG = -1;
    }
    //Healing gives back 30 HP
    else if (moveType.equals("Heal")) {
      playerDMG = 30;
    }
    //Recharge gives back 4 MP
    else if (moveType.equals("Recharge")) {
      playerDMG = 4;
    }
    //Physical attacks are 35 DMG
    else if (moveType.equals("Physical")) {
      playerDMG = 35;
    }
    //Magic attacks are 20 DMG
    else if (moveType.equals("Magic")) {
      playerDMG = 20;
    }
    //Neutral attacks are 25 DMG
    else if (moveType.equals("Neutral")) {
      playerDMG = 25;
    }

    return playerDMG;
  }



//Enemy turn
  //For enemy moves (strings)
  public static String enemyMove(int enemyIndex, int moveIndex) {
    //Checks which enemy the player is fighting, picks a random move from that enemy's moveset

    //Initializes move
    String move = "";

    //Mr. Whammy-Bar
    if (enemyIndex == 0) {
      //Moves: "Wack", "Wham-Hammer", "Bar Destroyer", "Whams and Bars"
      move = whammyMoves[moveIndex];
      return move;
    }
    //Doc. Slayer
    else if (enemyIndex == 1) {
      //Moves: "Ibuprofen", "Antibiotics", "Blood-Transmission", "MRI"
      move = slayerMoves[moveIndex];
      return move;
    }
    //BINKY
    else if (enemyIndex == 2) {
      //Moves: "Shove", "Buster", "Thwompper", "Brink of Extinction"
      move = binkyMoves[moveIndex];
      return move;
    }
    //SoulStrike
    else if (enemyIndex == 3) {
      //Moves: "Soul Touch", "Death Call", "Grave Digger", "Soul Reaper"
      move = soulStrikeMoves[moveIndex];
      return move;
    }
    //Default
    else {
      move = "Error";
      return move;
    }
  } //enemyMove

  //For enemy damage (int)
  public static int enemyDMG(int enemyIndex) {
    //Gets the damage for the move the enemy just did

    //Initializes dmg
    int dmg = 0;

    /*0 is weakest attack, 3 is strongest
    Weakest starts at 10 damage, damage goes up 5 each index, highest is 25 damage*/
    if (enemyIndex == 0) {
      return dmg = 10;
    }
    else if (enemyIndex == 1) {
      return dmg = 15;
    }
    else if (enemyIndex == 2) {
      return dmg = 20;
    }
    else if (enemyIndex == 3) {
      return dmg = 25;
    }
    else {
      return dmg;
    }
  } //enemyDMG

}
