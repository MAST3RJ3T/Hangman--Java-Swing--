//Importing the necessary java libraries like random or for error handling
import java.io.*;
import java.util.*;

//Creating a class to store methods that will be reused in the game
public class gameFunctions {
	//Creating static variables to store total wins and losses for the user 
	private static int totalWins = 0;
	private static int totalLosses = 0;
	
	//Creating a method to get a random word from the txt file
	public static ArrayList<String> getWord() {
		//Creating an arrayList to store all of the words in the txt file
		ArrayList<String> wordBank = new ArrayList<>();
		Random rand = new Random();
		
		//Using try catch error checking in case the txt file can't be found
		try {
			//Reading the txt file, and storying each word in the arrayList
			File wordBankFile = new File("C:\\Users\\tejpa\\OneDrive\\Documents\\Java Projects\\Culminating\\src\\words.txt");
			Scanner fileReader = new Scanner(wordBankFile);
			while(fileReader.hasNextLine()) {
				wordBank.add(fileReader.nextLine());
			}
			fileReader.close();
			} 
		//If the txt file can't be found, the console will print an appropriate message to deal with the error 
		catch(FileNotFoundException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
		
		//Getting a random word from the arrayList
		String randomWord = wordBank.get(rand.nextInt(wordBank.size()-0 + 1) + 0);
		//Storing each letter of the word in an arrayList 
		ArrayList<String> word = new ArrayList<>();
		for (int i = 0; i < randomWord.length();i++) {
			word.add(String.valueOf(randomWord.charAt(i)));
		}
		return word;
	}
	
	//Creating a method to store the alphabet in an arrayList 
	public static ArrayList<String> alphabet(){
		ArrayList<String> alpha = new ArrayList<>();
		alpha.add("a");
		alpha.add("b");
		alpha.add("c");
		alpha.add("d");
		alpha.add("e");
		alpha.add("f");
		alpha.add("g");
		alpha.add("h");
		alpha.add("i");
		alpha.add("j");
		alpha.add("k");
		alpha.add("l");
		alpha.add("m");
		alpha.add("n");
		alpha.add("o");
		alpha.add("p");
		alpha.add("q");
		alpha.add("r");
		alpha.add("s");
		alpha.add("t");
		alpha.add("u");
		alpha.add("v");
		alpha.add("w");
		alpha.add("x");
		alpha.add("y");
		alpha.add("z");
		return alpha;
	}
	
	//Creating a method to print what letters the user hasn't found yet, taking in an arrayList of the correct letters they have guessed
	public static String dashes(ArrayList<String> dash) {
		String text = "";
		//Converting the arrayList into a string to be printed by a JLabel 
		for (String i: dash) {
			text += (i.toUpperCase() + " ");
		}
		return text;
	}
	
	//Adding to the total wins
	public static void addWin() {
		totalWins += 1;
	}
	
	//Adding to the total losses
	public static void addLoss() {
		totalLosses += 1;
	}
	
	//Getting the total wins
	public static String getWins() {
		return String.valueOf(totalWins);
	}
	
	//Getting the total losses 
	public static String getLosses() {
		return String.valueOf(totalLosses);
	}

}
