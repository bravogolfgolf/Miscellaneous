package tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class DollarTest {

	@Test
	public void testMultiplication() {
		Dollar five = new Dollar(5);
		five.times(2);
		assertEquals(10,five.amount);
	}

}
