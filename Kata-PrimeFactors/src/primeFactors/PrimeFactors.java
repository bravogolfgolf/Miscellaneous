package primeFactors;

import java.util.*;

public class PrimeFactors {

	public static List<Integer> calculate(int input) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		if(input > 1){
			for(int divisor = 2; input > 1; divisor++){
				while(input % divisor == 0){
					arrayList.add(divisor);
					input /= divisor;
				}
			}
		}
		return arrayList;
	}
}