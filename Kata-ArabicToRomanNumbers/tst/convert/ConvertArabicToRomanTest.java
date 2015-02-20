package convert;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertArabicToRomanTest {

	@Test
	public void test1toI() {
		assertEquals("I", Arabic.convert(1));
	}
}
