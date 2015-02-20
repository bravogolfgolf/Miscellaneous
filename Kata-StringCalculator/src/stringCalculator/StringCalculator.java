package stringCalculator;

public class StringCalculator {

	public static int toCalculate(String input) {
		int result = 0;
		if(input != ""){
			String[] list = input.split(",");
			for( String item : list)
				result = result + Integer.parseInt(item.toString());
		}
		return result;
	}
}