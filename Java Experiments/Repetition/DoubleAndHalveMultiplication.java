import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: December 2nd, 2022
/*This program follows a process for determining the product of two positive integers using only 
multiplication by two, division by two, and addition.*/

public class DoubleAndHalveMultiplication {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Initializes num1, num2 and product
            int num1;
            int num2;
            int product = 0;
            //While num1 and num2 do not equal zero, keep asking for input and go through the process
            do {
                //Gets num1 and num2
                System.out.print("Please enter your first integer: ");
                num1 = in.nextInt();
                System.out.print("Please enter your second integer: ");
                num2 = in.nextInt();

                //Always output 0 is either num1 or num2 is 0
                if (num1 == 0 || num2 == 0) {
                    System.out.println("The product of " + num1 + " and " + num2 + " is 0.");
                }
                else {
                    System.out.println("  num1 | num2  ");
                    //Will stop after counter is equal to less than 1 and counter is divided by 2 each time
                    for (int counter = num2; counter > 1; counter /= 2) {
                        //Everytime num2 is even, the product of num1 * 2 will not be added to product
                        if (num2 % 2 == 0) {
                            System.out.println("~~" + (num1 *= 2) + " | " + (counter) + "~~");
                        }
                        //Everytime num2 is odd, the product of num1 * 2 will be added to product
                        else if (num2 % 2 == 1) {
                            System.out.println("  " + (product += num1 *= 2) + " | " + (counter) + "  ");
                        }
                        //Prints product
                        System.out.println(product);
                    }
                }

            } while (num1 > 0 && num2 > 0); //End of do-while


            //Tells the user that the program has ended
            System.out.println("Exit program.");
        }
    } 
}
