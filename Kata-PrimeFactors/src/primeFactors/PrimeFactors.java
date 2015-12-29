package primeFactors;

import java.util.*;

public class PrimeFactors {

	public static List<Integer> calculate(int number) {
		List<Integer> list = new ArrayList<Integer>();
		for(int divisor = 2; number > 1; divisor++)
			for(;number % divisor == 0; number = number / divisor)
				list.add(divisor);
		return list;
	}
}