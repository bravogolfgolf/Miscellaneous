package convert;

import static org.junit.Assert.*;
import static convert.Arabic.convert;

import org.junit.Test;

public class ConvertArabicToRomanTest {

	@Test
	public void testNumerals() {
		checkRomanNumerals("I",1);
		checkRomanNumerals("V",5);
		checkRomanNumerals("X",10);
		checkRomanNumerals("L",50);
		checkRomanNumerals("C",100);
		checkRomanNumerals("D",500);
		checkRomanNumerals("M",1000);
	}

	@Test
	public void testAddition() {
		checkRomanNumerals("II",2);
		checkRomanNumerals("III",3);
		checkRomanNumerals("VI",6);
		checkRomanNumerals("VII",7);
		checkRomanNumerals("VIII",8);
	}

	@Test
	public void testSubtraction() {
		checkRomanNumerals("IV",4);
		checkRomanNumerals("IX",9);
		checkRomanNumerals("XL",40);
		checkRomanNumerals("XC",90);
		checkRomanNumerals("CD",400);
		checkRomanNumerals("CM",900);		
	}

	@Test
	public void testAdditionalCases() {
		checkRomanNumerals("CMXCIX",999);
		checkRomanNumerals("MCDXLIV",1444);
		checkRomanNumerals("MCMXLIV",1944);
		checkRomanNumerals("MCMXLIX",1949);
		checkRomanNumerals("MCMXCIV",1994);
		checkRomanNumerals("MCMXCIX",1999);
		checkRomanNumerals("MM",2000);
	}

	private void checkRomanNumerals(String roman, int arabic) {
		assertEquals(roman, convert(arabic));
	}
}
