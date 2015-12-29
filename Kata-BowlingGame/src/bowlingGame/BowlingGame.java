package bowlingGame;

public class BowlingGame {
	private int scoreSheetIndex = 0;
	private int scoreSheet[] = new int[21];

	public void roll(int score) {
		scoreSheet[scoreSheetIndex] = score;
		scoreSheetIndex++;
	}

	public int score(){
		int total = 0;
			for(int i = 0, j = 0; j < 10; j++) {
				if(isStrike(i)) {
					total = total + scoreStrike(i);
					i = i + 1;
				}

				else if (isSpare(i)) {
					total = total + scoreSpare(i);
					i = i + 2;
				}

				else {
					total= total + scoreFrame(i);
					i = i + 2;				
				}
			}
		return total;
	}

	public boolean isStrike(int i) {
		return scoreSheet[i] == 10;
	}

	public boolean isSpare(int i) {
		return scoreSheet[i] + scoreSheet[i+1] == 10;
	}

	private int scoreStrike(int index) {
		return 10 + scoreSheet[index+1] + scoreSheet[index+2];		
	}
	
	private int scoreSpare(int index) {
		return 10 + scoreSheet[index+2];		
	}
	
	private int scoreFrame(int index) {
		return scoreSheet[index] + scoreSheet[index + 1];
	}
}