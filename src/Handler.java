import java.awt.event.*;

//Creating an abstract class that implements the ActionListener library to detect button or text input - reused in the game various times 
public abstract class Handler implements ActionListener{
	//Abstract method that deals with the user input 
	public abstract void actionPerformed(ActionEvent e);
}
