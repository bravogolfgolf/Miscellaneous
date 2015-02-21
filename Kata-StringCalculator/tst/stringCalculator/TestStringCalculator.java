package stringCalculator;

import static org.junit.Assert.*;

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
	
	@Test
	public void testStingDefaultDelimiter() {
		checkStringCalculatorResuts("//;\n1;2",3);
	}
	
	@Test
	public void testStingDefaultDelimiterOther() {
		checkStringCalculatorResuts("//|\n1|2,3\n4",10);
	}
	
	@Test (expected = NumberFormatException.class)
	public void testNegativeThrowsException() {
		checkStringCalculatorResuts("//|\n1|2,3\n-4",6);
	}

	@Test (expected = NumberFormatException.class)
	public void testNegativeThrowsExceptionOther() {
		checkStringCalculatorResuts("//|\n1|2,-3\n-4",3);
	}

	private void checkStringCalculatorResuts(String input, int result) {
		StringCalculator sc = new StringCalculator();
		assertEquals(result, sc.add(input));
	}
}
