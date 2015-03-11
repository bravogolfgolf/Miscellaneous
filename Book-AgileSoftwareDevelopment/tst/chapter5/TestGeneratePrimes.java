package chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGeneratePrimes {

	@Test
	public void testArrayfor0() {
		int[] nullArray = PrimesGenerator.generatePrimes(0);
		assertEquals(nullArray.length, 0);
	}

	@Test
	public void testArrayfor2() {
		int[] minArray = PrimesGenerator.generatePrimes(2);
		assertEquals(minArray.length, 1);
		assertEquals(minArray[0], 2);
	}

	@Test
	public void testArrayfor3() {
		int[] threeArray = PrimesGenerator.generatePrimes(3);
		assertEquals(threeArray.length, 2);
		assertEquals(threeArray[0], 2);
		assertEquals(threeArray[1], 3);
	}

	@Test
	public void testArrayfor100() {
		int[] centArray = PrimesGenerator.generatePrimes(100);
		assertEquals(centArray.length, 25);
		assertEquals(centArray[24], 97);
	}

	@Test
	public void testExhaustive() {
		for (int i = 99; i < 100; i++)
			verifyPrimeList(PrimesGenerator.generatePrimes(i));
	}

	private void verifyPrimeList(int[] list) {
		for (int i = 0; i < list.length; i++)
			verifyPrime(list[i]);
	}

	private void verifyPrime(int i) {
		for(int factor = 2; factor < i; factor++)
			assert(i % factor != 0);
	}
}
