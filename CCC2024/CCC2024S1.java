package CCC2024;
//CCC 2024 S1: Hat Circle
import java.util.*;

public class CCC2024S1 {
static Scanner in = new Scanner(System.in);
static int[] peopleHats;
static int numSameHats = 0;
    public static void main(String[] args) throws Exception{
        //Number of people in the circles
        int N = in.nextInt();

        //Makes the length of the array the number of people in the circle
        peopleHats = new int[N];

        //Loops through each index of the peopleHats array to record each person's hat number
        for(int i = 0; i < peopleHats.length; i++) {
            peopleHats[i] = in.nextInt();
        }

        /*Stores half of the array's length since we must add half of the people every time to get 
        their partner*/
        int half = peopleHats.length / 2;

        //Runs for half the array's length since that is the number of pairs we have
        for(int j = 0; j < peopleHats.length / 2; j++) {
            /*If the person across from them has the same hat, adds 2 to the total number of people who 
            see the same hat number as their hat numbers*/
            if (peopleHats[j] == peopleHats[j + half]) {
                numSameHats += 2;
            }
        }

        System.out.println(numSameHats);
    } //main
}
