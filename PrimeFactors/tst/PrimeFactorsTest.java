import java.util.ArrayList;
import junit.framework.TestCase;

public class PrimeFactorsTest extends TestCase {

	private PrimeFactors primefactors;
	private ArrayList<Integer> knownList;

	protected void setUp(){
		primefactors = new PrimeFactors();
		knownList = new ArrayList<Integer>();
	}

	public void testOne(){
		assertEquals(knownList, primefactors.find(1));
	}

	public void testTwo(){
		knownList.add(2);
		assertEquals(knownList, primefactors.find(2));
	}
}
