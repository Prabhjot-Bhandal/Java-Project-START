//Imports the scanner class to get user input
import java.util.Scanner;

public class CrazyFencingCCC21 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int numberOfDiffSides = in.nextInt();
        double sides[] = new double[numberOfDiffSides + 1];
        double base[] = new double [numberOfDiffSides];
        double area[] = new double [numberOfDiffSides];
        
        for (int i = 0; i <= numberOfDiffSides; i++) {
        sides[i] = in.nextDouble();
        
        }

        for (int i1 = 0; i1 <= numberOfDiffSides - 1; i1++) {
        base[i1] = in.nextDouble();

        }
        double area2 = 0; 
        for (int i3 = 0; i3 <= numberOfDiffSides - 1; i3++){
            //System.out.println(sides[i3]);
            // System.out.println(sides[i3+1]);
            //System.out.println(base[i3]);
            
            double area1 = (((sides[i3] + sides[i3+1]) / 2) * base[i3]);
            area2 += area1;
        }
        System.out.println(area2);
        
        

        
        //for (int index=0; int ) 
  }
}
