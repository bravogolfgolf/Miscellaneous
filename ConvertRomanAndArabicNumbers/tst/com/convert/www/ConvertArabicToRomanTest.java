package com.convert.www;
import org.junit.Test;
import junit.framework.TestCase;

public class ConvertArabicToRomanTest extends TestCase {

	@Test
	public void testOnetoI() throws Exception {
		assertEquals("I", Arabic.toRoman(1));

	}

}
