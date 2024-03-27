package GUIExploration;
//For input
import java.util.Scanner;

//Importing GUI componenets using swing components
import javax.swing.*;

public class GUIExploration {
    //Scanner object that can be used for user input across all methods
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        setUpFrame();
    } //main

    public static void setUpFrame() {
        /*Action: Sets up the frame/canvas that we put all of our GUI components on.
          Input: None
          Output: JFrame and other components set up*/

        //Frame, the root of the "canvas" that we put our GUI on
        //Initializes the frame that we will be creating
        JFrame frame = new JFrame();

        //Sets the size of the frame
        frame.setSize(600, 480);

        //Set the default close operation (exit when closed)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creates a label
        JLabel frameName = new JLabel("Program 1");

        //Add the label to the frame
        frame.getContentPane().add(frameName);

        //Make the frame visible
        frame.setVisible(true);

    } //setUpFrame
}
