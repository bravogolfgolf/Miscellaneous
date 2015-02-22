package primeFactors;

import java.util.*;

public class PrimeFactors {

	public static List<Integer> find(int i) {
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		for(int divisor = 2; i > 1; divisor++)
			while (i % divisor == 0){
				primeFactors.add(divisor);
				i /= divisor;
			}
		return primeFactors;
	}
}