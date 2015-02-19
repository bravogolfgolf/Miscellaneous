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
		assertEquals(list(1,2),sort(1,2));
		assertEquals(list(1,2),sort(2,1));
		assertEquals(list(1,2,3),sort(1,2,3));
		assertEquals(list(1,2,3),sort(2,1,3));
		assertEquals(list(1,2,3),sort(2,3,1));
	}

	private List<Integer> sort(Integer...ints) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (ints.length > 0){
			for (Integer j : ints){
				result.add(j);
			}
			if (result.size() > 1)
				for (int i = 0; i < result.size() - 1; i++) {
					if(result.get(i) > result.get(i+1)){
						Integer high = result.get(i+1);
						Integer low = result.get(i);						
						result.set(i, high);
						result.set(i+1, low);
					}
				}
		}
		return result;
	}
}
