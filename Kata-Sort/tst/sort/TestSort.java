package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;


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
		
		assertEquals(list(1,2,3), Sorter.sort(1,2,3));
		assertEquals(list(1,2,3), Sorter.sort(1,3,2));
		assertEquals(list(1,2,3), Sorter.sort(2,1,3));
		assertEquals(list(1,2,3), Sorter.sort(2,3,1));
		assertEquals(list(1,2,3), Sorter.sort(3,1,2));
		assertEquals(list(1,2,3), Sorter.sort(3,2,1));
		
		assertEquals(list(1,2,3,4), Sorter.sort(1,2,3,4));
		assertEquals(list(1,2,3,4), Sorter.sort(4,1,2,3));
		assertEquals(list(1,2,3,4), Sorter.sort(3,4,1,2));
		assertEquals(list(1,2,3,4), Sorter.sort(2,3,4,1));
		
		assertEquals(list(1,2,3,2147483647), Sorter.sort(2147483647,1,2,3));
	}
}
	
