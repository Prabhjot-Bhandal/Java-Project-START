import java.util.Scanner;
//Prabhjot Bhandal
//February 2, 2024
/*This is a programmed version of the Name Game done in class. Different names are associated with
 * different foods and this program will allow the user to choose if it will be printed in order, in reverse
 * or randomized.*/


public class NameGameCS12 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            /*Arrays of all names and foods, they have corresponding indicies (Ex. Dhruv and Dragonfruit has 
            index 0)*/
            String names[] = {"Dhruv", "Kabilash", "Varun D", "Anmol", "Gursimar", "Catherine", "Aryan", "Megan", 
            "Ria", "Manreet", "Abinash", "Trinity", "Aadpuran", "Yuvraj", "Zayne", "Bhuvan", "Varun R", "Sreyo",
            "Joban", "Sijaanth", "Prabhjot", "Udhav", "Harjeevan", "Om", "Angadjyot"};
            String foods[] = {"Dragonfruit", "Kiwi", "Vanilla Ice Cream", "Apple", "Guava", "Cookie", "Avocado", 
            "Mango", "Raspberry", "Marshmellow", "Asparagus", "Trout", "Almond", "Yam", "Zucchini", "Banana", 
            "Velvet Bean", "Strawberry", "Jackfruit", "Salmon", "Pineapple", "Umbrellafruit", "Hamburger", 
            "Orange", "Apricot"};

            //Welcomes the user, asks for input to print in order, reverse or randomized
            System.out.println("Welcome to the Name Game Simulation!\nTo print all names and foods in order, please press 0.\nTo print names in reverse order, please press 1.\nTo print names in randomized order, please press 2.");
            int printMode = in.nextInt();

            switch(printMode) {
                //Print in order
                case 0:
                    
                //Print in reverse
                case 1:
                    
                //Print randomized
                case 2:
                    
            }
            /*for (int index = 0; index < array.length; index++) {
                String firstLetter = array[index].substring(0, 1);
                String restOfWord = array[index].substring(1);
                String encodedWord = restOfWord + firstLetter + "y";
                System.out.println(encodedWord);*/
        }
    }
}



