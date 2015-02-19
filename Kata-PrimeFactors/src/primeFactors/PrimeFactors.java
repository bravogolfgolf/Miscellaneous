package primeFactors;

import java.util.*;

public class PrimeFactors {

	public static List<Integer> find(int i) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		while (i % 2 == 0){
			arrayList.add(2);
			i /= 2;
		}
		if (i > 1)
			arrayList.add(i);
		return arrayList;
	}
}
