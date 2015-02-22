package stringCalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	private String unSplitString;
	private List<Integer> positive = new ArrayList<Integer>();
	private List<Integer> negative = new ArrayList<Integer>();
	int sum = 0;

	public int add(String input) {
		unSplitString = input;
		if(isNotEmpty(input)){		
			if (hasDefaultDelimiter(input))
				removeDefaultDelimiterFrom(input);
			createArraysFrom(unSplitString);
			checkForException();
			calculate();
		}
		return sum;
	}

	private boolean isNotEmpty(String input) {
		return !input.isEmpty();
	}

	private boolean hasDefaultDelimiter(String input) {
		final String DELIMITER_MARKER = "//";
		if (input.length() > 2)
			if (input.substring(0,2).equals(DELIMITER_MARKER))
				return true;
		return false;
	}

	private void removeDefaultDelimiterFrom(String input) {
		final String NEW_LINE = System.getProperty("line.separator");
		String[] splitInput = input.split(NEW_LINE,2);
		unSplitString =  splitInput[1];
	}

	private void createArraysFrom(String input) {
		final String ON_ALL_NON_NUMBER_CHARACTERS_EXCEPT_MINUS_SIGN = "[\\D&&[^-]]+";
		String[] temp = input.split(ON_ALL_NON_NUMBER_CHARACTERS_EXCEPT_MINUS_SIGN);
		for(int value = 0; value < temp.length; value++){
			if (isGreaterThanThisThenIgnore(temp, value)) {;}			
			else if (isNegative(temp, value)) {negative.add(Integer.parseInt(temp[value].toString()));}
			else if (isPositive(temp, value)){positive.add(Integer.parseInt(temp[value].toString()));}
		}
	}

	private boolean isGreaterThanThisThenIgnore(String[] temp, int i) {
		return Integer.parseInt(temp[i].toString()) > 1000;
	}

	private boolean isNegative(String[] temp, int i) {
		return Integer.parseInt(temp[i].toString()) < 0;
	}

	private boolean isPositive(String[] temp, int i) {
		return Integer.parseInt(temp[i].toString()) >= 0;
	}

	private void checkForException() {
		try {hasNegatives();}
		catch (IllegalArgumentException e) {
			String message = formatMessage();
			throw new IllegalArgumentException(message);}
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
		for(int i = 1; i < negative.size(); i++)
			message += ", " + negative.get(i).toString();
		message += "]";
		return message;
	}

	private void calculate() {
		for(int i : positive)
			sum += i;
	}
}