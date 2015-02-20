package bowlingGame;

public class BowlingGame {

	private int rolls[] = new int[21];
	int currentRoll = 0;

	public void roll(int i) {
		rolls[currentRoll++] = i;
	}

	public int score() {
		int score = 0;
		int roll = 0;
		for(int frame = 1; frame <= 10; frame++)
			if(isSpare(roll)){
				score += 10 + spareBonus(roll);
				roll+=2;
			}
			else if(isStrike(roll)){
				score += 10 + strikeBonus(roll);
				roll+=1;
			}
			else{
				score += rolls[roll] + rolls[roll+1];
				roll+=2;}
		
		return score;
	}

	private boolean isStrike(int roll) {
		return rolls[roll] == 10;
	}

	private int strikeBonus(int roll) {
		return rolls[roll+1] + rolls[roll+2];
	}

	private boolean isSpare(int roll) {
		return rolls[roll] + rolls[roll+1] == 10;
	}
	
	private int spareBonus(int roll) {
		return rolls[roll+2];
	}
}