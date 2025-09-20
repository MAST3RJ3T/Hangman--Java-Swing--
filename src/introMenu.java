//Importing all required java libraries 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Creating a class that will display the intro page at the start the game 
public class introMenu extends JFrame{
	//Private variables for 2 buttons and the panel
	private JButton start;
	private JButton stats;
	private JPanel panel;
	JLabel displayField;
	
	//Constructor that creates the intro menu 
	public introMenu() {
		//Setting the default options such as the window title, size, what happens for the window to close, setting the layout 
		super("Hangman - Start Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,800);
		this.setLayout(new BorderLayout());
		
		//Creating the panel and adding it to the JFrame
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);
		
		//Creating a button that allows the user to start the game 
		Font newFont = new Font ("Calibri", Font.BOLD, 60);		
		JButton start = textFunctions.createButton("START", 50,500,300,200, newFont, 229, 228, 226, 115, 181, 92);
		panel.add(start);
		
		//Creating a button that allows the user to go to the stats page 
		JButton stats = textFunctions.createButton("STATS", 450,500,300,200, newFont, 229, 228, 226, 96, 130, 182);
		panel.add(stats);
				
		//Adding action listener to both buttons to detect input 
		start.addActionListener(new startHandler());
		stats.addActionListener(new statsHandler());
		
		//Creating the title of the main menu 
		Font titleFont = new Font("Calibri", Font.BOLD, 80);
		JLabel title = textFunctions.createText("HANGMAN", 210, 10, 400, 100, titleFont, 96, 130, 182); 
		panel.add(title);
		
		//Creating the rules that are displayed on the main menu 
		Font rulesFont = new Font("Calibri", Font.ITALIC, 30);
		JLabel rules = textFunctions.createText("--You have 8 tries to guess the word--", 170, 60, 600, 100, rulesFont, 0, 0, 0);
		panel.add(rules);
		
		//Using try catch error checking in case the image file doesn't exist 
		try{
			//Getting the image and displaying it onto the panel as a JLabel 
	        ImageIcon image = new ImageIcon(getClass().getResource("hangman.png"));
	        displayField = new JLabel(image);
	        displayField.setBounds(200, 130, image.getIconWidth(), image.getIconHeight());
            panel.add(displayField);
	    } catch(Exception e){
	    	//If the image isn't found, a message in the console is displayed 
	        System.out.println("Image not found");
	    }
		this.setVisible(true);
	}

//Class that deals with the input of the start button
protected class startHandler extends Handler{
	public void actionPerformed(ActionEvent e) {
		//When the start button is pressed, the user will be brought to the game page, running the game as an instance of it is created 
		gameMenu gameMenu = new gameMenu();
		dispose(); //Getting rid of the current page 
	}
}

//Class that deals with the input of the stats button 
protected class statsHandler extends Handler{
	public void actionPerformed(ActionEvent e) {
		//When the stats button is pressed, the user will be brought to the stats page, as an instance of it is created 
		statsMenu statsMenu = new statsMenu();
		dispose();
	}
}
}

