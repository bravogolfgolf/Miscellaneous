public class Game {
	private int rolls[] = new int[21];
	private int currentRoll = 0;

	public void roll(int pins){
		rolls[currentRoll = currentRoll +1] = pins;
	}

	public int score() {
		int score = 0;
		int frame = 0;
		int i = 0;
		while (i < rolls.length){
			frame = rolls[i] + rolls[i+1];
			if (frame == 10)
				frame = frame + rolls[i+2];
			score = score + frame;
			i = i + 2;
		}
		return score;
	}
}
