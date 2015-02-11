import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
	private Game g;

	protected void setUp(){
		g = new Game();
	}

	public void testGutterGame() throws Exception {
		int rolls = 20;
		int pins = 0;
		for(int i = 0; i < rolls; i++)
			g.roll(pins);
		assertEquals(0,g.score());
	}

	public void testAllOnes() throws Exception {
		for(int i=0;i<20;i++)
			g.roll(1);
		assertEquals(20,g.score());
	}
}