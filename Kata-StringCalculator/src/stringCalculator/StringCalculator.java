package stringCalculator;

public class StringCalculator {
	private static final String COMMA = ",";
	private static final String NEW_LINE = System.getProperty("line.separator");
	private static String delimited[];
	private static String delimiterRegularExpression = "";

	public static int add(String input) {
		int sum = 0;
		if(isNotEmpty(input)){		
			setDelimiterRegularExpression(input);
			delimitInput(input);
			sum = sumDelimited(sum);
		}
		return sum;
	}

	private static boolean isNotEmpty(String input) {
		return !input.isEmpty();
	}

	private static void setDelimiterRegularExpression(String input) {
		delimiterRegularExpression = COMMA + NEW_LINE;
		if (isLenghtGreaterThan2(input))
			if (hasDefaultDelimiter(input))
				delimiterRegularExpression += defaultDelimiterFromInput(input);
	}

	private static boolean isLenghtGreaterThan2(String input) {
		return input.length() > 2;
	}

	private static boolean hasDefaultDelimiter(String input) {
		return input.substring(0,2).equals("//");
	}

	private static String defaultDelimiterFromInput(String input) {
		return input.substring(2,3);
	}

	private static void delimitInput(String input) {
		if (isLenghtGreaterThan2(input))
			if (hasDefaultDelimiter(input))
				input = removeDefaultDelimiterFromInput(input);
		delimited = input.split("[" + delimiterRegularExpression + "]");
	}

	private static String removeDefaultDelimiterFromInput(String input) {
		String[] splitInput = input.split(NEW_LINE,2);
		input = splitInput[1];
		return input;
	}

	private static int sumDelimited(int sum) {
		for(String item : delimited){
				sum += Integer.parseInt(item.toString());			
		}
		return sum;
	}
}