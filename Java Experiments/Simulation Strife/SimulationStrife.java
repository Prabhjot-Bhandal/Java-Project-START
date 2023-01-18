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
    Index 0 is heal*/
    static String playerMoves[] = {"Curaga", "Upper Slash", "Fire", "Aerial Sweep", "Gravira", "Groundbreaker", "Thunderaga", "Triple Rush", "Backspin"};

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
      //Gets an interger between 0 and 3 for what the current enemy is
      int currentEnemyIndex = enemyRandomizer();
      String currentEnemy = enemyList[currentEnemyIndex];

      //Initializes stats so it refreshes everytime the player starts a new game
      playerHP = 100;
      playerMP = 10;
      enemyHP = 100;

      //Intializes playerTurn, moveDuplicate
      int playerChoice = 0;
      boolean moveDuplicate = true;
      do {
        do {
          //Randomizes the first index of the cycle
          //Figure out a way to take an element out of an array
          int firstMove = randomizer(playerMoves);

          //Shows player's current stats and the enemy's currents stats
          System.out.println("HP: " + playerHP + "/100\t\t\t\t" + currentEnemy + "'s HP: " + enemyHP + "/100\nMP: " + playerMP + "/100\n");
          Thread.sleep(1000);
          //Gets player's current turn
          System.out.print("YOUR TURN\n1) " + playerMoves[firstMove] + "\n2) " + playerMoves[firstMove + 1] + "\n3) " + playerMoves[firstMove + 2] + "\n4) Guard" + "\n\nYOUR CHOICE: ");
          playerChoice = in.nextInt();

          //Keeps looping if user does not enter either 1, 2, 3 or 4
        } while(playerChoice != 1 && playerChoice != 2 && playerChoice != 3 && playerChoice != 4);

        //Once the player enters a valid integer, player's turn will run
        playerTurn(playerChoice, currentEnemyIndex);

        //After player's turn runs, it's the enemy's turn
        //Gets enemyIndex for enemyMove and enemyDMG
        int enemyIndex = (int) (Math.random() * 3);
        //With currentEnemy and enemyIndex, gets which move the enemy is doing
        String enemyMove = enemyMove(currentEnemyIndex, enemyIndex);
        //With enemyIndex, gets how much damage the enemy has done
        int enemyDMG = enemyDMG(enemyIndex);

        //Keeps looping until either the playerHP == 0 or enemyHP == 0
      } while (playerHP != 0 && enemyHP != 0);

    } while (run == true); //Game loop
  } //main



  public static boolean introduction() throws InterruptedException{
    //Introduces the game, asks the user if they want to play, returns a boolean

    System.out.println("Welcome to Simulation Strife!\n\nThis program simulates a text and turn-based battle (or strife), similar to many battles found in RPG games today. In Simulation Strife, each battle is against a singular, randomized enemy and your job is to defeat your enemy in battle. However, each move is a one-time use and your list of moves shuffles each time you play. This means that if you use one move, you cannot use that move again and the next move in the cycle replaces the move you just used. In addition to that, specific enemy attacks make it more difficult for you to defeat the enemy. If you’re not careful, your enemy will defeat you, so think your moves through and play carefully.");
    
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



//Randomizers
  public static int randomizer(String[] array) {
    //Gets a random int for the playerMove's array index

    //Gets a random integer between 0 and one less the array's length
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
  public static int playerTurn(int choice, int enemyIndex) {
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
