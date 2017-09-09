import java.util.Random;
import javax.swing.*;

public class GuessingGame {

	Random random = new Random();
	private int randomNumber;

	public GuessingGame() {

		randomNumber = random.nextInt(100) + 1;

	}

	public void run () {
		
		JOptionPane.showMessageDialog(null, "This is Guessing game. You have 6 guesses.","GUESSING GAME",JOptionPane.INFORMATION_MESSAGE);
		int i = 6;
		
		while(i>0) {
			String name = "guesses";
			if (i == 1) {
				name = "guess";
			}
			String userNumber = JOptionPane.showInputDialog("Guess a number between 1 to 100 : ( "+ (i) +" " + name + " Left)");
			
			if (userNumber != null && userNumber != "") {
			try {
				
				
		            int yourNumber = Integer.parseInt(userNumber);
		            int checkNumber = GuessedNumber(yourNumber);
		        if (checkNumber == 1) {
		    	    JOptionPane.showMessageDialog(null,"You won","CONGRATULATIONS",JOptionPane.PLAIN_MESSAGE);
		    	    return;
		        }
		        else {
		    	    i--;
		    	    if (i==0) {
		    	    	JOptionPane.showMessageDialog(null,"The Correct Answer is "+randomNumber,"YOU LOST",JOptionPane.PLAIN_MESSAGE);
		    	    }
		    	    continue;
		        }
			}
			
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null , "You didn't enter an integer","INVALID INPUT",JOptionPane.WARNING_MESSAGE);
				continue;
			}
			}
			else {
				return;
			}
		}
		
		
	}

	private int GuessedNumber(int checkNumber) {

		if (checkNumber == randomNumber) {
			return 1;
		} else if (checkNumber < randomNumber) {
			JOptionPane.showMessageDialog(null, "Your number is Lower.",
					"HINT", JOptionPane.PLAIN_MESSAGE);
			return -1;
		} else {
			JOptionPane.showMessageDialog(null, "Your number is Higher.",
					"HINT", JOptionPane.PLAIN_MESSAGE);
			return -1;
		}

	}

}
