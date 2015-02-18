import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class PrimeFactorsTest {

	private List<Integer> list(Integer...ints) {return Arrays.asList(ints);}

	@Test
	public void factors() {
		assertEquals(list(),determinePrimeFactors(1));
	}

	private List<Integer> determinePrimeFactors(int i) {
		return null;
	}

}
