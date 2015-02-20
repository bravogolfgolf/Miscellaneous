package stringCalculator;

import static org.junit.Assert.*;
import static stringCalculator.StringCalculator.toCalculate;

import org.junit.Test;

public class TestStringCalculator {

	@Test
	public void testEmptyStingReturns0() {
		checkStringCalculatorResuts("",0);
	}

	@Test
	public void testStingWith1Returns1() {
		checkStringCalculatorResuts("1",1);
	}

	private void checkStringCalculatorResuts(String input, int result) {
		assertEquals(result,toCalculate(input));
	}
}
