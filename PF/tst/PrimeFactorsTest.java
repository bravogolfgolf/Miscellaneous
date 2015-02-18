import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PrimeFactorsTest {

	@Test
	public void testOne() {
		assertEquals(list(),PrimeFactors.determinePrimeFactors(1));
	}

	private List<Integer> list() {
		return Arrays.asList();
	}
}
