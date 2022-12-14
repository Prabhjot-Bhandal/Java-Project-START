import java.util.Scanner;

public class MethodsDemo {
    //Prabhjot Bhandal
    //December 13th, 2022
    //To demonstrate methods
    //Methods are just functions 

    //This makes in a class varialble, not a local variable
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        gettingStarted();

    } //main

    /*
    public static returnType nameOfMethod /MethodIdentifier (<parameter list> ){
        void means returns nothing

         //details of the method a.k.a the method’s body

         …

    }// nameOfMethod/MethodIdentifier*/

    public static void gettingStarted() {
        String time = getTimeOfDay();

        //If morning or noon
        if (time.equalsIgnoreCase("morning") || time.equalsIgnoreCase("noon")) {
            greetingAM();
        }
        //If afternoon, evening or night
        else if (time.equalsIgnoreCase("afternoon") || time.equalsIgnoreCase("evening") || time.equalsIgnoreCase("night")) {
            greetingPM();
        }
        //If anything else
        else {
            greeting();
        }
    }
        public static void greeting() {
            System.out.println("\nHello.");

        } //greeting

        public static void greetingAM() {
            System.out.println("\nIt's beaUTIFUL DAY HERE IN LOS ANGELES.\nTHERE IS CURRENTLY A DROUGHT, BE CAREFUL AND HAVE A GOOD DAY!");

        } //Morning greeting

        public static void greetingPM() {
            System.out.println("\nNO SUN DON'T LEAVE ME");

        } //Evening greeting

        public static String getTimeOfDay() {
            //Gets timeOfDay
            System.out.print("Please enter the time of day: ");
            //Changes the whole string to lower case and takes out all the spaces
            String timeOfDay = in.next().toLowerCase().replaceAll(" ", "");
            return timeOfDay;
        }

    public static void hourOfTheDay() {
        
    }
    
}
