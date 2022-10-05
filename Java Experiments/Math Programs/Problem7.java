import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 3rd, 2022
/*Write a program that gets a three-digit number from the user, finds the sum of the digits 
of the number, and then prints both the number and the sum of its digits.*/

public class Problem7 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
        
            System.out.print("Type a three-digit number: ");
            int threeDigitNumber = in.nextInt();
            int firstDigit = threeDigitNumber / 100;
            int secondDigit = threeDigitNumber / 10 % 10;
            int thirdDigit = threeDigitNumber % 10;
            int threeDigitSum = firstDigit + secondDigit + thirdDigit;
            System.out.println("Your three-digit number was " + threeDigitNumber + " and the sum of the three digits in " + threeDigitNumber + " is " + threeDigitSum + ".");
        }
}
}