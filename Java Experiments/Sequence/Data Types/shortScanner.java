import java.util.Scanner;

//Name: Prabhjot Bhandal
//Date: October 3rd, 2022
/*Purpose: Reads different data types*/

public class shortScanner {
    public static void main(String[] args) 
    {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("What is your name? \n");
            //Creates a string object for the input of their name
            String name = in.next();
            System.out.println("Hello " + name + "!");

            System.out.println("What is your favourite double-digit number? \n");
            //short shortNumber = in.nextShort();
        }
    }
}
