import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GuessNumber {
	
	//Field:
	private int lowerLimit = 0; //Minimum number the computer can select, only works at 0
	private int upperLimit = 101; //Maximum number + 1 (10 minimum, any lower might break stuff)
	
	
	Random rand = new Random();
	Scanner keyboard = new Scanner(System.in);
	
	/* main game loop:
	 * 1 - set lower/upper bounds for number, (e.x., 0 - 10)
	 * 2 - pick random number within bounds
	 * 3 - loop -- (
	 * 		guess,
	 * 		check for win
	 * 		if win, finish
	 * 		if no win, repeat
	 * )
	 */
	
	//TODO: format cancel to exit game
	
	
	
	public GuessNumber() {
		
	} //end of constructor
	
	public void randDebug() {
		int counter = 1000;
		while (counter > 0) {
			counter--;
			JOptionPane.showMessageDialog(null, rand.nextInt(upperLimit - lowerLimit) + lowerLimit);
		}
	}
	
	public void startGame() {
		
		
		
		//method scope: only exists within this method.
		int answer = rand.nextInt(upperLimit - lowerLimit) + lowerLimit; //get a new random number.
		Boolean gameOver = false;
		Boolean win = false;
		int guess; //User's guess as to what the number is
		int turnCount = 1; //don't change
		int turnLimit = 15; //5 minimum
		String Msg = "";
		
		/*
		System.out.println();
		System.out.println(); //space
		System.out.println();
		*/
		
		//Msg = ("...For testing purposes, the answer is " + answer);														//in case of test, break glass
		//JOptionPane.showMessageDialog(null, Msg, "Mr. McDebug", JOptionPane.WARNING_MESSAGE);	
			
		CreateMsg gameMsg = new CreateMsg();
		
		while (gameOver != true && turnCount <= turnLimit) { //loop until game end (gameOver, or turn limit reached)
			
			Msg = ("Please enter your guess, between " + lowerLimit + " and " + (upperLimit - 1) + ".");  //upperLimit is exclusive
			//JOptionPane.showMessageDialog(null, Msg);
			
			/*
			System.out.println(); //space
			System.out.println();
			*/
			
			//guess = keyboard.nextInt(); //read from keyboard
			try {
				guess = Integer.parseInt(JOptionPane.showInputDialog(Msg));
			} catch(Exception err) {
				Msg = "Input error: integer conversion failure. " + err;
				JOptionPane.showMessageDialog(null, Msg, "fail", JOptionPane.WARNING_MESSAGE);
				guess = -1;
			}
				
			//Bounds Check:
			if (guess <= -1) {
				gameMsg.msg("Invalid Entry"); //checks for non-number answers and negatives
			}
			
			else if (guess < lowerLimit) {
				
				//System.out.println("Out of bounds: too low");
				gameMsg.msg("Out of bounds: too low");
				
			} else if (guess >= upperLimit) {
				
				//System.out.println("Out of bounds: too high");
				gameMsg.msg("Out of bounds: too high");
				
			} else {
			
				//Check for answer (correct, too high or too low):
				if (guess == answer) {
					
					gameMsg.msg("You win. The answer is " + guess + ".");
					//System.out.println("You win. The answer is " + guess + ".");
					
					if (turnCount == 1) {
						gameMsg.msg("Holy crap dude. You got it in one guess.");
						//System.out.println("Holy crap dude. You got it in one guess.");
					} else {
						gameMsg.msg("You got it in " + turnCount + " guesses.");
						//System.out.println("You got it in " + turnCount + " guesses.");
					}
					
					//congratulations message
					if (turnCount <= (turnLimit / 4)) {
						gameMsg.msg("Well done.");
						//System.out.println("Well done.");
					} else if (turnCount < (turnLimit)) {
						gameMsg.msg("Try playing again for a higher score.");
						//System.out.println("Try playing again for a higher score.");
					} else if (turnCount == turnLimit) {
						gameMsg.msg("You just barely made it. You can do better.");
						//System.out.println("You just barely made it. You can do better.");
					} else {
						gameMsg.msg("Error: congrat message failure.");
						//System.out.println("Error: congrat message failure.");
					}
					
					gameOver = true;
					win = true;
					
				} else if (guess > answer) {
					
					gameMsg.msg("Wrong. Too high.");
					//System.out.println("Wrong. Too high.");
					turnCount++; // new turn, add 1 to turn count
					
				} else if (guess < answer) {
					
					gameMsg.msg("Wrong. Too low.");
					//System.out.println("Wrong. Too low.");
					turnCount++; // new turn, add 1 to turn count
					
				} else {
					
					Msg = "Error: guess/answer relationship failure.";
					JOptionPane.showMessageDialog(null, Msg, "Mr. McDebug", JOptionPane.WARNING_MESSAGE);
					//System.out.println("Error: guess/answer relationship failure."); //this should never happen
					
				} //end of answer check
			} //end of out of bounds check
		} //end of while loop
		
		if (win != true) {
			gameMsg.msg("You ran out of guesses. Better luck next time.");
			//System.out.println("You ran out of guesses. Better luck next time.");
		}
		
		//System.out.println(); //space
		//System.out.println("Exiting...");
		
	} //end of startGame
} //end of class
