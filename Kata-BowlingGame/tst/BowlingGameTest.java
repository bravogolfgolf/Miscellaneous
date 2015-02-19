import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
	private Game g;

	protected void setUp(){
		g = new Game();
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

	public void testOneSpare() throws Exception {
		rollSpare();
		g.roll(3);
		int remainingRolls = 17;
		int pins = 0;
		rollMany(remainingRolls, pins);
		assertEquals(16,g.score());
	}

	public void testOneStrike() throws Exception {
		rollStrike();
		g.roll(3);
		g.roll(4);
		rollMany(16, 0);
		assertEquals(24, g.score());
	}

	public void testAllSpares() throws Exception {
		rollMany(21, 5);
		assertEquals(150, g.score());
	}
	
	public void testPerfectGame() throws Exception {
		rollMany(12,10);
		assertEquals(300, g.score());
	}

	private void rollMany(int rolls, int pins){
		for(int i = 0; i < rolls; i++)
			g.roll(pins);		
	}

	private void rollStrike() {
		g.roll(10);
	}

	private void rollSpare() {
		g.roll(5);
		g.roll(5);
	}

}