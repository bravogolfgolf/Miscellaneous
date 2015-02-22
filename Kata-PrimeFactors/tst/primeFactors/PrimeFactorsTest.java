package primeFactors;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class PrimeFactorsTest {


	@Test
	public void testPrimeFactors1() {
		assertEquals(list(), PrimeFactors.find(1));
	}

	private List<Integer> list() {
		return new ArrayList<Integer>();
	}
}