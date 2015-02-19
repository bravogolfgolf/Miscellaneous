package sort;

import java.util.*;

public class Sorter {

	public static List<Integer> sort(Integer...ints) {
		List<Integer> asList = Arrays.asList(ints);
		if(asList.size() > 1){
			for (int i = 1; i < asList.size(); i++) {
				if(asList.get(i - 1) > asList.get(i)){
					Integer temp = asList.get(i);
					asList.set(i, asList.get(i - 1));
					asList.set(i - 1, temp);
					i = 0;
				}
			}
		}
		return asList;
	}

}
