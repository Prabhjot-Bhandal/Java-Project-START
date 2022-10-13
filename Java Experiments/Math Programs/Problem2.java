//Name: Prabhjot Bhandal
//Date: October 12th, 2022
/*Write a program that simulates the rolling of a fair die. Output what shows on the face that is up.*/

public class Problem2 {
    public static void main(String[] args) {
        //Randomized diceRoll variable that has a range of 1-6 that will output a whole number
        double diceRoll = (int)(Math.random() * 6 + 1);
        //Prints diceRoll
        System.out.println(diceRoll);
}
}
