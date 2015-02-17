package com.convert.www;

public class Arabic {
	int tensPlaceHolder = 0;
	int onesPlaceHolder = 0;
	StringBuffer numbersRepresentingSymbols = new StringBuffer();
	StringBuffer romanNumber = new StringBuffer();

	public String toRoman(int arabicNumber) {
		determineVauleOfEachPlaceHolders(arabicNumber);
		appendProperSymbols(tensPlaceHolder, 10);
		appendProperSymbols(onesPlaceHolder, 1);
		createRomanNumber();
		return romanNumber.toString();
	}

	private void determineVauleOfEachPlaceHolders(int arabicNumber) {
		tensPlaceHolder = Math.round((arabicNumber / 10) - 0.5f);
		onesPlaceHolder = arabicNumber - (tensPlaceHolder * 10);
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

	private void appendOne(int numberOfOnesToAppend, int multiplier) {
		for(int i = 1; i <= numberOfOnesToAppend; i++){
			Integer numbersRepresentingSymbol = 1 * multiplier;
			numbersRepresentingSymbols.append(numbersRepresentingSymbol.toString() + ",");		
		}
	}

	private void appendFive(int multiplier) {
		Integer numbersRepresentingSymbol = 5 * multiplier;
		numbersRepresentingSymbols.append(numbersRepresentingSymbol.toString() + ",");
	}
	
	private void appendTen(int multiplier) {
		Integer numbersRepresentingSymbol = 10 * multiplier;
		numbersRepresentingSymbols.append(numbersRepresentingSymbol.toString() + ",");
	}

	private void createRomanNumber() {
		String commaDelimited = new String(numbersRepresentingSymbols.toString());
		String[] parts = commaDelimited.split(",");
		for(int n = 0; n < parts.length; n++) {
			switch (Integer.parseInt(parts[n])) {
			case 1: romanNumber.append("I"); break;
			case 5: romanNumber.append("V"); break;
			case 10: romanNumber.append("X"); break;
			}	   
		}
	}
}
