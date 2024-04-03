package GUIExploration;
//Imports some other GUI components like color and dimensions
import java.awt.*;

//For input
import java.util.Scanner;

//Importing GUI componenets using swing components
import javax.swing.*;

public class GUIExploration {
    //Scanner object that can be used for user input across all methods
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        setUpFrameAndPanel();
    } //main

    public static void setUpFrameAndPanel() {
        /*Action: Sets up the frame/canvas that we put all of our GUI components on 
          and the colourPanel for specific interactive GUI components.
          Input: None
          Output: JFrame and JPanel Setup with basic components in the colourPanel*/
        
        String frameName = "The Main Frame";

        //Frame, the root of the "canvas" that we put our GUI on
        //Initializes the frame that we will be creating
        JFrame frame = new JFrame(frameName);

        /*Panel, a kind of section of the frame that we can append interactive components too.
        Initializes the colourPanel.*/
        JPanel colourPanel = new JPanel();
        JPanel hideColourPanel = new JPanel();

        //Creates a button and adds it to the colourPanel
        JButton colourButton = new JButton("Change Colour");
        colourPanel.add(colourButton);

        //Makes the colourPanel light-gray
        colourPanel.setBackground(Color.LIGHT_GRAY);

        //What happens when the button is clicked
        colourButton.addActionListener(e -> {
            //Generates a random number between 0 and 12 for the colour options
            int randInt = (int)(Math.random() * 13);
            switch (randInt) {
                default:
                    //Automatically ligh gray background on the colourPanel
                    colourPanel.setBackground(Color.LIGHT_GRAY);
                case 0:
                    colourPanel.setBackground(Color.RED);
                    break;
                case 1:
                    colourPanel.setBackground(Color.GREEN);
                    break;
                case 2:
                    colourPanel.setBackground(Color.BLUE);
                    break;
                case 3:
                    colourPanel.setBackground(Color.MAGENTA);
                    break;
                case 4:
                    colourPanel.setBackground(Color.CYAN);
                    break;
                case 5:
                    colourPanel.setBackground(Color.YELLOW);
                    break;
                case 6:
                    colourPanel.setBackground(Color.BLACK);
                    break;
                case 7:
                    colourPanel.setBackground(Color.WHITE);
                    break;
                case 8:
                    colourPanel.setBackground(Color.GRAY);
                    break;
                case 9:
                    colourPanel.setBackground(Color.DARK_GRAY);
                    break;
                case 10:
                    colourPanel.setBackground(Color.ORANGE);
                    break;
                case 11:
                    colourPanel.setBackground(Color.PINK);
                    break;
            }
        });

        //Sets the size of the frame
        frame.setSize(600, 480);

        //Set the default close operation (exit when closed)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creates a button that will hide the colourPanel if clicked
        JButton colourPanelHideButton= new JButton("Hide Panel");
        //Adds the button to the hideColourPanel panel
        hideColourPanel.add(colourPanelHideButton);
        //Shows the hiding button
        colourPanelHideButton.setVisible(true);

        //Creates a button that will show the colourPanel if clicked
        JButton colourPanelShowButton= new JButton("Show Panel");
        //Adds the button to the frame
        hideColourPanel.add(colourPanelShowButton);
        //Will make the button invisible 
        colourPanelShowButton.setVisible(false);

        //If the hide button is clicked
        colourPanelHideButton.addActionListener(e -> {
            //Make the frame invisible
            colourPanel.setVisible(false);
            //Hides the hiding button
            colourPanelHideButton.setVisible(false);
            //Makes the show button visible
            colourPanelShowButton.setVisible(true);

        });

        //If the show button is pressed
        colourPanelShowButton.addActionListener(e -> {
            //Make the frame invisible
            colourPanel.setVisible(true);
            //Makes the hiding button visible
            colourPanelHideButton.setVisible(true);
            //Makes the show button invisible
            colourPanelShowButton.setVisible(false);

        });

        //Make the frame visible
        frame.setVisible(true);

        //Adds the colourPanel to the frame
        frame.add(colourPanel);

        //Adds the hideColourPanel to the frame
        frame.add(hideColourPanel);

        //Makes the colourPanel visible
        colourPanel.setVisible(true);
        colourPanel.setBounds(0, 0, 200, 480);

        //Makes the hideColourPanel visible
        hideColourPanel.setVisible(true);
        hideColourPanel.setBounds(50, 0, 100, 480);


    } //setUpFrame
}
