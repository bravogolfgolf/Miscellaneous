package stringCalculator;

public class StringCalculator {

	public static int add(String delimited) {
		int sum = 0;
		if(isNotEmpty(delimited)){

			String[] defaultDelimiter = delimited.split("[\n]",2);
			char[] characters= defaultDelimiter[0].toCharArray();
			String delimiterRegularExpression = "," + "\n";
			
			if(characters.length > 2)
				if( characters[0] == '/' || characters[1] == '/') {
					delimiterRegularExpression = delimiterRegularExpression + characters[2];
					System.out.println(delimiterRegularExpression);
					delimited = defaultDelimiter[1];
				}
			System.out.println(delimiterRegularExpression);
			String[] numbers = delimited.split("[" + delimiterRegularExpression + "]");
			for( String item : numbers)
				sum = sum + Integer.parseInt(item.toString());
		}
		return sum;
	}

	private static boolean isNotEmpty(String input) {
		return !input.isEmpty();
	}
}