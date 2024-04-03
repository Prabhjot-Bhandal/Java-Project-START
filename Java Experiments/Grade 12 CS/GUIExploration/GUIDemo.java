package GUIExploration;

//Imports the entire swing package
import javax.swing.*;

public class GUIDemo {
    //Creates the frame for the GUI and makes it accessible across the entire class
    static JFrame frame = new JFrame("DEMO");
    public static void main(String[] args) {
        //Sets the frame's size
        frame.setSize(400, 600);
        //Sets the frame's close operation, how it can close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Calls addMenu method to add the menu bar to the frame
        addMenu();

        //Makes the frame visible
        frame.setVisible(true);
    }

    public static void addMenu() {
        //Creates the menubar
        JMenuBar menuBar = new JMenuBar();

        //Creates the menu itself
        JMenu menu = new JMenu("Demo Menu");

        //Creates the items for the menu to have
        JMenuItem item1 = new JMenuItem("AmongUs");
        JMenuItem item2 = new JMenuItem("AChungUs");
        JMenuItem item3 = new JMenuItem("HuMongUs");

        //Adds them to the menuBar
        menu.add(item1);
        menu.add(item2);
        menu.addSeparator(); //Adds a line between items (the seperator)
        menu.add(item3);

        //Adds the menu to the menuBar
        menuBar.add(menu);

        //Adds the menuBar to the main frame
        frame.setJMenuBar(menuBar);
    }

    public static void addButtons() {
        JButton button1 = new JButton("A");

        frame.add(button1);
    }
}