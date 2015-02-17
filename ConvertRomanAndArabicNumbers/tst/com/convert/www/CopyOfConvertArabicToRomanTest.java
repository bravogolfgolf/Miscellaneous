package com.convert.www;

import org.junit.Test;
import junit.framework.TestCase;

public class CopyOfConvertArabicToRomanTest extends TestCase {

	@Test
	public void testSymbols() throws Exception {
		assertEquals("I", ArabicNumber.toRoman(1));
		assertEquals("V", ArabicNumber.toRoman(5));
		assertEquals("X", ArabicNumber.toRoman(10));
		assertEquals("L", ArabicNumber.toRoman(50));
		assertEquals("C", ArabicNumber.toRoman(100));
		assertEquals("D", ArabicNumber.toRoman(500));
		assertEquals("M", ArabicNumber.toRoman(1000));
	}

	@Test
	public void testAddition() throws Exception {
		assertEquals("II", ArabicNumber.toRoman(2));
		assertEquals("III", ArabicNumber.toRoman(3));
		assertEquals("VI", ArabicNumber.toRoman(6));
		assertEquals("VII", ArabicNumber.toRoman(7));
		assertEquals("VIII", ArabicNumber.toRoman(8));
		assertEquals("XV", ArabicNumber.toRoman(15));
		assertEquals("XX", ArabicNumber.toRoman(20));
		assertEquals("MMMM", ArabicNumber.toRoman(4000));
	}

	@Test
	public void testSubtraction() throws Exception {
		assertEquals("IV", ArabicNumber.toRoman(4));
		assertEquals("IX", ArabicNumber.toRoman(9));
		assertEquals("XIV", ArabicNumber.toRoman(14));
		assertEquals("XIX", ArabicNumber.toRoman(19));
		assertEquals("XL", ArabicNumber.toRoman(40));
		assertEquals("XLIV", ArabicNumber.toRoman(44));
		assertEquals("XLIX", ArabicNumber.toRoman(49));
		assertEquals("XC", ArabicNumber.toRoman(90));
		assertEquals("XCIX", ArabicNumber.toRoman(99));
		assertEquals("CXCIX", ArabicNumber.toRoman(199));
		assertEquals("CDXLIV", ArabicNumber.toRoman(444));
		assertEquals("CDXCIX", ArabicNumber.toRoman(499));
		assertEquals("CMXCIX", ArabicNumber.toRoman(999));

	}
}
