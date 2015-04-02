package primeFactors;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrimeFactorsTest {

	private List<Integer> createList(Integer...args) {
		List<Integer> list = Arrays.asList(args);
		return list;
	}
	
	@Test
	public void factorsOf1() {
		assertEquals(createList(), PrimeFactors.calculate(1));
	}
}
