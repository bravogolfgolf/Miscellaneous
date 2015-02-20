package convert;

import static org.junit.Assert.*;
import static convert.Arabic.convert;

import org.junit.Test;

public class ConvertArabicToRomanTest {

	@Test
	public void test1toI() {
		assertEquals("I", convert(1));
	}
	
	@Test
	public void test2toII() {
		assertEquals("II", convert(2));
	}
}
