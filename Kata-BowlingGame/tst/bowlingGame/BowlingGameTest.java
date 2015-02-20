package bowlingGame;
import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
	private BowlingGame bg;

	protected void setUp(){
		bg = new BowlingGame();
	}

	public void testGutterGame() throws Exception {
		rollMany(20,0);
		assertEquals(0,bg.score());
	}

	public void testBowlNonSpareNonStrikeGame() throws Exception {
		rollMany(20,4);
		assertEquals(80,bg.score());
	}

	public void testBowlSpareNonStrikeGame() throws Exception {
		bg.roll(5);
		bg.roll(5);
		rollMany(18,4);
		assertEquals(86,bg.score());
	}

	public void testBowlAllSpareGame() throws Exception {
		rollMany(21,5);
		assertEquals(150,bg.score());
	}

	public void testBowlStrikeNonSpareGame() throws Exception {
		rollMany(2,4);
		bg.roll(10);
		rollMany(16,4);
		assertEquals(90,bg.score());
	}

	public void testBowlTwoStrikeNonSpareGame() throws Exception {
		rollMany(18,4);
		bg.roll(10);
		bg.roll(10);
		bg.roll(10);
		assertEquals(102,bg.score());
	}

	public void testBowlPerfectGame() throws Exception {
		rollMany(12,10);
		assertEquals(300,bg.score());
	}

	
	private void rollMany(int rolls, int pins){
		for(int i = 0; i < rolls; i++)
			bg.roll(pins);		
	}
}