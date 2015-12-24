package bowlingGame;

public class BowlingGame {

	public int roll(int roll, int score) {
		int total = 0;
		for(int i = 0; i < roll; i++)
			total+=score;
		return total;	
	}

}
