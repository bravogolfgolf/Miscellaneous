import java.util.ArrayList;
import junit.framework.TestCase;


public class PrimeFactorsTest extends TestCase{
	public void testOne() throws Exception {
		PrimeFactors pm = new PrimeFactors();
		ArrayList<Integer> list = new ArrayList<Integer>();
		assertEquals(list,pm.find(1));
	}
	public void testTwo() throws Exception {
		PrimeFactors pm = new PrimeFactors();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		assertEquals(list,pm.find(2));
	}
}
