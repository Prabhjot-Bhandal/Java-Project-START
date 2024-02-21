//CCC 2020 S1, Surmising a Sprinter's Speed
import java.util.Scanner;
import java.math.BigDecimal;

public class CCC2020S1 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        //Number of inputs that the user will give
        int numOfInputs = in.nextInt();
        //Array that has all the positions
        double[] posArray = new double[numOfInputs];
        //Array that has all times
        double[] timeArray = new double[numOfInputs];

        //Gets all the elements for the timeArray and posArray
        for (int loop = 0; loop < numOfInputs; loop++) {
            timeArray[loop] = in.nextDouble();
            posArray[loop] = in.nextDouble();
        }

        int swapforMinIndexTimeAndPos;
        //Selection sort, looks for the smallest element, puts it first, then looks for second smallest, puts it second, etc
        for (int currentIndex = 0; currentIndex < timeArray.length; currentIndex++) {
            //If the current index is less than the first element in the timeArray, swaps the two values, keeps running until entire array sorted
            swapforMinIndexTimeAndPos = findMin(timeArray, currentIndex);
            //Uses the minimum value found in findMin() to swap the elements, restarts loop to look at the next element
            timeArray = swap(timeArray, swapforMinIndexTimeAndPos, currentIndex);
            posArray = swap(posArray, swapforMinIndexTimeAndPos, currentIndex);
        }

        //Once sorted, looks at all the velocities, keeps the LARGEST
        double velocities[] = new double[numOfInputs - 1];
        for (int currentIndex = 0; currentIndex < timeArray.length - 1; currentIndex++) {
            //Gets velocity, change in dist over change in time
            velocities[currentIndex] = Math.abs(((posArray[currentIndex + 1] - posArray[currentIndex]) / (timeArray[currentIndex + 1] - timeArray[currentIndex])));
        }

        int swapforMinIndexVelocity;
        //Selection sort, looks for the smallest element, puts it first, then looks for second smallest, puts it second, etc
        for (int currentIndex = 0; currentIndex < velocities.length; currentIndex++) {
            //If the current index is less than the first element in the timeArray, swaps the two values, keeps running until entire array sorted
            swapforMinIndexVelocity = findMin(velocities, currentIndex);
            //Uses the minimum value found in findMin() to swap the elements, restarts loop to look at the next element
            velocities = swap(velocities, swapforMinIndexVelocity, currentIndex);
        }

        //Prints out the last element in velocities, which will be the largest
        System.out.print(velocities[velocities.length - 1]);

    }

    public static int findMin(double[] array, int currentIndex) {
        //Runs for each element in the array, all are compared to the subsequent ones
        double minValue = array[currentIndex];
        int minIndex = currentIndex;
        //Finds the minimum value in an array
        for (int loop = minIndex + 1; loop < array.length; loop++) {
            //If a new minimum is found, minValue and minIndex are rewritten with the new min's value and index
            if (minValue > array[loop]) {
                minIndex = loop;
                minValue = array[loop];
            }
        }
        return minIndex;
    }

    public static double[] swap(double[] array, int firstIndex, int secondIndex) {
        //Holds secondIndex's value in array, overwrites array[secondIndex] and then overwrites array[firstIndex] w/ hold
        double hold = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = hold;

        return array;
    }
}
