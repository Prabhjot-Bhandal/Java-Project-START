//Prabhjot Bhandal
//June 15, 2024
//Final FEU Project for Grade 12 CS

package GameLauncherREBORN;
//Imports swing, awt and io for the GUI components and filing capabilities
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class GameLauncherREBORN {
    //Crates the mainFrame that houses everything, static so all methods can access it
    //String taken in as an argument to name the the window "Game Launcher REBORN"
    static JFrame mainFrame = new JFrame("Game Launcher REBORN");
    //Sets the game icon's width to 150 pixels, will be used to find the height using aspect ratios
    static int gameIconWidth = 150;
    //Will dictate the height of the gameLibrary panel
    static int gameLibraryHeightSum = 0;
    //Instantiates the number of games the user has in their library
    static int numOfGames = 7;
    /*Creates a 2D array that contains all the available assets.
      Each row will represent each game, their assets will be in that row (ex. game 0 is represented by the 0th
      row). Each column will represent the type of asset (ex. coloumn zero houses all game banners).*/
    static String gameAssetsFiles[][];
    //Cards for game info and stats
    static JPanel gameInfoCards = new JPanel(new CardLayout());
    static JPanel gameButtonsAndStatsCards = new JPanel(new CardLayout());

    public static void main(String[] args) throws IOException, InterruptedException {

      //Fills the gameAssetsFiles 2D array to be used later to access game assets
      fillGameAssetsFilesTwoDArray();

      //Sets the size of the frame
      mainFrame.setSize(1280, 720);

      //Sets the layout of the main frame
      mainFrame.getContentPane().setLayout(new BorderLayout()); 

      //Changes the launcher's program icon
      changeAppIcon();

      //Creates the menuBar in its entirety, appends to the mainFrame
      menuBar();

      //Creates the gameLibrary side view and adds it to the left-side of the main frame
      gameLibrarySideView();

      /*Create and add game info panels for the different games in the user's library.
        Stores each panel for each game in an array to make it easy to swap.*/
      JPanel[] mainGameInfoArray = fillMainGameInfoArray(numOfGames);

      /*Create and add game info panels for the different games in the user's library.
        Stores each panel for each game in an array to make it easy to swap.*/
      JPanel[] gameButtonsAndStatsArray = fillgameButtonsAndStatsArray(numOfGames);

      //Add the cards (aka each game) to the main frame
      mainFrame.getContentPane().add(gameInfoCards, BorderLayout.CENTER);
      mainFrame.getContentPane().add(gameButtonsAndStatsCards, BorderLayout.EAST);

      //Show the first game info and buttons by default using card layout
      CardLayout gameInfoLayout = (CardLayout) gameInfoCards.getLayout();
      gameInfoLayout.show(gameInfoCards, "0");
      CardLayout buttonsAndStatsLayout = (CardLayout) gameButtonsAndStatsCards.getLayout();
      buttonsAndStatsLayout.show(gameButtonsAndStatsCards, "0");

      //Makes it so that the program is exited when the "x" button is hit
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Makes the mainFrame visible
      mainFrame.setVisible(true);

    } //main

    public static JPanel[] fillMainGameInfoArray(int numOfGames) throws IOException {
      /*Action: Fills an empty array of type JPanel with game info JPanels for each game.
        Input: numOfGames
        Output: A filled array of JPanels corresponding to the game info of different games.*/

      //Instatiates the array so it can be filled within the method
      JPanel[] mainGameInfoArray = new JPanel[numOfGames];

      for (int index = 0; index < numOfGames; index++) {
        //Builds the game info panel for the current game
        mainGameInfoArray[index] = mainGameInfo(index);
        //Puts it into the card layout
        gameInfoCards.add(mainGameInfoArray[index], String.valueOf(index));
      }
      
      return mainGameInfoArray;

    } //fillMainGameInfoArray

    public static JPanel[] fillgameButtonsAndStatsArray(int numOfGames) throws IOException, InterruptedException {
      /*Action: Fills an empty array of type JPanel with game buttons and stats JPanels for each game.
        Input: numOfGames
        Output: A filled array of JPanels corresponding to the game buttons and stats of different games.*/

      //Instatiates the array so it can be filled within the method
      JPanel[] gameButtonsAndStatsArray = new JPanel[numOfGames];
      
      for (int index = 0; index < numOfGames; index++) {
        //Builds the game buttons and stats panel for the current game
        gameButtonsAndStatsArray[index] = gameButtonsAndStats(index);
        //Puts it into the card layout
        gameButtonsAndStatsCards.add(gameButtonsAndStatsArray[index], String.valueOf(index));
      }

      return gameButtonsAndStatsArray;

    } //fillMainGameInfoArray

    public static void fillGameAssetsFilesTwoDArray() {
      /*Action: Fills the gameAssets two dimensional array with all of the required file paths.
        Input: An empty string type two dimensional array.
        Output: A filled string type two dimensional array containing all of the required assets
        for the launcher. No return is given for the method because the gameAssetsFiles array is static*/

      /*Columns Legend:
        Column 0 = Game Banners
        Column 1 = Names
        Column 2 = Descriptions
        Column 3 = Description Images
        Column 4 = gameStats*/
      
      //Stores the possible asset types for the different assets in an array, indicies correspond to which column is for what asset type
      String gameAssetsTypes[] = {"gameBanner", "gameName", "gameDesc", "gameDescImg", "gameStats"};

      //Stores the possible file paths for different assets in an array, indicies correspond to which column is for what asset type
      String generalGameAssetsFilePaths[] = {
          "Java Experiments\\Grade 12 CS\\GameLauncherREBORN\\assets\\gameBanners\\",
          "Java Experiments\\Grade 12 CS\\GameLauncherREBORN\\assets\\gameNames\\",
          "Java Experiments\\Grade 12 CS\\GameLauncherREBORN\\assets\\gameDescriptions\\",
          "Java Experiments\\Grade 12 CS\\GameLauncherREBORN\\assets\\gameDescImages\\",
          "Java Experiments\\Grade 12 CS\\GameLauncherREBORN\\assets\\gameStats\\"
      };

      //Houses all the URLs needed for each game
      String[] URLs = {
          "https://store.steampowered.com/app/945360/Among_Us/",
          "https://www.minecraft.net/en-us",
          "https://store.steampowered.com/app/1687950/Persona_5_Royal/",
          "https://store.steampowered.com/app/1817070/Marvels_SpiderMan_Remastered/",
          "https://store.steampowered.com/app/413150/Stardew_Valley/",
          "https://www.nintendo.com/en-ca/store/products/the-legend-of-zelda-tears-of-the-kingdom-switch/",
          "https://sm64-embed.glitch.me/start.html"
      };

      //As each row is a different game, sets the number of rows to the number of games in the library
      gameAssetsFiles = new String[numOfGames][generalGameAssetsFilePaths.length + 1];

      //Fills the gameAssetsFiles 2D array, not the last column because that will have URLs
      for (int currentRow = 0; currentRow < gameAssetsFiles.length; currentRow++) {
        /*Starts at the first game and banner, (0,0)*/
        for (int currentColumn = 0; currentColumn < generalGameAssetsFilePaths.length; currentColumn++) {
          //If the asset type is an image, ensures the correct asset type, file path and file type is selected
            if (currentColumn == 0 || currentColumn == 3) {
              //Adding currentRow is just for the actual game the asset is for
              gameAssetsFiles[currentRow][currentColumn] = generalGameAssetsFilePaths[currentColumn] + gameAssetsTypes[currentColumn] + currentRow + ".png";
            }
            //All other assets are text, so they would have .txt file type
            else {
              gameAssetsFiles[currentRow][currentColumn] = generalGameAssetsFilePaths[currentColumn] + gameAssetsTypes[currentColumn] + currentRow + ".txt";
            }
            //Prints out the file path, type and the actual asset name for debugging
            System.out.println("Asset path for game " + currentRow + ", type " + gameAssetsTypes[currentColumn] + ": " + gameAssetsFiles[currentRow][currentColumn]);

          } //column for loop

      } //row for loop

      //Puts all the URL's in the last column of the 2D array since they can't be generated logically
      for (int currentRow = 0; currentRow < gameAssetsFiles.length; currentRow++) {
        //Uses the URLs array to do this
        gameAssetsFiles[currentRow][5] = URLs[currentRow];
        //Prints out the URL for the current game being loaded currently
        System.out.println("URL for game " + currentRow + ": " + gameAssetsFiles[currentRow][5]);

      } //for loop for URLs in col 6

  } //fillGameAssetsFilesTwoDArray

    public static ImageIcon getScaledIcon(String imagePath, int width) throws IOException {
      /*Action: Gets images from the computer and scales them according to the dimensions of their button
        Input: The image's file path, and the width of the button
        Output: A new, properly scaled, ImageIcon*/
  
      //Takes in the original image from the specified file path
      ImageIcon originalIcon = new ImageIcon(imagePath);
      //Creates a seperate image var to get the original's dimensions
      Image originalImage = originalIcon.getImage();
      
      //Get the aspect ratio of the original image, observer isn't mainFrame since it isn't visible yet, making the aspectRatio 0
      double aspectRatio = (double) originalImage.getWidth(null) / originalImage.getHeight(null);
      
      //Calculate the height using the given width and aspect ratio
      int height = (int) (width / aspectRatio);
      //Adds this icons height to the height sum
      gameLibraryHeightSum += height;
      
      //Scale the original images to the desired dimensions while upholding its aspect ratio
      Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
      
      //Creates an ImageIcon using the new scaled image and returns it
      return new ImageIcon(scaledImage);

  } //getScaledIcon

  public static void showNewMainGamePage(int newCurrentGame) {
    /*Action: Showcases the current game's information and statistics, will be used for an action listener
      for the different games in the side view. Uses the cardLayout to do this.
      Input: The new current game.
      Output: Shows the new current game's information page.*/

    //Show the selected game info and buttons
    /*Gets the layout manager and casts it with CardLayout to make it a card layout, stores it
      so we can use the card layour methods.*/
    CardLayout gameInfoLayout = (CardLayout) gameInfoCards.getLayout();

    /*Calls the show method, which shows the new desired card. We do stringOf on the newCurrentGame because
     the method only takes in strings, while this program classifies each game with an integer.*/
    gameInfoLayout.show(gameInfoCards, String.valueOf(newCurrentGame));

    CardLayout buttonsAndStatsLayout = (CardLayout) gameButtonsAndStatsCards.getLayout();
    buttonsAndStatsLayout.show(gameButtonsAndStatsCards, String.valueOf(newCurrentGame));

  } //showNewMainGamePage

  public static void changeAppIcon() {
    /*Action: Changes the icon of the application.
      Input: None
      Output: The application launches with the new app icon.*/

    //Loads the icon image with the following file path
    ImageIcon icon = new ImageIcon("Java Experiments\\Grade 12 CS\\GameLauncherREBORN\\assets\\appIcon.png");
    Image appIconImage = icon.getImage();

    //Sets the icon image for the JFrame
    mainFrame.setIconImage(appIconImage);

  } //changeAppIcon

    public static void menuBar() {
        /*Action: Makes the menuBar at the top of the screen
          Input: None
          Output: Creates the menu bar at the top*/

        //Creates the menuBar
        JMenuBar mainMenuBar = new JMenuBar();

        //Creates a menu that will make the searchBar pop up
        JMenu searchBarMenu = new JMenu("Search");
        //Creates the search bar
        JTextField searchBar = new JTextField(20); 
        //Adds the search bar to the search bar menu
        searchBarMenu.add(searchBar);
        //Adds the search bar menu to the menu bar
        mainMenuBar.add(searchBarMenu);

        //Creates a library button, sets the name as "Library"
        JButton libraryButton = new JButton("Library");
        //Adds the library button to the menu bar
        mainMenuBar.add(libraryButton);

        //Creates a store button, sets the name as "Store"
        JButton storeButton = new JButton("Store");
        //Adds the store button to the menu bar
        mainMenuBar.add(storeButton);
        //If the play button is clicked
        storeButton.addActionListener(e -> {
          webLauncher("https://store.steampowered.com/");
        });

        //Creates the settings menu
        JMenu settingsMenu = new JMenu("Settings");
        //Creates the system menu item, appends to the settings menu
        JMenuItem systemSettings = new JMenuItem("System");
        //Adds the system menu item to the settings menu
        settingsMenu.add(systemSettings);
        JMenuItem fileSettings = new JMenuItem("File");
        settingsMenu.add(fileSettings);
        JMenuItem displaySettings = new JMenuItem("Display");
        settingsMenu.add(displaySettings);
        JMenuItem audioSettings = new JMenuItem("Audio");
        settingsMenu.add(audioSettings);
        JMenuItem bluetoothSettings = new JMenuItem("Bluetooth");
        settingsMenu.add(bluetoothSettings);
        JMenuItem miscSettings = new JMenuItem("Misc");
        settingsMenu.add(miscSettings);
        //Adds the settings menu to the menuBar
        mainMenuBar.add(settingsMenu);

        //Creates the friends menu
        JMenu friendsMenu = new JMenu("Friends");
        //Creates the friends online menu item, appends to the friends menu
        JMenuItem friendsOnlineItem = new JMenuItem("Friends Online");
        //Adds the friends online menu item to the friends menu
        friendsMenu.add(friendsOnlineItem);
        JMenuItem friendsListItem = new JMenuItem("Friends List");
        friendsMenu.add(friendsListItem);
        JMenuItem friendRequestsItem = new JMenuItem("Friend Requests");
        friendsMenu.add(friendRequestsItem);
        JMenuItem addFriendsItem = new JMenuItem("Add Friends");
        friendsMenu.add(addFriendsItem);
        //Adds the friends menu to the menuBar
        mainMenuBar.add(friendsMenu);

        //Adds the menu bar to the mainFrame
        mainFrame.setJMenuBar(mainMenuBar);

    } //menuBar

    public static void gameLibrarySideView() throws IOException {
        /*Action: Makes the right most panel that houses all of the user's games.
          There are setup as buttons that allow the user to view the information of the
          the different games they own.
          Input: None
          Output: Creates the library scrolling panel*/

        //Creates a new panel that will house the games on the side view
        JPanel gameLibrary = new JPanel();
        //Sets the layout manager of the gameLibrary as a box layout, organizes the subpanels vertically
        gameLibrary.setLayout(new BoxLayout(gameLibrary, BoxLayout.Y_AXIS));

        //Creates arrays for the game banners and buttons that have the same amount of games the user owns
        ImageIcon gameBanners[] = new ImageIcon[numOfGames];
        JButton gameButtons[] = new JButton[numOfGames];

        //Goes through all the games and makes buttons for each
        for (int currentGameBanner = 0; currentGameBanner < gameButtons.length; currentGameBanner++) {
            /*Sets the current element to be a scaled version of the game banners stored in the file.
              The game banners stored in the file are numbered to make it easier to access them in a loop.
              The getScaledIcon method is accessed using the correct measurements so that the icons are not distorted.
              Column 0 houses all the game banners*/
            gameBanners[currentGameBanner] = getScaledIcon(gameAssetsFiles[currentGameBanner][0], gameIconWidth);
        }

        //Sets the gameLibrary panel's size, makes the height equal to how tall each game is by how many games there are
        //Offset of 100 pixels added to ensure the games display properly
        gameLibrary.setPreferredSize(new Dimension(gameIconWidth, (gameLibraryHeightSum + 100)));

        //Goes through all the games and makes buttons for each
        for (int currentGameButton = 0; currentGameButton < gameButtons.length; currentGameButton++) {
            /*Stores all the gameButtons in an array and appends all the banners in the gameBanners array
              to their corresponding buttons in the gameButtons array.*/
            gameButtons[currentGameButton] = new JButton(gameBanners[currentGameButton]);
            //Adds the current game button to the panel
            gameLibrary.add(gameButtons[currentGameButton]);
        }


        //Action listeners for each button in the library
        //Among Us
        gameButtons[0].addActionListener(e -> {
          showNewMainGamePage(0);
        }); //Among Us action listener

        //Minecraft
        gameButtons[1].addActionListener(e -> {
          showNewMainGamePage(1);
          
        }); //Minecraft action listener
        
        //Persona 5
        gameButtons[2].addActionListener(e -> {
            showNewMainGamePage(2);
        }); //Persona 5 action listener

        //Spider-Man
        gameButtons[3].addActionListener(e -> {
            showNewMainGamePage(3);
        }); //Spider-Man action listener

        //Stardew Valley
        gameButtons[4].addActionListener(e -> {
            showNewMainGamePage(4);
        }); //Stardew Valley action listener

        //Zelda
        gameButtons[5].addActionListener(e -> {
            showNewMainGamePage(5);
        }); //Zelda action listener

        //Mario 64
        gameButtons[6].addActionListener(e -> {
          showNewMainGamePage(6);
        }); //Mario 64 action listener


        //Set the vertical scrollbar policy for the gameLibrary panel
        JScrollPane scrollGameLibrary = new JScrollPane(gameLibrary);
        scrollGameLibrary.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //Adds the scroll pane and game library to the main frame, don't need to add game library directly if we are already adding the scroll pane
        //Add scroll pane to the left
        mainFrame.getContentPane().add(scrollGameLibrary, BorderLayout.WEST);
        mainFrame.pack();

    } //gameScrollLibrary


    @SuppressWarnings("resource") //Supresses warnings for the way the program accesses files for labels and text area
    public static JPanel mainGameInfo(int newCurrentGame) throws IOException {
      /*Action: Creates the panel that houses the game's description, who owns the game and play and 
        settings buttons
        Input: None
        Output: The panel will all of its components*/
      
      //Creates the main
      JPanel mainGameInfoPanel = new JPanel();

      //Sets the layout manager of the info panel as a box layout, organizes the buttons vertically
      mainGameInfoPanel.setLayout(new BoxLayout(mainGameInfoPanel, BoxLayout.Y_AXIS));

      //Gets and stores the image in a JLabel so it can be accessed later
      JLabel currentGameDescImageLabel = new JLabel(getScaledIcon(gameAssetsFiles[newCurrentGame][3], 1080));
      //Adds the image label to the panel
      mainGameInfoPanel.add(currentGameDescImageLabel);

      //Gets the name for the current game
      String currentGameNameString = new Scanner(new File(gameAssetsFiles[newCurrentGame][1])).useDelimiter("\\A").next();

      //Creates a label for the game's name, SwingConstraints forces the position of the title to be in the center
      JLabel currentGameName = new JLabel(currentGameNameString);
      //Sets the font of the label, if it's bolded or italisized and the font size
      currentGameName.setFont(new Font("Arial", Font.BOLD, 40));
      //Adds the image label to the panel
      mainGameInfoPanel.add(currentGameName);

      //Gets the desription for the current game
      String currentGameDescString = new Scanner(new File(gameAssetsFiles[newCurrentGame][2])).useDelimiter("\\A").next();
      //Creates the text area that will house the description of the game
      JTextArea currentGameDesc = new JTextArea(50, 8);
      //Makes the text area uneditable
      currentGameDesc.setEditable(false);
      //Scroll bard for the game's description
      JScrollPane scrollCurrentGameDesc = new JScrollPane(currentGameDesc);

      //Puts the text from the txt file in the text area for the game's description
      currentGameDesc.setText(currentGameDescString);
      //Sets the font and size of the game's description
      currentGameDesc.setFont(new Font("Arial", Font.PLAIN, 13));
      //Ensures that the text does not go outside of the text area horizontally
      currentGameDesc.setLineWrap(true);

      //Adds the scroll bar for the description to the panel
      mainGameInfoPanel.add(scrollCurrentGameDesc);
      scrollCurrentGameDesc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

      return mainGameInfoPanel;
    } //mainGameInfoPanel


    @SuppressWarnings("resource") //Supresses warnings for the way the program accesses files for labels and text area
    public static JPanel gameButtonsAndStats(int currentGame) throws InterruptedException, IOException {
      /*Action: Creates the right-side panel that houses the play button, the settings button,
        and a list of friends who own the game.
        Input: None
        Output: The creation of a play and settings button as well as a list of friends who own the game.*/

      //Creates the main panel that will house the subpanels for the buttons and list
      JPanel gameButtonsStatsFriendsPanel = new JPanel();

      //Sets the layout manager of the right-side panel as a box layout, organizes the subpanels vertically
      gameButtonsStatsFriendsPanel.setLayout(new BoxLayout(gameButtonsStatsFriendsPanel, BoxLayout.Y_AXIS));

      //Creates a subpanel that will be used to house the buttons
      JPanel playAndSettingsButtons = new JPanel();
      
      //Creates the play button with a properly scaled icon
      JButton playButton = new JButton(getScaledIcon("Java Experiments\\Grade 12 CS\\SimpleGameLauncher\\play.png", 100));
      //If the play button is clicked
      playButton.addActionListener(e -> {
        webLauncher(gameAssetsFiles[currentGame][5]);
      });

      //Adds the play button to the playAndSettingsButtons subpanel
      playAndSettingsButtons.add(playButton);
      //Creates an empty border so that the play and settings buttons are spaced out
      playAndSettingsButtons.add(Box.createRigidArea(new Dimension(5, 0)));
      //Creates the settings button with a properly scaled icon
      JButton settingsButton = new JButton(getScaledIcon("Java Experiments\\Grade 12 CS\\SimpleGameLauncher\\settings.png", 100));
      //Adds the settings button to the playAndSettingsButtons subpanel
      playAndSettingsButtons.add(settingsButton);
      //Add the subpanel containing the play and settings buttons to the main panel
      gameButtonsStatsFriendsPanel.add(playAndSettingsButtons);

      //Gets the user's statistics for the current game
      String currentGameStatsString = new Scanner(new File(gameAssetsFiles[currentGame][4])).useDelimiter("\\A").next();
      //Creates the text area that will house the user's statistics of the game
      JTextArea currentGameStats = new JTextArea(1, 8);
      //Puts the text from the txt file in the text area for the user's statistics in the game
      currentGameStats.setText(currentGameStatsString);
      //Makes the text area uneditable
      currentGameStats.setEditable(false);
      //Sets the font and size of the game's description
      currentGameStats.setFont(new Font("Arial", Font.PLAIN, 20));
      //Ensures that the text does not go outside of the text area horizontally
      currentGameStats.setLineWrap(true);
      //Adds the text area with the user's statistics for the current game to the main panel
      gameButtonsStatsFriendsPanel.add(currentGameStats);

      //Creates an array containing all the names of the friends who own the current game
      String friendsOwningCurrentGameArray[] = {"Friend 1", "Friend 2", "Friend 3", "Friend 4", "Friend 5"};
      //Creates a JList housing the names of which friends own the current game
      JList friendsOwningCurrentGameList = new JList<>(friendsOwningCurrentGameArray);
      //Sets the font and font size of the list
      friendsOwningCurrentGameList.setFont(new Font("Arial", Font.PLAIN, 20));
      //Adds the list to the main panel
      gameButtonsStatsFriendsPanel.add(friendsOwningCurrentGameList);

      //Makes the subpanel that has the play and settings buttons visible
      playAndSettingsButtons.setVisible(true);
      //Makes the main panel visible
      gameButtonsStatsFriendsPanel.setVisible(true);

      return gameButtonsStatsFriendsPanel;
    } //gameButtonsStatsFriendsPanel

    public static void webLauncher(String URL) {
      /*Purpose: For action listeners that direct user's to a certain URL.
        Input: A string with the desired URL
        Output: Sends the user to the URL*/

      //If the URL is null, aka not initialized or has no value, program will say so
      if (URL == null) {
        //Prints as an error
        System.err.println("Attempted to launch a null URL");
        return;
      }

      try {
        //Prints out the current URL being launched
        System.out.println("Launching URL: " + URL);
        //Opens the browser and puts in the URL for the current game
        Desktop.getDesktop().browse(new URI(URL));

      } 
      catch (IOException | URISyntaxException ex) {
        ex.printStackTrace();

      }

  } //webLauncher

   
} //GameLauncherREBORN