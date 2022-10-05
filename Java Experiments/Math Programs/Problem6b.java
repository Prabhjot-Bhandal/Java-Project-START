import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 4th, 2022
/*Write a program that can be used to determine interest earned on an investment or 
interest to be paid on a loan.*/

public class Problem6b {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
        //Introduction for amountOfMoney
        System.out.print("Please enter the money deposited into your bank account or \n enter the amount of money you took out for a loan: $");
        double amountOfMoney = in.nextDouble();
        System.out.print("Please enter the yearly interest : $");
        double yearlyInterest = in.nextDouble();
        double interestMoney = amountOfMoney * yearlyInterest;
        System.out.print("Therefore, the earned interest from the bank account will be $" + interestMoney + ".");
  }
  }
}