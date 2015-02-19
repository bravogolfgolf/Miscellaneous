package bowlingGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void testBowlAllGutterBallsGame() {
		BowlingGame bg = new BowlingGame();	
		for(int i = 1; i <= 20; i++)
			bg.roll(0);
		assertEquals(0, bg.score());
	}

	@Test
	public void testBowlNonSpareNonStrikeGame() {
		BowlingGame bg = new BowlingGame();	
		for(int i = 1; i <= 20; i++)
			bg.roll(4);
		assertEquals(80, bg.score());
	}

}
