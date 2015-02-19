package primeFactors;

import java.util.*;

public class PrimeFactors {

	public static List<Integer> find(int i) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for(int divisor = 2; divisor <= i; divisor++) {
			while (i % divisor == 0){
				arrayList.add(divisor);
				i /= divisor;
			}	
		}
		return arrayList;
	}
}