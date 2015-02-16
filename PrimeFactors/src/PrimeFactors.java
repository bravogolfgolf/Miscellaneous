import java.util.ArrayList;

public class PrimeFactors {

	public ArrayList<Integer> find(int numberToFactor ) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		if (numberToFactor > 1)
			factors.add(numberToFactor);
		return factors;
	}

}
