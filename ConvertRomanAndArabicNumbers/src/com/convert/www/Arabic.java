package com.convert.www;

public class Arabic {
	StringBuffer sb = new StringBuffer();
	
	public String toRoman(int arabicNumber) {
		
		if (arabicNumber == 9) {
			sb.append("I");
			sb.append("X");
		}
		
		else if (arabicNumber > 5) {
			sb.append("V");
			appendOnes(arabicNumber % 5);
		}
		
		else if (arabicNumber == 5) {
			sb.append("V");
		}
		
		else if (arabicNumber == 4) {
			sb.append("I");
			sb.append("V");

		}
		else { appendOnes(arabicNumber);
		}
		return sb.toString();
	}

	private void appendOnes(int numberOfOnesToAppend) {
		for(int i = 1; i <= numberOfOnesToAppend; i++)
			sb.append("I");
	}
}
