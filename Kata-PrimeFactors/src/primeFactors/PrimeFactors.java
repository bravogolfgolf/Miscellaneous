package primeFactors;

import java.util.*;

public class PrimeFactors {

	public static List<Integer> find(int i) {
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		if(i > 1)
			while (i%2 == 0){
				primeFactors.add(2);
				i/=2;
			}
		while (i%3 == 0){
			primeFactors.add(3);
			i/=3;
		}
		if(i > 1)
			primeFactors.add(i);
		return primeFactors;
	}

}
