package com.convert.www;
import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class ConvertArabicToRomanTest extends TestCase {
	Arabic arabic = new Arabic();
	
	
	@Test
	public void testOnetoI() throws Exception {
		assertEquals("I", arabic.toRoman(1));
	}

	@Test
	public void testTwoToII() throws Exception {
		assertEquals("II", arabic.toRoman(2));
	}

	@Test
	public void testThreeToIII() throws Exception {
		assertEquals("III", arabic.toRoman(3));
	}

	@Test
	public void testFourToIV() throws Exception {
		assertEquals("IV", arabic.toRoman(4));
	}

	@Test
	public void testFiveToV() throws Exception {
		assertEquals("V", arabic.toRoman(5));
	}

	@Test
	public void testSixToVI() throws Exception {
		assertEquals("VI", arabic.toRoman(6));
	}
	@Test
	public void testSevenToVII() throws Exception {
		assertEquals("VII", arabic.toRoman(7));
	}

	@Test
	public void testNineToIX() throws Exception {
		assertEquals("IX", arabic.toRoman(9));
	}

}
