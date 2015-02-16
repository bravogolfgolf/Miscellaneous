import java.util.ArrayList;

public class PrimeFactors {

	public ArrayList<Integer> find(int numberToFactor ) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int candidate = 2;
		while (numberToFactor > 1){
			for (;numberToFactor % candidate == 0; numberToFactor /= candidate){
				factors.add(candidate);
				
			}
			candidate++;
		}
		return factors;
	}
}
