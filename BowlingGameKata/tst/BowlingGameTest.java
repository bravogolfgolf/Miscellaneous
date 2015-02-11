import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
	private Game g;

	protected void setUp(){
		g = new Game();
	}

	private void rollMany(int rolls, int pins){
		for(int i = 0; i < rolls; i++)
			g.roll(pins);		
	}

	public void testGutterGame() throws Exception {
		int rolls = 20;
		int pins = 0;
		rollMany(rolls, pins);
		assertEquals(0,g.score());
	}

	public void testAllOnes() throws Exception {
		int rolls = 20;
		int pins = 1;
		rollMany(rolls, pins);
		assertEquals(20,g.score());
	}
	
//	public void testOneSpare() throws Exception {
//		g.roll(5);
//		g.roll(5);
//		g.roll(3);
//		int remainingRolls = 17;
//		int pins = 0;
//		rollMany(remainingRolls, pins);
//		assertEquals(16,g.score());
//	}

}