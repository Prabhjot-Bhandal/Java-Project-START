import java.util.Scanner;
//Prabhjot Bhandal
//December 15th, 2022
//To greet the user depending on the time of day they input

public class TimeOfDayGreetings {
    //Methods are just functions 

    //This makes in a class varialble, not a local variable
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        gettingStarted();

    } //main

    public static void gettingStarted() {
        //Initializes stringOrInt
        String stringOrInt = "";

        //Loops back if the user does not input word or numbers when prompted
        do {
            //Gets stringOrInt
            System.out.print("\nWould you like to input the current time of day with words or hours?: ");
            //Takes all the spaces out of the string and turns the string lowercase
            stringOrInt = in.next().replaceAll(" ", "").toLowerCase();

            //Returns an error message if the user enters an incorrect input
            if (!stringOrInt.equalsIgnoreCase("words") || !stringOrInt.equalsIgnoreCase("hours")) {
                System.out.println("You must input either \"words\" or \"hours\" for your answer. Please try again.\n");
            }
        } while (!stringOrInt.equalsIgnoreCase("words") || !stringOrInt.equalsIgnoreCase("hours"));

        //If the user wants to input the time of day in words
        if (stringOrInt.equalsIgnoreCase("words")) {
            //Sets the string that getTimeOfDay() returns to the time variable
            String timeString = getTimeOfDay();

            //If morning
            if (timeString.equalsIgnoreCase("morning")) {
                greetingMorning();
            }
            //If afternoon
            else if (timeString.equalsIgnoreCase("noon") || timeString.equalsIgnoreCase("afternoon")) {
                greetingAfternoon();
            }
            //If evening
            else if (timeString.equalsIgnoreCase("evening")) {
                greetingEvening();
            }
            //If night
            else if (timeString.equalsIgnoreCase("night")) {
                greetingNight();
            }
            //If anything else
            else {
                greeting();
            }
        }
        //If the user wants to input the time of day in hours
        else if (stringOrInt.equalsIgnoreCase("hours")) {
            //Sets the interger that getHourOfDay() returns to the timeInt variable
            int timeInt = getHourOfDay();

            //If morning, greater than/equal to 5AM AND less than/
            if (timeInt >= 5 && timeInt <= 11) {
                greetingMorning();
            }
            //If afternoon, greater than/equal to 12PM AND less than/equal to 5PM
            else if (timeInt >= 12 && timeInt <= 17) {
                greetingAfternoon();
            }
            //If evening, greater than/equal to 6PM AND less then/equal to 8PM
            else if (timeInt >= 18 && timeInt <= 20) {
                greetingEvening();
            }
            /*If night, greater than/equal to 9PM and less then/equal to 11PM
            OR greater than/equal to 12AM and less than/equal to 4AM*/
            else if ((timeInt >= 0 && timeInt <= 4) || (timeInt >= 21 && timeInt <= 23)) {
                greetingNight();
            }
            //If anything else
            else {
                greeting();
            }
        }
    }


    
    //Methods that gets the time of day
        public static String getTimeOfDay() {
            //Gets timeOfDay
            System.out.print("Please enter the time of day: ");
            //Changes the whole string to lower case and takes out all the spaces
            String timeOfDay = in.next().toLowerCase().replaceAll(" ", "");

            return timeOfDay;
        } //getTimeOfDay


        public static int getHourOfDay() {
            //Initializes hourOfDay
            int hourOfDay = 0;

            //Loops back if user inputs an invalid hour of the day (less than 0 or greater than 23)
            do {
                //Gets hourOfDay
                System.out.print("\nPlease enter a valid hour of the day (in the 24-hour clock): ");
                hourOfDay = in.nextInt();

                //Tells user input is invalid if hour is less than 0 or greater than 23
                if (hourOfDay < 0 || hourOfDay > 23) {
                    System.out.print("Invalid input. Please input a vaild hour (0-23).\n\n");
                }

            } while (hourOfDay < 0 || hourOfDay > 23);

            return hourOfDay;
        } //getHourOfTheDay



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
