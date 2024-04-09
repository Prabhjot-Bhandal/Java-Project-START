//Prabhjot Bhandal
//April 9th, 2024
//My GUI Project based on a game launcher for computers

package SimpleGameLauncher;
//Imports swing, awt and io for the GUI components and filing capabilities
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class GUIProject {
    //Crates the mainFrame that houses everything, static so all methods can access it
    //String taken in as an argument to name the the window "Simple Game Launcher"
    static JFrame mainFrame = new JFrame("Simple Game Launcher");
    //Sets the game icon's width to 150 pixels, will be used to find the height using aspect ratios
    static int gameIconWidth = 150;
    //Will dictate the height of the gameLibrary panel
    static int gameLibraryHeightSum = 0;
    public static void main(String[] args) throws IOException {

        //Makes it so that the program is exited when the "x" button is hit
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Sets the size of the frame
        mainFrame.setSize(1280, 720);

        //Sets the layout of the main frame
        mainFrame.getContentPane().setLayout(new BorderLayout()); 

        //Creates the menuBar in its entirety, appends to the mainFrame
        menuBar();

        gameLibrarySideView();

        mainGameInfoPanel();

        //Makes the mainFrame visible
        mainFrame.setVisible(true);
    } //main

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
    }

    public static void gameLibrarySideView() throws IOException {
        /*Action: Makes the right most panel that houses all of the user's games
          Input: None
          Output: Creates the library scrolling panel*/

        //Creates a new panel that will house the games on the side view
        JPanel gameLibrary = new JPanel();
        //Sets the layout manager of the gameLibrary as a box layout, organizes the buttons vertically
        gameLibrary.setLayout(new BoxLayout(gameLibrary, BoxLayout.Y_AXIS));

        //Instantiates the number of games the user has in their library
        int numOfGames = 6;
        //Creates arrays for the game banners and buttons that have the same amount of games the user owns
        ImageIcon gameBanners[] = new ImageIcon[numOfGames];
        JButton gameButtons[] = new JButton[numOfGames];

        //Goes through all the games and makes buttons for each
        for (int currentGameBanner = 0; currentGameBanner < gameButtons.length; currentGameBanner++) {
            /*Sets the current element to be a scaled version of the game banners stored in the file.
              The game banners stored in the file are numbered to make it easier to access them in a loop.
              The getScaledIcon method is accessed using the correct measurements so that the icons are not distorted.*/
            gameBanners[currentGameBanner] = getScaledIcon("Java Experiments\\Grade 12 CS\\SimpleGameLauncher\\gameBanner" + currentGameBanner + ".png", gameIconWidth);
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

        //Set the vertical scrollbar policy for the gameLibrary panel
        JScrollPane scrollGameLibrary = new JScrollPane(gameLibrary);
        scrollGameLibrary.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //Adds the scroll pane and game library to the main frame, don't need to add game library directly if we are already adding the scroll pane
        //Add scroll pane to the left
        mainFrame.getContentPane().add(scrollGameLibrary, BorderLayout.WEST);
        mainFrame.pack();

    } //gameScrollLibrary


    @SuppressWarnings("resource")
    public static void mainGameInfoPanel() throws IOException {
      /*Action: Creates the panel that houses the game's description, who owns the game and play and 
        settings buttons
        Input: None
        Output: The panel will all of its components*/
      
      //Creates the main
      JPanel mainGameInfoPanel = new JPanel();

      //Sets the layout manager of the gameLibrary as a box layout, organizes the buttons vertically
      mainGameInfoPanel.setLayout(new BoxLayout(mainGameInfoPanel, BoxLayout.Y_AXIS));

      //Sets the current game to the first one in the array
      int currentGame = 0;

      //Gets and stores the image in a JLabel so it can be accessed later
      JLabel currentGameDescImageLabel = new JLabel(getScaledIcon("Java Experiments\\Grade 12 CS\\SimpleGameLauncher\\gameDescImg" + currentGame + ".png", 500));
      //Adds the image label to the panel
      mainGameInfoPanel.add(currentGameDescImageLabel);

      //Gets the name for the current game
      String currentGameNameString = new Scanner(new File("Java Experiments\\Grade 12 CS\\SimpleGameLauncher\\gameName" + currentGame + ".txt")).useDelimiter("\\A").next();

      //Creates a label for the game's name
      JLabel currentGameName = new JLabel(currentGameNameString);
      //Sets the font of the label, if it's bolded or italisized and the font size
      currentGameName.setFont(new Font("Arial", Font.BOLD, 40));
      //Adds the image label to the panel
      mainGameInfoPanel.add(currentGameName);

      //Gets the desription for the current game
      String currentGameDescString = new Scanner(new File("Java Experiments\\Grade 12 CS\\SimpleGameLauncher\\gameDesc" + currentGame + ".txt")).useDelimiter("\\A").next();

      //Creates the text area that will house the description of the game
      JTextArea currentGameDesc = new JTextArea(50, 8);

      //Scroll bard for the game's description
      JScrollPane scrollCurrentGameDesc = new JScrollPane(currentGameDesc);

      //Puts the text from the txt file in the text area for the game's description
      currentGameDesc.setText(currentGameDescString);

      //Ensures that the text does not go outside of the text area horizontally
      currentGameDesc.setLineWrap(true);

      //Adds the scroll bar for the description to the panel
      mainGameInfoPanel.add(scrollCurrentGameDesc);
      scrollCurrentGameDesc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


      //container.add(Box.createRigidArea(new Dimension(5, 0))); <- To space out the components

      //Makes the panel visible
      mainGameInfoPanel.setVisible(true);

      //Sets the panel to the center in the frame's layout
      mainFrame.getContentPane().add(mainGameInfoPanel, BorderLayout.CENTER);
      mainFrame.pack();
    } //mainGamePanel
}
