package bowlingGame;

import java.util.*;

public class BowlingGame {

	private List<Integer> rolls = new ArrayList<Integer>();
	private int score = 0;

	public void roll(int i) {
		rolls.add(i);	
	}

	public int score() {
		for(Integer i : rolls)
			score+=rolls.get(i);
		return score;
	}
}
