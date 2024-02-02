//Name: Prabhjot Bhandal
//Date: October 13th, 2022
/*Write a program that simulates the rolling of two fair dice. Output
what shows on each face that is up
the sum of the values 
the difference of the values 
the product of the values
the quotient of the values
*/

public class Problem3 {
    public static void main(String[] args) {
        //Randomized diceRoll1 and dice2 variables have a range of 1-6 and will output a whole number
        double diceRoll1 = (int)(Math.random() * 6 + 1);
        double diceRoll2 = (int)(Math.random() * 6 + 1);

        //Determines sum (addition)
        double sum = diceRoll1 + diceRoll2;
        //Determines difference (subtraction)
        double difference = diceRoll1 - diceRoll2;
        //Determines product (multiplication)
        double product = diceRoll1 * diceRoll2;
        //Determines quotient (division)
        double quotient = diceRoll1 / diceRoll2;

        //Prints diceRoll1, diceRoll2, sum, difference, product and quotient
        System.out.println("The outcome of the first dice roll was: " + diceRoll1 + ".\nThe outcome of the second dice roll was: " + diceRoll2 + ".\nThe sum of both dice rolls is " + sum + ".\nThe difference between both dice rolls is " + difference + ".\nThe product of both dice rolls is " + product + ".\nThe quotient of both dice rolls is " + quotient + ".");
}
}
