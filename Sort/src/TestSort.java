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
		assertEquals(list(1),sort(1));
	}

	private List<Integer> sort(Integer...ints) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		if (ints.length > 0){
			arrayList.add(1);
		}
		return arrayList;
	}
}
