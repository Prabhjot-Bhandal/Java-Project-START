import java.util.Scanner;
//Prabhjot Bhandal
//November 28th, 2022
//Find the sum of the integers between two integers provided by the user

public class CountedRepetitionTask {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Gets startNum
            System.out.print("Please enter your starting integer: ");
            int num1 = in.nextInt();
            //Gets endNum
            System.out.print("Please enter your ending integer: ");
            int num2 = in.nextInt();
            //Initializes the sum, startNum and endNum
            int sum = 0;
            int startNum = 0;
            int endNum = 0;

            
            //Checks which number is bigger and which is smaller
            //If num1 is bigger than num2
            if (num1 > num2) {
                //startNum is the small integer
                startNum = num2;
                //endNum is the bigger integer
                endNum = num1;
            } 
            //If num1 is smaller than num2
            else {
                startNum = num1;
                endNum = num2;
            }

            //Starts at startNum, adds 1 each time, runs until the counter > endNum
            for (int counter = startNum; counter <= endNum; counter += 1) {
                //Adds counter to the sum each time the lop runs
               sum += counter;
            }


            //Outputs the sum once all the numbers between the two integers are added together
            System.out.println("Therefore, the sum of all intergers between " + startNum + " and " + endNum + " is " + sum + ".");
        }
    }
}
