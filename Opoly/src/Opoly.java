import java.util.Random;

public class Opoly {
	private int boardSize;
	private int score;
	private int roundsOfPlay;
	private int position;
	private Random random;

	public Opoly(int intBoardSize, int intSeed) {
		boardSize = intBoardSize;
		random = new Random(intSeed);
	}

	public Opoly(int intBoardSize) {
		boardSize = intBoardSize;
		random = new Random();
	}

	public void playGame() {
		while (gameOver() == false) {
			move();

			displayGame();
		}

	}

	private boolean gameOver() {
		if (score >= 1000) {
			return true;
		} else {
			return false;
		}
	}

	private void displayGame() {
		for (int i = 0; i < boardSize; i++) {
			if (position == i) {
				System.out.print("o");
			} else {
				System.out.print("*");
			}
		}
		System.out.println(" " + score +" "+position);
	} 

	private void move() {
		position = position + getRandomNumber();
		positionReset();
		luckySevens();
		endOfBoardRule();
	}
	private int getRandomNumber() {
		return random.nextInt(5) + 1;
	}
	private void positionReset() {
		if (position >= boardSize) {
			position = position % boardSize;
			score = score + 100;
		}
	}

	private void luckySevens() {
		if (position % 7 == 0) {
			score = score * 2;
		}
	}

	

	private void endOfBoardRule() {
		if (position == boardSize-1) {
			position = position - 3;
			luckySevens();
		}
	}

}
