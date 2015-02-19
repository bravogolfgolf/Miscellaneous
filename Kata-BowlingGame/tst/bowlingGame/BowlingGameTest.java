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
		
	private void rollMany(int rolls, int pins){
		for(int i = 0; i < rolls; i++)
			bg.roll(pins);		
	}
}