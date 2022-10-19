//Name: Prabhjot Bhandal
//Date: October 19th, 2022
//Finds the number of characters in my name, the second character in my name and the last character in my name

public class StringsIntroCYU {
    public static void main(String[] args) {
        String myName = "Prabhjot";

        //Prints # of characters in my name
        System.out.println("There are " + (myName.length()) + " characters in my name.");

        //Finds the second character in my name
        System.out.println("There second character in my name is " + (myName.charAt(1)) + ".");

        //Finds the last character in my name
        System.out.println("There last character in my name is " + (myName.charAt(myName.length() - 1)) + ".");

    }
}
