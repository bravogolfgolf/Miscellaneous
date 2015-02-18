import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class PrimeFactorsTest {

	private List<Integer> list(Integer...ints) {return Arrays.asList(ints);}

	@Test
	public void factors() throws Exception {
		assertEquals(list(),determinePrimeFactors(1));
		assertEquals(list(2),determinePrimeFactors(2));
	}

	private List<Integer> determinePrimeFactors(int i) {
		List<Integer> factors = new ArrayList<Integer>();
		if(i > 1)
			factors.add(2);
		return factors;
	}

}
