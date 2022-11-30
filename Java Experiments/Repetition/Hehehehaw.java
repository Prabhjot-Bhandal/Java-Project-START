import java.util.Scanner;

public class Hehehehaw {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Please enter an integer: ");
            int num = in.nextInt();
            int counter = 1;
            while (num % 2 == 0) {
                num /= 2;
                counter++;
            }
            System.out.println(counter);
        }
    }
}