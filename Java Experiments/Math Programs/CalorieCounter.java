import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 17th, 2022
/*Determines how many calories the user consumes from their favourite food per week, per month, per year 
and how many they will have consumed once they hit the age of 25.*/

public class CalorieCounter {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Input
            System.out.println("What is your name?");
            //gets name
            String name = in.next();
            System.out.println("\nHello " + name + "! \nHow old are you, " + name + "?");
            //gets age
            int age = in.nextInt();
            System.out.println("\nHey " + name + ", what is your favourite food?");
            //gets favFood
            String favFood = in.next();
            System.out.println("\nHow many calories are in one serving of " + favFood + "?");
            //gets calories
            int calories = in.nextInt();
            System.out.println("\nHow many servings of " + favFood + " do you eat per week?");
            //gets servingsPerWeek
            int servingsPerWeek = in.nextInt();

            //Process
            //Determines weeklyCalories 
            int weeklyCalories = calories * servingsPerWeek;
            //Determines monthlyCalories, assuming that there are 4 weeks in a month
            int monthlyCalories = weeklyCalories * 4;
            /*Determines yearlyCalories, multiplying weeklyCalories by 52 to get yearlyCalories to be more 
            accurate*/
            int yearlyCalories = weeklyCalories * 52;
            /*Determines the amount of calories that will be consumed from the user's current age to 
            when they turn 25.*/
            int caloriesWhen25 = (25 - age) * yearlyCalories;

            //Output
            /*Print name, age, favFood, calories, servingsPerWeek, weeklyCalories, monthlyCalories, 
            yearlyCalories and calories when 25. I split up the print statements so that one prints what the 
            user inputted while the other prints the calorie calculations to make the program more organized.*/
            System.out.println(name + " is " + age + " years old and your favourite food is " + favFood + ".\n You have " + servingsPerWeek + " servings of " + favFood + " per week with " + calories + " calories per serving.");
            System.out.println("\nTherefore, if you continue to eat your favourite food at this current rate, you will have eaten " + weeklyCalories + " calories per week, " + monthlyCalories + " calories per month, " + yearlyCalories + " calories per year and you will have consumed " + caloriesWhen25 + " calories of your favourite food once you hit the age of 25.");
            System.out.println("Now, I know that may seem like alot of calories, but if you exercise and/or work out consistently, you will be maintain your current body weight.");
        }
    }
}