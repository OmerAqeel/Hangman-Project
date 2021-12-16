import java.io.FileNotFoundException;
import java.util.Scanner;

public class Welcome {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("");
		System.out.println(
				"******************** Here comes THE HANGMAN ********************");
		System.out.println("");
		System.out.println(
				">+++++++ ARE YOU READY CHAMP ?? (Y/N) +++++++<");
		String yesOrNo = input.nextLine();
		if(yesOrNo.equalsIgnoreCase("Y")) {
			System.out.println("");
			System.out.println(
					"<--------------- WHO ARE YOU ? --------------->");
			System.out.println("");
			System.out.println("");
			System.out.println(
					"(N) - - - - - > > > > > NEWBIE");
			System.out.println("");
			System.out.println(
					"(A) - - - - - > > > > > AMATEUR");
			System.out.println("");
			System.out.println(
					"(L) - - - - - > > > > > LEGEND");
			System.out.println("");
			String difficulty = input.nextLine();
			if(difficulty.equalsIgnoreCase("N")) {
				System.out.println("///// OK SO BEFORE WE BEGIN WOULD YOU LIKE TO KNOW THE GAME RULES? (Yes/No) /////");
				yesOrNo = input.nextLine();
				if(yesOrNo.equalsIgnoreCase("Yes")) {
					System.out.println(
							"*======================================================GAME RULES======================================================================*");
					System.out.println("");
					System.out.println("O    You are supposed to guess the letter in each word that is presented  ");
					System.out.println("");
					System.out.println("O    You will be given 10 guesses to guess the secret word");
					System.out.println("");
					System.out.println("O    If you are a NEWBIE, then your guesses will reduce by 1 at every wrong guess ");
					System.out.println("");
					System.out.println("       o     If you are an AMATUER , then your guesses will reduce by 2 at every wrong guess");
					System.out.println("");
					System.out.println("                o     If you are a LEGEND , then your guesses will reduce by 3 at every wrong guess");
					System.out.println("");
					System.out.println("O    You are not supposed to enter any invalid character i.e. numbers/special characters");
					System.out.println("");
					System.out.println("O    You will recieve warning at every invalid entery, if you recieve 3 warnings your guesses will start deducting by 1 ");
					System.out.println("");
					System.out.println("O    To end the game just enter END into the console");
					System.out.println("");
					System.out.println(
							"*======================================================GAME RULES======================================================================*");			
				}else if(yesOrNo.equalsIgnoreCase("No")) {
					
				}
				TheGame.inTheGame();
			}else if(difficulty.equalsIgnoreCase("A")) {
				TheGame.inTheGame();
			}else if(difficulty.equalsIgnoreCase("L")) {
				TheGame.inTheGame();
			}else if(!(difficulty.equalsIgnoreCase("N")) ||!(difficulty.equalsIgnoreCase("A")) || !(difficulty.equalsIgnoreCase("L")) ) {
				difficulty = input.nextLine();
				
			}
			
			
			
			
		}else if(yesOrNo.equalsIgnoreCase("N")) {
			System.out.println(
					"********** PLEASE LEAVE, THE GAME DOES NOT LIKE YOU **********");
		}
		
	}

}
