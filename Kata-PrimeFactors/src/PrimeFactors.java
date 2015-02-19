import java.util.*;

public class PrimeFactors {

	public static List<Integer> find(int input) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		if(input > 1) {
			factors.add(input);
		}
		return factors;
	}
}
