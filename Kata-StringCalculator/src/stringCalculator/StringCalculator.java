package stringCalculator;

public class StringCalculator {

	public static int toCalculate(String input) {
		if(input != "")
			return Integer.parseInt(input);
		return 0;
	}

}
