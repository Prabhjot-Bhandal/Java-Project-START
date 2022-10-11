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
        System.out.print("Please enter the yearly interest: ");
        //Gets yearlyInterest
        double yearlyInterest = in.nextDouble();
        //Introduction for yearsTime
        System.out.print("Please enter the amount of time in years the loan has been taken out for/the money has been invest for: ");
        //Gets yearsTime
        double yearsTime = in.nextDouble();
        //Calculates the interest 
        double interestMoney = amountOfMoney * yearlyInterest * yearsTime;
        //Prints out interestMoney
        System.out.print("The amount of money invested/taken out for a loan was $" + amountOfMoney + ", the yearly interest was " + yearlyInterest + "% and the amount of years the interest has built for is " + yearsTime + " years. \nTherefore, the earned interest from the bank account will be $" + interestMoney + ".");
  }
  }
}