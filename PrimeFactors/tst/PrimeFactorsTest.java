import junit.framework.TestCase;

public class PrimeFactorsTest extends TestCase {
	public void testOne(){
		PrimeFactors primefactors = new PrimeFactors();
		assertEquals(1, primefactors.find(1));
	}
}
