package com.convert.www;
import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class ConvertArabicToRomanTest extends TestCase {

	@Test
	public void testOnetoI() throws Exception {
		assertEquals("I", Arabic.toRoman(1));
	}
	@Test
	public void testTwoToII() throws Exception {
		assertEquals("II", Arabic.toRoman(2));
	}
	
	@Test
	public void testThreeToIII() throws Exception {
		assertEquals("III", Arabic.toRoman(3));
	}
	@Test
	public void testFourToIV() throws Exception {
		assertEquals("IV", Arabic.toRoman(4));
	}
	@Test
	public void testFiveToV() throws Exception {
		assertEquals("V", Arabic.toRoman(5));
	}
}
