import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 5th, 2022
/*You’ve deposited $500 into your bank account and will leave it untouched for one year. 
How much will you earn in interest if the bank pays 2.5% interest per year?*/

public class Problem6a {
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      //Gets moneyDeposited and yearlyInterest
      double moneyDeposited = 500;
      double yearlyInterest = 0.025;
      //Calculates earnedInterest
      double earnedInterest = moneyDeposited * yearlyInterest;
      //Displays earnedInterest
      System.out.print("Therefore, the earned interest from the bank account will be $" + earnedInterest + ".");
  }
  }
}