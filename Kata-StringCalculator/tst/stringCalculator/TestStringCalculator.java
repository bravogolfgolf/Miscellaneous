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

	@Test
	public void testStingWith2Returns2() {
		checkStringCalculatorResuts("2",2);
	}
	
	@Test
	public void testStingWith1And2Returns3() {
		checkStringCalculatorResuts("1,2",3);
	}
	
	private void checkStringCalculatorResuts(String input, int result) {
		assertEquals(result,toCalculate(input));
	}
}
