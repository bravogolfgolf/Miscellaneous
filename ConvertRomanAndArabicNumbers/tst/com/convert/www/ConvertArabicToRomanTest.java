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
}
