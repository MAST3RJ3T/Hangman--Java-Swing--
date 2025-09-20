//Importing all of the required libraries for the game 
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

//Creating a class that will run the game page and game calculations 
public class gameMenu extends JFrame{
	//Creating private variables for various text labels, buttons, the panel
	private JPanel panel;
	private JTextField enterLetter;
	private JLabel dashesTitle;
	private JLabel rightOrWrong;
	private JButton back;
	private JButton guessButton;
	private int wrong = 0; //Stores the number of wrong guesses
	private int userMatch = 0; //Stores the number of letters the user has matched 
	private boolean gameOver = false; //Boolean that determines if the game is done or not 
	private ArrayList<String> alpha; //Stores the alphabet
	private ArrayList<String> word; //Stores the random word to be guessed
	private ArrayList<String> dash; //Stores the letters the user has gotten correct 
	
	public gameMenu() {
		super("Hangman - Game");
		dash = new ArrayList<>();
		
		//Calling the alphabet function and storing it in the alpha arrayList 
		alpha = gameFunctions.alphabet();
		
		//Setting frame size, layout, what happens when the window is closed 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,800);
		this.setLayout(new BorderLayout());
		
		//Creating and adding the panel to the frame 
		panel = new DrawingPanel();
		panel.setLayout(null);
		this.add(panel);
		
		//Getting the random word and storing it an arrayList 
		word = gameFunctions.getWord();
		
		//Storing dashes into an arrayList to be displayed at the start as no letters have been guessed 
		for(int i = 0; i < word.size(); i++) {
			dash.add("_");
		}
		
		//Creating a label to display the number of letters (dashes) in the word 
		Font titleFont = new Font("Calibri", Font.BOLD, 60);
		dashesTitle = textFunctions.createText(gameFunctions.dashes(dash), 20, 630, 750, 100, titleFont, 96, 130, 182);
		panel.add(dashesTitle);
		
		//Creating a label to display the text "Enter Letter"
		Font entertextTitleFont = new Font("Calibri", Font.BOLD, 40);
		JLabel entertextTitle = textFunctions.createText("Enter Letter", 560,300, 200, 150, entertextTitleFont, 96, 130, 182);
		panel.add(entertextTitle);
		
		//Creating a label to display whether the guess is correct or not 
		rightOrWrong = textFunctions.createText("", 520, 20, 200,100, entertextTitleFont, 0, 0, 0);
		panel.add(rightOrWrong);
		
		//Creating a textfield for the user to enter their letter 
		Font textboxFont = new Font("Calibri", Font.BOLD, 40);
		enterLetter = new JTextField(1); 
		enterLetter.setBounds(620,400, 80, 60);
		enterLetter.setFont(textboxFont);
		panel.add(enterLetter);	
		
		//Creating a button allowing the user to guess a letter 
		guessButton = textFunctions.createButton("GUESS", 570,500,180, 70, entertextTitleFont, 0, 0, 0, 115, 181, 92);
		panel.add(guessButton);
		
		//Creating a button allowing the user to return to the main menu 
		Font backFont = new Font ("Calibri", Font.BOLD, 40);
		back = textFunctions.createButton("BACK", 560, 650, 200, 60, backFont, 229, 228, 226, 96, 130, 182);
		panel.add(back);
		
		//Adding action listeners to all 3 buttons 
		guessButton.addActionListener(new guessHandler());
		enterLetter.addActionListener(new enterLetterHandler());
		back.addActionListener(new backHandler());
		
		this.setVisible(true);	
	}
	
	//Creating a class that draws the hangman  
	private class DrawingPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html 
            //Calling the Graphics2D class allowing me to rotate rectangles and shapes when they are drawn onto the panel 
            Graphics2D g2d = (Graphics2D) g;
            //https://docs.oracle.com/javase%2Ftutorial%2F/2d/advanced/transforming.html
            //Storing the original transformation of the shapes to be referenced later on
            AffineTransform originalTransform = g2d.getTransform();
            g2d.setStroke(new BasicStroke(5)); //Width of lines
            // Draw lines here
            g.setColor(Color.BLACK);
            //Drawing the main black structure for the hangman 
            g.fillRect(50, 500, 200, 20); 
            g.fillRect(140,50,20,450);
            g.fillRect(140, 50, 280,20);
            g.fillRect(400,70,20,80);
            g.setColor(new Color(96, 130, 182));
            
