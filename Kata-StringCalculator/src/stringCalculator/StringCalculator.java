package stringCalculator;

public class StringCalculator {

	private static String delimited[];
	private static String delimiterRegularExpression = "";

	public static int add(String input) {
		int sum = 0;
		if(isNotEmpty(input)){		
			setDelimiterRegularExpression(input);
			delimitInput(input);
			for( String item : delimited)
				sum += Integer.parseInt(item.toString());
		}
		return sum;
	}

	private static boolean isNotEmpty(String input) {
		return !input.isEmpty();
	}

	private static void setDelimiterRegularExpression(String input) {
		delimiterRegularExpression = "," + "\n";
		if (input.length() > 2)
			if (input.substring(0,2).equals("//"))
				delimiterRegularExpression += input.substring(2,3);
	}
	
	private static void delimitInput(String input) {
		String local = input;
		if (input.length() > 2)
			if (input.substring(0,2).equals("//")){
				String[] splitInput = input.split("[\n]",2);
				local = splitInput[1];
			}
		delimited = local.split("[" + delimiterRegularExpression + "]");
	}
}