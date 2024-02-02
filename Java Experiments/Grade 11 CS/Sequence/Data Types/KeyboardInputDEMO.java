import java.util.Scanner;

//Name: Prabhjot Bhandal
//Date: October 3rd, 2022
/*Purpose: Reads different data types*/

public class KeyboardInputDEMO {
    public static void main(String[] args) 
    {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("What is your name?");

            //Put the requested data in a container
            String name = in.next();
            System.out.println("Hello " + name + "!");

            /*use the method nextLine() to read a text with embedded spaces */
            System.out.println(name + ", how are you today?");
            //Use next instead of nextLine to not go to the next line
            String mood = in.next();

            /*use the method nextInt() to read an integer value */
            System.out.println(name +", how old are you?");
            int age = in.nextInt();

            /*use the method nextDouble() to read an double value */
            System.out.println("How much is a medium coffee?");
            double medCoffee = in.nextDouble();

            /*use the methods next() …from the Scanner class and charAt(index)… from the String class 
            combined as next().charAt(0) to read an char value */
            System.out.println("What is your favourite letter of the English Alphabet?");
            //If a word is the input, only gets the first letter as it's getting the character at the index of 0
            char favLetter = in.next().charAt(0);

            System.out.println("Your name is " + name + ", you are feeling " + mood + ", you are " + age + " years old, a medium coffee costs $" + medCoffee + " and your favourite letter is the English alphabet is " + favLetter + ".");
        }
    }
}