            //Hangman is drawn based upon how many incorrect letters the user guesses 
            if (wrong >= 1) { //Drawing the head
            	g.fillOval(370, 145, 80, 80);
            }
            if (wrong >= 2) { //Drawing the body 
            	g.fillRect(405, 205, 15, 140);
            }
            if (wrong >= 3) { //Drawing left arm
            	g2d.setTransform(originalTransform);
            	double angle = Math.toRadians(45); 
                g2d.rotate(angle, 420, 225);
            	g.fillRect(415, 240, 15, 80);
            	g2d.setTransform(originalTransform);
            }
            if (wrong >= 4) { //Drawing right arm
            	g2d.setTransform(originalTransform);
            	double angle = Math.toRadians(-45); 
                g2d.rotate(angle, 400, 225);
            	g.fillRect(395, 240, 15, 80);
            	g2d.setTransform(originalTransform);        	
            }
            if (wrong >= 5) { //Drawing left leg 
            	g2d.setTransform(originalTransform);
            	double angle = Math.toRadians(30);
                g2d.rotate(angle, 420, 365);
                g2d.fillRect(390, 345, 15, 90);
                g2d.setTransform(originalTransform);
            }
            if (wrong >= 6) { //Drawing right leg 
            	g2d.setTransform(originalTransform);
            	double angle = Math.toRadians(-30);
                g2d.rotate(angle, 400, 365);
                g2d.fillRect(420, 345, 15, 90);
                g2d.setTransform(originalTransform);
            }  
            if (wrong >= 7) { //Drawing eyes 
            	 g.setColor(Color.BLACK);
            	 g.fillOval(390, 165, 12, 12);
            	 g.fillOval(420, 165, 12, 12);
            }
            if (wrong >= 8) { //Drawing mouth
            	g2d.drawLine(400, 190, 420, 210);
            	g2d.drawLine(420, 190, 400, 210);
            }
        }
    }
	
	//Class that handles the input for the guess button 
	protected class guessHandler extends Handler{
		public void actionPerformed(ActionEvent e) {
			String userGuess = enterLetter.getText();
			int notLetter = 0;
			//Using a for loop to check if the user has entered a letter that is in the alphabet 
			for (String i: alpha) {
				if (userGuess.equalsIgnoreCase(i)) { 
					alpha.remove(i); //Removing the letter if it's in the alphabet 
					break;
				} else if(!userGuess.equalsIgnoreCase("z")) {
					notLetter += 1;
				}
			}
			
			//If the letter isn't in the alphabet, a message will be printed to the console 
			if (notLetter == alpha.size()) {
				System.out.println("Enter a valid letter as a guess");
			} else { //If the letter was in the alphabet, the program checks to see if it matches one in the word 
				int count = 0;
				int noMatch = 0;
				//For loop that checks the user's letter against the word 
				for (String i: word) {
					if (userGuess.equalsIgnoreCase(i)) {
						dash.set(count, i);
						userMatch += 1; //If the letter is in the word, 1 will be added to the user's matches 
					} else {
						noMatch += 1; //If the letter isn't in the word
					}
					count += 1;
				}
				//If the letter isn't in the word, 1 will be added to the wrong variable and the panel will display incorrect 
				if (noMatch == word.size()) {
					wrong += 1;
					System.out.println("This letter is not in the word");
					rightOrWrong.setForeground(new Color (167, 13, 42));
					rightOrWrong.setText("INCORRECT");
		            rightOrWrong.repaint();
				} else {
					//If the letter is in the word, the panel will display correct 
					System.out.println("This letter is in the word");
					rightOrWrong.setForeground(new Color (115, 181, 92));
					rightOrWrong.setText("CORRECT");
		            rightOrWrong.repaint();
				}
			}
			
			//If the user has correctly guessed the word
			if (userMatch == word.size() && wrong != 8) {
				gameOver = true;
				System.out.println("YOU HAVE GUESSED THE WORD\nPress the button to play again\n");
				gameFunctions.addWin(); //1 added to total wins 
				rightOrWrong.setForeground(new Color (115, 181, 92));
				rightOrWrong.setText("YOU WON");
	            rightOrWrong.repaint();
				dashesTitle.setForeground(new Color(115, 181, 92));
			} 
			//If the user hasn't correctly guessed the word 
			else if (wrong == 8) {
				gameOver = true; //gameover is set to true 
				System.out.print("YOU RAN OUT OF GUESSES, THE WORD IS: ");
				gameFunctions.addLoss(); //1 added to total losses 
				rightOrWrong.setForeground(new Color (167, 13, 42));
				rightOrWrong.setText("YOU LOST");
	            rightOrWrong.repaint();
				for (String n: word) {
					System.out.print(n);
				}
				//After the game has ended, text to play again will be displayed 
				System.out.println("\nPress the button to play again\n");
				dashesTitle.setForeground(new Color(167, 13, 42));
				dash = word;
			}
			
			//If the game has ended, the back button will change to restart
			if (gameOver) {
				back.setBackground(new Color(115, 181, 92));
				back.setText("Restart");
	            back.repaint();
	            panel.remove(guessButton); //Guess button is removed so the user must click the restart button 
	            panel.revalidate();
	            panel.repaint();
			}
			//After every guess, the text displaying the correct words and dashes is updated
			dashesTitle.setText(gameFunctions.dashes(dash));
            dashesTitle.repaint();
            panel.repaint();
		}
	}
	
	//Class that handles the input for the text box 
	protected class enterLetterHandler extends Handler{
		public void actionPerformed(ActionEvent e) {
			String userGuess = "";
			if(e.getSource()==enterLetter) {
				//Stores the user inputted letter as a string 
				userGuess = String.format("field 1: %s", e.getActionCommand());
			}
		}
	}
	
	//Class that handles input for the back button 
	protected class backHandler extends Handler{
		public void actionPerformed(ActionEvent e) {
			if (gameOver) {
				//If the game is done, pressing the button will restart the game for the user by reopening the game window 
				gameMenu gameMenu = new gameMenu();
				dispose();
			} else {
			//If the button is pressed, the user will be returned back to the main menu 
			introMenu introMenu = new introMenu();
			dispose();
		    }
		  }
	}
}