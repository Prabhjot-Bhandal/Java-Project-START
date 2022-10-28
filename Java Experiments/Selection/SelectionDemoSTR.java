import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 28th, 2022

public class SelectionDemoSTR {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Introduction
            System.out.println("Welcome to my Selection Demo with Strings.");
            System.out.println("\n\n You will be prompted for two strings.");
            System.out.println("This program will indicate which string comes first alphabetically. \n\n");

            //Prompt for the first string
            System.out.println("Please enter the first string: ");
            String firstStr = in.nextLine();
            //Prompt for the second string
            System.out.println("\nPlease enter the second string: ");
            String secondStr = in.nextLine();

            //If both strings are the same
            if (firstStr.equals(secondStr)) {
                //True, prints that both strings are the same
                System.out.println("Both strings are the same.");
            } else if (firstStr.compareTo(secondStr) < 0) {
                //False, prints that both strings are NOT the same
                System.out.println("Therefore " + firstStr + " comes before " + secondStr + " alphabetically.");
            }

            //If false, skips if statement and goes straight to the end
            System.out.println("Fin.");
        }
    }
}
