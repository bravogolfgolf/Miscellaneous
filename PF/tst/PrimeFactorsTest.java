import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class PrimeFactorsTest {

	private List<Integer> list(Integer...ints) {return Arrays.asList(ints);}

	@Test
	public void factors() throws Exception {
		assertEquals(list(),determinePrimeFactors(1));
		assertEquals(list(2),determinePrimeFactors(2));
		assertEquals(list(3),determinePrimeFactors(3));
		assertEquals(list(2,2),determinePrimeFactors(4));
		assertEquals(list(5),determinePrimeFactors(5));
		assertEquals(list(2,3),determinePrimeFactors(6));
		assertEquals(list(7),determinePrimeFactors(7));
		assertEquals(list(2,2,2),determinePrimeFactors(8));
		assertEquals(list(3,3),determinePrimeFactors(9));
	}

	private List<Integer> determinePrimeFactors(int i) {
		List<Integer> factors = new ArrayList<Integer>();
		for (int divisor = 2; i > 1; divisor++)
			for (;i%divisor==0;i/=divisor)
				factors.add(divisor);
		return factors;
	}
}
