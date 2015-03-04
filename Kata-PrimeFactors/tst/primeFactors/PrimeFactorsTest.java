package primeFactors;

import static org.junit.Assert.*;
import org.junit.Test;

public class PrimeFactorsTest {

	@Test
	public void testPrimeFactorsOf1() throws Exception {
		assertEquals("", PrimeFactors.calculate(1));
	}
	
	@Test
	public void testPrimeFactorsOf2() throws Exception {
		assertEquals("2", PrimeFactors.calculate(2));
	}
}