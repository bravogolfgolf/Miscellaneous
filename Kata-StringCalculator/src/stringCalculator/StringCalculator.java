package stringCalculator;

public class StringCalculator {

	public static int add(String delimited) {
		int sum = 0;
		if(isNotEmpty(delimited)){

			String[] defaultDelimiter = delimited.split("[\n]",2);
			char[] characters= defaultDelimiter[0].toCharArray();
			char delimiter = '\n';
			if(characters.length > 2)
				if( characters[0] == '/' || characters[1] == '/') {
					delimiter = characters[2];
					delimited = defaultDelimiter[1];
				}
			String[] numbers = delimited.split("[,\\n" + delimiter + "]");
			for( String item : numbers)
				sum = sum + Integer.parseInt(item.toString());
		}
		return sum;
	}

	private static boolean isNotEmpty(String input) {
		return !input.isEmpty();
	}
}