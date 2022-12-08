import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: December 7th, 2022
/*Purpose: User can input an two integers: one being the integer to be shifted, and the other dictating how many times the first integer shifts.
Then, each time the first integer shifts, it is added to a sum and the sum is then shown at the end.*/

public class ShiftySum {
    public static void main(String[] args) throws InterruptedException{
        try (Scanner in = new Scanner(System.in)) {
            //Intro
            System.out.println("Welcome to Shifty Sum!\n\nThis program will prompt you to enter an integer, then it will ask you how many times you want it to be shifted\nTo shift means to add a 0 to the end of the number.\nFor example, let's say you want 12 to be shifted once, thus the shifted number of 12 that has been shifted once will be 120.");
            System.out.println("Once you put in your integer and the number of times you want it to be shifted, then this program will add up each time your integer shifts (12+120) then output the sum (132).");
            Thread.sleep(5000);
            System.out.println("\nNow then, let's get started!\n\n");
            Thread.sleep(2000);

            //Gets shiftInt
            System.out.print("Please input the integer you want to be shifted: ");
            int num = in.nextInt();
            //Gets shiftTimes
            System.out.print("Please enter the number of times you want your first integer to be shifted: ");
            int shiftTimes = in.nextInt();
            //Initializes sum, shiftInt
            int sum = 0;
            int shiftInt = num;

            //Loop repeats until counter is <= to shiftTimes
            for (int counter = 0; counter <= shiftTimes; counter++) {
                //First adds the current shiftInt to the sum
                sum += shiftInt;
                //Shifts the integer
                shiftInt *= 10;
            }

            //Outputs the num, shiftTimes and sum
            System.out.println("\nTherefore the shifty sum of " + num + ", which has been shifted " + shiftTimes + ", will be " + sum + ".");
        }
    }
}