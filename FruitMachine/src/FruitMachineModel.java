/* Anthony Lydon - 2497467.
 * 
 * A class to represent the model; deals with the application logic.
 * 
 */

// Importing .Random in order to generate random values. 

import java.util.Random;

public class FruitMachineModel {

	// Setting up the class variables.

	private int credits = 100; // Setting the initial value for credits.
	private int[] cards = new int[3];
	private String message = "";
	private String statusMessage = "";
	private boolean gameOver;

	public FruitMachineModel() {
		// Setting the initial values of the cards; will be 'King', 'Queen' and 'Jack'.
		cards[0] = 2;
		cards[1] = 3;
		cards[2] = 4;
	}

	public int[] getCards() {
		return cards;
	}

	public void spin() {
		// A method which 'spins' the cards, with each card assuming a random value. The
		// credits, the game state and the content of the JLables are updated depending
		// on which card values occur.
		Random rand = new Random();
		int randNum = rand.nextInt(4);
		int jokerCount = 0;
		cards[0] = randNum;
		randNum = rand.nextInt(4);
		cards[1] = randNum;
		randNum = rand.nextInt(4);
		cards[2] = randNum;

		for (int i = 0; i < 3; i++) { // Counting the jokers.
			if (cards[i] == 0)
				jokerCount += 1;
		}

		if (jokerCount > 0) {
			credits -= jokerCount * 25; // Taking 25 credits for each joker card.
			// Updating the message content.
			message = (jokerCount + " joker(s): You lose " + (jokerCount * 25) + " credits.");

		} else {
			if (cards[0] == cards[1] && cards[0] == cards[2]) {
				credits += 50; // Adds 50 for three of a kind.
				// Updating the message content.
				message = ("Three of a kind. You win 50 points.");
			}

			else if (cards[0] == cards[1] || cards[0] == cards[2] || cards[1] == cards[2]) {
				credits += 20; // Adds 20 for three of a kind.
				// Updating the message content.
				message = ("Two of a kind. You win 20 points.");
			} else
				// Updates the message content and does nothing else if no jokers occur and no
				// two or three of a kinds occur.
				message = ("Balance unchanged");
		}

		if (credits <= 0) { // Checks if lost.
			statusMessage = ("You lose."); // Updates the content of the JLabel detailing the status of the game.
			gameOver = true; // Flags the game as being over.

		} else if (credits >= 150) { // Checks if won.
			statusMessage = ("You win!");
			gameOver = true;

		}

	}

	

	public void newGame() { // A method triggered by a new game occurring, sets the variables back to their
							// initial values
		credits = 100;
		message = "Welcome!";
		statusMessage = "";
		gameOver = false;
		cards[0] = 2; // back to King
		cards[1] = 3; // back to Queen
		cards[2] = 4; // back to Jack

	}
	
	// Getters

	public int getCredits() {
		return credits;
	}

	public String getMessage() {
		return message;
	}

	public String getStatusMessage() {
		return statusMessage;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}

}
