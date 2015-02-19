package sort;

import java.util.*;

public class Sorter {

	public static List<Integer> sort(Integer...ints) {
		List<Integer> asList = Arrays.asList(ints);
		if(asList.size() > 1){
			if(asList.get(0) > asList.get(1)){
				Integer temp = asList.get(1);
				asList.set(1, asList.get(0));
				asList.set(0, temp);
			}
		}
		return asList;
	}

}
