package sort;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;


public class TestSort {

	private List<Integer> list() {return Arrays.asList();}

	@Test
	public void testSortArrays() {		
		assertEquals(list(), Sorter.sort());
	}
}
	
