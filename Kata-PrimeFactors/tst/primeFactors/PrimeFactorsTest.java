package primeFactors;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.*;

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
	public void testPrimeFactorsOf2() throws Exception {
		assertEquals(creatList(2), PrimeFactors.calculate(2));
	}

	@Test
	public void testPrimeFactorsOf3() throws Exception {
		assertEquals(creatList(3), PrimeFactors.calculate(3));
	}
	
	@Test
	public void testPrimeFactorsOf4() throws Exception {
		assertEquals(creatList(2,2), PrimeFactors.calculate(4));
	}
	
	@Test
	public void testPrimeFactorsOf5() throws Exception {
		assertEquals(creatList(5), PrimeFactors.calculate(5));
	}
	
	@Test
	public void testPrimeFactorsOf6() throws Exception {
		assertEquals(creatList(2,3), PrimeFactors.calculate(6));
	}

	@Test
	public void testPrimeFactorsOf7() throws Exception {
		assertEquals(creatList(7), PrimeFactors.calculate(7));
	}
	
	@Test
	public void testPrimeFactorsOf8() throws Exception {
		assertEquals(creatList(2,2,2), PrimeFactors.calculate(8));
	}
	
	@Test
	public void testPrimeFactorsOf9() throws Exception {
		assertEquals(creatList(3,3), PrimeFactors.calculate(9));
	}
}