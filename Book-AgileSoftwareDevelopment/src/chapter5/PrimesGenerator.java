package chapter5;

public class PrimesGenerator {
	private static boolean[] crossedOut;
	private static int[] result;

	public static int[] generatePrimes(int maxValue) {

		if (maxValue < 2)
			return new int[0];
		else {
			uncrossIntegersUpTo(maxValue);
			crossOutMultiples();
			putUncrossedIntegersIntoResult();
			return result;
		}
	}

	private static void uncrossIntegersUpTo(int maxValue) {
		crossedOut = new boolean[maxValue + 1];
		for(int i = 2; i < crossedOut.length; i++)
			crossedOut[i] = false;
	}

	private static void crossOutMultiples() {
		int limit = determineIterationLimit();
		for(int i = 2; i < limit; i++) {
			if (notCrossed(i)) {
				crossOutMultiples(i);
			}
		}
	}

	private static int determineIterationLimit() {
		return (int) Math.sqrt(crossedOut.length);
	}
	
	private static boolean notCrossed(int i) {
		return !crossedOut[i];
	}

	private static void crossOutMultiples(int i) {
		for (int multiple = 2 * i; multiple < crossedOut.length; multiple += i)
			crossedOut[multiple] = true;
	}
	
	private static void putUncrossedIntegersIntoResult() {
		result = new int[numberOfUncrossedIntegers()];
		for (int i = 2, j = 0;i < crossedOut.length; i++) {
			if (notCrossed(i))
				result[j++] = i;
		}
	}

	private static int numberOfUncrossedIntegers() {
		int count = 0;
		for(int i = 2; i < crossedOut.length; i++) {
			if (notCrossed(i))
				count++;
		}
		return count;
	}
}
