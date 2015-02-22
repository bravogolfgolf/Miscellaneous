package primeFactors;

import java.util.*;

public class PrimeFactors {

	public static List<Integer> find(int i) {
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		if( i > 1)
			primeFactors.add(2);
		return primeFactors;
	}

}
