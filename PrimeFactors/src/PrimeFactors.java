import java.util.ArrayList;

public class PrimeFactors {

	public ArrayList<Integer> find(int howManyPrimeFactors) {
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		if (howManyPrimeFactors > 1)
			primeFactors.add(2);
		return primeFactors;
	}
}
