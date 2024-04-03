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
          and the panel for specific interactive GUI components.
          Input: None
          Output: JFrame and JPanel Setup with basic components in the panel*/
        
        String frameName = "The Main Frame";

        //Frame, the root of the "canvas" that we put our GUI on
        //Initializes the frame that we will be creating
        JFrame frame = new JFrame(frameName);

        /*Panel, a kind of section of the frame that we can append interactive components too.
        Initializes the panel.*/
        JPanel panel = new JPanel();

        //Creates a button and adds it to the panel
        JButton button = new JButton("Button");
        panel.add(button);
        button.addActionListener(e -> {
            //Action to perform when the button is clicked
            
        });
        //Creates a label and adds the label to the panel
        panel.add(new JLabel("Label"));
        ///Creates and adds a textfield to the panel
        panel.add(new JTextField(10));

        //Makes the panel blue
        panel.setBackground(Color.BLUE);

        //Sets the size of the frame
        frame.setSize(600, 480);

        //Set the default close operation (exit when closed)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Make the frame visible
        frame.setVisible(true);

        //Adds the panel to the frame
        frame.add(panel);

        //Makes the panel visible
        panel.setVisible(true);

    } //setUpFrame
}
