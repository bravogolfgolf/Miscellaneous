import java.util.ArrayList;
import junit.framework.TestCase;


public class PrimeFactorsTest extends TestCase{

	private PrimeFactors pm = new PrimeFactors();
	private ArrayList<Integer> list = new ArrayList<Integer>();

	private void createList(int...ints) {
		for(int i : ints)
		list.add(i);
	}
	
	public void testOne() throws Exception {
		assertEquals(list, pm.find(1));
	}
	public void testTwo() throws Exception {
		createList(2);
		assertEquals(list, pm.find(2));
	}
	public void testThree() throws Exception {
		createList(3);
		assertEquals(list, pm.find(3));
	}
	public void testFour() throws Exception {
		createList(2,2);
		assertEquals(list, pm.find(4));
	}
	public void testFive() throws Exception {
		createList(5);
		assertEquals(list, pm.find(5));
	}
}
