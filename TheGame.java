import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TheGame {
	public static int guesses = 10;
	public static int warning = 0;
	public static int deductionPoints = 1;
	public static ArrayList<String> words = new ArrayList<>();
	public static String theChosenOne;
		static void inTheGame() throws FileNotFoundException {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println(
					"!<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< LET'S BEGIN >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>! ");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			File wordsList = new File("/Users/macbookpro/eclipse-workspace/Hangman/the_words.txt");
			Scanner scan = new Scanner(wordsList);
			Scanner guess = new Scanner(System.in);
			
			
			
			//List of words that will be given to the player
			
			while(scan.hasNextLine()) {									 // The while will run until there is a string/word/etc in the next line so it will stop at the last word of the words.txt because each word is written in different line 
				words.add(scan.nextLine());							    // All the word from the words.txt will be added to words ArrayList
			}
			
			Random w = new Random();								   // using the "random" package to choose the word from the  list 
			int choosing = w.nextInt(words.size());                   // declaring a variable with the .nextInt() method which returns a random element from the words array (it will choose a random digit from length of the arra(words)).
			theChosenOne = words.get(choosing);               //This variable will be output a the random element (words) from the words 
			
			System.out.print("The Word is: ");
			ArrayList<Character> playerGuess = new ArrayList<>();
			currentstate(theChosenOne, playerGuess);
			
			
			
			
			playerIn(guess, playerGuess);
		}


		////METHODS 
		
		private static void playerIn(Scanner guess, ArrayList<Character> playerGuess) {
			while(true) {
				playerStats();
			if(!getPlayerGuess(guess, theChosenOne, playerGuess)|| warning>=3){		//if the getPlayerGuess returns false which means that the player's guessed letter is not contained in the theChosenOne then the number of guesses will reduce.
				guesses -= deductionPoints;						//The number of guesses will reduce depending on the deduction points, to know the deduction points please see the setDifficulty method
			};
			if(currentstate(theChosenOne, playerGuess)) {		//the condition returns the theChosenOne.length() == count, which is executed when the player guesses all the letter correct
				break;										//the loop will break if the line 55 is true which is if the player guesses all the letter correct.
			}
			if(guesses <= 0)								//if the number of guesses == 0 then the player will lose the game and loop will break.
			{printBoo();
				break;
			}
			}
			if(guesses>0) {
			printCongrats();
			
			}
		}


		private static void playerStats() {
			System.out.println("\n\nGUESSES" + " = " +guesses);
			System.out.println("WARNINGS" + " = " + warning + "/3");
		}


		private static void printCongrats() {
			System.out.println("\n\n\n!!*******************************************************************!!");
			System.out.println("\n                         HOORAY !! YOU WON. ");
			System.out.println("\n!!*******************************************************************!!");
		}


		private static void printBoo() {
				System.out.println("\n\n\n!!***************************************************************!!");
				System.out.println("\n                     OOPS !! YOU LOST. ");
				System.out.println("\nTHE WORD WAS ----------> " + theChosenOne);
				System.out.println("\n!!***************************************************************!!");
		}
		
		
			
			
		
	
			
		public static boolean setDifficulty(String difficulty) {
			if(difficulty.equalsIgnoreCase("n")) {				//So, if the difficulty level is newbie then the deduction points by 1.
				deductionPoints = 1;						
				return true;
			}
			if(difficulty.equalsIgnoreCase("a")) {			//So, if the difficulty level is newbie then the deduction points by 2.
				deductionPoints = 2;
				return true;
			}
			if(difficulty.equalsIgnoreCase("l")) {			//So, if the difficulty level is newbie then the deduction points by 
				deductionPoints = 3;
				return true;
			}
			return false;

		}

			
		
		
		
		
		private static boolean getPlayerGuess(Scanner guess, String theChosenOne, ArrayList<Character> playerGuess) {
			System.out.println("");
			System.out.println("Please guess the letter:");
			String guessedLetter = guess.nextLine();               //this is where the player will enter the character they expect in the secret word
			playerGuess.add(guessedLetter.charAt(0));			  // As, soon as the player guess the letter will be saved/added to the Player Guess ArrayList 
			
			giveWarning(guessedLetter);
			
			Boolean result = theChosenOne.contains(guessedLetter);
			
			return result;		//This will return whether the secret word (theChosenOne) contains the guessed letter by the player, returns true when the player guessed the correct letter and false if not.
		}
		
//		private static boolean checkPreviousGuesses(ArrayList<String> playerGuess, String guessedLetter) {
//		boolean result = false;
//			//String letter = guessedLetter.toString();
//			for(int i = 0; i<= playerGuess.size();i++) {					
//				if(playerGuess.get(i).contains(guessedLetter)) {
//					result = true;
//				}else {
//					result = false;
//				}
//			}
//			return result;
//		}


		private static void giveWarning(String guessedLetter) {
			if(!(guessedLetter.matches("[a-z]"))) {			//if the the player enters any special characters or numbers then the number of warning is going to increase
				System.err.println( "****** That's a warning for you ! ******");
				System.out.println("");
				warning++;													
				if(warning<3) {													//The number of guesses will increment if the number of warning is less than because if this code is not written then because of the code in line 41 - 42 the guesses will decrease and we do not want that
				guesses += deductionPoints;										
				} else {
					warning = 0;											//The warning will be equal to 0 because we want to deduct the number guesses after every 3 subsequent warning.
					guesses += deductionPoints - 1;							//The number of guesses should decrease by only 1.
				}
			}
		}

		private static boolean currentstate(String theChosenOne, ArrayList<Character> playerGuess) {
			int count = 0;
			for(int i = 0; i< theChosenOne.length();i++) {
				if (playerGuess.contains(theChosenOne.charAt(i))){		 //if the player guesses the letter of the secret word then that letter will be printed instead of " - "
					System.out.print(theChosenOne.charAt(i));
					count++;											//As soon as the player gets the correct letter, count will increment so if all the letters are guessed correct the count will be equal to the length of the random word (theChosenOne)
				}else {System.out.print(" - ");
			}
				
				
		}
			Boolean result = theChosenOne.length() ==  count;
			return result;				//if this is true then the player has guessed the random word and has won the game.
			
		}
		
		public static void gameRestarted() {
			guesses = 10;
			warning = 0;										
			words.remove(words.indexOf(theChosenOne));			//The previous word from the words will be removed so that it does not repeats again
			
			
			
		}
}
