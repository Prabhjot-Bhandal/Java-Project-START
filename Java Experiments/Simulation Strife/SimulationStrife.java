import java.util.Scanner;
//Prabhjot Bhandal
//January 13th, 2022
/*Simulates a text and turn-based battle against an enemy, but everytime the program runs, 
 it's a different scenario*/

public class SimulationStrife {
    //Static variables that can be used across the enitre program
    //Input
    static Scanner in = new Scanner(System.in);

    //Player stats and moves
    static int playerHP = 100;
    static int playerMP = 10;
    /*We'll start with 8, minimum 6
    Even indices are Physical attacks
    Odd indices are Magic attacks
    Indices 7 and 8 are Neutral attacks
    Index 0 is heal
    Append each object into playerMoves[] array in a for loop*/
    static String playerMagicMoves[] = {"Fire", "Gravira", "Thunderaga", "Backspin"};
    static String playerPhysicalMoves[] = {"Upper Slash", "Aerial Sweep", "Groundbreaker", "Triple Rush"};
    static String playerNeutalMoves[] = {"Groundbreaker", "Triple Rush"};
    static String playerHeal = "Curaga";
    static String playerMoves[] = new String[9];

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
    boolean run = introduction();
    
    //Keeps running game 
    do {
      //Gets an integer between 0 and 3 for what the current enemy is
      int currentEnemyIndex = enemyRandomizer();
      String currentEnemy = enemyList[currentEnemyIndex];

      //Puts in and correctly orders cure, magic, physical and neutral moves in playerMoves[]
      playerMoves = definePlayerMoves(playerMoves, playerHeal, playerMagicMoves, playerPhysicalMoves, playerNeutalMoves);

      //Initializes stats so it refreshes everytime the player starts a new game
      playerHP = 100;
      playerMP = 10;
      enemyHP = 100;

      //Intializes playerChoiceInt, playerChoiceStr, move1, move2, move3
      int playerChoiceInt = 0;
      String playerMoveStr = "";
      int playerMoveIndex = -2;
      String moveChoice1 = "";
      int moveChoice1Index = 0;
      String moveChoice2 = "";
      int moveChoice2Index = 0;
      String moveChoice3 = "";
      int moveChoice3Index = 0;
      do {
        //Gets a random index in playerMoves for each move choice
        moveChoice1Index = randomizer(playerMoves);
        moveChoice2Index = randomizer(playerMoves);
        moveChoice3Index = randomizer(playerMoves);
       
        //If statements for ensuring no duplicate moves
        //If move choice 1 and 2 are the same
        if (moveChoice1Index == moveChoice2Index) {
          //Rerolls moveChoice2Index
          moveChoice2Index = randomizer(playerMoves);
        } 
        //If move choices 1 and 3 are the same
        else if (moveChoice1Index == moveChoice3Index) {
          //Rerolls moveChoice3Index
          moveChoice3Index = randomizer(playerMoves);
        }
        else if (moveChoice2Index == moveChoice3Index) {
          //Rerolls moveChoice3Index
          moveChoice3Index = randomizer(playerMoves);
        }

        //Assigns move choice indexes to corresponding move choice
        moveChoice1 = playerMoves[moveChoice1Index];
        moveChoice2 = playerMoves[moveChoice2Index];
        moveChoice3 = playerMoves[moveChoice3Index];

        do {
          //Randomizes the first index of the cycle
          //Shows player's current stats and the enemy's currents stats
          System.out.println("HP: " + playerHP + "/100\t\t\t\t" + currentEnemy + "'s HP: " + enemyHP + "/100\nMP: " + playerMP + "/100\n");
          Thread.sleep(1000);
          //Gets player's current turn and displays which moves the player has to pick from
          System.out.print("YOUR TURN\n1) " + moveChoice1 + "\n2) " + moveChoice2 + "\n3) " + moveChoice3 + "\n4) Guard" + "\n\nYOUR CHOICE: ");
          playerChoiceInt = in.nextInt();

          //Keeps looping if user does not enter either 1, 2, 3 or 4
        } while(playerChoiceInt != 1 && playerChoiceInt != 2 && playerChoiceInt != 3 && playerChoiceInt != 4);

        //Switch case for the player picking which move they want to use
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
        playerTurn(playerMoveIndex, playerMoveStr, currentEnemyIndex);

        //After player's turn runs, it's the enemy's turn
        //Gets enemyIndex for enemyMove and enemyDMG
        int enemyMoveIndex = (int) (Math.random() * 3);
        //With currentEnemy and enemyIndex, gets which move the enemy is doing
        String enemyMove = enemyMove(currentEnemyIndex, enemyMoveIndex);
        //With enemyIndex, gets how much damage the enemy has done
        int enemyDMG = enemyDMG(enemyMoveIndex);

        //Keeps looping until either the playerHP == 0 or enemyHP == 0
      } while (playerHP != 0 && enemyHP != 0);

      //If statements that show who won this round
      //If the enemy and player tie
      if (enemyHP == playerHP) {
        System.out.println("No way! HOW DID YOUR SIMULATION STRIFE WITH " + currentEnemy.toUpperCase() + " END IN A DRAW!?!");
      }
      //If the enemy loses
      else if (enemyHP == 0) {
        //Prints enemy's name in upper case
        System.out.println("\n\nCongratulations! You have defeated " + currentEnemy.toUpperCase() + " in this simulation strife!");

      } 
      //If the player loses
      else if (playerHP == 0) {
        //Prints that the player lost to their specific enemy, enemy name in upper case
        System.out.println("\n\nOh no! You were defeated by " + currentEnemy.toUpperCase() + " in this simulation strife! Better luck next time!");
      }


    } while (run == true); //Game loop
  } //main



  public static boolean introduction() throws InterruptedException{
    //Introduces the game, asks the user if they want to play, returns a boolean

    System.out.println("Welcome to Simulation Strife!\n\nThis program simulates a text and turn-based battle (or strife), similar to many battles found in RPG games today. In Simulation Strife, each battle is against a singular, randomized enemy and your job is to defeat your enemy in battle. However, each time it is the player’s turn, they have a randomized moveset.\nIn addition to that, specific enemy attacks make it more difficult for you to defeat the enemy.\nIf you’re not careful, your enemy will defeat you, so think your moves through and play carefully.");
    
    //Initializes runQuestion
    String runQuestion = "";

    Thread.sleep(4000);

    //Loop keeps running if the user does not input Y or N
    do {
      //Updates runQuestion with user input
      System.out.print("\nDo you want to play? (Y/N): ");
      runQuestion = in.next();
    } while (!runQuestion.equalsIgnoreCase("Y") && !runQuestion.equalsIgnoreCase("N")); //End of do-while

    //If the user wants to play (responds with Y), returns true
    if (runQuestion.equalsIgnoreCase("Y")) {
      return true;
    }
    //If the user responds with anything else, returns false
    else {
      return false;
    }
  } //introduction



  public static String[] definePlayerMoves(String[] playerMoves, String playerHeal, String[] playerMagicMoves, String[] playerPhysicalMoves, String[] playerNeutalMoves) {
    //Assigns and correctly orders the different types of moves into playerMoves[]

    for (int index = 0; index < playerMoves.length; index++) {
      //Initializes additional counters to make adding elements into playerMoves[] from other arrays easier
      int magicIndex = 0;
      int physicalIndex = 0;
      int neutralIndex = 0;

      //If 0, sets index 0 of playerMoves to heal
      if (index == 0) {
        playerMoves[index] = playerHeal;
      }
      //If the index is 7 or 8, sets the current index of player moves to corresponding index in playerNeutralMoves using neutralIndex
      if (index == 7 || index == 8) {
        playerMoves[index] = playerNeutalMoves[neutralIndex];
        //Adds 1 to neutralIndex
        neutralIndex++;
      }
      //If odd, sets current index of playerMoves to corresponding index in playerMagicMoves using magicIndex
      else if (index % 2 == 1) {
        playerMoves[index] = playerMagicMoves[magicIndex];
        //Adds 1 to magicIndex
        magicIndex++;
      }
      //If even, sets current index of playerMoves to corresponding index in playerPhysicalMoves using physicalIndex
      else if (index % 2 == 0) {
        playerMoves[index] = playerPhysicalMoves[physicalIndex];
        //Adds 1 to physicalIndex
        physicalIndex++;
      }
    } 

    return playerMoves;
  } //definePlayerMoves


//Randomizers
  public static int randomizer(String[] array) {
    //Gets a random int for the playerMove's array index

    //Gets a random integer between the arrays first and last index
    int index = (int)(Math.random() * (array.length - 1));

    return index;
  } //moveRandomizer

  public static int enemyRandomizer() {
    //Gets a random int between 0 and 3
    int index = (int) (Math.random() * 3);

    return index;
  } //enemyRandomizer



//Player turn
//Work in progress
  public static int playerTurn(int moveIndex, String moveStr, int enemyIndex) {
    //If statements to determine moveType

    //If moveIndex == 0, heal
    //If moveIndex == 7 || moveIndex == 8, neutral attack
    //If moveIndex % 2 == 1, magic attack
    //If moveIndex % 2 == 0, physical attack
    int playerDMG = 0;
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
    else if (enemyIndex == 1) {
      return dmg = 20;
    }
    else if (enemyIndex == 1) {
      return dmg = 25;
    }
    else {
      return dmg;
    }
  } //enemyDMG
}
