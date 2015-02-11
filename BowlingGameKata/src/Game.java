public class Game {
	private int score = 0;

	public void roll(int pins){
		score = score + pins;
	}

	public int score() {
		return score;
	}
}
