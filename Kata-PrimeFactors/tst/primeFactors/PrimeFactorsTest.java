package primeFactors;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class PrimeFactorsTest {


	@Test
	public void testPrimeFactors1() {
		assertEquals(list(), PrimeFactors.find(1));
	}

	@Test
	public void testPrimeFactors2() {
		assertEquals(list(2), PrimeFactors.find(2));
	}

	private List<Integer> list(Integer...ints) {
		List<Integer> arrayList = Arrays.asList(ints);
		return arrayList;
	}
}