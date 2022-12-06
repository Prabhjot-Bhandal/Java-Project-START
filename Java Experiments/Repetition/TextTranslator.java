import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: December 6th, 2022
/*Purpose: Write a program that will continually input a short form and output the translation.*/
 
public class TextTranslator {
    public static void main(String[] args) throws InterruptedException{
        try (Scanner in = new Scanner(System.in)) {
            //Intro for the program
            System.out.println("This program translates texting abbreviations for you.\nJust type in the phrase you want to translate and the program translates it for you!\nTo stop the program, simply type \"stop\" when prompted for a phrase.\n\n");
            Thread.sleep(3000);
 
            //Initializes phrase and run
            String phrase;
            boolean run = true;
 
            while (run == true) {
                //Gets phrase
                System.out.print("Enter a phrase: ");
                //Changes whatever the user enters to upper case and takes out all spaces
                phrase = in.nextLine().toUpperCase().replaceAll(" ", "");
 
                //Abbreviations eligible for translation
                switch (phrase) {
                    case "CU":
                        System.out.println("Translation: See you\n");
                        break;
                    case ":-)":
                        System.out.println("Translation: I'm happy\n");
                        break;
                    case ":-(":
                        System.out.println("Translation: I'm unhappy\n");
                        break;
                    case ";-)":
                        System.out.println("Translation: Wink\n");
                        break;
                    case ":-P":
                        System.out.println("Translation: Stick out my tongue\n");
                        break;
                    case "(~.~)":
                        System.out.println("Translation: I'm sleepy\n");
                        break;
                    case "TA":
                        System.out.println("Translation: Totally awesome\n");
                        break;
                    case "CUZ":
                        System.out.println("Translation: Because\n");
                        break;
                    case "TY":
                        System.out.println("Translation: Thank you\n");
                        break;
                    case "YW":
                        System.out.println("Translation: You're welcome\n");
                        break;
                    case "TTYL":
                        System.out.println("Translation: Talk to you later\n");
                        break;
                    //Stopping the program
                    case "STOP":
                        System.out.println("\n\nExit program");
                        run = false;
                        break;
                    //For errors/abbreviations not in the list
                    default:
                    System.out.println("\nSorry, please enter a valid abbreviation.\n\n");
                    break;
                }
            }//End of while loop
        }
    }
}

