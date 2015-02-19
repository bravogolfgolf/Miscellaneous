import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;


public class PrimeFacrorsTest {

	@Test
	public void testPrimeFactors() {
		assertEquals(list(),PrimeFactors.find());
	}

	private List<Integer> list() {
		return new ArrayList<Integer>();
	}

}
