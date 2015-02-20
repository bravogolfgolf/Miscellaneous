package stringCalculator;

public class StringCalculator {

	public static int add(String delimited) {
		int sum = 0;
		if(isNotEmpty(delimited)){
			String[] numbers = delimited.split("[,\\n]");
			for( String item : numbers)
				sum = sum + Integer.parseInt(item.toString());
		}
		return sum;
	}

	private static boolean isNotEmpty(String input) {
		return !input.isEmpty();
	}
}