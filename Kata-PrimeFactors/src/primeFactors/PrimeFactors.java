package primeFactors;

import java.util.*;

public class PrimeFactors {

	public static List<Integer> calculate(int input) {
		List<Integer> factors = new ArrayList<Integer>();
		if (input > 1) {
			for (int i = 2; i < input; i++)
				if (input % i == 0) {
					factors.add(i);
					input /= i;				
				}
			if (input > 1)
				factors.add(input);
		}
		return factors;
	}
}