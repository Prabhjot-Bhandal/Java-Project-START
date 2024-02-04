import java.util.Scanner;
//Prabhjot Bhandal
//February 2, 2024
/*This is a programmed version of the Name Game done in class. Different names are associated with
different foods and this program will allow the user to choose if it will be printed in order, in reverse
or randomized.*/

public class NameGameCS12 {
    /*Arrays of all names and foods, they have corresponding indicies (Ex. Both Dhruv and Dragonfruit 
    are index 0 in theoir respective arrays)*/
    static String names[] = {"Dhruv", "Kabilash", "Varun D", "Anmol", "Gursimar", "Catherine", "Aryan", "Megan", 
    "Ria", "Manreet", "Abinash", "Trinity", "Aadpuran", "Yuvraj", "Zayne", "Bhuvan", "Varun R", "Sreyo",
    "Joban", "Sijaanth", "Prabhjot", "Udhav", "Harjeevan", "Om", "Angadjyot"};
    static String foods[] = {"Dragonfruit", "Kiwi", "Vanilla Ice Cream", "Apple", "Guava", "Cookie", "Avocado", 
    "Mango", "Raspberry", "Marshmellow", "Asparagus", "Trout", "Almond", "Yam", "Zucchini", "Banana", 
    "Velvet Bean", "Strawberry", "Jackfruit", "Salmon", "Pineapple", "Umbrellafruit", "Hamburger", "Orange", 
    "Apricot"};
    //Creates an empty array with the same amount of variables as name array
    static int alreadyCalled[] = new int[names.length];
    //Used for assigning current index being called to alreadyCalled array to be checked in future to prevent repetition
    static int currentCalledIndex = 0;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Welcomes the user, asks for input to print in order, reverse or randomized
            System.out.print("Welcome to the Name Game Simulation!\nTo print all names and foods in order, please press 0.\nTo print names in reverse order, please press 1.\nTo print names in randomized order, please press 2.\n\nInput: ");
            int printMode = in.nextInt();

            switch(printMode) {

                //Print in order
                case 0:
                    //Starts at index 0, works up to the last index
                    for (int index = 0; index < names.length; index++) {
                        //Prints the name and corresponding food
                        nameAndFoodPrint(names, foods, index);
                    }
                    break;
                
                //Print in reverse
                case 1:
                    //Starts at index 24, works down to the first index
                    for (int index = names.length - 1; index > -1; index--) {
                        //Prints the name and corresponding food
                        nameAndFoodPrint(names, foods, index);
                    }
                    break;
                
                //Print randomized
                case 2:
                /*Fills alreadyCalled array with integers that cannot be used to access an index
                in the names and foods arrays, array will be filled with already called indices
                to prevent repetition*/
                for (int index = 0; index < alreadyCalled.length; index++) {
                    alreadyCalled[index] = -2;
                }

                //Goes to randomized printing method, done so recursion can be used
                randomizedPrint();     
            }
        }
        
        System.out.println("\n\nAnd that's the everyone!");

    } //main


    public static void nameAndFoodPrint(String[] names, String[] foods, int index) {
        //Prints out all names and their corresponding foods
        System.out.println(names[index] + " likes " + foods[index]);
    } //nameAndFoodPrint


    public static void randomizedPrint() {
        /*This method prints out everyone's names and foods in random order, 
        this was made into a method to rewrite repeated random indices via recursion*/

        //do while loop runs for all names in the names array
        do {
            //Generates randomized index using randomIndexGenerator
            int randIndex = randomIndexGenerator(names, alreadyCalled, currentCalledIndex);

            //If randIndex has already been called, re-runs the method to re-roll randIndex
            if (randIndex < 0) {
                randomizedPrint();
            }
            else {
                //Prints the name and corresponding food
                nameAndFoodPrint(names, foods, randIndex);
            }
            //Adds one to the current called index
            currentCalledIndex++;
        } while (currentCalledIndex < names.length);
    } //randomizedPrint

    
    public static int randomIndexGenerator(String[] names, int[] alreadyCalled, int currentCalledIndex) {
        /*Generatres a random index that will be used to call a name and food,
        checks if this name and food has already been called, rerolls if so*/

        //Randomized integer, randIndex, within the available indices of names
        int randIndex = (int)(Math.random() * names.length);

        /*Searches alreadyCalled[] to see if the current randomized index has already been called*/
        for (int index = 0; index < alreadyCalled.length; index++) {
            /*If the current random index has already been called, returns -1 so that the 
             method will be called again to re-roll randIndex*/

             //If current randomized index has already been called
             if (alreadyCalled[index] == randIndex) {
                randIndex = -1;
                return randIndex;
             }
        }

        //Assigns the random index that will be caleld to the current loop number
        alreadyCalled[currentCalledIndex] = randIndex;

        //Returns the randomized index that will be called
        return randIndex;
                     
    } //randomIndexGenerator
}



