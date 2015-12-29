package primeFactors;

import java.util.*;


public class PrimeFactors {

	public static List<Integer> calculate(int number) {
		List<Integer> list = new ArrayList<Integer>();
		if(number > 1) {
			if(number % 2 == 0) {
				list.add(2);
				number = number / 2;				
			}
			if(number > 1)
				list.add(number);
		}
		return list;
	}
}
