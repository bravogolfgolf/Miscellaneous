import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class TestSort {

	private List<Integer> list(Integer...ints) {return Arrays.asList(ints);}

	@Test
	public void testSortArrays() {
		assertEquals(list(),sort());
	}

	private List<Integer> sort() {
		return new ArrayList<Integer>();
	}


}
