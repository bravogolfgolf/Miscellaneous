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

	@Test
	public void factorsOf5() {
		assertEquals(createList(5), PrimeFactors.calculate(5));
	}

	@Test
	public void factorsOf6() {
		assertEquals(createList(2,3), PrimeFactors.calculate(6));
	}

	@Test
	public void factorsOf7() {
		assertEquals(createList(7), PrimeFactors.calculate(7));
	}

	@Test
	public void factorsOf8() {
		assertEquals(createList(2,2,2), PrimeFactors.calculate(8));
	}

	@Test
	public void factorsOf9() {
		assertEquals(createList(3,3), PrimeFactors.calculate(9));
	}
	
	@Test
	public void factorsOf10() {
		assertEquals(createList(2,5), PrimeFactors.calculate(10));
	}
	
	@Test
	public void factorsOf11() {
		assertEquals(createList(11), PrimeFactors.calculate(11));
	}
	
	@Test
	public void factorsOf12() {
		assertEquals(createList(2,2,3), PrimeFactors.calculate(12));
	}
	
	@Test
	public void factorsOf13() {
		assertEquals(createList(13), PrimeFactors.calculate(13));
	}
	
	@Test
	public void factorsOf14() {
		assertEquals(createList(2,7), PrimeFactors.calculate(14));
	}
	
	@Test
	public void factorsOf15() {
		assertEquals(createList(3,5), PrimeFactors.calculate(15));
	}
	
	@Test
	public void factorsOf16() {
		assertEquals(createList(2,2,2,2), PrimeFactors.calculate(16));
	}
	
	@Test
	public void factorsOf17() {
		assertEquals(createList(17), PrimeFactors.calculate(17));
	}
	
	@Test
	public void factorsOf18() {
		assertEquals(createList(2,3,3), PrimeFactors.calculate(18));
	}
	@Test
	public void factorsOf19() {
		assertEquals(createList(19), PrimeFactors.calculate(19));
	}
	@Test
	public void factorsOf20() {
		assertEquals(createList(2,2,5), PrimeFactors.calculate(20));
	}
	@Test
	public void factorsOf21() {
		assertEquals(createList(3,7), PrimeFactors.calculate(21));
	}
	@Test
	public void factorsOf22() {
		assertEquals(createList(2,11), PrimeFactors.calculate(22));
	}
	@Test
	public void factorsOf23() {
		assertEquals(createList(23), PrimeFactors.calculate(23));
	}
	@Test
	public void factorsOf24() {
		assertEquals(createList(2,2,2,3), PrimeFactors.calculate(24));
	}
	@Test
	public void factorsOf25() {
		assertEquals(createList(5,5), PrimeFactors.calculate(25));
	}
	
}
