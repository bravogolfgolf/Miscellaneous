package com.convert.www;

public class Arabic {

	public static String toRoman(int arabicNumber) {
		StringBuffer sb = new StringBuffer();

		if (arabicNumber == 5) {
			sb.append("V");
		}
		else if (arabicNumber == 4) {
			sb.append("IV");

		}
		else { for(int i = 1; i <= arabicNumber; i++)
			sb.append("I");
		}
		return sb.toString();
	}
}
