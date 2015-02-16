import java.util.ArrayList;

public class PrimeFactors {

	public ArrayList<Integer> find(int numberToFactor ) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int candidate = 2;
		while (numberToFactor > 1){
			while (numberToFactor % candidate == 0){
				factors.add(candidate);
				numberToFactor /= candidate;
			}
			candidate++;
		}
		if (numberToFactor > 1)
			factors.add(numberToFactor);
		return factors;
	}
}
