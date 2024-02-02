//Name: Prabhjot Bhandal
//Date: November 22nd, 2022
/*Purpose: To demonstrate step counting and counting down.*/

public class StepCountingDown {
    public static void main(String[] args)throws InterruptedException{
        //Step Counting
        System.out.println("Step Counting");

        //Use a for-loop to determine the sum
        for(int counter = 2; counter<=10;counter+=2 ){
            System.out.println(counter);
            Thread.sleep(1000);
        }//End of loop

        System.out.println();
        //Counting Down
        System.out.println("Counting Down");
        for(int counter = 100; counter > 0;counter -= 10){
            System.out.println(counter);
            Thread.sleep(1000);
        }//End of loop


    }

}