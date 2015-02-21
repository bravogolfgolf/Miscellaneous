package stringCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	private final String COMMA = ",";
	private final String NEW_LINE = System.getProperty("line.separator");
	private String delimiterRegularExpression = "";
	private String unSplitString;
	private List<Integer> positive = new ArrayList<Integer>();
	int sum = 0;

	public int add(String input) {
		unSplitString = input;

		if(isNotEmpty(input)){		
			setDelimiterRegularExpression(input);
			createArray(unSplitString);
			calculate();
		}
		return sum;
	}

	private boolean isNotEmpty(String input) {
		return !input.isEmpty();
	}

	private void setDelimiterRegularExpression(String input) {
		delimiterRegularExpression = COMMA + NEW_LINE;
		if (isLenghtGreaterThan2(input))
			if (hasDefaultDelimiter(input)){
				delimiterRegularExpression += defaultDelimiterFrom(input);
				unSplitString = removeDefaultDelimiterFrom(input);
			}
	}

	private boolean isLenghtGreaterThan2(String input) {
		return input.length() > 2;
	}

	private boolean hasDefaultDelimiter(String input) {
		return input.substring(0,2).equals("//");
	}

	private String defaultDelimiterFrom(String input) {
		return input.substring(2,3);
	}

	private String removeDefaultDelimiterFrom(String input) {
		String[] splitInput = input.split(NEW_LINE,2);
		return splitInput[1];
	}

	private void createArray(String input) {
		String[] temp = input.split("[" + delimiterRegularExpression + "]");
		for(int i = 0; i < temp.length; i++){
			positive.add(Integer.parseInt(temp[i].toString()));
		}

	}

	private void calculate() {
		for(int i : positive)
			sum += i;
	}
}