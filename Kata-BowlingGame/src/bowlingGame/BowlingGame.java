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
				if(scoreSheet[i] == 10) {
					total = total + 10 + scoreSheet[i+1] + scoreSheet[i+2];
					i = i + 1;
				}

				else if (scoreSheet[i] + scoreSheet[i+1] == 10) {
					total = total + 10 + scoreSheet[i+2];
					i = i + 2;
				}

				else {
					total= total + scoreSheet[i] + scoreSheet[i+1];
					i = i + 2;				
				}
			}
		return total;
	}
}