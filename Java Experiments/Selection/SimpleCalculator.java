import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 4th, 2022
//Purpose: Simple calculator that takes in two integers and an arithmetic operator and conducts the operation

public class SimpleCalculator {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Intro for calculator
            System.out.println("Welcome to my simple calculator that allows you to do basic arithmetic. Please follow the instructions below.\n");

            
            //Input
            //Intro for firstInt
            System.out.print("Please input your first integer: ");
            //Gets firstInt
            int firstInt = in.nextInt();
            //Intro for secondInt
            System.out.print("Please input your second integer: ");
            //Gets secondInt
            int secondInt = in.nextInt();
            //Intro for operator
            System.out.print("Please input the operator you wish to conduct to the first integer with the second integer (+, -, *, / or %): ");
            //Gets operator
            String operator = in.next();
            //Gets rid of spaces in operator
            operator = operator.trim();
            //Creates equation string with firstInt, operator and secondInt
            String equation = firstInt + " " + operator + " " + secondInt;
            //Prints the user's equation
            System.out.println("\nThe equation you put in was: " + equation + ".");


            //Process
            //Addition
            if (operator.equals("+")) {
                int answer = firstInt + secondInt;
                //Outputs firstInt, operator, secondInt and answer
                System.out.println(equation + " = " + answer);
            }
            //Subtraction
            else if (operator.equals("-")) {
                int answer = firstInt - secondInt;
                //Outputs firstInt, operator, secondInt and answer
                System.out.println(equation + " = " + answer);
            }
            //Multiplication
            else if (operator.equals("*")) {
                int answer = firstInt * secondInt;
                //Outputs firstInt, operator, secondInt and answer
                System.out.println(equation + " = " + answer);
            }
            //Division
            else if (operator.equals("/")) {
                int answer = firstInt / secondInt;
                //Outputs firstInt, operator, secondInt and answer
                System.out.println(equation + " = " + answer);
            }
            //Modulo
            else if (operator.equals("%")) {
                int answer = firstInt % secondInt;
                //Outputs firstInt, operator, secondInt and answer
                System.out.println(equation + " = " + answer);
            }
        }
    }
}
