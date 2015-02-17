package com.convert.www;

public class Arabic {

	public static String toRoman(int arabicNumber) {
		StringBuffer sb = new StringBuffer();

		if (arabicNumber == 9) {
			sb.append("I");
			sb.append("X");
		}
		
		else if (arabicNumber > 5) {
			sb.append("V");
			appendOnes(arabicNumber % 5, sb);
		}
		
		else if (arabicNumber == 5) {
			sb.append("V");
		}
		
		else if (arabicNumber == 4) {
			sb.append("I");
			sb.append("V");

		}
		else { appendOnes(arabicNumber, sb);
		}
		return sb.toString();
	}

	private static void appendOnes(int arabicNumber, StringBuffer sb) {
		for(int i = 1; i <= arabicNumber; i++)
			sb.append("I");
	}
}
