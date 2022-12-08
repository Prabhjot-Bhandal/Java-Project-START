import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: December 7th, 2022
/*Purpose: User enters the humidity and maximum time they will wait for a weather balloon to touch the ground.
 Outputs which hour the balloon will hit the ground and if it's within the maximum time they'll wait for it.*/

public class WhoHasSeenTheWind {
    public static void main(String[] args) throws InterruptedException{
        try (Scanner in = new Scanner(System.in)) {
            //Initializes humidity, maxTIme, time and altitude
            int humidity = 0;
            int maxTime = 0;
            //Initialized time to print it outside the for loop
            int time = 0;
            double altitude = 0;

            //Only moves on to the next part of the program if 0 <= humidity <= 100 and 0 < maxTime < 240
            do {
                //gets humidity
                System.out.print("\n\nPlease input the humidity factor (0-100): ");
                humidity = in.nextInt();
                //gets maxTime
                System.out.print("Please enter the maximum amount of time (in hours) you are willing to wait for the weather balloon to return to ground: ");
                maxTime = in.nextInt();
            //Loops if any invalid integers are given based on these conditions
            } while (humidity < 0 || humidity > 100 || maxTime < 0 || maxTime > 240); //End of do-while


            //Time increases by 1 each time until altitude < 0
            for (time = 0; altitude >= 0; time++) {
                altitude = -6*Math.pow(time, 4) + humidity*Math.pow(time, 3) + 2*Math.pow(time, 2) + time;
            } //End of for
            //Have to subtract time by 1 because time increments once when leaving the loop
            time -= 1;


            //The balloon touches the ground within maxTime
            if (time <= maxTime) {
                //Outputs maxTime, humidity, time
                System.out.println("The balloon will touch the ground within " + maxTime + " hours of waiting and with a humidity rating of " + humidity + ", as the balloon touches the ground at hour " + time + ".");
            } 
            //The balloon does not touch the ground within maxTime
            else {
                //Outputs maxTime, humidity, time
                System.out.println("The balloon will NOT touch the ground within " + maxTime + " hours of waiting and with a humidity rating of " + humidity + ", as the balloon would touch the ground at hour " + time + ".");
            }
        }
    }
}