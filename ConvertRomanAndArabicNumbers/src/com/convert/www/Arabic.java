package com.convert.www;

public class Arabic {

	public static String toRoman(int arabicNumber) {
		StringBuffer sb = new StringBuffer();

		if (arabicNumber == 9) {
			sb.append("I");
			sb.append("X");
		}
		
		else if (arabicNumber == 6) {
			sb.append("V");
			sb.append("I");
		}
		
		else if (arabicNumber == 5) {
			sb.append("V");
		}
		
		else if (arabicNumber == 4) {
			sb.append("I");
			sb.append("V");

		}
		else { for(int i = 1; i <= arabicNumber; i++)
			sb.append("I");
		}
		return sb.toString();
	}
}
