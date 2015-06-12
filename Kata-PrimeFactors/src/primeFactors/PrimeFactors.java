package primeFactors;

import java.util.*;

public class PrimeFactors {

	public static List<Integer> calculate(int input) {
		List<Integer> factors = new ArrayList<Integer>();
		for (int divisor = 2; input > 1; divisor++)
			for (; input % divisor == 0;input /= divisor) 
				factors.add(divisor);
		return factors;
	}
}
