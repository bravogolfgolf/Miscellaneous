package primeFactors;

import java.util.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeFactorsTest {

	private List<Integer> createList(Integer...args) {
		List<Integer> list = Arrays.asList(args);
		return list;
	}

	@Test
	public void factorsOf1() {
		assertEquals(createList(), PrimeFactors.calculate(1));
	}

	@Test
	public void factorsOf2() {
		assertEquals(createList(2), PrimeFactors.calculate(2));
	}

	@Test
	public void factorsOf3() {
		assertEquals(createList(3), PrimeFactors.calculate(3));
	}

	@Test
	public void factorsOf4() {
		assertEquals(createList(2,2), PrimeFactors.calculate(4));
	}
}
