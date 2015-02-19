import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class PrimeFacrorsTest {

	@Test
	public void testPrimeFactors() {
		assertEquals(list(), PrimeFactors.find(1));
		assertEquals(list(2), PrimeFactors.find(2));
		assertEquals(list(3), PrimeFactors.find(3));
		assertEquals(list(2,2), PrimeFactors.find(4));
	}

	private List<Integer> list(Integer...ints) {
		return Arrays.asList(ints);
	}
}
