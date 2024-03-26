package ImageIconDemo;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ImageIConDemo {
	static Scanner input = new Scanner (System.in);
	
	
	public static void main(String[] args) {
		
			
		selectPic();
		
		
	}//main
	
	
	public static int getInput(){
		System.out.println("Please enter a number from 1 - 5");
		int number = input.nextInt();
		return number;
	}
	
	
	public static void selectPic(){
		ImageIcon picA = new ImageIcon( "Java Experiments\\Grade 12 CS\\ImageIconDemo\\amogus.jpg"); 
		ImageIcon picB = new ImageIcon( "Java Experiments\\Grade 12 CS\\ImageIconDemo\\bigchungus.jpg"); 
		ImageIcon picC = new ImageIcon("Java Experiments\\Grade 12 CS\\ImageIconDemo\\capybara.jpg");
		ImageIcon picD = new ImageIcon("Java Experiments\\Grade 12 CS\\ImageIconDemo\\avatar-anime-lock-in.gif");
		ImageIcon picE = new ImageIcon("Java Experiments\\Grade 12 CS\\ImageIconDemo\\get-fake.gif");
		
		
		int number = getInput();
		
		if (number ==1)
			intro(picA);
							
		else if(number ==2)
			intro(picB);

		else if(number == 3)
			intro(picC);

		else if(number == 4)
			intro(picD);

		else if(number == 5)
			intro(picE);
	}
	
		
	public static void intro(ImageIcon image){
		
		JFrame frame1 = new JFrame();
		frame1.setSize(1000,1000);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton  button = new JButton(image);
						
		frame1.add(button);
			
		frame1.setVisible(true);
		
		
		
	}
	

}
