import java.util.Scanner;
//Prabhjot Bhandal
//January 9th, 2023
//To demonstrate arrays

public class ArraysDemo {
    static Scanner in = new Scanner(System.in);
    public static void main(String args[]) {
        //Declares the array
        String classList[];

        //Tells the program how length of the array
        classList = new String[7];

        //Declaration and memory allocation in one line
        int studentNum[] = new int[7];

        double marks[] = new double[7];

        //Boolean arrays auto-initialized to false
        boolean yesOrNo[] = new boolean[2];

        //How to call an index of an array
        //If you print an index in an array with no values, will output null

        //Arrays with objects auto-initialize to null
        System.out.println(classList[0]);
        System.out.println(yesOrNo[0]);

        //Shows length of an array
        System.out.println(yesOrNo.length);

        //Input for arrays
        for (int index = 0; index < classList.length; index++) {
            System.out.println("\nEnter each student's name");
            classList[index] = in.next();
        }

        System.out.println("\n\n");
        //Gets all value from the user
        for (int index = 0; index < studentNum.length; index++) {
            System.out.println("\nEnter the student number for " + classList[index]);
            studentNum[index] = in.nextInt();
        }

        //How to print an entire array and to print two arrays beside each other
        System.out.println("Name\t\t\tNumber");
        for (int index = 0; index < studentNum.length; index++) {
            System.out.println(classList[index] + "\t\t\t" + studentNum[index]);
        }

        //Processing - Strings
        String suffix = " is enough!";
        for (int index = 0; index < classList.length; index++) {
            //Append suffix
            classList[index] = classList[index] + suffix;
            /*First three characters
            * classList[index] = classList[index] + suffix;
            */
        }

        //Processing - Numbers
        int sum = 0;
        for (int index = 0; index < studentNum.length; index++) {
            sum += studentNum[index];
        }
        System.out.println(sum);
    } //main
}
