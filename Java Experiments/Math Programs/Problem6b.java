import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 5th, 2022
/*Write a program that can be used to determine interest earned on an investment or 
interest to be paid on a loan.*/

public class Problem6b {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
        //Introduction for amountOfMoney
        System.out.print("Please enter the money deposited into your bank account or \n enter the amount of money you took out for a loan: $");
        //Gets amountOfMoney
        double amountOfMoney = in.nextDouble();
        //Introduction for yearlyInterest
        System.out.print("Please enter the yearly interest : $");
        //Gets yearlyInterest
        double yearlyInterest = in.nextDouble();
        //Calculates the interest 
        double interestMoney = amountOfMoney * yearlyInterest;
        //Prints out interestMoney
        System.out.print("Therefore, the earned interest from the bank account will be $" + interestMoney + ".");
  }
  }
}