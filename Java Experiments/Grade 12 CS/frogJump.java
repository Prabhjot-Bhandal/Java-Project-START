import java.util.*;

public class frogJump {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Jumps: ");
        int numOfJumps = in.nextInt();
        System.out.print("\nLog Length: ");
        int logLength = in.nextInt();

        double newLogLength = jumpLength(numOfJumps, logLength);

        System.out.println(newLogLength);
    }

    public static double jumpLength(int numOfJumps, double logLength) {
        if (numOfJumps == 0) {
            return logLength;
        }

        return jumpLength(numOfJumps - 1, logLength / 2);

    }
}
