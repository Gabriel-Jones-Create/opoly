import java.util.Random;

/**
 * @author gabrieljones
 *
 */
public class Opoly {
	private int boardSize; // number of things spaces on the board
	private int reward; // value of reward
	private int roundsOfPlay; // value of the rounds played
	private int position; // current position of the player
	private Random random; // gets a random number for the spinner

	/**
	 * Opoly constructor with board size and seed
	 * 
	 * @param intBoardSize sets the board size for the game
	 * @param intSeed      sets the seed for the random number
	 */
	public Opoly(int intBoardSize, int intSeed) {
		boardSize = intBoardSize;
		random = new Random(intSeed);
	}

	/**
	 * Opoly constructor with board size
	 * 
	 * @param intBoardSize sets the board size for the game
	 */
	public Opoly(int intBoardSize) {
		boardSize = intBoardSize;
		random = new Random();
	}

	/**
	 * Uses methods to play the game
	 */
	public void playGame() {
		initGame();
		while (isGameOver() == false) {
			spinAndMove();
			drawBoard();
			roundsOfPlay++;
		}
		displayReport();
	}

	/**
	 * Uses the move and spin functions and establishes the
	 */
	private void spinAndMove() {
		move(spin());
		if (roundsOfPlay % 10 == 0 && reward > 0) {
			reward = reward - 50;
		}
		if (position == boardSize - 1) {
			position = position - 3;
		}
		if (position % 7 == 0) {
			reward = reward * 2;
		}

	}

	/**
	 * Generates Random integer using Random class between 1 and 5
	 * 
	 * @return returns a random number 1-5
	 */
	private int spin() {
		return random.nextInt(5) + 1;
	}

	/**
	 * Changes the position of the character based on the remainder of the new
	 * position divided by the board size
	 * 
	 * @param spinResult takes a number that is added to the position variable.
	 */
	private void move(int spinResult) {
		// if the new position of the character exceeds the size of the board, then it
		// would pass the beginning meaning that 100 would be added to the balance
		if ((position + spinResult) > boardSize - 1) {
			reward = reward + 100;
		}
		position = (position + spinResult) % boardSize;
	}

	/**
	 * Checks if the player has obtained the reward to end the game
	 * 
	 * @return returns <code>true</code> if reward exceeds or is equal to 1000.
	 *         Otherwise returns <code>false</code>
	 */
	private boolean isGameOver() {
		// if the reward is greater than 1000 the game would be over, otherwise the game
		// would continue
		if (reward >= 1000) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Uses a for loop to print every character on the board.
	 */
	private void drawBoard() {
		// runs for the number of iterations of the board size
		for (int i = 0; i < boardSize; i++) {
			// if the position is equal to the iteration that its on, then it prints an "o",
			// otherwise it prints a "*"
			if (position == i) {
				System.out.print("o");
			} else {
				System.out.print("*");
			}
		}
		// prints out the current reward
		System.out.println(" " + reward);
	}

	/**
	 * Gives final statistics for the game that was played
	 */
	private void displayReport() {
		// prints "game over"
		System.out.println("game over");
		// prints the final reward
		System.out.println("Final Reward : " + reward);
		// prints the rounds played
		System.out.println("Rounds Played : " + roundsOfPlay);
	}

	/**
	 * Initializes private variables with starting values
	 */
	private void initGame() {
		reward = 100;
		roundsOfPlay = 0;
		position = 0;
	}

}
