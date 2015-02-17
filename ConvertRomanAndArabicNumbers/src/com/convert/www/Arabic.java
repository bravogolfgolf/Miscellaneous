package com.convert.www;

public class Arabic {
	StringBuffer symbols = new StringBuffer();
	StringBuffer numbersRepresentingSymbols = new StringBuffer();
	int[] integersRepresentingSymbols;

	public String toRoman(int arabicNumber) {
		int howManyTens = 0;
		int howManyOnes = 0;

		howManyTens = Math.round((arabicNumber / 10) - 0.5f);
		howManyOnes = arabicNumber - (howManyTens * 10);

		appendProperSymbols(howManyTens, 10);
		appendProperSymbols(howManyOnes, 1);


		String commaDelimited = new String(numbersRepresentingSymbols.toString());
		String[] parts = commaDelimited.split(",");
		for(int n = 0; n < parts.length; n++) {
			switch (Integer.parseInt(parts[n])) {
			case 1: symbols.append("I"); break;
			case 5: symbols.append("V"); break;
			case 10: symbols.append("X"); break;
			}	   
		}
		return symbols.toString();
	}

	private void appendProperSymbols(int number, int multiplier) {

		if (number == 9) {
			appendOne(1,multiplier);
			appendTen(multiplier);
		}

		else if (number > 5) {
			int numberOfOnesToAppend = number % 5;
			appendFive(multiplier);
			appendOne(numberOfOnesToAppend,multiplier);
		}

		else if (number == 5) {
			appendFive(multiplier);
		}

		else if (number == 4) {
			appendOne(1,multiplier);
			appendFive(multiplier);

		}
		else { appendOne(number,multiplier);
		}
	}

	private void appendTen(int multiplier) {
		Integer numbersRepresentingSymbol = 10 * multiplier;
		numbersRepresentingSymbols.append(numbersRepresentingSymbol.toString() + ",");

	}

	private void appendFive(int multiplier) {
		Integer numbersRepresentingSymbol = 5 * multiplier;
		numbersRepresentingSymbols.append(numbersRepresentingSymbol.toString() + ",");
	
	}

	private void appendOne(int numberOfOnesToAppend, int multiplier) {
		for(int i = 1; i <= numberOfOnesToAppend; i++){
			Integer numbersRepresentingSymbol = 1 * multiplier;
			numbersRepresentingSymbols.append(numbersRepresentingSymbol.toString() + ",");
		
		}
	}
}
