import java.util.*;

public class PrimeFactors {

	public static List<Integer> find(int input) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		if (input > 1) {
			while (input % 2 == 0){
				factors.add(2);
				input /= 2;
			}
			if (input % 3 == 0){
				factors.add(3);
				input /= 3;
			}
			if (input > 1)
				factors.add(input);
		}
		return factors;
	}
}
