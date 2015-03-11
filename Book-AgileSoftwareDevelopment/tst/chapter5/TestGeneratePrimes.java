package chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGeneratePrimes {

	@Test
	public void testArrayfor0() {
		int[] nullArray = GeneratePrimes.generatePrimes(0);
		assertEquals(nullArray.length, 0);
	}

	@Test
	public void testArrayfor2() {
		int[] minArray = GeneratePrimes.generatePrimes(2);
		assertEquals(minArray.length, 1);
		assertEquals(minArray[0], 2);
	}

	@Test
	public void testArrayfor3() {
		int[] threeArray = GeneratePrimes.generatePrimes(3);
		assertEquals(threeArray.length, 2);
		assertEquals(threeArray[0], 2);
		assertEquals(threeArray[1], 3);
	}

	@Test
	public void testArrayfor100() {
		int[] centArray = GeneratePrimes.generatePrimes(100);
		assertEquals(centArray.length, 25);
		assertEquals(centArray[24], 97);
	}
}
