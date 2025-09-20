//Importing the required java libraries 
import javax.swing.*;
import java.awt.*;

//Creating a class that creates buttons and text labels for the game 
public class textFunctions {
	
	//Method that creates but  tons for the program, taking in various parameters
	public static JButton createButton(String name, int xBound, int yBound, int width, int height, Font type, int foregroundR, int foregroundG, int foregroundB, int backgroundgroundR, int backgroundgroundG, int backgroundgroundB) {
		JButton button = new JButton(name); //Creating the button with text
		button.setBounds(xBound,yBound,width,height); //Setting the location and size 
		button.setFont(type); //Setting the font type
		button.setForeground(new Color(foregroundR, foregroundG, foregroundB)); //Setting the text colour
		button.setBackground(new Color(backgroundgroundR, backgroundgroundG, backgroundgroundB)); // Setting the colour of the button
		button.setFocusable(false); //Removing the ability for the cursor to lock onto the button, causing a rectangle to appear around the text
		return button;
	}
	
	//Method that creates labels for the program, taking in various parameters
	public static JLabel createText(String words, int xBound, int yBound, int width, int height, Font type,int r, int g, int b) {
		JLabel text = new JLabel(words); //Creating the label with text
		text.setBounds(xBound, yBound, width, height); //Setting the location and size
		text.setFont(type); //Setting the font type 
		text.setForeground(new Color(r, g, b)); //Setting the text colour 
		return text;
	}
}