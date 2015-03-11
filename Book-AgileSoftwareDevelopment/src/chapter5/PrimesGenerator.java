package chapter5;

public class PrimesGenerator {
	static boolean[] isCrossed;
	static int[] result;

	public static int[] generatePrimes(int maxValue) {

		if (maxValue < 2)
			return new int[0];
		else {
			initializeArrayOfIntegers(maxValue);
			crossOutMultiples();
			putUncrossedIntegersIntoResult();
			return result;
		}
	}

	private static void initializeArrayOfIntegers(int maxValue) {
		isCrossed = new boolean[maxValue + 1];
		for(int i = 2; i < isCrossed.length; i++)
			isCrossed[i] = false;
	}

	private static void crossOutMultiples() {
		for(int i = 2; i < Math.sqrt(isCrossed.length) + 1; i++) {
			if (!isCrossed[i]) {
				crossOutMultiples(i);
			}
		}
	}

	private static void crossOutMultiples(int i) {
		for (int multiple = 2 * i; multiple < isCrossed.length; multiple += i)
			isCrossed[multiple] = true;
	}
	
	private static void putUncrossedIntegersIntoResult() {
		int j;
		int i;
		
		int count = 0;
		for(i = 2; i < isCrossed.length; i++) {
			if (!isCrossed[i])
				count++;
		}
		
		result = new int[count];
		for (i = 2, j = 0;i < isCrossed.length; i++) {
			if (!isCrossed[i])
				result[j++] = i;
		}
	}
}
