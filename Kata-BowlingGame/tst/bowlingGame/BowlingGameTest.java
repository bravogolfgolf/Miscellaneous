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
	public void rollAllGutterBalls() {
		rollMany(20,0);
		assertEquals(0,bg.score());
	}


	@Test
	public void rollAllOnes() {
		rollMany(20,1);
		assertEquals(20,bg.score());
	}

	private void rollMany(int roll, int pins) {
		for(int i = 0; i < roll; i++)
			bg.roll(pins);
	}

	@Test
	public void rollASpare() {
		bg.roll(5);
		bg.roll(5);
		rollMany(18,4);
		assertEquals(86,bg.score());
	}
	
	@Test
	public void midGameRollASpare() {
		rollMany(10,4);
		bg.roll(5);
		bg.roll(5);
		rollMany(8,4);
		assertEquals(86,bg.score());
	}

	@Test
	public void tensButNotSparesRoll() {
		rollMany(10,4);
		bg.roll(6);
		bg.roll(3);
		bg.roll(3);
		bg.roll(6);
		rollMany(6,4);
		assertEquals(82,bg.score());
	}
	
	@Test
	public void tensAndSpareRolled() {
		bg.roll(6);
		bg.roll(3);
		bg.roll(7);
		bg.roll(2);
		bg.roll(6);
		bg.roll(4);
		bg.roll(3);
		bg.roll(6);
		rollMany(12,4);
		assertEquals(88,bg.score());
	}
	
	@Test
	public void strikeRolled() {
		bg.roll(6);
		bg.roll(3);
		bg.roll(10);
		bg.roll(5);
		bg.roll(4);
		bg.roll(3);
		bg.roll(6);
		rollMany(12,4);
		assertEquals(97,bg.score());
	}
}