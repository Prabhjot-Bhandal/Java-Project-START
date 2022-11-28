import java.util.Scanner;
//Prabhjot Bhandal
//November 28th, 2022
//Find the sum of the integers between two integers provided by the user

public class CountedRepetitionTask {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Gets startNum
            System.out.print("Please enter your starting integer: ");
            int startNum = in.nextInt();
            //Gets endNum
            System.out.print("Please enter your ending integer: ");
            int endNum = in.nextInt();
            //Initializes the sum
            int sum = 0;


            //Starts at startNum, adds 1 each time, runs until the counter > endNum
            for (int counter = startNum; counter <= endNum; counter += 1) {
               sum += counter;
            }


            //Outputs the sum once all the numbers between the two integers are added together
            System.out.println("Therefore, the sum of all intergers between " + startNum + " and " + endNum + " is " + sum + ".");
        }
    }
}
