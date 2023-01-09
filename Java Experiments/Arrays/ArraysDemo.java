//Prabhjot Bhandal
//January 9th, 2023
//To demonstrate arrays

public class ArraysDemo {
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
        //Assigns a value to an index of an array
        classList[0] = "Freiza";

        //Gets middle of array
        int mid = classList.length/2;
        classList[mid] = "Mona";
    } //main
}
