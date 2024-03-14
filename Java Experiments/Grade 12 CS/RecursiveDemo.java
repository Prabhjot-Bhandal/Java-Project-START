

public class RecursiveDemo {
    public static void main(String[] args) {

        showRecursion(3);
        System.out.println(4 + "! = " + factorial(4));
    } //main

    public static void showRecursion(int num) {
        System.out.println("Entering method. num = " + num);

        //If num is greater than 1, keeps calling on the method until the int parameter is equal to one
        //Prior recursive calls are paused until base case reached, then works back up to finish the prior calls
        //Recursive programs must have a BASE CASE, there must be a way to stop recursive calls or else it will be infinite
        if (num > 1) {
            showRecursion(num - 1); //The main recursive call, calls on the method again
        } 

        System.out.println("Leaving method. num = " + num);
    } 

    public static int factorial(int num) {
        if (num == 1) { //Zaza base case
            return num;
        }
        return num * factorial(num - 1); //Recursive call
    }
}