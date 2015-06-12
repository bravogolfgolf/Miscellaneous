package primeFactors;

import java.util.*;

public class PrimeFactors {
	
	public static List<Integer> calculate(int input) {
		List<Integer> factors = new ArrayList<Integer>();
		if (input > 1)
			factors.add(input);
		return factors;
	}
}