package bowlingGame;

public class BowlingGame {

	private int score = 0;
	
	public int score() {
		return score;
	}

	public void roll(int i) {
		score = score + i;	
	}
}
