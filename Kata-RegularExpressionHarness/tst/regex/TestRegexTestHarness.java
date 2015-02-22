package regex;

import org.junit.Test;

public class TestRegexTestHarness {
	//		String NEW_LINE = System.getProperty("line.separator");

	@Test
	public void testFindSingleCharater() {
		String regex = "a";
		String input = "bat cat rat sat";
		RegexTestHarness.main(regex,input);
	}

	@Test
	public void testFindStringWithLeadingCharater() {
		String regex = ".at";
		String input = "bat cat rat sat";
		RegexTestHarness.main(regex,input);
	}
	
	@Test
	public void testFindStringWithCertainLeadingCharaters() {
		String regex = "[bcr]at";
		String input = "bat cat rat sat";
		RegexTestHarness.main(regex,input);
	}
}
