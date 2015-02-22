package primeFactors;

import static org.junit.Assert.*;
import static primeFactors.PrimeFactors.find;
import java.util.*;
import org.junit.Test;

public class PrimeFactorsTest {

	private List<Integer> list(Integer...ints) { List<Integer> arrayList = Arrays.asList(ints);	return arrayList; }

	@Test
	public void testPrimeFactors1() {
		assertEquals(list(), find(1));
	}

	@Test
	public void testPrimeFactors2() {
		assertEquals(list(2), find(2));
	}

	@Test
	public void testPrimeFactors3() {
		assertEquals(list(3), find(3));
	}

	@Test
	public void testPrimeFactors4() {
		assertEquals(list(2,2), find(4));
	}
	
	@Test
	public void testPrimeFactors5() {
		assertEquals(list(5), find(5));
	}
	
	@Test
	public void testPrimeFactors6() {
		assertEquals(list(2,3), find(6));
	}
	
	@Test
	public void testPrimeFactors7() {
		assertEquals(list(7), find(7));
	}

	@Test
	public void testPrimeFactors8() {
		assertEquals(list(2,2,2), find(8));
	}	
	
	@Test
	public void testPrimeFactors9() {
		assertEquals(list(3,3), find(9));
	}
	
	@Test
	public void testPrimeFactors27() {
		assertEquals(list(3,3,3), find(27));
	}
	
	@Test
	public void testPrimeFactorsLargestNonPrimeInt() {
		assertEquals(list(2,3,3,7,11,31,151,331), find(2147483646));
	}
	
	@Test
	public void testPrimeFactorsLargestInt() {
		assertEquals(list(2147483647), find(2147483647));
	}
	
	
	
	
}