import java.util.*;

public class PrimeFactors {

	public static List<Integer> find(int input) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		if (input > 1) {
			for (int divisor = 2; divisor <= input; divisor++){
				while (input % divisor == 0){
					factors.add(divisor);
					input /= divisor;
				}
			}
		}
		return factors;
	}
}
