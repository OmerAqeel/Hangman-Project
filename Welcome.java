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
				System.out.println("///// OK SO BEFORE WE BEGIN WOULD YOU LIKE TO KNOW THE GAME RULES? (Y/N) /////");
				yesOrNo = input.nextLine();
				if(yesOrNo.equalsIgnoreCase("Y")) {
					System.out.println(
							"---------------------------------------------");
					
					
				}
				TheGame.inTheGame();
			}else if(difficulty.equalsIgnoreCase("A")) {
				TheGame.inTheGame();
			}else if(difficulty.equalsIgnoreCase("L")) {
				TheGame.inTheGame();
			}
			
			
			
			
		}else if(yesOrNo.equalsIgnoreCase("N")) {
			System.out.println(
					"********** PLEASE LEAVE, THE GAME DOES NOT LIKE YOU **********");
		}
		
	}

}
