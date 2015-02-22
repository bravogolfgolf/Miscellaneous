package stringCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	private final String NEW_LINE = System.getProperty("line.separator");
	private String unSplitString;
	private List<Integer> positive = new ArrayList<Integer>();
	private List<Integer> negative = new ArrayList<Integer>();
	int sum = 0;

	public int add(String input) {
		unSplitString = input;
		if(isNotEmpty(input)){		
			if (checkForDefaultDelimiter(input))
				if (hasDefaultDelimiter(input)) {
					removeDefaultDelimiterFrom(input);}
			createArraysFrom(unSplitString);
			checkForException();
			calculate();
		}
		return sum;
	}

	private boolean isNotEmpty(String input) {
		return !input.isEmpty();
	}

	private boolean checkForDefaultDelimiter(String input) {
		
		return input.length() > 2;
	}

	private boolean hasDefaultDelimiter(String input) {
		final String DELIMITER_MARKER = "//";
		return input.substring(0,2).equals(DELIMITER_MARKER);
	}

	private void removeDefaultDelimiterFrom(String input) {
		String[] splitInput = input.split(NEW_LINE,2);
		unSplitString =  splitInput[1];
	}

	private void createArraysFrom(String input) {
		String[] temp = input.split("[\\D&&[^-]]+");
		for(int i = 0; i < temp.length; i++){
			if (ignoreNumbersGreaterThanThis(temp, i)) {;}			
			else if (isNegative(temp, i)) {negative.add(Integer.parseInt(temp[i].toString()));}
			else if (isPositive(temp, i)){positive.add(Integer.parseInt(temp[i].toString()));}
		}
	}

	private boolean ignoreNumbersGreaterThanThis(String[] temp, int i) {
		return Integer.parseInt(temp[i].toString()) > 1000;
	}

	private boolean isNegative(String[] temp, int i) {
		return Integer.parseInt(temp[i].toString()) < 0;
	}

	private boolean isPositive(String[] temp, int i) {
		return Integer.parseInt(temp[i].toString()) >= 0;
	}

	private void checkForException() {
		try {
			hasNegatives();
		} catch (IllegalArgumentException e) {
			String message = formatMessage();
			throw new IllegalArgumentException(message);
		}
	}

	private void hasNegatives() throws IllegalArgumentException {
		if(isNotEmpty(negative))
			throw new IllegalArgumentException();
	}

	private boolean isNotEmpty(List<Integer> negative) {
		return !negative.isEmpty();
	}

	private String formatMessage() {
		String message = "negatives not allowed: [";
		message += negative.get(0).toString();
		for(int i = 1; i < negative.size(); i++){
			message += ", " + negative.get(i).toString();
		}
		message += "]";
		return message;
	}

	private void calculate() {
		for(int i : positive)
			sum += i;
	}
}