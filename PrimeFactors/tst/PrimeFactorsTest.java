import java.util.ArrayList;
import junit.framework.TestCase;

public class PrimeFactorsTest extends TestCase {
	public void testOne(){
		PrimeFactors primefactors = new PrimeFactors();
		ArrayList<Integer> knownList = new ArrayList<Integer>();
		knownList.add(1);
		assertEquals(knownList, primefactors.find(1));
	}
}
