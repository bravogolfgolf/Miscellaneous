package bowlingGame;

public class BowlingGame {

	public int rollMany(int numberOfRolls, int score) {
		int total = 0;
		for(int i = 0; i < numberOfRolls; i++)
			total+=score;
		return total;	
	}

}
