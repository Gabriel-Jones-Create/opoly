import java.util.Random;

public class Opoly {
		private int boardSize;
		private int seed;
		private int score; 
		private int roundsOfPlay;
		private int position;
		private Random random;
		private int oldPosition;
	
		public Opoly(int intBoardSize, int intSeed) {
			boardSize = intBoardSize;
			random = new Random(intSeed);
		}
		public Opoly(int intBoardSize) {
			boardSize = intBoardSize; 
			random = new Random();
		}
		public void playGame() {
			while(gameOver() == false) {
				displayGame();
				scoring();
				move();
				}
				
			}
		public boolean gameOver() {
			if(score < 1000) {
				return false;
				}
			else {
				return true;
			}
		}
		public void displayGame(){
			for(int i = 0; i < boardSize; i++) {
				if(i == position%boardSize) {
					System.out.print("o");
				}
				else {
					System.out.print("*");
				}	
		}
			System.out.println(" " + score);
		}
		public void move() {
			position = oldPosition;
			position = position + random.nextInt(5)+1;
		}
		public void scoring() {
			
			if(position%boardSize == boardSize) {
				position = position - 3;
				luckySevens();
				}
			else {
				luckySevens();
			}
			if(position%boardSize <= oldPosition%boardSize) {
				score = score + 100;
			}
		}
			
		
		public void luckySevens() {
			if(position % 7 == 0) {
				score = score*2;
			}
		}
}
