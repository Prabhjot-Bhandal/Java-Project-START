package SimpleGameLauncher;
import javax.swing.*;
import java.awt.*;

public class SimpleGameLauncher {
    //Crates the mainFrame that houses everything, static so all methods can access it
    //String taken in as an argument to name the the window "Simple Game Launcher"
    static JFrame mainFrame = new JFrame("Simple Game Launcher");
    public static void main(String[] args) {

        //Makes it so that the program is exited when the "x" button is hit
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Sets the size of the frame
        mainFrame.setSize(1280, 720);

        //Creates the menuBar in its entirety, appends to the mainFrame
        menuBar();

        gameLibrarySideView();
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

    public static void gameLibrarySideView() {
        /*Action: Makes the right most panel that houses all of the user's games
          Input: None
          Output: Creates the library scrolling panel*/

        //Creates a new panel that will house the games on the side view
        JPanel gameLibrary = new JPanel();
        //Sets the gameLibrary panel's size
        gameLibrary.setSize(500, 500);

        //Sets the layout manager of the gameLibrary as a flow layout
        gameLibrary.setLayout(new BorderLayout());  

        //Creates image icons that will be used as the look of the game buttons
        ImageIcon gamePic1 = new ImageIcon( "Java Experiments\\Grade 12 CS\\ImageIconDemo\\amogus.jpg"); 
		ImageIcon gamePic2 = new ImageIcon( "Java Experiments\\Grade 12 CS\\ImageIconDemo\\bigchungus.jpg"); 
		ImageIcon gamePic3 = new ImageIcon("Java Experiments\\Grade 12 CS\\ImageIconDemo\\capybara.jpg");
		ImageIcon gamePic4 = new ImageIcon("Java Experiments\\Grade 12 CS\\ImageIconDemo\\avatar-anime-lock-in.gif");
		ImageIcon gamePic5 = new ImageIcon("Java Experiments\\Grade 12 CS\\ImageIconDemo\\get-fake.gif");

        //Making the game buttons and appending them to the gameLibrary panel
        JButton game1 = new JButton(gamePic1);
        gameLibrary.add(game1);
        JButton game2 = new JButton(gamePic2); 
        gameLibrary.add(game2);   
        JButton game3 = new JButton(gamePic3);
        gameLibrary.add(game3);
        JButton game4 = new JButton(gamePic4);
        gameLibrary.add(game4);
        JButton game5 = new JButton(gamePic5);
        gameLibrary.add(game5);

        //Creates a scroll bar for the gameLibrary widget
        JScrollPane scroll = new JScrollPane(gameLibrary);

        gameLibrary.add(scroll);


        mainFrame.getContentPane().add(gameLibrary);
        mainFrame.pack();
    } //gameScrollLibrary
}
