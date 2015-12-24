package bowlingGame;

import static org.junit.Assert.*;
import org.junit.Test;

public class BowlingGameTest {
	
	@Test
	public void rollAllGutterBalls() {
		BowlingGame bg = new BowlingGame();
		int score = bg.roll(20,0);
		assertEquals(0,score);
	}
	
}