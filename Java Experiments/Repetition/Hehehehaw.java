import java.util.Scanner;

public class Hehehehaw {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            double aValue;
            do {
                System.out.println("Please enter the value for a: ");
                aValue = in.nextDouble();
            } while (aValue != 1);
            System.out.println("Please enter the value for b: ");
            double bValue = in.nextDouble();
            System.out.println("Please enter the value for c: ");
            double cValue = in.nextDouble();
            
            double discriminant = Math.pow(bValue, 2) - (4 * aValue * cValue);
            double posRoot = (-bValue + Math.sqrt(discriminant)) / (2 * aValue);
            double negRoot = (-bValue - Math.sqrt(discriminant)) / (2 * aValue);

            System.out.println("\nThis equation in standard form will be: " + aValue + "x^2+(" + bValue + "x)+(" + cValue + ") = 0.");
            if (posRoot / 1 != posRoot && negRoot / 1 != negRoot) {
                System.out.println("There are no real roots.");
            } 
            else if (posRoot == negRoot) {
                System.out.println("This equation in factored form will be: (x+" + posRoot + ")^2 = 0.");
                System.out.println("Therefore, the only solution to this eqaution is (" + posRoot + ", 0).");
            } 
            else {
                System.out.println("This equation in factored form will be: (x+" + posRoot + ")(x+" + negRoot + ") = 0.");
                System.out.println("Therefore, the solutions to this eqaution are (" + posRoot + ", 0) and (" + negRoot + ", 0).");
            }
        }
    }
}