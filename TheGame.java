import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TheGame {
		static void inTheGame() throws FileNotFoundException {
			File wordsList = new File("/Users/macbookpro/eclipse-workspace/Hangman/the_words.txt");
			Scanner scan = new Scanner(wordsList);
			
			
			//List of words that will be given to the player
			ArrayList<String> words = new ArrayList<>();
			while(scan.hasNextLine()) {
				words.add(scan.nextLine());
			}
			
			Scanner sc = new Scanner(System.in);
			
			// using the "random" package to choose the word from the  list 
			Random w = new Random();
			// declaring a variable with the .nextInt() method which returns a random element from the words arrayList (it will choose a random digit from size of the arra(words)).
			int choosing = w.nextInt(words.size());
			//This variable will be output a the random element (words) from the words 
			String theChosenOne = words.get(choosing);
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println(
					"!<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< LET'S BEGIN >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>! ");
			System.out.println("");
			System.out.println("Please guess the word:");
			System.out.println();
			//The below line of code will produce a underscores for the length of the random word that is chosen
			System.out.print("The Word is: ");
			
			ArrayList<Character> theguess = new ArrayList<>();
			
			for(int i = 0; i< theChosenOne.length();i++) {
				if(i == 0) {											//When i == 0 it means that its on the first character of the random word 
				System.out.print(theChosenOne.charAt(0));				//Prints the first character of the random word
				}
				while(i<theChosenOne.length()-2) {
					System.out.print(" - ");
					break;
				}
				if(i > (theChosenOne.length()-2)) {
					System.out.print(theChosenOne.charAt(i));
				}
				if(i == theChosenOne.length()) {
					break;
				}
			}
			
			
		
}
	
	
}
