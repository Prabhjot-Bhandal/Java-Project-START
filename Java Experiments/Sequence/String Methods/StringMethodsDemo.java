import java.util.Scanner;

public class StringMethodsDemo {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
        System.out.print("What city do you live in?: ");
        String cityStr = in.next();

        //Gets length of the string
        System.out.println(cityStr.length());
        //Finds the first letter of the string
        System.out.println(cityStr.charAt(0));
        //Finds the last letter of the string by subtracting 1 from the length of the string
        System.out.println(cityStr.charAt(cityStr.length() - 1));

        }
    }
}
