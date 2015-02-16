import java.util.ArrayList;

public class PrimeFactors {

	public static ArrayList<Integer> find(int numberToFactor ) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		
		for (int candidate = 2; numberToFactor > 1; candidate++){
			for (;numberToFactor % candidate == 0; numberToFactor /= candidate){
				factors.add(candidate);	
			}
		}
		return factors;
	}
}
