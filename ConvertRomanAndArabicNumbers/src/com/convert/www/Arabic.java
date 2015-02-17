package com.convert.www;

public class Arabic {
	StringBuffer symbols = new StringBuffer();
	StringBuffer numbersRepresentingSymbols = new StringBuffer();

	public String toRoman(int arabicNumber) {
		appendProperSymbols(arabicNumber);
		System.out.println(numbersRepresentingSymbols.toString());
		return symbols.toString();
	}

	private void appendProperSymbols(int number) {
		if (number == 9) {
			appendOne(1);
			appendTen();
		}

		else if (number > 5) {
			int numberOfOnesToAppend = number % 5;
			appendFive();
			appendOne(numberOfOnesToAppend);
		}

		else if (number == 5) {
			appendFive();
		}

		else if (number == 4) {
			appendOne(1);
			appendFive();

		}
		else { appendOne(number);
		}
	}

	private void appendTen() {
		numbersRepresentingSymbols.append("10,");
		symbols.append("X");
	}

	private void appendFive() {
		numbersRepresentingSymbols.append("5,");
		symbols.append("V");
	}

	private void appendOne(int numberOfOnesToAppend) {
		for(int i = 1; i <= numberOfOnesToAppend; i++){
			numbersRepresentingSymbols.append("1,");
			symbols.append("I");
		}
	}
}
