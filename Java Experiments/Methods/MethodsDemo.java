import java.util.Scanner;

public class MethodsDemo {
    //Prabhjot Bhandal
    //December 13th, 2022
    //To demonstrate methods
    //Methods are just functions 

    //This makes in a class varialble, not a local variable
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //How to use the method in main
        greeting();
        greetingAM();
        greetingPM();
        getTimeOfDay();
        System.out.println("This is the end of the road for us Waltuh.");

    } //main

    /*
    public static returnType nameOfMethod /MethodIdentifier (<parameter list> ){
        void means returns nothing

         //details of the method a.k.a the method’s body

         …

    }// nameOfMethod/MethodIdentifier*/

    public static void greeting() {
        System.out.println("I'm afraid and hopless since I didn't have a clue of what to do.");

    } //greeting

    public static void greetingAM() {
        System.out.println("It's beaUTIFUL DAY HERE IN LOS ANGELES.\nTHERE IS CURRENTLY A DROUGHT, BE CAREFUL AND HAVE A GOOD DAY!");

    } //Morning greeting

    public static void greetingPM() {
        System.out.println("NO SUN DON'T LEAVE ME");

    } //Evening greeting

    public static String getTimeOfDay() {
        System.out.print("Please enter the time of day: ");
        String timeOfDay = in.next();
        return timeOfDay;
    }
}
