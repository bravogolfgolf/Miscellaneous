package primeFactors;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class PrimeFactorsTest {


	@Test
	public void testPrimeFactors() {
		assertEquals(list(), PrimeFactors.find(1));
	}

	private Object list() {
		// TODO Auto-generated method stub
		return new ArrayList<Integer>();
	}
}