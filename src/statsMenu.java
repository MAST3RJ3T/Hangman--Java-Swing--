//Importing all required java libraries 
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

//Creating a class that will display the stats page in the game 
public class statsMenu extends JFrame{
	
	//Creating private variables for the back button and panel to be used throughout the class
	private JButton back;
	private JPanel panel;
	
	//Constructor that creates the stats menu
	public statsMenu() {
		//Setting the default options such as the window title, size, what happens for the window to close, setting the layout 
		super("HangMan - Stats Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,800);
		this.setLayout(new BorderLayout());
		
		//Creating the panel and adding it to the JFrame
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);
		
		//Creating a label that displays the text "WINs"
		Font statsFont = new Font("Calibri", Font.BOLD, 100);
		JLabel winsTitle = textFunctions.createText("WINS: ", 50, 100, 750, 100, statsFont, 115, 181, 92);
		panel.add(winsTitle);
		
		//Creating a label that displays the text "LOSSES"
		JLabel LossesTitle = textFunctions.createText("LOSSES: ", 50, 400, 750, 100, statsFont, 167, 13, 42);
		panel.add(LossesTitle);
		
		//Displaying the total number of wins by using the getWins method 
		JLabel totalWinsTitle = textFunctions.createText(gameFunctions.getWins(), 600, 100, 750, 100, statsFont, 0,0,0);
		panel.add(totalWinsTitle);
		
		//Displaying the total number of losses by using the getLosses method 
		JLabel totalLossesTitle = textFunctions.createText(gameFunctions.getLosses(), 600, 400, 750, 100, statsFont, 0,0,0);
		panel.add(totalLossesTitle);
		
		//Creating a back button to return to the main menu of the game 
		Font newFont = new Font ("Calibri", Font.BOLD, 40);
		JButton back = textFunctions.createButton("BACK", 550, 600, 200, 100, newFont, 229, 228, 226, 96, 130, 182);
		panel.add(back);
		
		//Adding the action listener to the button 
		back.addActionListener(new backHandler());
		this.setVisible(true);
}		

//Class that deals with the input of the back button
protected class backHandler extends Handler{
public void actionPerformed(ActionEvent e) {
	//When the button is pressed, the user will return to the main menu, as an instance of it is created 
	introMenu introMenu = new introMenu();
	dispose(); //Removing the current page 
    }
  }
}
