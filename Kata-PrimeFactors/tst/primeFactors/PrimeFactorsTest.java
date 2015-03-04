package primeFactors;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class PrimeFactorsTest {

	private List<Integer> creatList(Integer...args){
		List<Integer> list = Arrays.asList(args);
		return list;
	}

	@Test
	public void testPrimeFactorsOf1() throws Exception {
		assertEquals(creatList(), PrimeFactors.calculate(1));
	}

	@Test
	@Ignore
	public void testPrimeFactorsOf2() throws Exception {
		assertEquals("2", PrimeFactors.calculate(2));
	}

	@Test
	@Ignore
	public void testPrimeFactorsOf3() throws Exception {
		assertEquals("3", PrimeFactors.calculate(3));
	}
}