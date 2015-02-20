package stringCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringCalculator {

	@Test
	public void testEmptyStingReturns0() {
		assertEquals(0,StringCalculator.toCalculate(""));
	}
	
	@Test
	public void testStingWith1Returns1() {
		assertEquals(1,StringCalculator.toCalculate("1"));
	}
}
