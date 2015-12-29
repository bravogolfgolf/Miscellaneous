package primeFactors;

import java.util.*;


public class PrimeFactors {
	static List<Integer> list = new ArrayList<Integer>();

	public static List<Integer> calculate(int number) {
		if(number > 0)
			list.add(number);
		return list;
	}


}
