package sort;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;


public class TestSort {

	private List<Integer> list(Integer...ints) {return Arrays.asList(ints);}

	@Test
	public void testSortArrays() {		
		assertEquals(list(), Sorter.sort());
		assertEquals(list(1), Sorter.sort(1));
		assertEquals(list(1,1), Sorter.sort(1,1));
		assertEquals(list(1,2), Sorter.sort(1,2));
		assertEquals(list(1,2), Sorter.sort(2,1));
		assertEquals(list(1,2,2), Sorter.sort(1,2,2));
		assertEquals(list(1,2,2), Sorter.sort(2,1,2));
		assertEquals(list(1,2,2), Sorter.sort(2,2,1));
	}
}
	
