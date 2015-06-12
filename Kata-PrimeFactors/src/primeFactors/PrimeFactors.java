package primeFactors;

import java.util.*;

public class PrimeFactors {

	public static List<Integer> calculate(int input) {
		List<Integer> factors = new ArrayList<Integer>();
		if (input > 1) {
			if (input % 2 == 0) {
				factors.add(2);
				input -= 2;				
			}
			factors.add(input);
		}
		return factors;
	}
}