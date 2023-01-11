import java.util.Scanner;
//Prabhjot Bhandal
//January 9th, 2023
//To demonstrate arrays

public class ArraysDemo {
    static Scanner in = new Scanner(System.in);
    public static void main(String args[]) {
        //Arrays with objects auto-initialize to null
        //Calls classListMethod() to get students names
        String classList[] = classListMethod();

        //Calls studentNumMethod() to get students' ID numbers
        int studentNum[] = studentNumMethod(classList);

        //Boolean arrays auto-initialized to false
        boolean yesOrNo[] = new boolean[2];
        System.out.println(yesOrNo[0]);

        //Shows length of an array
        System.out.println(yesOrNo.length);

        //Calls studentsAndIDs() to print students names with their ID numbers
        studentsAndIDs(classList, studentNum);

        //Processing - Strings
        //Calls appendPhrase() to append " is enough!" to each string in the array
        String appendedClassList[] = appendPhrase(classList);
        //Prints students name with the phrase
        printArraySTR(appendedClassList);

        //Processing - Numbers
        //Calls studentNumSum() to determine sum of all students' numbers
        studentNumSum(studentNum);
    } //main

    public static void printArraySTR (String[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.println("\n\n" + array[index]);
        }
    }

    public static void printArrayINT (int[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.println("\n\n" + array[index]);
        }
    }

    public static String[] classListMethod () {
        //Creates classList array, gets students names and puts them in array
        //Declares the array
        String classList[];
        //Tells the program how length of the array
        classList = new String[7];
        //Input for arrays
        for (int index = 0; index < classList.length; index++) {
            System.out.print("\nEnter student " + (index + 1) + "'s name: ");
            classList[index] = in.next();
        }

        return classList;
    }//classListMethod

    //Made classList[] array a parameter to use classList in this method
    public static int[] studentNumMethod (String[] classList) {
        //Creates studentNum array, gets student numbers and puts them in array
        int studentNum[] = new int[7];
        System.out.println("\n\n");
        //Gets all value from the user
        for (int index = 0; index < studentNum.length; index++) {
            System.out.print("\nEnter the student ID number for " + classList[index] + ": ");
            studentNum[index] = in.nextInt();
        }

        return studentNum;
    }//studentNumMethod

    public static void studentsAndIDs (String[] classList, int[] studentNum) {
        //Prints students names with their corresponding ID numbers

        //How to print an entire array and to print two arrays beside each other
        System.out.println("\n\nName\t\t\tNumber");
        for (int index = 0; index < studentNum.length; index++) {
            //How to call an index of an array
            //If you print an index in an array with no values, will output null
            System.out.println(classList[index] + "\t\t\t" + studentNum[index]);
        }
    }//studentsAndIDs

    public static String[] appendPhrase (String[] classList) {
        //Appends " is enough!" to each index in classList

        //Phrase to append
        String suffix = " is enough!";
        //Initializes appendedClassList and sets its length equal to classList[]'s length
        String appendedClassList[] = new String[classList.length];

        //For loop ends when the index gets to length of classList[] - 1
        for (int index = 0; index < classList.length; index++) {
            //Declares each index with the index's specific student name appended with the suffix
            appendedClassList[index] = classList[index] + suffix;
            /*First three characters
            * classList[index] = classList[index] + suffix;
            */
        }

        return appendedClassList;
    }//appendPhrase

    public static void studentNumSum (int[] studentNum) {
        //Adds up all the students' ID numbers and returns the sum

        //Initializes sum
        int sum = 0;
        for (int index = 0; index < studentNum.length; index++) {
            //Adds each index of studentNum to sum
            sum += studentNum[index];
        }
        System.out.println("\n\nTherefore the sum of all the students' ID numbers is " + sum + ".");
    }//studentNumSum
}
