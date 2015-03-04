package primeFactors;

import static org.junit.Assert.*;
import org.junit.Test;

public class PrimeFactorsTest {

	@Test
	public void testPrimeFactorsOf1() throws Exception {
		assertEquals("", PrimeFactors.calculate(1));
	}
}