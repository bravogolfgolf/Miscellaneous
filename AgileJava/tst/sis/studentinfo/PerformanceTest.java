package sis.studentinfo;

import junit.framework.TestCase;

public class PerformanceTest extends TestCase {
	private Performance performance;
	private static final double TOLERANCE = 0.005;

	protected void setUp(){
		performance = new Performance();
	}

	public void testAverage(){
		performance.setNumberOfTest(4);
		performance.set(0,98);
		performance.set(1,92);
		performance.set(2,81);
		performance.set(3,72);

		assertEquals(92.00, performance.get(1));
		assertEquals(85.75,performance.average(), TOLERANCE);
	}
	public void testAverageForNoScore(){
		assertEquals(0.0,performance.average(), TOLERANCE);
	}
}
