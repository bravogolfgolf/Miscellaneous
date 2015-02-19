package primeFactors;

import static primeFactors.PrimeFactors.find;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class PrimeFacrorsTest {

	private List<Integer> list(Integer...ints) {return Arrays.asList(ints);}

	@Test
	public void testPrimeFactors() {
		assertEquals(list(), find(1));
		assertEquals(list(2), find(2));
		assertEquals(list(3), find(3));
		assertEquals(list(2,2), find(4));
		assertEquals(list(5), find(5));
		assertEquals(list(2,3), find(6));
		assertEquals(list(7), find(7));
		assertEquals(list(2,2,2), find(8));
		assertEquals(list(3,3), find(9));
/*		assertEquals(list(3,3,3), find(27));
		assertEquals(list(2,3,3,7,11,31,151,331), find(2147483646));
		assertEquals(list(2147483647), find(2147483647));
*/	}


}
