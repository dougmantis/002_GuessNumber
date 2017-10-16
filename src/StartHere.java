
public class StartHere {

	public static void main(String[] args) {
		
		String first_welcome = "Hello.";
		String second_welcome = "This is the 'guess my number' game.";
		String third_welcome = "Guess a number, and you will be told whether it's too high or too low. Guess the right number to win.";
		
		CreateMsg welcome = new CreateMsg();
		welcome.msg(first_welcome);
		welcome.msg(second_welcome);
		welcome.msg(third_welcome);
		
		
		GuessNumber guess01 = new GuessNumber();
		//guess01.randDebug()								in case of test, break glass
		
		guess01.startGame();
		
	}

}
