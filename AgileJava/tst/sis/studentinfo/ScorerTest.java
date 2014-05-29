package sis.studentinfo;

import junit.framework.*;

public class ScorerTest extends TestCase {
	public void testCaptureScore () {
		Scorer scorer = new Scorer();
		assertEquals(75,scorer.score("75"));
	}

	public void testBadScore () {
		Scorer scorer = new Scorer();
		try {
			scorer.score("abc");
			fail("Expected NumberFormatException for testBadScore");
		}
		catch (NumberFormatException success){
		}
	}

}
