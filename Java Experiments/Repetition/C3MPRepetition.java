import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: November 17th, 2022
/*Purpose: Shuffles a playlist with the use of three buttons. 
The 1st button puts the first song at the end.
The 2nd button moves the last song to the front. 
The 3rd button swaps the first two songs around.
The 4th button stops the playlist.*/

public class C3MPRepetition {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //Initial playlist
            String playlist = "A, B, C, D, E";
            System.out.println("The initial playlist goes as follows: " + playlist + ".");
            System.out.println("Button 1 puts the first song at the end.\nButton 2 places the last song to the front.\nButton 3 switches the first two songs around.\nButton 4 ends the playlist.");
            

            //Moves the first song to the end
            String button1 = playlist.substring(3) + ", " + playlist.charAt(0);
            //Moves the last song to the front
            String button2 = playlist.substring(playlist.length() - 1) + ", " + playlist.substring(0, playlist.lastIndexOf(", E"));
            //Swaps the first two songs
            String button3 = playlist.substring(3, 6) + playlist.substring(0, 3) + playlist.substring(6);
            

            //Button 4 just stops rearranging the playlist and outputs the playlist
            //Prints the outcome of button1
            System.out.println(button1);
            //Prints the outcome of button2
            System.out.println(button2);
            //Prints the outcome of button3
            System.out.println(button3);
        }
    }
}