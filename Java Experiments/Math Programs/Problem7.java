import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 3rd, 2022
/*Write a program that gets a three-digit number from the user, finds the sum of the digits 
of the number, and then prints both the number and the sum of its digits.*/

public class Problem7 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Introduction
            System.out.print("Type a three-digit number: ");
            //Gets threeDigitNumber
            int threeDigitNumber = in.nextInt();
            
            //Determine firstDigit
            int firstDigit = threeDigitNumber / 100;
            //Determine secondDigit
            int secondDigit = threeDigitNumber / 10 % 10;
            //Determine thirdDigit
            int thirdDigit = threeDigitNumber % 10;
            //Determines the threeDigitNumber's sum
            int threeDigitSum = firstDigit + secondDigit + thirdDigit;

            //Prints the user's threeDigitNumber and the sum
            System.out.println("Your three-digit number was " + threeDigitNumber + " and the sum of the three digits in " + threeDigitNumber + " is " + threeDigitSum + ".");
        }
}
}