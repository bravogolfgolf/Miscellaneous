package primeFactors;

import java.util.*;

public class PrimeFactors {

	public static List<Integer> calculate(int input) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
			for(int divisor = 2; input > 1; divisor++)
				for(;input % divisor == 0; input /= divisor)
					arrayList.add(divisor);
		return arrayList;
	}
}