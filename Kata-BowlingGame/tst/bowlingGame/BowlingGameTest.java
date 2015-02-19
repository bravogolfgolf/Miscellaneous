package bowlingGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void testBowlAllGutterBalls() {
		BowlingGame bg = new BowlingGame();
		assertEquals(0, bg.score());
	}
}
