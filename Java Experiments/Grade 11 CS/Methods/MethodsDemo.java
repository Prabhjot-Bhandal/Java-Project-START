import java.util.Scanner;
//Prabhjot Bhandal
//December 13th, 2022
//To demonstrate methods
/* A method's signature is the method's name and the parameters it takes in. 
Each method's signature should be unique.*/

/*
    public static returnType nameOfMethod /MethodIdentifier (<parameter list> ){
        void means returns nothing

         //details of the method a.k.a the method’s body

         …

    }// nameOfMethod/MethodIdentifier*/

public class MethodsDemo {
    //Methods are just functions 

    //This makes in a class varialble, not a local variable
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        greeting();
        greetingMorning();

    } //main


        //Greetings
            public static void greeting() {
                System.out.println("\nHello.");
            } //greeting

            public static void greetingMorning() {
                System.out.println("\nIT IS A BEAUTIFUL DAY HERE IN [your city].\nTHERE IS CURRENTLY A RECESSION, BE CAREFUL AND HAVE A GOOD DAY!");
            } //Morning greeting

            public static void greetingAfternoon() {
                System.out.println("\nThe sun sure is high in the sky...");
            } //Afternoon greeting

            public static void greetingEvening() {
                System.out.println("\nNO SUN DON'T LEAVE ME!");
            } //Evening greeting
            
            public static void greetingNight() {
                System.out.println("Hello darkness my old friend...");
            } //Night greeting
}
