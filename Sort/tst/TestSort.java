import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;


public class TestSort {

	private List<Integer> list(Integer...ints) {return Arrays.asList(ints);}

	@Test
	public void testSortArrays() {

		Sorter s = new Sorter();
		
		assertEquals(list(),s.sort());
		assertEquals(list(1),s.sort(1));
		assertEquals(list(1,2),s.sort(1,2));
		assertEquals(list(1,2),s.sort(2,1));
		assertEquals(list(1,2,3),s.sort(1,2,3));
		assertEquals(list(1,2,3),s.sort(2,1,3));
		assertEquals(list(1,2,3),s.sort(2,3,1));
	}
}
	
