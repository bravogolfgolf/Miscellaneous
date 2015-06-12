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
	public void factorsOf3() {
		assertEquals(createList(3), PrimeFactors.calculate(3));
	}

	@Test
	public void factorsOf4() {
		assertEquals(createList(2,2), PrimeFactors.calculate(4));
	}

//	@Test
//	public void factorsOf5() {
//		assertEquals(createList(5), PrimeFactors.calculate(5));
//	}
//
//	@Test
//	public void factorsOf6() {
//		assertEquals(createList(2,3), PrimeFactors.calculate(6));
//	}
//
//	@Test
//	public void factorsOf7() {
//		assertEquals(createList(7), PrimeFactors.calculate(7));
//	}
//
//	@Test
//	public void factorsOf8() {
//		assertEquals(createList(2,2,2), PrimeFactors.calculate(8));
//	}
//
//	@Test
//	public void factorsOf9() {
//		assertEquals(createList(3,3), PrimeFactors.calculate(9));
//	}
//
//	@Test
//	public void factorsOf27() {
//		assertEquals(createList(3,3,3), PrimeFactors.calculate(27));
//	}
//	
//	@Test
//	public void factorsOf2147483646() {
//		assertEquals(createList(2,3,3,7,11,31,151,331), PrimeFactors.calculate(2147483646));
//	}
//	
//	@Test
//	public void factorsOf2147483647() {
//		assertEquals(createList(2147483647), PrimeFactors.calculate(2147483647));
//	}
}
