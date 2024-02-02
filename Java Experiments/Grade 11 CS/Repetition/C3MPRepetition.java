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
            //Sets initialPlaylist
            String initialPlaylist = "ABCDE";
            //Initializes playlist as initialPlaylist
            String playlist = initialPlaylist;
            //Prints instructions for the different buttons
            System.out.println("Here's the instructions:\n\nButton 1 puts the first song at the end.\nButton 2 places the last song to the front.\nButton 3 switches the first two songs around.\nButton 4 ends the playlist.");
            //Initializes button4 as false to keep the plalist looping since button4 stops the playlist
            boolean button4 = false;
            //States that the playlist has begun and prints the initial playlist
            System.out.println("PLAYLIST START\n" + playlist);


            //While button4 has not been pressed, the playlist will keep looping
            while (button4 == false) {
                System.out.print("Another shuffle?: ");
                //Gets which button the user is initially pressing
                int input = in.nextInt();
                switch(input) {
                    //Prints the outcome of button1 if button1 is pressed
                    case 1:
                        //Moves the first song to the end
                        playlist = playlist.substring(1) + playlist.substring(0, 1);
                        break;
                    //Prints the outcome of button2 if button2 is pressed
                    case 2:
                        //Moves the last song to the front
                        playlist = playlist.substring(playlist.length() - 1) + playlist.substring(0, playlist.length() - 1);
                        break;
                    //Prints the outcome of button3 if button3 is pressed
                    case 3:
                        //Swaps the first two songs
                        playlist = playlist.substring(1, 2) + playlist.substring(0, 1) + playlist.substring(2);
                        break;
                    //Sets button4 to true to end the loop
                    case 4:
                        button4 = true;
                        break;
                    //Default case is initial playlist   
                    default:
                        System.out.println("Please enter a valid button.");
                        break;
                }//End of switch
            //Prints playlist after the switch statement checks for different input
            System.out.println("\n" + playlist);
            }
            //End of loop
            //Prints out final shuffled playlist
            System.out.print("\nYour final shuffle was: " + playlist);
            //Indicates playlist has ended
            System.out.println("\nEND OF PLAYLIST");
        }
    }
}