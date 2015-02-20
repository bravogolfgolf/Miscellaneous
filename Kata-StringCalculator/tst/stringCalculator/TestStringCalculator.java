package stringCalculator;

import static org.junit.Assert.*;
import static stringCalculator.StringCalculator.add;

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

	@Test
	public void testStingOflongListReturnsCorrectSum() {
		checkStringCalculatorResuts("1,2,56,2,3,45,76,98436",98621);
	}

	@Test
	public void testStingNewLineAndCommas() {
		checkStringCalculatorResuts("1\n2,3",6);
	}
	
	private void checkStringCalculatorResuts(String input, int result) {
		assertEquals(result,add(input));
	}
}
