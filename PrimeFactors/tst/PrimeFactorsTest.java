import java.util.ArrayList;
import junit.framework.TestCase;

public class PrimeFactorsTest extends TestCase {
	public void testOne(){
		PrimeFactors primefactors = new PrimeFactors();
		ArrayList<Integer> knownList = new ArrayList<Integer>();
		assertEquals(knownList, primefactors.find(1));
	}
}
