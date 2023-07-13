import java.util.Scanner;
//Prabhjot Bhandal
//February 14th, 2023
//Problem J1: What is n, Daddy

public class Main {
    //Scanner object
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //First gets number of sensors in the river
        int numOfSensors = in.nextInt();

        //Initializes highestFreq and lowestFreq
        int highestFreq = 1;
        int lowestFreq = 1;

        //For loop for getting frequency from user
        for (int counter = numOfSensors; counter > 0; counter--) {
            //Gets frequency each time
            int frequency = in.nextInt();

            //Makes sure to get the highest frequency by end
            if (frequency > highestFreq) {
                highestFreq = frequency;
            }
            //Makes sure to get lowest frequency by end
            else if (frequency < lowestFreq) {
                lowestFreq = frequency;
            }
        }

        //Outputs absolute difference
        System.out.println(Math.abs(highestFreq - lowestFreq));
    }
}
