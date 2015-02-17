package com.convert.www;

public class Arabic {

	public static String toRoman(int arabicNumber) {
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= arabicNumber; i++)
			sb.append("I");
		return sb.toString();
	}
}
