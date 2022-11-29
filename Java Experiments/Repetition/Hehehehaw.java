import java.util.Scanner;

public class Hehehehaw {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Please enter a positive integer.");
            int userInput = in.nextInt();
            int powerOfTwo = 0;
            while (Math.pow(2,powerOfTwo) < userInput){
                powerOfTwo++;
            }
            System.out.println("The smallest power of two greater than or equal to " + userInput + " is " + powerOfTwo);
    
        }
}
}