import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 25th, 2022
/*Purpose: Shuffles a playlist with the use of three buttons. 
The 1st button puts the first song at the end.
The 2nd button moves the last song to the front. 
The 3rd button swaps the first two songs around.*/

public class Task5 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Initial playlist
            String playlist = "A, B, C, D, E";
            System.out.println("The initial playlist goes as follows: " + playlist + ".");

            //Moves the first song to the end
            String button1 = playlist.substring(3, playlist.length()) + ", " + playlist.charAt(0);
            //Prints the outcome of button1
            System.out.println(button1);

            //Moves the last song to the front
            String button2 = playlist.substring(playlist.length() - 1) + ", " + playlist.charAt(0) + playlist.substring(1, playlist.lastIndexOf(", E"));
            //Prints the outcome of button2
            System.out.println(button2);
        }
    }
}