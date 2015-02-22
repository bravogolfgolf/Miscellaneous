package primeFactors;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class PrimeFactorsTest {

	private List<Integer> list(Integer...ints) { List<Integer> arrayList = Arrays.asList(ints);	return arrayList; }

	@Test
	public void testPrimeFactors1() {
		assertEquals(list(), PrimeFactors.find(1));
	}

	@Test
	public void testPrimeFactors2() {
		assertEquals(list(2), PrimeFactors.find(2));
	}

	@Test
	public void testPrimeFactors3() {
		assertEquals(list(3), PrimeFactors.find(3));
	}

	@Test
	public void testPrimeFactors4() {
		assertEquals(list(2,2), PrimeFactors.find(4));
	}
	
	@Test
	public void testPrimeFactors5() {
		assertEquals(list(5), PrimeFactors.find(5));
	}
	
	@Test
	public void testPrimeFactors6() {
		assertEquals(list(2,3), PrimeFactors.find(6));
	}
	
	@Test
	public void testPrimeFactors7() {
		assertEquals(list(7), PrimeFactors.find(7));
	}

	@Test
	public void testPrimeFactors8() {
		assertEquals(list(2,2,2), PrimeFactors.find(8));
	}	
	
	@Test
	public void testPrimeFactors9() {
		assertEquals(list(3,3), PrimeFactors.find(9));
	}
	
	@Test
	public void testPrimeFactors27() {
		assertEquals(list(3,3,3), PrimeFactors.find(27));
	}
}