package primeFactors;

import java.util.*;

public class PrimeFactors {

	public static List<Integer> calculate(int input) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		if(input > 1){
			if(input % 2 == 0){
				arrayList.add(2);
				input /= 2;
			}
			if(input > 1)
				arrayList.add(input);						
		}
		return arrayList;
	}
}