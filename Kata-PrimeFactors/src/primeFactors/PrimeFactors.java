package primeFactors;

import java.util.*;

public class PrimeFactors {

	public static List<Integer> find(int i) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for(int divisor = 2; i > 1; divisor++)
			for (;i % divisor == 0; i /= divisor)
				arrayList.add(divisor);
		return arrayList;
	}
}