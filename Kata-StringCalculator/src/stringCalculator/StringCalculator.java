package stringCalculator;

public class StringCalculator {

	public static int toCalculate(String commaDelimited) {
		int sum = 0;
		if(isNotEmpty(commaDelimited)){
			String[] numbers = commaDelimited.split(",");
			for( String item : numbers)
				sum = sum + Integer.parseInt(item.toString());
		}
		return sum;
	}

	private static boolean isNotEmpty(String input) {
		return !input.isEmpty();
	}
}