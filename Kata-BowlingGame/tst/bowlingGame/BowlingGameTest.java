package bowlingGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	BowlingGame bg;

	@Before
	public void createGame(){
		bg = new BowlingGame();
	}

	@Test
	public void rollAllGutterBalls() {;
	int total = bg.rollMany(20,0);
	assertEquals(0,total);
	}

	@Test
	public void rollAllOnes() {
		int total = bg.rollMany(20,1);
		assertEquals(20,total);
	}
}£